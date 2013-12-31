package sample;

import com.eugenefe.valuation.hifive.IHiFiveMc;


public class TestHiFiveMc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("value0:");
		
		int nStock =3;
		double[] S0 = new double[nStock]; 
		double[] div = new double[nStock];
		int[] bUpHitted = new int[nStock];  		// IN:  Knock-out Barrier Hitting 여부
		S0[0] = 1;
		S0[1] =1;
		S0[2] =1;
		
		for(int i=0; i<nStock; i++){
			div[i]=0;
			bUpHitted[i]=0;
		}
		
		int nStrike =6;
		double[] X1= new double[nStrike];
		double[] X2= new double[nStrike];
		double[] X3= new double[nStrike];
		
		double[] upBarrier= new double[nStrike];		// IN:  Knock-out Barrier
		
		double[] amt1= new double[nStrike];			// IN:  행사가격1에 해당되는 중도상환 금액
		double[] amt2= new double[nStrike];			// IN:  행사가격2에 해당되는 중도상환 금액
		double[] amt3= new double[nStrike];			// IN:  행사가격3에 해당되는 중도상환 금액
		double[] coupon= new double[nStrike+1];			// IN:  추가 지급 쿠폰
		
		int[] dates= new int[nStrike]; 			// IN:  중간 평가일까지의 일수 
		int[] pay_dates= new int[nStrike]; 			// IN:  중간 지급일까지의 일수 
		double[] p = new double[nStrike+2];		// OUT: 중도상환 확률
		
		dates[0] = 175;
		dates[1] = 359;
		dates[2] = 540;
		dates[3] = 724;
		dates[4] = 905;
		dates[5] = 1089;
		
		X1[0] = 0.95;
		X1[1] = 0.95;
		X1[2] = 0.9;
		X1[3] = 0.9;
		X1[4] = 0.85;
		X1[5] = 0.85;
		
		amt1[0] = 1.042;
		amt1[1] = 1.084;
		amt1[2] = 1.126;
		amt1[3] = 1.168;
		amt1[4] = 1.21;
		amt1[5] = 1.25;
		
		
		for(int j=0; j<nStrike; j++){
//			X1[j] = (70 - j*5)/100;
			X2[j] = X1[j];
			X3[j] = X1[j];
			
			upBarrier[j] = 100; 
			
			
//			amt1[j] = (110 + j*5)/100;
			amt2[j] = amt1[j];
			amt3[j] =  amt1[j];
			coupon[j] =0;
			
//			dates[j] = 50 *(j+1);
			pay_dates[j] = dates[j];
			p[j] =0;
		}
		coupon[5] = 0.252;
		coupon[6]=0;
				
		int nt =2		;		
		double[] t = new double[nt];
		double[] rf= new double[nt*nStock];
//		double[] rf1= new double[nt];
//		double[] rf2= new double[nt];
		double[] rd = new double[nt];

		for(int k=0; k<nt; k++){
			t[k]=k+1;
//			rf1[k] = 0.02;
//			rf2[k] = 0.02;
			rd[k] = 0.02;
		}
		
		for(int k=0; k<nt*nStock; k++){
			rf[k]= 0.02;
		}
		
		int n_vol =2;
		double[] t_vol = new double[n_vol];
		double[] vol= new double[n_vol*nStock];
		double[] vol1= new double[n_vol];
		double[] vol2= new double[n_vol];
		double[] corr= new double[nStock*nStock];
//		double[][] rho= new double[n_vol][n_vol];
		
		for(int k=0; k<nt; k++){
			t_vol[k]=k+1;
			vol1[k] = 0.2;
			vol2[k] = 0.2;
		}
		for(int h=0; h<n_vol*nStock; h++){
			vol[h] = 0.2;
		}
		for(int h=0; h<nStock*nStock; h++){
			corr[h] = 0.9;
		}
		corr[0]=1;
		corr[4]=1;
		corr[8]=1;
		
		double downBarrier =0.55;		// IN:  Knock-in Barrier

		int upBarrierFlag = 0;		    // IN:  upBarrier 체크 방법(0:동시, 1:각각)
		int downBarrierFlag = 1;		// IN:  downBarrier 유무(0:없음, 1:있음)
		
		int bDownHitted =0;  		// IN:  Knock-in Barrier Hitting 여부
		int nTrials =1000;			// IN:  시행회수 
		double max_loss= 1;		// IN:  최대손실
		
//		double[] delta= new double[nStock];
//		double[] gamma =new double[nStock];
//		double[] theta =new double[nStock];
//		
//		double[] delta1= new double[nStock];
//		double[] gamma1 =new double[nStock];
//		double[] delta2= new double[nStock];
//		double[] gamma2 =new double[nStock];
//		double[] cross =new double[nStock];
		
		
//		for( int i=0; i<10; i++){
//		 nTrials = 10000*(i+1);	
//		double pv = IHiFiveMc.INSTANCE.HiFive_MC(S0, t, rf, rd, nt, t_vol, vol, n_vol, corr, div, nStock, X1, X2, X3,
//				upBarrier, downBarrier, amt1, amt2, amt3, coupon, dates, pay_dates, nStrike, upBarrierFlag, 
//				downBarrierFlag, bUpHitted, bDownHitted, nTrials, max_loss, p);
//		
//		
//		System.out.println("HiFive:"+i+"_"+pv);
//		}
		
//		for(int i=0 ; i< nStrike+2; i++){
//			System.out.println("HifiveMc_prob:"+p[i]);
//		}
		
		for( int j=0 ; j<nStock; j++){
			
			double MC_delta = IHiFiveMc.INSTANCE.HiFive_MC_Delta(j+1,S0, t, rf, rd, nt, t_vol, vol, n_vol, corr, div, nStock, X1, X2, X3,
				upBarrier, downBarrier, amt1, amt2, amt3, coupon, dates, pay_dates, nStrike, upBarrierFlag, 
				downBarrierFlag, bUpHitted, bDownHitted, nTrials, max_loss);
				
			System.out.println("HiFiveMC_delta:"+j+"_"+MC_delta);
		}
		
		double MC_vega = IHiFiveMc.INSTANCE.HiFive_MC_Vega(1,S0, t, rf, rd, nt, t_vol, vol, n_vol, corr, div, nStock, X1, X2, X3,
				upBarrier, downBarrier, amt1, amt2, amt3, coupon, dates, pay_dates, nStrike, upBarrierFlag, 
				downBarrierFlag, bUpHitted, bDownHitted, nTrials, max_loss);
		System.out.println("HiFiveMC_vega:"+MC_vega);
		
		double MC_rho = IHiFiveMc.INSTANCE.HiFive_MC_Rho(S0, t, rf, rd, nt, t_vol, vol, n_vol, corr, div, nStock, X1, X2, X3,
				upBarrier, downBarrier, amt1, amt2, amt3, coupon, dates, pay_dates, nStrike, upBarrierFlag, 
				downBarrierFlag, bUpHitted, bDownHitted, nTrials, max_loss);
				
		System.out.println("HiFiveMC_rho:"+MC_rho);
	}
}
