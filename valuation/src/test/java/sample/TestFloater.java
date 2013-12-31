package sample;

import com.eugenefe.valuation.basic.IFloatBond;


public class TestFloater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("value0:");

		int	nRateCount	=	8	;
	    
		double issue_date  = 20080528 ;
		double mat_date 	= 	20090528;
		double interval =3;
		double ipm = 12/interval;
		double adr_flag =1;
		
		double spread =0;
		double price_date = 20080628;
		double reval_date = 20080628;
		double ipmethod =1;

		double time_ref[]= new double[nRateCount];
		double time_dis[]= new double[nRateCount];
		double ytm_mat_ref[] = new double[nRateCount];
		double ytm_mat_dis[] = new double[nRateCount];
		
		double numytm_ref =nRateCount ;
		double numytm_dis = nRateCount ;
		
		double  time_bump[]= new double[nRateCount];
		double  numytm_bump= nRateCount;
		double fixedrate = 0.04162;
		double dcconv[]= new double[1];
		double report[] = new double[nRateCount];
		
		
		
		time_ref[0] =1/365;
		time_dis[0] = 1/365;
		time_bump[0] =1/365;
		ytm_mat_ref[0] = 0.05;
		ytm_mat_dis[0] = 0.02;
		report[0] =1.1;
		for(int k =1; k<nRateCount; k++){
			time_ref[k] = (k+1)/4;
			time_dis[k] = (k+1)/4;
			time_bump[k] =(k+1)/4;
			ytm_mat_ref[k] = 0.05;
			ytm_mat_dis[k] = 0.02;
			report[k]=1;
		}
		
		double cpn_period =0.25;
		double n_cpn =1; 
		dcconv[0] =1;



		double pv = IFloatBond.INSTANCE.Floater_pricing_price(issue_date, mat_date, interval, ipm, adr_flag, spread
				, price_date, reval_date, ipmethod, time_ref, time_dis, ytm_mat_ref, ytm_mat_dis, numytm_ref
				, numytm_dis, time_bump, numytm_bump,  fixedrate, cpn_period, n_cpn, dcconv, report);
		
		
		System.out.println("Stock:"+pv +"_"+ report[0]);
	}
}
