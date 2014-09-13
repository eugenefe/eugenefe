/* Copyright 2009-2014 David Hadka
 *
 * This file is part of the MOEA Framework.
 *
 * The MOEA Framework is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * The MOEA Framework is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the MOEA Framework.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.eugenefe.saa.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.crypto.NullCipher;
import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.Query;
import org.hibernate.Session;
import org.moeaframework.core.Solution;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.core.variable.RealVariable;
import org.moeaframework.problem.AbstractProblem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eugenefe.saa.entity.OverallConstraints;
import com.eugenefe.saa.entity.SegmentConstraints;
import com.eugenefe.saa.entity.SegmentRiskMeasure;
import com.eugenefe.saa.entity.SegmentScenario;
import com.eugenefe.saa.entity.SegmentScenarioId;
import com.eugenefe.util.HibernateUtil;


public class MinConditionalVaR extends AbstractProblem {
	private final static Logger logger = LoggerFactory.getLogger(MinConditionalVaR.class);
	private double[][] sceArray;
	private double[] expectedReturn ;
	private int varSize ;
	private int sceNum;
	
	public MinConditionalVaR() {
		super(304,2,1);
		varSize =303;
		logger.info("Start creation : {}", varSize);
		sceNum = 5000;
		sceArray = getScenarioArray(varSize,sceNum);
		expectedReturn = new double[varSize];
		for(int i =0; i< varSize; i++){
			expectedReturn[i] =0.03 + 0.03* Math.random();
		}
		logger.info("End of Creation : {},{}", varSize, sceArray.length);
		
	}
	
	public MinConditionalVaR(List<SegmentRiskMeasure> posList, List<OverallConstraints> overConts
									, List<SegmentConstraints> segConts) {
		super(posList.size()+1 ,2,overConts.size() + segConts.size() );
		varSize =303;
		logger.info("Start creation : {}", varSize);
		sceNum = 5000;
		sceArray = getScenarioArray(varSize,sceNum);
		expectedReturn = new double[varSize];
		for(int i =0; i< varSize; i++){
			expectedReturn[i] =0.03 + 0.03* Math.random();
		}
		logger.info("End of Creation : {},{}", varSize, sceArray.length);
		
	}
	
	@Override
	public Solution newSolution() {
		Solution solution = new Solution(numberOfVariables, numberOfObjectives, numberOfConstraints) {
		};

		for (int i = 1; i < numberOfVariables; i++) {
			solution.setVariable(i, new RealVariable(0.8, 1.2));
//			solution.setVariable(i, new RealVariable(-5.0, 5.0));
		}
		solution.setVariable(0, new RealVariable(0.0, 1000));

		return solution;
	}

	@Override
	public void evaluate(Solution solution) {
		double[] vari= EncodingUtils.getReal(solution);
		double alpha = 0.01;
		
		double valueAtRisk = vari[0];
		double[] weight = new double[vari.length-1];
		for(int k=1; k < vari.length; k++){
			weight[k-1] = vari[k];
		}
		
		double[] sce = getScenario(weight, sceArray, sceNum);
		
		double f1 = 0.0;
		double f2 = 0.0;
		double g = 0.0;
		for(int j =0; j< varSize; j++){
			f2 = f2 - weight[j] * expectedReturn[j]; 
			g = g + weight[j];
		}
		if(g<=330 ){
			g=0.0;
		}
		else{
			g=-1.0;
		}
		
		for( int i=0; i<sceNum; i++){
//			logger.info("shortfall:{},{}", valueAtRisk, sce[i]);
			if(sce[i]-valueAtRisk >0) {
				f1 = f1+ sce[i]-valueAtRisk;
			}
		}
		
		double cvar = valueAtRisk +  1/alpha  * f1 / sceNum;
//		logger.info("weight:{},{}", valueAtRisk, weight[0]);
		
//		logger.info("var:{},{}", f1, cvar	);
		
		
		solution.setObjective(0, cvar);
		solution.setObjective(1, f2/varSize);		
		solution.setConstraint(0, g);
	}
	
	
	private static double[][] getScenarioArray(int varSize, int sceNum){
//		int sceNum = 1000;
		Session s = HibernateUtil.currentSession();
		List<SegmentScenario> scenarios = new ArrayList<SegmentScenario>();
		Query qr = s.createQuery(	"from SegmentScenario a  where 1=1 " 
								 +  " and   a.id.basDt = :param3 "
								 +  " and  a.id.scnrNo <= :param2 "	
								 +  " order by scnrNo, a.id.segId"
				);
		 qr.setParameter("param3", "20140630");
		 qr.setParameter("param2", Integer.valueOf(sceNum));

		scenarios = qr.list();
		
		double[][] rst = new double[sceNum][varSize];
		logger.info("allocate array : {}", scenarios.size(), sceNum);
		for(int i =0; i<sceNum; i++){
			int k =0;
			int inx = i+1;
			for(SegmentScenario bb : scenarios.subList(i*varSize, (i+1)*varSize)){
//				logger.info("subList :{},{}", bb.getId().getSceId(), i);
				rst[i][k] = Math.exp(bb.getSnroEvalAmt().doubleValue()/100) * Math.random();
			}
			/*for(SegmentScenario aa : scenarios){
				if(aa.getId().getSceId().equals(String.valueOf(inx))){
//					rst[i][k] = aa.getSceValue().doubleValue()/100;
					rst[i][k] = Math.exp(aa.getSceValue().doubleValue()/100) * Math.random();
					k=k+1;
				}
			}*/
		}
		return rst;
	}
	
	private static void getScenarioMap(double weight, double[] sceArray, double[] rst){
		Map<String, Double> rstMap = new HashMap<String, Double>();
		double temp = 0.0;
		for(int i=0 ; i< sceArray.length; i++){
			rst[i] = rst[i]+ weight *  sceArray[i];
		}
	}
	
	private static double[] getScenario(double[] weight, double[][] sceArray, int sceSize){
		double[] rst = new double[sceSize];
		double temp = 0.0;
//		logger.info("sceArray:{},{}", sceArray.length);
		for( int i =0 ; i< sceSize; i++){
			rst[i] =0.0;
			for(int j=0 ; j< weight.length; j++){
				rst[i] =  rst[i] + weight[j] * sceArray[i][j];
			}
		}
		return rst;
	}
	
	private Map<Long, Long> getScenarioMap(List<SegmentScenario> sceList){
		Map<Long, Long> rstMap = new HashMap<Long, Long>();
		long temp = 0;
		for(SegmentScenario aa : sceList){
			if(rstMap.containsKey(aa.getId().getSnroNo())){
				temp = rstMap.get(aa.getId().getSnroNo()).longValue() + aa.getSnroEvalAmt();
			}
			else{
				temp = aa.getSnroEvalAmt().longValue();
			}
			rstMap.put(new Long(aa.getId().getSnroNo()), new Long(temp));
		}
		return rstMap;
	}
	
	private double getShortfall(List<SegmentScenario> sceList, double  valueAtRisk){
		double rst =0.0;
		double temp=0.0;
		for(SegmentScenario aa : sceList){
			temp = aa.getSnroEvalAmt().doubleValue() - valueAtRisk ;
			if(temp >0){
				rst = rst + temp;
			}
		}
		
		return rst;
		
	}

}
