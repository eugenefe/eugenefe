package com.eugenefe.valuation.basic;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IFixedBond extends Library {
	IFixedBond INSTANCE = (IFixedBond)Native.loadLibrary("KisPricingWin", IFixedBond.class);
	
//	public int CalcValueFromCurve ( 
//		int	nIssueDay
//	,	int	nMatDay
//	,	int	nFirstCouponDate
//	,	int	nLastCouponDate
//	,	int	nPreSellDay
//	,	int	nPreSellType
//	,	int	nPreSellIntType
//	,	int	nPreSellIntTaxType
//	,	double	dblCouponRate
//	,	int	nPayType
//	,	int	nPeriodMonth
//	,	double	dblIssueRate
//	,	int	nOriginType
//	,	int	nCalcRemainDays
//	,	double	dblCbPrcpReturnRate
//	,	int	nPartialPayType
//	,	int	nInstallmentFreq
//	,	int	nInstallmentPeriodMonth
//	,	int	nUnredeemPeriodMonth
//	,	int	nSatType
//	,	int	nPayTimeType
//	,	int	nIsTips
//	,	double	dblInflationRate
//	,	int	nFloorType
//	,	int	nProrated
//	,	int	nStepping
//	,	int	nIsLeap
//	,	int	nIsKrwBond
//	,	int	nDayCnt
//	,	double	dblNotional
//	,	double	dblBuySellPrice
//	,	int	nHolidayCount
//	,	int[]	nHolidayDate
//	,	int		nStepCount
//	,	int[]	nVectorStepFlowPymt
//	,	double[]	dblVectorStepRate
//	,	int		nRateCount
//	,	double[]	dblVectorTerm
//	,	double[]	dblVectorRate
//	,	int		nPriceDate
//	,	int		nTextFlag
//	,	double	dblPrice
//	,	double	dblCleanPrice
//	,	double	dblModDuration
//	,	double	dblMacDuration
//	,	double	dblConvexity
//	,	double	dblPvbp
//	,	double	dblYtm
//	,	int[]		nPrnFlowDate
//	,	double[]	dblPrnFlowAmt
//	,	int[]		nIntFlowDate
//	,	double[]	dblIntFlowAmt
//	);
	
	public int CalcValueFromCurve ( 
			int	nIssueDay
		,	int	nMatDay
		,	int	nFirstCouponDate
		,	int	nLastCouponDate
		,	int	nPreSellDay
		,	int	nPreSellType
		,	int	nPreSellIntType
		,	int	nPreSellIntTaxType
		,	double	dblCouponRate
		,	int	nPayType
		,	int	nPeriodMonth
		,	double	dblIssueRate
		,	int	nOriginType
		,	int	nCalcRemainDays
		,	double	dblCbPrcpReturnRate
		,	int	nPartialPayType
		,	int	nInstallmentFreq
		,	int	nInstallmentPeriodMonth
		,	int	nUnredeemPeriodMonth
		,	int	nSatType
		,	int	nPayTimeType
		,	int	nIsTips
		,	double	dblInflationRate
		,	int	nFloorType
		,	int	nProrated
		,	int	nStepping
		,	int	nIsLeap
		,	int	nIsKrwBond
		,	int	nDayCnt
		,	double	dblNotional
		,	double	dblBuySellPrice
		,	int	nHolidayCount
		,	int[]	nHolidayDate
		,	int		nStepCount
		,	int[]	nVectorStepFlowPymt
		,	double[]	dblVectorStepRate
		,	int		nRateCount
		,	double[]	dblVectorTerm
		,	double[]	dblVectorRate
		,	int		nPriceDate
		,	int		nTextFlag
		,	double[]	dblPrice
		,	double[]	dblCleanPrice
		,	double[]	dblModDuration
		,	double[]	dblMacDuration
		,	double[]	dblConvexity
		,	double[]	dblPvbp
		,	double[]	dblYtm
//		, double dlbYtm
		,	int[]		nPrnFlowDate
		,	double[]	dblPrnFlowAmt
		,	int[]		nIntFlowDate
		,	double[]	dblIntFlowAmt
		);
}
