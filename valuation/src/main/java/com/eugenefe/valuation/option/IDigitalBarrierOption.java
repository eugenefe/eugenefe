package com.eugenefe.valuation.option;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IDigitalBarrierOption extends Library {
	
	IDigitalBarrierOption pricer = (IDigitalBarrierOption)Native.loadLibrary("Option", IDigitalBarrierOption.class);
	
	double DigitalBarrier(
			int TypeFlag,		// Option Type: 아래 참고
			double S,		// 기초자산 현재가
			double X,		// 행사가격
			double H,		// 베리어 수준
			double T,		// 잔존만기(만기평가일,년환산)
			double T1,		// 잔존만기(만기지급일,년환산)
			double rf,		// 무위험 금리
			double rd,		// 할인금리
			double dvd,		// 배당율
			double vol,		// 변동성
			double fix_amt,		// 지급액
			int bHitted		// 히팅여부
		);

	double DigitalBarrier_Delta (
			int TypeFlag, double S, double X, double H, double T, double T1,
			double rf, double rd, double dvd, double vol, double fix_amt, int bHitted
		);
	double DigitalBarrier_Gamma (
			int TypeFlag, double S, double X, double H, double T, double T1,
			double rf, double rd, double dvd, double vol, double fix_amt, int bHitted
		);
	double DigitalBarrier_Vega (
			int TypeFlag, double S, double X, double H, double T, double T1,
			double rf, double rd, double dvd, double vol, double fix_amt, int bHitted
		);
	double DigitalBarrier_Theta (
			int TypeFlag, double S, double X, double H, double T, double T1,
			double rf, double rd, double dvd, double vol, double fix_amt, int bHitted
		);
	double DigitalBarrier_Rho (
			int TypeFlag, double S, double X, double H, double T, double T1,
			double rf, double rd, double dvd, double vol, double fix_amt, int bHitted
		);

}
