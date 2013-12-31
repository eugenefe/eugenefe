package com.eugenefe.valuation.option;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public interface IPlainOption extends Library {
	
	IPlainOption pricer = (IPlainOption)Native.loadLibrary((Platform.isWindows()? "takion77_Option": "OptionLinux"), IPlainOption.class);
	
	public double BSOption(
			int TypeFlag,	// Option Type: 1이면 콜, 2이면 풋
			double S,		// 기초자산 현재가				
			double X,		// 행사가격
			double T,		// 잔존만기(만기평가일,년환산)
			double T1,		// 잔존만기(만기지급일,년환산)
			double rf,		// 무위험 금리
			double rd,		// 할인금리
			double dvd,		// 배당율
			double vol		// 변동성
		);
	
	public double BSOption_Delta(
			int TypeFlag
			, double S
			, double X
			, double T
			, double T1
			, double rf
			, double rd
			, double dvd
			, double vol
			);
	public double BSOption_Gamma(
			int TypeFlag
			, double S
			, double X
			, double T
			, double T1
			, double rf
			, double rd
			, double dvd
			, double vol
			);


	public double BSOption_Vega(
			int TypeFlag
			, double S
			, double X
			, double T
			, double T1
			, double rf
			, double rd
			, double dvd
			, double vol
			);


	public double BSOption_Theta(
			int TypeFlag
			, double S
			, double X
			, double T
			, double T1
			, double rf
			, double rd
			, double dvd
			, double vol
			);

	public double BSOption_Rho(  
			int TypeFlag
			, double S
			, double X
			, double T
			, double T1
			, double rf
			, double rd
			, double dvd
			, double vol
			);
}
