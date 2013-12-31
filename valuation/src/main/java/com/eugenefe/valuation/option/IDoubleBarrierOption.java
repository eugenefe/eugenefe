package com.eugenefe.valuation.option;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IDoubleBarrierOption extends Library {
	
	IDoubleBarrierOption pricer = (IDoubleBarrierOption)Native.loadLibrary("Option", IDoubleBarrierOption.class);
	double DoubleBarrier(
			int TypeFlag,		// Option Type: 아래 참고
			double S,		// 기초자산 현재가
			double X,		// 행사가격
			double L,		// 구간 최소값
			double U,		// 구간 최대값
			double T,		// 잔존만기(만기평가일,년환산)
			double T1,		// 잔존만기(만기지급일,년환산)
			double rf,		// 무위험 금리
			double rd,		// 할인금리
			double dvd,		// 배당율
			double vol,		// 변동성
			double bHitted		// 과거 히팅 여부
		);
	double DoubleBarrier_Delta (
			int TypeFlag, double S, double X, double L, double U, double T, double T1,
			double rf, double rd, double dvd, double vol, double bHitted
		);
	double DoubleBarrier_Gamma (
			int TypeFlag, double S, double X, double L, double U, double T, double T1,
			double rf, double rd, double dvd, double vol, double bHitted
		);
	double DoubleBarrier_Vega (
			int TypeFlag, double S, double X, double L, double U, double T, double T1,
			double rf, double rd, double dvd, double vol, double bHitted
		);
	double DoubleBarrier_Theta (
			int TypeFlag, double S, double X, double L, double U, double T, double T1,
			double rf, double rd, double dvd, double vol, double bHitted
		);
	double DoubleBarrier_Rho (
			int TypeFlag, double S, double X, double L, double U, double T, double T1,
			double rf, double rd, double dvd, double vol, double bHitted
		);

}
