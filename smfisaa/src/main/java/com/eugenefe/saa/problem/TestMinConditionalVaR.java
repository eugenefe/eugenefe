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
import com.eugenefe.saa.entity.SegmentRiskMeasure;
import com.eugenefe.saa.entity.SegmentScenario;
import com.eugenefe.saa.problem.MinConditionalVaR;
import com.eugenefe.util.HibernateUtil;

public class TestMinConditionalVaR {
	private final static Logger logger = LoggerFactory.getLogger(TestMinConditionalVaR.class);
	private static Session s = HibernateUtil.currentSession();
	private static String basDt;
	private static String optMthdlId;
	private static List<SegmentRiskMeasure> segPosList = new ArrayList<SegmentRiskMeasure>();
	private static List<SaaSegment> segmentList = new ArrayList<SaaSegment>();

	public static void main(String[] args) throws IOException {
//		basDt = args[0];
//		optMthdlId = args[1];
		basDt = "20140630";
		optMthdlId ="PRB_03";
		int segNum = 1;
		long sceNo = 20000;
		testHibernate();
		testSaveOrUpdate();
//		 runProblem();
	}

	private static void testHibernate(){
		String bssd = "20140630";
		String probId = "PRB_02";
		String riskType = "MR";
		String segId = "SEG_111";
		long sceNo = 20000;
		
		List<OptimumProblem> probList = new ArrayList<OptimumProblem>();
//		List<SaaSegment> segments = new ArrayList<SaaSegment>();
		Map<String, List<SegmentScenario>> sceMap = new HashMap<String, List<SegmentScenario>>();
		Map<Long, List<SegmentScenario>> sceByNumberMap = new HashMap<Long, List<SegmentScenario>>();
		List<SegmentScenario> sceList = new ArrayList<SegmentScenario>();
//		List<SegmentRiskMeasure> posList = new ArrayList<SegmentRiskMeasure>();
		
//		probList = getProbelms();
		
		OptimumProblem probs = getProbelm(probId);
		String segGroup  = probs.getSegGrpId();
//		logger.info("Proble : {},{}", probs.getOptMthdlId(), segGroup);
		segmentList = getSegmentByGroup(segGroup);

		segPosList = getPosition();
		for(SaaSegment aa : segmentList){
			segPosList.add(getPositionById(aa.getSegId()));
			sceMap.put(aa.getSegId(), getScenariosById(basDt, probs.getRiskTypeCd(), aa.getSegId(), sceNo));
		}
		
		logger.info("Segment Position : {},{}", segPosList.get(0).getId().getSegId());

		List<BucketMapping> bucket = getBucket(segId);
		logger.info("Proble : {},{}", bucket.get(0).getId().getBucketId());
		
		
		
//		sceList = getScenariosById(bssd, riskType, segId, sceNo);
//		for ( SaaSegment aa : getSegmentByGroup(segGroup)){
//			logger.info("segScenario : {},{}", aa.getSegId(), aa.getSegGroupId());
//		}

		sceMap = getScenarioMap(bssd, riskType, segGroup, sceNo);
		logger.info("Map Size : {},{}", sceMap.size());
		// getConstraints(probId);

//		List<SegmentScenario> zz = getScenariosById(bssd, riskType, segId, sceNum);
	}
	
	private static OptimumProblem getProbelm(String probId) {
//		 Session s = HibernateUtil.currentSession();

		Query qr = s.createQuery(	"	from OptimumProblem a  where 1=1 " 
								+ 	" 	and   a.optMthdlId = :param1 "
								);
		qr.setParameter("param1", probId);

		OptimumProblem prob = (OptimumProblem) qr.uniqueResult();
		return prob;
	}
	
	private static List<OptimumProblem> getProbelms() {
//		 Session s = HibernateUtil.currentSession();

		Query qr = s.createQuery(	"	from OptimumProblem a  where 1=1 " 
								);

		List<OptimumProblem> probList = qr.list();
		for (OptimumProblem aa : probList) {
			logger.info("Problems : {},{}", aa.getOptMthdlId(), aa.getOptMdlCd());
		}
		return probList;
	}
	
	private static List<BucketMapping> getBucket(String segId) {
		Query qr = s.createQuery(	"	from BucketMapping a  where 1=1 " 
								+ 	" 	and   a.id.segId = :param1 "
								);
		qr.setParameter("param1", segId);
		return qr.list();
	}

	private static List<SegmentRiskMeasure> getPosition(){
		Query qr = s.createQuery(	"	from SegmentRiskMeasure a  where 1=1 " 
//								+ 	" 	and   a.id.segId = :param1 "
								);
//		qr.setParameter("param1", segId);
		return qr.list();
	}
	private static SegmentRiskMeasure getPositionById(String segId){
		Query qr = s.createQuery(	"	from SegmentRiskMeasure a  where 1=1 " 
								+ 	" 	and   a.id.segId = :segId "
								);
		qr.setParameter("segId", segId);
		return (SegmentRiskMeasure)qr.uniqueResult();
	}
	
	private static List<SaaSegment> getSegmentByGroup(String segGroup) {
//		Session s = HibernateUtil.currentSession();
		List<SaaSegment> rst = new ArrayList<SaaSegment>();
		Query qr = s.createQuery(	" from SaaSegment a where 1=1 " 
								+ 	" and   a.segGroupId = :segGroup "
								+ 	" order by a.segId "
								);
		qr.setParameter("segGroup", segGroup);

		rst = qr.list();
		for (SaaSegment aa : rst) {
//			logger.info("segScenario : {},{}", aa.getSegId(), aa.getSegGroupId());
			logger.info("segScenario : {},{}", aa.getSegId());
		}
		return rst;
	}

	private static Map<String, List<SegmentScenario>> getScenarioMap(String bssd, String riskType, String segGroup, long sceNum) {
		Map<String, List<SegmentScenario>> rst = new HashMap<String, List<SegmentScenario>>();
		for ( SaaSegment aa : getSegmentByGroup(segGroup)){
//			logger.info("segScenario : {},{}", aa.getSegId(), aa.getSegGroupId());
			rst.put(aa.getSegId(), getScenariosById(bssd, riskType, aa.getSegId(), sceNum));
			
		}
		return rst;
	}
	
/*	private static Map<Long, List<SegmentScenario>> getScenarioByNumber(String bssd, String riskType, String segGroup, long sceNum) {
		Map<Long, List<SegmentScenario>> rst = new HashMap<Long, List<SegmentScenario>>();
		for ( SaaSegment aa : getSegmentByGroup(segGroup)){
//			logger.info("segScenario : {},{}", aa.getSegId(), aa.getSegGroupId());
			rst.put(new Long(i), getScenariosByNumber(bssd, riskType, segGroup,i));
			
		}
		return rst;
	}*/
	
	
	private static List<SegmentScenario> getScenariosById(String bssd, String riskType, String segId, long sceNum) {
//		 Session s = HibernateUtil.currentSession();
		List<SegmentScenario> scenarios = new ArrayList<SegmentScenario>();
		Query qr = s.createQuery("from SegmentScenario a  where 1=1 " 
								+ " and   a.id.basDt = :bssd "
								+ " and   a.id.riskTypeCd = :riskType " 
								+ " and   a.id.segId =:segId"
				 				+ " and   a.id.snroNo <= :sceNum "
								+ " order by a.id.snroNo, a.id.segId"
								);
		qr.setParameter("bssd", bssd);
		qr.setParameter("riskType", riskType);
		qr.setParameter("segId", segId);
//		 qr.setParameter("sceNum", Integer.valueOf(sceNum));
		 qr.setParameter("sceNum", sceNum);

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
