package sample;

import com.eugenefe.valuation.basic.IPureBond;


public class TestPureBond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("value0:");
		
		
		
		int	nRateCount	=	4	;
		double[]	dblVectorTerm	= new double[nRateCount]	;
		double[]	dblVectorRate	= new double[nRateCount]	;
		for(int k =0; k<4; k++){
			dblVectorTerm[k] = k+1;
			dblVectorRate[k] = 0.02;
		}
		



		double pv = IPureBond.INSTANCE.Pure_Bond_Price(dblVectorTerm, dblVectorRate, 4, 100, 366);
		
		
		System.out.println("Stock:"+pv);
	}
}
