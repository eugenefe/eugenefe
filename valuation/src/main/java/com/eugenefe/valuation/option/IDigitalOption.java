package com.eugenefe.valuation.option;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IDigitalOption extends Library {
	
	IDigitalOption pricer = (IDigitalOption)Native.loadLibrary("Option", IDigitalOption.class);
	
	double DigitalOption(
			int TypeFlag,		// Option Type: 1이면 콜, 2이면 풋
			double S,		// 기초자산 현재가
			double X,		// 행사가격
			double T,		// 잔존만기(만기평가일,년환산)
			double T1,		// 잔존만기(만기지급일,년환산)
			double rf,		// 무위험 금리
			double rd,		// 할인금리
			double dvd,		// 배당율
			double vol,		// 변동성
			double fix_amt		// 지급액
		);
	double DigitalOption_Delta(
			int TypeFlag,		// Option Type: 1이면 콜, 2이면 풋
			double S,		// 기초자산 현재가
			double X,		// 행사가격
			double T,		// 잔존만기(만기평가일,년환산)
			double T1,		// 잔존만기(만기지급일,년환산)
			double rf,		// 무위험 금리
			double rd,		// 할인금리
			double dvd,		// 배당율
			double vol,		// 변동성
			double fix_amt		// 지급액
			);
	double DigitalOption_Gamma (
			int TypeFlag,		// Option Type: 1이면 콜, 2이면 풋
			double S,		// 기초자산 현재가
			double X,		// 행사가격
			double T,		// 잔존만기(만기평가일,년환산)
			double T1,		// 잔존만기(만기지급일,년환산)
			double rf,		// 무위험 금리
			double rd,		// 할인금리
			double dvd,		// 배당율
			double vol,		// 변동성
			double fix_amt		// 지급액
			);

	
	double DigitalOption_Vega (
			int TypeFlag,		// Option Type: 1이면 콜, 2이면 풋
			double S,		// 기초자산 현재가
			double X,		// 행사가격
			double T,		// 잔존만기(만기평가일,년환산)
			double T1,		// 잔존만기(만기지급일,년환산)
			double rf,		// 무위험 금리
			double rd,		// 할인금리
			double dvd,		// 배당율
			double vol,		// 변동성
			double fix_amt		// 지급액
			);
	double DigitalOption_Theta (
			int TypeFlag,		// Option Type: 1이면 콜, 2이면 풋
			double S,		// 기초자산 현재가
			double X,		// 행사가격
			double T,		// 잔존만기(만기평가일,년환산)
			double T1,		// 잔존만기(만기지급일,년환산)
			double rf,		// 무위험 금리
			double rd,		// 할인금리
			double dvd,		// 배당율
			double vol,		// 변동성
			double fix_amt		// 지급액
	);
	
	double DigitalOption_Rho (
			int TypeFlag,		// Option Type: 1이면 콜, 2이면 풋
			double S,		// 기초자산 현재가
			double X,		// 행사가격
			double T,		// 잔존만기(만기평가일,년환산)
			double T1,		// 잔존만기(만기지급일,년환산)
			double rf,		// 무위험 금리
			double rd,		// 할인금리
			double dvd,		// 배당율
			double vol,		// 변동성
			double fix_amt		// 지급액
			);

}
