package com.eugenefe.saa.problem;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jfree.data.statistics.MeanAndStandardDeviation;
import org.moeaframework.Executor;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.problem.javanance.MeanVariance;
import org.moeaframework.util.Vector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eugenefe.saa.entity.BucketMapping;
import com.eugenefe.saa.entity.OptimumProblem;
import com.eugenefe.saa.entity.OverallConstraints;
import com.eugenefe.saa.entity.SaaEfficientFrontier;
import com.eugenefe.saa.entity.SaaEfficientFrontierId;
import com.eugenefe.saa.entity.SaaSegment;
import com.eugenefe.saa.entity.SaaWeightResult;
import com.eugenefe.saa.entity.SaaWeightResultId;
import com.eugenefe.saa.entity.SegmentConstraints;
import com.eugenefe.saa.entity.SegmentRiskMeasure;
import com.eugenefe.saa.entity.SegmentScenario;
import com.eugenefe.saa.problem.MinConditionalVaR;
import com.eugenefe.util.DaoUtil;
import com.eugenefe.util.HibernateUtil;

public class TestMinConditionalVaR {
	private final static Logger logger = LoggerFactory.getLogger(TestMinConditionalVaR.class);
	private static Session s = HibernateUtil.currentSession();
	private static String basDt;
	private static String optMthdlId;
	private static List<SegmentRiskMeasure> segPosList = new ArrayList<SegmentRiskMeasure>();
	private static List<SaaSegment> segmentList = new ArrayList<SaaSegment>();
	private static List<OverallConstraints> overallConts = new ArrayList<OverallConstraints>();
	private static List<SegmentConstraints> segConts = new ArrayList<SegmentConstraints>();

	public static void main(String[] args) throws IOException {
//		basDt = args[0];
//		optMthdlId = args[1];
		basDt = "20140630";
		optMthdlId ="PRB_03";
		int segNum = 1;
		long sceNo = 20000;
		testHibernate();
//		testSaveOrUpdate();
//		 runProblem();
	}

	private static void testHibernate(){
		String bssd = "20140630";
		String optMthdlId = "PRB_01";
		String riskType = "MR";
		String segId = "SEG_111";
		long sceNo = 20000;
		
		List<OptimumProblem> probList = new ArrayList<OptimumProblem>();
		
//		List<SaaSegment> segments = new ArrayList<SaaSegment>();
		Map<String, List<SegmentScenario>> sceMap = new HashMap<String, List<SegmentScenario>>();
		Map<Long, List<SegmentScenario>> sceByNumberMap = new HashMap<Long, List<SegmentScenario>>();
		List<SegmentScenario> sceList = new ArrayList<SegmentScenario>();
//		List<SegmentRiskMeasure> posList = new ArrayList<SegmentRiskMeasure>();
		
		probList = DaoUtil.getProbelms();
		
		OptimumProblem probs = DaoUtil.getProbelm(optMthdlId);
		String segGroup  = probs.getSegGrpId();
		logger.info("Proble : {},{}", probs.getOptMthdlId(), segGroup);
		segmentList = DaoUtil.getSegmentByGroup(segGroup);

		segPosList = DaoUtil.getSegmentPositionByGroup(segGroup);
//		segPosList = DaoUtil.getSegmentPosition();
		logger.info("Segment Position : {},{}", segPosList.get(0).getId().getSegId(), segPosList.get(0).getSegment().getSegGroupId());
		
//		overallConts = DaoUtil.getOverallConstraints(optMthdlId);
//		segConts = DaoUtil.getSegmentConstraints(optMthdlId);
//		logger.info("Segment Position : {},{}", overallConts.size(), segConts.size());
		
//		for(SaaSegment aa : segmentList){
//			segPosList.add(getPositionById(aa.getSegId()));
//			sceMap.put(aa.getSegId(), getScenariosById(basDt, probs.getRiskTypeCd(), aa.getSegId(), sceNo));
//		}
//		
//		logger.info("Segment Position : {},{}", segPosList.get(0).getId().getSegId());
//
		List<BucketMapping> bucket = DaoUtil.getBucket(segId);
//		logger.info("Proble : {},{}", bucket.get(0).getId().getBucketId());
		
		
		
		sceList = DaoUtil.getScenariosById(bssd, riskType, segId, sceNo);
//		for ( SaaSegment aa : getSegmentByGroup(segGroup)){
//			logger.info("segScenario : {},{}", aa.getSegId(), aa.getSegGroupId());
//		}

//		sceMap = getScenarioMap(bssd, riskType, segGroup, sceNo);
		logger.info("Map Size : {},{}", sceMap.size());
		// getConstraints(probId);

//		List<SegmentScenario> zz = getScenariosById(bssd, riskType, segId, sceNum);
	}
	
	

