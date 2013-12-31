package com.eugenefe.valuation.fx;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IFxForward extends Library {
	IFxForward pricer = (IFxForward)Native.loadLibrary("FX_Basic", IFxForward.class);
	
	double FX_Forward(
			double F0
			, double X
			, double r
			, double rf
			, double rd
			, double T
			, double T1 
		);
	double FX_Forward_Delta(
			double F0
			, double X
			, double r
			, double rf
			, double rd
			, double T
			, double T1 
		);
//	double FX_Forward_Gamma(
//			double F0
//			, double X
//			, double r
//			, double rf
//			, double rd
//			, double T
//			, double T1
//		) ;
//	double FX_Forward_Vega(
//			double F0
//			, double X
//			, double r
//			, double rf
//			, double rd
//			, double T
//			, double T1		
//			) ;
	double FX_Forward_Theta(
			double F0
			, double X
			, double r
			, double rf
			, double rd
			, double T
			, double T1		
			) ;
	double FX_Forward_Rho(
			double F0
			, double X
			, double r
			, double rf
			, double rd
			, double T
			, double T1		
			) ;

}
