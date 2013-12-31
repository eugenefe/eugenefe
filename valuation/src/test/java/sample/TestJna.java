package sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eugenefe.valuation.option.IPlainOption;


public class TestJna {
	private final static Logger logger = LoggerFactory.getLogger("ValuationTest");
	
	public static void main(String[] args) {
		logger.info("Start Valuation");
		
		double aa = IPlainOption.pricer.BSOption(1, 100, 100, 0.1, 0.1, 0.03, 0.03, 0, 0.2);
		logger.info("Option Value : {}", aa);

		double delta = IPlainOption.pricer.BSOption_Delta(1, 100, 100, 0.1, 0.1, 0.03, 0.03, 0, 0.2);
		logger.info("Option Delta : {}", delta);
		
		int	nIssueDay 			= 20090331	;
		int	nMatDay				= 20390331	;
		int	nFirstCouponDate=0;
		int	nLastCouponDate=0;
		int	nPreSellDay=0;
		int	nPreSellType	=	2	;
		int	nPreSellIntType	=	2	;
		int	nPreSellIntTaxType	=	1	;
		double	dblCouponRate	=	0.0676	;
		int	nPayType	=	13	;
		int	nPeriodMonth	=	3	;
		double	dblIssueRate	=	1	;
		int	nOriginType	=	3	;
		int	nCalcRemainDays	=	0	;
		double	dblCbPrcpReturnRate	=	1	;
		int	nPartialPayType	=	1	;
		int	nInstallmentFreq	=	0	;
		int	nInstallmentPeriodMonth	=	0	;
		int	nUnredeemPeriodMonth	=	0	;
		int	nSatType	=	0	;
		int	nPayTimeType	=	2	;
		int	nIsTips	=	0	;
		double	dblInflationRate	=	1	;
		int	nFloorType	=	1	;
		int	nProrated	=	0	;
		int	nStepping	=	1	;
		int	nIsLeap	=	1	;
		int	nIsKrwBond	=	0	;
		int	nDayCnt	=	9	;
		double	dblNotional	=	10000	;
		double	dblBuySellPrice	=	10000	;
		
		int	nHolidayCount	=	1	;
		int[]	nHolidayDate = new int[nHolidayCount];	
		
				nHolidayDate[0] = 1;
		
		int	nStepCount	=	1	;
		int[]	nVectorStepFlowPymt	 = new int[nStepCount]		;
		double[]	dblVectorStepRate = new double[nStepCount] 		;
				nVectorStepFlowPymt[0] = 20090331;
				dblVectorStepRate[0] = 	0.0676;	
		
		
		int	nRateCount	=	4	;
		double[]	dblVectorTerm	= new double[nRateCount]	;
		double[]	dblVectorRate	= new double[nRateCount]	;
		for(int k =0; k<4; k++){
			dblVectorTerm[k] = k+1;
			dblVectorRate[k] = 0.02;
		}
		
		int	nPriceDate	=	20110711	;
		int	nTextFlag	=	1	;
		
//		double	dblPrice =0			;
//		double	dblCleanPrice	= 0;		
//		double	dblModDuration	= 0;		
//		double	dblMacDuration	= 0;		
//		double	dblConvexity	= 0;		
//		double	dblPvbp	= 0;		
//		double	dblYtm	= 0;
		
		double[]	dblPrice = new double[100]			;
		double[]	dblCleanPrice	= new double[100];		
		double[]	dblModDuration	= new double[100];		
		double[]	dblMacDuration	= new double[100];		
		double[]	dblConvexity	= new double[100];		
		double[]	dblPvbp	= new double[100];		
		double[]	dblYtm	= new double[100];
		int[]	nPrnFlowDate	= new int[100];		
		double[]	dblPrnFlowAmt	= new double[100];		
		int[]	nIntFlowDate	= new int[100];		
		double[]	dblIntFlowAmt = new double[100]	;		

		for(int j=0 ; j<100; j++){
			dblPrice[j] =0;
				dblCleanPrice[j]	= 0;		
				dblModDuration[j]	= 0;		
				dblMacDuration[j]	= 0;		
				dblConvexity[j]	= 0;		
				dblPvbp[j]	= 0;		
				dblYtm[j]	= 0;
				nPrnFlowDate[j]	= 0;
				dblPrnFlowAmt[j]	= 0;
				nIntFlowDate[j]	= 0;
				dblIntFlowAmt[j]	= 0;
			
		}
		
		
//		int errorCode = IFixedBond.INSTANCE.CalcValueFromCurve(
//				nIssueDay, nMatDay, nFirstCouponDate, nLastCouponDate, nPreSellDay, nPreSellType, nPreSellIntType
//				, nPreSellIntTaxType, dblCouponRate, nPayType, nPeriodMonth, dblIssueRate, nOriginType, nCalcRemainDays
//				, dblCbPrcpReturnRate, nPartialPayType, nInstallmentFreq, nInstallmentPeriodMonth, nUnredeemPeriodMonth
//				, nSatType, nPayTimeType, nIsTips, dblInflationRate, nFloorType, nProrated, nStepping, nIsLeap
//				, nIsKrwBond, nDayCnt, dblNotional, dblBuySellPrice, nHolidayCount, nHolidayDate, nStepCount
//				, nVectorStepFlowPymt, dblVectorStepRate, nRateCount, dblVectorTerm, dblVectorRate, nPriceDate
//				, nTextFlag, dblPrice, dblCleanPrice, dblModDuration, dblMacDuration, dblConvexity, dblPvbp
//				, dblYtm, nPrnFlowDate, dblPrnFlowAmt, nIntFlowDate, dblIntFlowAmt);
//		System.out.println("value:" + fx);
		
//		String st = ICpUtil.INSTANCE.CodeToName("000660");
//		String st = IStockCode.INSTANCE.CodeToName("000660");
//		System.out.println("Stock:"+st);
		
//		int bb = IStockCode.INSTANCE.IsConnect();
//		System.out.println("Stock:"+bb);
	}
}
