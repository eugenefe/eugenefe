package com.eugenefe.saa.problem;
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


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jfree.data.statistics.MeanAndStandardDeviation;
import org.moeaframework.Executor;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;
import org.moeaframework.problem.javanance.MeanVariance;
import org.moeaframework.util.Vector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eugenefe.saa.entity.BucketMapping;
import com.eugenefe.saa.entity.OptimumProblem;
import com.eugenefe.saa.entity.OverallConstraints;
import com.eugenefe.saa.entity.SaaSegment;
import com.eugenefe.saa.entity.SegmentScenario;
import com.eugenefe.saa.problem.MinConditionalVaR;
import com.eugenefe.util.HibernateUtil;

public class TestMinConditionalVaR {
	private final static Logger logger = LoggerFactory.getLogger(TestMinConditionalVaR.class);
//	private static Session s = HibernateUtil.currentSession();

	public static void main(String[] args) throws IOException {
		String bssd = "20140630";
		String probId = "PRB_02";
		String riskType = "MR";
		String segId = "SEG_111";
		
		int segNum = 1;
		int sceNo = 1000;
		
		List<SaaSegment> segments = new ArrayList<SaaSegment>();
		Map<String, List<SegmentScenario>> sceMap = new HashMap<String, List<SegmentScenario>>();
		List<SegmentScenario> sceList = new ArrayList<SegmentScenario>();
		
		OptimumProblem probs = getProbelm(probId);
		String segGroup  = probs.getSegGrpId();
		logger.info("Proble : {},{}", probs.getOptMthdlId(), segGroup);
		
//		List<BucketMapping> bucket = getBucket(segId);
//		logger.info("Proble : {},{}", bucket.get(0).getId().getBucketId());
//		segments = getSegmentByGroup(segGroup);
		
//		sceList = getScenariosById(bssd, riskType, segId, sceNo);
//		for ( SaaSegment aa : getSegmentByGroup(segGroup)){
//			logger.info("segScenario : {},{}", aa.getSegId(), aa.getSegGroupId());
//		}

//		sceMap = getScenarioMap(bssd, riskType, segGroup, sceNo);
		logger.info("Map Size : {},{}", sceMap.size());
		// getConstraints(probId);

//		List<SegmentScenario> zz = getScenariosById(bssd, riskType, segId, sceNum);
//		 runProblem();
	}

	private static OptimumProblem getProbelm(String probId) {
		 Session s = HibernateUtil.currentSession();

		Query qr = s.createQuery(	"	from OptimumProblem a  where 1=1 " 
								+ 	" 	and   a.optMthdlId = :param1 "
								);
		qr.setParameter("param1", probId);

		OptimumProblem prob = (OptimumProblem) qr.uniqueResult();
		return prob;
	}
	
	private static List<BucketMapping> getBucket(String segId) {
		 Session s = HibernateUtil.currentSession();
		 List<BucketMapping> rst = new ArrayList<BucketMapping>();
		Query qr = s.createQuery(	"	from BucketMapping a  where 1=1 " 
								+ 	" 	and   a.id.segId = :param1 "
								);
		qr.setParameter("param1", segId);

//		BucketMapping bucket = (BucketMapping) qr.uniqueResult();
		
		rst	= qr.list();
		return rst;
	}

	private static List<OptimumProblem> getProbelms() {
		 Session s = HibernateUtil.currentSession();
		List<OptimumProblem> probs = new ArrayList<OptimumProblem>();

		Query qr = s.createQuery(	"	from OptimumProblem a  where 1=1 " 
							   	+ 	" 	and   a.probId = :param1 "
								);
		probs = qr.list();
		for (OptimumProblem aa : probs) {
			logger.info("Problems : {},{}", aa.getOptMthdlId(), aa.getOptMdlCd());
		}
		return probs;
	}

