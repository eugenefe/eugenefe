package com.eugenefe.valuation.option;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface ISingleBarrierOption  extends Library {
	
	ISingleBarrierOption pricer = (ISingleBarrierOption)Native.loadLibrary("Option", ISingleBarrierOption.class);
	
	double SingleBarrier(
			int TypeFlag,		// Option Type: 아래 참고
			double S,		// 기초자산 현재가
			double X,		// 행사가격
			double H,		// 베리어 수준
			double Rebate, 		// 리베이트 금액
			double T,      		// 잔존만기(만기평가일,년환산)      
			double T1,     		// 잔존만기(만기지급일,년환산)      
			double rf,		// 무위험 금리
			double rd,		// 할인금리
			double dvd,		// 배당율		 
			double vol,		// 변동성
			int bHitted		// 과거 베리어 히팅 여부
		);
	double SingleBarrier_Delta(
			int TypeFlag, double S, double X, double H, double Rebate, double T, double T1, 
			double rf, double rd, double dvd, double vol, int bHitted
			);
	double SingleBarrier_Gamma (
			int TypeFlag, double S, double X, double H, double Rebate, double T, double T1, 
			double rf, double rd, double dvd, double vol, int bHitted
			);

	double SingleBarrier_Vega (
			int TypeFlag, double S, double X, double H, double Rebate, double T, double T1, 
			double rf, double rd, double dvd, double vol, int bHitted
			);

	double SingleBarrier_Theta(
			int TypeFlag, double S, double X, double H, double Rebate, double T, double T1, 
			double rf, double rd, double dvd, double vol, int bHitted
			);

	double SingleBarrier_Rho (
			int TypeFlag, double S, double X, double H, double Rebate, double T, double T1, 
			double rf, double rd, double dvd, double vol, int bHitted
			);

}
