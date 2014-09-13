package com.eugenefe.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eugenefe.saa.entity.BucketMapping;
import com.eugenefe.saa.entity.OptimumProblem;
import com.eugenefe.saa.entity.OverallConstraints;
import com.eugenefe.saa.entity.SaaSegment;
import com.eugenefe.saa.entity.SegmentConstraints;
import com.eugenefe.saa.entity.SegmentRiskMeasure;
import com.eugenefe.saa.entity.SegmentScenario;
import com.eugenefe.saa.problem.TestMinConditionalVaR;



public class DaoUtil {
	private final static Logger logger = LoggerFactory.getLogger(DaoUtil.class);
	private static Session s = HibernateUtil.currentSession();
	
	public static List<OptimumProblem> getProbelms() {
		Query qr = s.createQuery(	"	from OptimumProblem a  where 1=1 " 
								);

		List<OptimumProblem> probList = qr.list();
		for (OptimumProblem aa : probList) {
			logger.info("Problems : {},{}", aa.getOptMthdlId(), aa.getOptMdlCd());
		}
		return probList;
	}
	
	public static OptimumProblem getProbelm(String optMthdlId) {
		Query qr = s.createQuery(	"	from OptimumProblem a  where 1=1 " 
								+ 	" 	and   a.optMthdlId = :optMthdlId "
								);
		qr.setParameter("optMthdlId", optMthdlId);

		OptimumProblem prob = (OptimumProblem) qr.uniqueResult();
		return prob;
	}
	
	public static List<SaaSegment> getSegmentByGroup(String segGroup) {
		List<SaaSegment> rst = new ArrayList<SaaSegment>();
		Query qr = s.createQuery(	" from SaaSegment a where 1=1 " 
								+ 	" and   a.segGroupId = :segGroup "
								+ 	" order by a.segId "
								);
		qr.setParameter("segGroup", segGroup);

		rst = qr.list();
		for (SaaSegment aa : rst) {
//			logger.info("segScenario : {},{}", aa.getSegId(), aa.getSegGroupId());
//			logger.info("segScenario : {},{}", aa.getSegId());
		}
		return rst;
	}
	
	public static List<BucketMapping> getBucket(String bucketId) {
		Query qr = s.createQuery(	"	from BucketMapping a  where 1=1 " 
								+ 	" 	and   a.id.bucketId = :param1 "
								);
		qr.setParameter("param1", bucketId);
		return qr.list();
	}
	public static List<SegmentRiskMeasure> getSegmentPositionByGroup(String segGroupId){
		Query qr = s.createQuery(	"	from SegmentRiskMeasure a  where 1=1 " 
								+ 	" 	and   a.segment.segGroupId = :segGroupId "
								);
		qr.setParameter("segGroupId", segGroupId);
		return qr.list();
	}
	
	
	public static List<SegmentRiskMeasure> getSegmentPosition(){
		Query qr = s.createQuery(	"	from SegmentRiskMeasure a" +
				"						 where 1=1 " 
//								+ 	" 	and   a.id.segId = :param1 "
								);
//		qr.setParameter("param1", segId);
		return qr.list();
	}
	
	public static SegmentRiskMeasure getSegmentPositionById(String segId){
		Query qr = s.createQuery(	"	from SegmentRiskMeasure a  where 1=1 " 
								+ 	" 	and   a.id.segId = :segId "
								);
		qr.setParameter("segId", segId);
		return (SegmentRiskMeasure)qr.uniqueResult();
	}
	
	
	public static List<OverallConstraints> getOverallConstraints(String optMthdlId){
		Query qr = s.createQuery(	" from OverallConstraints a where 1=1 " 
								+ 	" and   a.id.optMthdlId = :optMthdlId "
								+ 	" and   a.useYn = :useYn "
								);
		qr.setParameter("optMthdlId", optMthdlId);
		qr.setParameter("useYn", "Y");
		return qr.list();
		
	}
//	private static Map<String, OverallConstraints> prepareOverallConstraints(List<OverallConstraints> list){
//		Map<String, OverallConstraints> rst = new HashMap<String, OverallConstraints>();
//		for(OverallConstraints aa: list){
//			
//		}
//	}
	public static List<SegmentConstraints> getSegmentConstraints(String optMthdlId){
		Query qr = s.createQuery(	" from SegmentConstraints a where 1=1 " 
								+ 	" and   a.id.optMthdlId = :optMthdlId "
								+ 	" and   a.useYn = :useYn "
								);
		qr.setParameter("optMthdlId", optMthdlId);
		qr.setParameter("useYn", "Y");
		return qr.list();
	}
	

	public static List<SegmentScenario> getScenariosById(String bssd, String riskType, String segId, long sceNum) {
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
//		logger.info("segScenario Size : {},{}", segId, scenarios.size());
		
		for (SegmentScenario aa : scenarios) {
//			logger.info("segScenario : {},{}", aa.getId().getSceId(), aa.getSceValue());
		}
		return scenarios;
	}
	
	

	public static void getConstraints(String probId) {
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

	public static Map<String, List<SegmentScenario>> getScenarioMap(String bssd, String riskType, String segGroup, long sceNum) {
		Map<String, List<SegmentScenario>> rst = new HashMap<String, List<SegmentScenario>>();
		for ( SaaSegment aa : getSegmentByGroup(segGroup)){
//			logger.info("segScenario : {},{}", aa.getSegId(), aa.getSegGroupId());
			rst.put(aa.getSegId(), getScenariosById(bssd, riskType, aa.getSegId(), sceNum));
			
		}
		return rst;
	}
}