	private static List<SaaSegment> getSegmentByGroup(String segGroup) {
		Session s = HibernateUtil.currentSession();
		List<SaaSegment> segments = new ArrayList<SaaSegment>();
		Query qr = s.createQuery(	"from SaaSegment a  where 1=1 " 
								+ 	" and   a.segGroupId = :segGroup "
								+ 	" order by a.segId "
								);
		qr.setParameter("segGroup", segGroup);

		segments = qr.list();
		for (SaaSegment aa : segments) {
//			logger.info("segScenario : {},{}", aa.getSegId(), aa.getSegGroupId());
		}
		return segments;
	}

	private static Map<String, List<SegmentScenario>> getScenarioMap(String bssd, String riskType, String segGroup, int sceNum) {
		Map<String, List<SegmentScenario>> rst = new HashMap<String, List<SegmentScenario>>();
		for ( SaaSegment aa : getSegmentByGroup(segGroup)){
//			logger.info("segScenario : {},{}", aa.getSegId(), aa.getSegGroupId());
			rst.put(aa.getSegId(), getScenariosById(bssd, riskType, aa.getSegId(), sceNum));
			
		}
		return rst;
	}

	private static List<SegmentScenario> getScenariosById(String bssd, String riskType, String segId, int sceNum) {
		 Session s = HibernateUtil.currentSession();
		List<SegmentScenario> scenarios = new ArrayList<SegmentScenario>();
		Query qr = s.createQuery("from SegmentScenario a  where 1=1 " 
								+ " and   a.id.baseDate = :bssd "
								+ " and   a.id.riskType = :riskType " 
								+ " and   a.id.segId =:segId"
				 				+ " and   to_number(a.id.sceId) <= :sceNum "
								+ " order by a.id.sceId, a.id.segId"
								);
		qr.setParameter("bssd", bssd);
		qr.setParameter("riskType", riskType);
		qr.setParameter("segId", segId);
		 qr.setParameter("sceNum", Integer.valueOf(sceNum));
		// qr.setParameter("sceNum", sceNum);

		scenarios = qr.list();
		logger.info("segScenario Size : {},{}", segId, scenarios.size());
		
		for (SegmentScenario aa : scenarios) {
//			logger.info("segScenario : {},{}", aa.getId().getSceId(), aa.getSceValue());
		}
		return scenarios;
	}
	
	

	private static void getConstraints(String probId) {
		 Session s = HibernateUtil.currentSession();
		List<OverallConstraints> overallConst = new ArrayList<OverallConstraints>();

		Query qr = s.createQuery("from OverallConstraints a  where 1=1 " 
								+ " and   a.id.probId = :param1 "
								);
		qr.setParameter("param1", probId);

		overallConst = qr.list();
		for (OverallConstraints aa : overallConst) {
			logger.info("Problems : {},{}", aa.getId().getOptMthdlId(), aa.getId().getLmtExprCd());
			logger.info("Problems : {},{}", aa.getLeftHandVal(), aa.getRightHandVal());
		}
	}

	private static void runProblem() throws IOException {

		// solve using NSGA-II
		NondominatedPopulation result = new Executor()
				.withProblemClass(MinConditionalVaR.class)
				.withAlgorithm("NSGAII")
				.withMaxEvaluations(50000)
				.withProperty("populationSize", 10000)
				.run();

		// print the results
		logger.info("Result : {}: {}", result.size());
		for (int i = 0; i < result.size(); i++) {
			Solution solution = result.get(i);
			double[] objectives = solution.getObjectives();
			
			// negate objectives to return them to their maximized form
			objectives = Vector.negate(objectives, 1);
			
			double cvar = objectives[0] + Double.valueOf(solution.getVariable(0).toString());
			
//			logger.info("Objectives : {}: {}", objectives[0], objectives[1]);
//			logger.info("variables : {}: {}", solution.getVariable(0), solution.getVariable(1));
			System.out.println("obj 1: " + objectives[0] + ","+ objectives[1] );
		}
	}

}
