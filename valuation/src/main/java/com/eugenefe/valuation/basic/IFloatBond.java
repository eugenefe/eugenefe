package com.eugenefe.valuation.basic;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IFloatBond extends Library {
	IFloatBond INSTANCE = (IFloatBond)Native.loadLibrary("Floater", IFloatBond.class);
	
	
//	public double  Floater_pricing_price(
//				double issue_date
//				,double mat_date
//				,double interval
//				,double ipm
//				,double adr_flag
//				,double  numvoltenor
//				,double voltenor[]
//				,double cd_vol[]
//				,double yvol[]
//				,double qf
//				,double fx_vol
//				,double rho
//				,double spread
//				,double price_date
//				,double reval_date
//				,double ipmethod
//				, double time_ref[]
//				, double time_dis[]
//				, double ytm_mat_ref[]
//				, double ytm_mat_dis[]
//				, double numytm_ref
//				, double numytm_dis
//				, double  time_bump[]
//				, double  numytm_bump
//				, double fixedrate
//				, double dcconv[]
//				, double report[]
//				);
	
	public double  Floater_pricing_price(
			
			double issue_date 
			, double mat_date 
			, double interval 
			, double ipm 
			, double adr_flag 
		     ,double spread 
		     , double price_date 
		     , double reval_date  
		     , double ipmethod 
		     , double[] time_ref 
		     , double[] time_dis  
		     , double[] ytm_mat_ref 
		     , double[] ytm_mat_dis 
		     , double numytm_ref 
		     , double numytm_dis 
		     , double[] tim_bump 
		     , double numytm_bump 
		     , double fixedrate 
		     , double cpn_period 
		     , double n_cpn 
		     , double[] dcconv 
		     , double[] report 
		     
			);
	
}