	private static void runProblem() throws IOException {
		List<SaaWeightResult> weightRst = new ArrayList<SaaWeightResult>();
		List<SaaEfficientFrontier> frontierRst = new ArrayList<SaaEfficientFrontier>();
		
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
			weightRst.addAll(convertToOptimalWeight(solution, i+1));
			frontierRst.add(convertToOptimalPoint(solution, i+1));
			
			double[] objectives = solution.getObjectives();
			
			// negate objectives to return them to their maximized form
			objectives = Vector.negate(objectives, 1);
			
			double cvar = objectives[0] + Double.valueOf(solution.getVariable(0).toString());
			
//			logger.info("Objectives : {}: {}", objectives[0], objectives[1]);
//			logger.info("variables : {}: {}", solution.getVariable(0), solution.getVariable(1));
//			System.out.println("obj 1: " + objectives[0] + ","+ objectives[1] );
			System.out.println("obj 1: " + cvar + ","+ objectives[1] );

		}
		Transaction tx = s.beginTransaction();
		for(SaaEfficientFrontier aa : frontierRst){
			s.saveOrUpdate(aa);
		}
		for(SaaWeightResult bb: weightRst){
			s.saveOrUpdate(bb);
		}
		tx.commit();
	}
	
	
	private static void testSaveOrUpdate(){
		s.setFlushMode(FlushMode.MANUAL);
		SaaEfficientFrontierId rstId = new SaaEfficientFrontierId(basDt, optMthdlId, 3) ;
		SaaEfficientFrontier rst =  new SaaEfficientFrontier(rstId);
		double cvar = 100.0;
		rst.setCondpVar(new BigDecimal(cvar));
		rst.setExpYield(new BigDecimal(0.034));
		List<SaaEfficientFrontier> frontierRst = new ArrayList<SaaEfficientFrontier>();
		frontierRst.add(rst);
		
		Transaction tx = s.beginTransaction();
		for(SaaEfficientFrontier aa : frontierRst){
			s.saveOrUpdate(aa);
			logger.info("Save : {}", aa.getId().getOptMthdlId());
		}
		
		List<SaaWeightResult> weightRst = new ArrayList<SaaWeightResult>();
		SaaWeightResultId wId = new SaaWeightResultId(basDt, optMthdlId, 3, "SEG_111");
		SaaWeightResult wt = new SaaWeightResult(wId);
		wt.setBookAmt(new Long(100));
		wt.setBookAmtChngRate(new BigDecimal(1.2));
		weightRst.add(wt);
		
		for(SaaWeightResult	aa : weightRst){
			s.saveOrUpdate(aa);
			logger.info("Save : {}", aa.getId().getOptMthdlId());
		}
		s.flush();
		tx.commit();
		
		logger.info("Save : {}");
	}
	private static List<SaaWeightResult> convertToOptimalWeight(Solution solution, int seqNum){
		List<SaaWeightResult> rst =new ArrayList<SaaWeightResult>();
		SaaWeightResult temp ;
		SaaWeightResultId tempId;
		for(int i=1; i< solution.getNumberOfVariables(); i++){
			tempId = new SaaWeightResultId(basDt, optMthdlId, seqNum, segPosList.get(i-1).getId().getSegId());
			temp = new SaaWeightResult(tempId);
			temp.setBookAmt(segPosList.get(i-1).getBookValAmt());
			temp.setEvalAmt(segPosList.get(i-1).getEvalAmt());
//TODO : column type change : Long to BigDecimal 
//			temp.setOptDtbnBookAmt(new Long(segPosList.get(i-1).getBookValAmt() 
//												* EncodingUtils.getReal(solution.getVariable(i)));
			temp.setBookAmtChngRate(new BigDecimal(EncodingUtils.getReal(solution.getVariable(i))));
			rst.add(temp);
		}
		return rst;
		
	}

	private static SaaEfficientFrontier convertToOptimalPoint(Solution solution, int seqNum){
		SaaEfficientFrontierId rstId = new SaaEfficientFrontierId(basDt, optMthdlId, seqNum) ;
		SaaEfficientFrontier rst =  new SaaEfficientFrontier(rstId);
		double[] objectives = solution.getObjectives();
		objectives = Vector.negate(objectives, 1);
		
		double cvar = EncodingUtils.getReal(solution.getVariable(0)) + objectives[0];
		rst.setVar(new BigDecimal(EncodingUtils.getReal(solution.getVariable(0))));
		rst.setCondpVar(new BigDecimal(cvar));
		
		rst.setExpYield(new BigDecimal(objectives[1]));
		
		return rst;
		
	}
}
