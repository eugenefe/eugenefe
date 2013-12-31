package com.eugenefe.valuation.hifive;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IHiFiveMcLocalVol extends Library {
	IHiFiveMcLocalVol INSTANCE = (IHiFiveMcLocalVol)Native.loadLibrary("HiFive_MC", IHiFiveMcLocalVol.class);
	
	double HiFive_MC(			//OUT: 가격 
			double[] S0,			// IN:  기초자산 현재가 
			double[] t,			// IN:  기간 구조 시점	
			double[] rf, 			// IN:  무위험이자율 기간구조
			double[] rd, 			// IN:  할인이자율 기간구조
			int nt,				// IN:  기간 구조 데이터 개수
			double[] t_vol,			// IN:  변동성 만기 시점
			double[] vol,			// IN:  기초자산 변동성 
			int n_vol,			// IN:  각 변동성 데이터 개수
			double[] rho,			// IN:  기초자산 상관계수
			double[] div,			// IN:  기초자산 배당율 
			int nStock,			// IN:  기초자산 개수
			double[] X1,			// IN:  행사가격1
			double[] X2,			// IN:  행사가격2
			double[] X3,			// IN:  행사가격3
			double[] upBarrier,		// IN:  Knock-out Barrier
			double downBarrier,		// IN:  Knock-in Barrier
			double[] amt1,			// IN:  행사가격1에 해당되는 중도상환 금액
			double[] amt2,			// IN:  행사가격2에 해당되는 중도상환 금액
			double[] amt3,			// IN:  행사가격3에 해당되는 중도상환 금액
			double[] coupon,			// IN:  추가 지급 쿠폰 
			int[] dates, 			// IN:  중간 평가일까지의 일수 
			int[] pay_dates, 			// IN:  중간 지급일까지의 일수 
			int nStrike, 			// IN:  중간평가일 수 
			int upBarrierFlag,		// IN:  upBarrier 체크 방법(0:동시, 1:각각)
			int downBarrierFlag,		// IN:  downBarrier 유무(0:없음, 1:있음)
			int[] bUpHitted,  		// IN:  Knock-out Barrier Hitting 여부
			int bDownHitted,  		// IN:  Knock-in Barrier Hitting 여부
			int nTrials,			// IN:  시행회수 
			double max_loss,		// IN:  최대손실
			double[] p			// OUT: 중도상환 확률
		);
	
	double HiFive_MC_Delta(
			int index,
			double[] S0,			// IN:  기초자산 현재가 
			double[] t,			// IN:  기간 구조 시점	
			double[] rf, 			// IN:  무위험이자율 기간구조
			double[] rd, 			// IN:  할인이자율 기간구조
			int nt,				// IN:  기간 구조 데이터 개수
			double[] t_vol,			// IN:  변동성 만기 시점
			double[] vol,			// IN:  기초자산 변동성 
			int n_vol,			// IN:  각 변동성 데이터 개수
			double[] rho,			// IN:  기초자산 상관계수
			double[] div,			// IN:  기초자산 배당율 
			int nStock,			// IN:  기초자산 개수
			double[] X1,			// IN:  행사가격1
			double[] X2,			// IN:  행사가격2
			double[] X3,			// IN:  행사가격3
			double[] upBarrier,		// IN:  Knock-out Barrier
			double downBarrier,		// IN:  Knock-in Barrier
			double[] amt1,			// IN:  행사가격1에 해당되는 중도상환 금액
			double[] amt2,			// IN:  행사가격2에 해당되는 중도상환 금액
			double[] amt3,			// IN:  행사가격3에 해당되는 중도상환 금액
			double[] coupon,			// IN:  추가 지급 쿠폰 
			int[] dates, 			// IN:  중간 평가일까지의 일수 
			int[] pay_dates, 			// IN:  중간 지급일까지의 일수 
			int nStrike, 			// IN:  중간평가일 수 
			int upBarrierFlag,		// IN:  upBarrier 체크 방법(0:동시, 1:각각)
			int downBarrierFlag,		// IN:  downBarrier 유무(0:없음, 1:있음)
			int[] bUpHitted,  		// IN:  Knock-out Barrier Hitting 여부
			int bDownHitted,  		// IN:  Knock-in Barrier Hitting 여부
			int nTrials,			// IN:  시행회수 
			double max_loss		// IN:  최대손실
		);

	double HiFive_MC_Gamma(
			int index,
			double[] S0,			// IN:  기초자산 현재가 
			double[] t,			// IN:  기간 구조 시점	
			double[] rf, 			// IN:  무위험이자율 기간구조
			double[] rd, 			// IN:  할인이자율 기간구조
			int nt,				// IN:  기간 구조 데이터 개수
			double[] t_vol,			// IN:  변동성 만기 시점
			double[] vol,			// IN:  기초자산 변동성 
			int n_vol,			// IN:  각 변동성 데이터 개수
			double[] rho,			// IN:  기초자산 상관계수
			double[] div,			// IN:  기초자산 배당율 
			int nStock,			// IN:  기초자산 개수
			double[] X1,			// IN:  행사가격1
			double[] X2,			// IN:  행사가격2
			double[] X3,			// IN:  행사가격3
			double[] upBarrier,		// IN:  Knock-out Barrier
			double downBarrier,		// IN:  Knock-in Barrier
			double[] amt1,			// IN:  행사가격1에 해당되는 중도상환 금액
			double[] amt2,			// IN:  행사가격2에 해당되는 중도상환 금액
			double[] amt3,			// IN:  행사가격3에 해당되는 중도상환 금액
			double[] coupon,			// IN:  추가 지급 쿠폰 
			int[] dates, 			// IN:  중간 평가일까지의 일수 
			int[] pay_dates, 			// IN:  중간 지급일까지의 일수 
			int nStrike, 			// IN:  중간평가일 수 
			int upBarrierFlag,		// IN:  upBarrier 체크 방법(0:동시, 1:각각)
			int downBarrierFlag,		// IN:  downBarrier 유무(0:없음, 1:있음)
			int[] bUpHitted,  		// IN:  Knock-out Barrier Hitting 여부
			int bDownHitted,  		// IN:  Knock-in Barrier Hitting 여부
			int nTrials,			// IN:  시행회수 
			double max_loss		// IN:  최대손실
		);

	double HiFive_MC_Vega(
			int index,
			double[] S0,			// IN:  기초자산 현재가 
			double[] t,			// IN:  기간 구조 시점	
			double[] rf, 			// IN:  무위험이자율 기간구조
			double[] rd, 			// IN:  할인이자율 기간구조
			int nt,				// IN:  기간 구조 데이터 개수
			double[] t_vol,			// IN:  변동성 만기 시점
			double[] vol,			// IN:  기초자산 변동성 
			int n_vol,			// IN:  각 변동성 데이터 개수
			double[] rho,			// IN:  기초자산 상관계수
			double[] div,			// IN:  기초자산 배당율 
			int nStock,			// IN:  기초자산 개수
			double[] X1,			// IN:  행사가격1
			double[] X2,			// IN:  행사가격2
			double[] X3,			// IN:  행사가격3
			double[] upBarrier,		// IN:  Knock-out Barrier
			double downBarrier,		// IN:  Knock-in Barrier
			double[] amt1,			// IN:  행사가격1에 해당되는 중도상환 금액
			double[] amt2,			// IN:  행사가격2에 해당되는 중도상환 금액
			double[] amt3,			// IN:  행사가격3에 해당되는 중도상환 금액
			double[] coupon,			// IN:  추가 지급 쿠폰 
			int[] dates, 			// IN:  중간 평가일까지의 일수 
			int[] pay_dates, 			// IN:  중간 지급일까지의 일수 
			int nStrike, 			// IN:  중간평가일 수 
			int upBarrierFlag,		// IN:  upBarrier 체크 방법(0:동시, 1:각각)
			int downBarrierFlag,		// IN:  downBarrier 유무(0:없음, 1:있음)
			int[] bUpHitted,  		// IN:  Knock-out Barrier Hitting 여부
			int bDownHitted,  		// IN:  Knock-in Barrier Hitting 여부
			int nTrials,			// IN:  시행회수 
			double max_loss		// IN:  최대손실
		);

	double HiFive_MC_Theta(
			double[] S0,			// IN:  기초자산 현재가 
			double[] t,			// IN:  기간 구조 시점	
			double[] rf, 			// IN:  무위험이자율 기간구조
			double[] rd, 			// IN:  할인이자율 기간구조
			int nt,				// IN:  기간 구조 데이터 개수
			double[] t_vol,			// IN:  변동성 만기 시점
			double[] vol,			// IN:  기초자산 변동성 
			int n_vol,			// IN:  각 변동성 데이터 개수
			double[] rho,			// IN:  기초자산 상관계수
			double[] div,			// IN:  기초자산 배당율 
			int nStock,			// IN:  기초자산 개수
			double[] X1,			// IN:  행사가격1
			double[] X2,			// IN:  행사가격2
			double[] X3,			// IN:  행사가격3
			double[] upBarrier,		// IN:  Knock-out Barrier
			double downBarrier,		// IN:  Knock-in Barrier
			double[] amt1,			// IN:  행사가격1에 해당되는 중도상환 금액
			double[] amt2,			// IN:  행사가격2에 해당되는 중도상환 금액
			double[] amt3,			// IN:  행사가격3에 해당되는 중도상환 금액
			double[] coupon,			// IN:  추가 지급 쿠폰 
			int[] dates, 			// IN:  중간 평가일까지의 일수 
			int[] pay_dates, 			// IN:  중간 지급일까지의 일수 
			int nStrike, 			// IN:  중간평가일 수 
			int upBarrierFlag,		// IN:  upBarrier 체크 방법(0:동시, 1:각각)
			int downBarrierFlag,		// IN:  downBarrier 유무(0:없음, 1:있음)
			int[] bUpHitted,  		// IN:  Knock-out Barrier Hitting 여부
			int bDownHitted,  		// IN:  Knock-in Barrier Hitting 여부
			int nTrials,			// IN:  시행회수 
			double max_loss		// IN:  최대손실
		);
	double HiFive_MC_Rho(
			double[] S0,			// IN:  기초자산 현재가 
			double[] t,			// IN:  기간 구조 시점	
			double[] rf, 			// IN:  무위험이자율 기간구조
			double[] rd, 			// IN:  할인이자율 기간구조
			int nt,				// IN:  기간 구조 데이터 개수
			double[] t_vol,			// IN:  변동성 만기 시점
			double[] vol,			// IN:  기초자산 변동성 
			int n_vol,			// IN:  각 변동성 데이터 개수
			double[] rho,			// IN:  기초자산 상관계수
			double[] div,			// IN:  기초자산 배당율 
			int nStock,			// IN:  기초자산 개수
			double[] X1,			// IN:  행사가격1
			double[] X2,			// IN:  행사가격2
			double[] X3,			// IN:  행사가격3
			double[] upBarrier,		// IN:  Knock-out Barrier
			double downBarrier,		// IN:  Knock-in Barrier
			double[] amt1,			// IN:  행사가격1에 해당되는 중도상환 금액
			double[] amt2,			// IN:  행사가격2에 해당되는 중도상환 금액
			double[] amt3,			// IN:  행사가격3에 해당되는 중도상환 금액
			double[] coupon,			// IN:  추가 지급 쿠폰 
			int[] dates, 			// IN:  중간 평가일까지의 일수 
			int[] pay_dates, 			// IN:  중간 지급일까지의 일수 
			int nStrike, 			// IN:  중간평가일 수 
			int upBarrierFlag,		// IN:  upBarrier 체크 방법(0:동시, 1:각각)
			int downBarrierFlag,		// IN:  downBarrier 유무(0:없음, 1:있음)
			int[] bUpHitted,  		// IN:  Knock-out Barrier Hitting 여부
			int bDownHitted,  		// IN:  Knock-in Barrier Hitting 여부
			int nTrials,			// IN:  시행회수 
			double max_loss		// IN:  최대손실
		);

}
