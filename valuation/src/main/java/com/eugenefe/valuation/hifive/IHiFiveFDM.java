package com.eugenefe.valuation.hifive;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IHiFiveFDM extends Library {
	IHiFiveFDM INSTANCE = (IHiFiveFDM)Native.loadLibrary("takion77_HiFive_FDM", IHiFiveFDM.class);
	
	
	public double HiFive1D_FDM(			// OUT: 가격
			double S0, 			// IN: 기초자산 현재가
			double[] t,			// IN: 기간 구조 시점	
			double[] rf, 			// IN: 무위험이자율 기간구조
			double[] rd, 			// IN: 할인이자율 기간구조
			int nt,				// IN: 기간 구조 데이터 개수
			double div, 			// IN: 기초자산 배당률
			
			double[] t_vol,			// IN:  변동성 만기 시점
			double[] vol, 			// IN: 기초자산 변동성 기간 구조
			int n_vol,			// IN: 변동성 데이터 개수
			
			double[] X1,			// IN: 행사가격1
			double[] X2,			// IN: 행사가격2
			double[] X3,			// IN: 행사가격3
			
			double[] upBarrier,		// IN: Knock-out Barrier
			double downBarrier,		// IN: Knock-in Barrier
			
			
			double[] amt1,			// IN: 행사가격1에 해당되는 중도상환 금액
			double[] amt2,			// IN: 행사가격2에 해당되는 중도상환 금액
			double[] amt3,			// IN: 행사가격3에 해당되는 중도상환 금액
			
			double[] coupon,			// IN: 추가 지급 쿠폰 
			int[] dates, 			// IN: 중간 평가일까지의 일수 
			int[] pay_dates, 			// IN: 중간 지급일까지의 일수 
			int nStrike, 			// IN: 중간평가일 수 
			int downBarrierFlag,		// IN:  downBarrier 유무(0:없음, 1:있음)
			int bUpHitted,  			// IN: Knock-out Barrier Hitting 여부
			int bDownHitted,  		// IN: Knock-in Barrier Hitting 여부
			double max_loss,		// IN: 최대손실

			double[] delta, 			// OUT: 델타값
			double[] gamma, 		// OUT: 감마값
			double[] theta			// OUT: 쎄타값
		);
	
	public double HiFive1D_FDM_Vega(
			double S0, 			// IN: 기초자산 현재가
			double[] t,			// IN: 기간 구조 시점	
			double[] rf, 			// IN: 무위험이자율 기간구조
			double[] rd, 			// IN: 할인이자율 기간구조
			int nt,				// IN: 기간 구조 데이터 개수
			double div, 			// IN: 기초자산 배당률
			double[] t_vol,			// IN:  변동성 만기 시점
			double[] vol, 			// IN: 기초자산 변동성 기간 구조
			int n_vol,			// IN: 변동성 데이터 개수
			double[] X1,			// IN: 행사가격1
			double[] X2,			// IN: 행사가격2
			double[] X3,			// IN: 행사가격3
			double[] upBarrier,		// IN: Knock-out Barrier
			double downBarrier,		// IN: Knock-in Barrier
			double[] amt1,			// IN: 행사가격1에 해당되는 중도상환 금액
			double[] amt2,			// IN: 행사가격2에 해당되는 중도상환 금액
			double[] amt3,			// IN: 행사가격3에 해당되는 중도상환 금액
			double[] coupon,			// IN: 추가 지급 쿠폰 
			int[] dates, 			// IN: 중간 평가일까지의 일수 
			int[] pay_dates, 			// IN: 중간 지급일까지의 일수 
			int nStrike, 			// IN: 중간평가일 수 
			int downBarrierFlag,		// IN:  downBarrier 유무(0:없음, 1:있음)
			int bUpHitted,  			// IN: Knock-out Barrier Hitting 여부
			int bDownHitted,  		// IN: Knock-in Barrier Hitting 여부
			double max_loss		// IN: 최대손실
		);

	public double HiFive1D_FDM_Rho(
			double S0, 			// IN: 기초자산 현재가
			double[] t,			// IN: 기간 구조 시점	
			double[] rf, 			// IN: 무위험이자율 기간구조
			double[] rd, 			// IN: 할인이자율 기간구조
			int nt,				// IN: 기간 구조 데이터 개수
			double div, 			// IN: 기초자산 배당률
			double[] t_vol,			// IN:  변동성 만기 시점
			double[] vol, 			// IN: 기초자산 변동성 기간 구조
			int n_vol,			// IN: 변동성 데이터 개수
			double[] X1,			// IN: 행사가격1
			double[] X2,			// IN: 행사가격2
			double[] X3,			// IN: 행사가격3
			double[] upBarrier,		// IN: Knock-out Barrier
			double downBarrier,		// IN: Knock-in Barrier
			double[] amt1,			// IN: 행사가격1에 해당되는 중도상환 금액
			double[] amt2,			// IN: 행사가격2에 해당되는 중도상환 금액
			double[] amt3,			// IN: 행사가격3에 해당되는 중도상환 금액
			double[] coupon,			// IN: 추가 지급 쿠폰 
			int[] dates, 			// IN: 중간 평가일까지의 일수 
			int[] pay_dates, 			// IN: 중간 지급일까지의 일수 
			int nStrike, 			// IN: 중간평가일 수 
			int downBarrierFlag,		// IN:  downBarrier 유무(0:없음, 1:있음)
			int bUpHitted,  			// IN: Knock-out Barrier Hitting 여부
			int bDownHitted,  		// IN: Knock-in Barrier Hitting 여부
			double max_loss		// IN: 최대손실
		);
	
	public double HiFive2D_FDM(			// OUT: 가격
			double S10, 
			double S20,			// IN: 기초자산 현재가
			double[] t,			// IN: 기간 구조 시점	
			double[] rf1, 			// IN: 무위험이자율 기간구조
			double[] rf2, 			// IN: 무위험이자율 기간구조
			double[] rd, 			// IN: 할인이자율 기간구조
			int nt,				// IN: 기간 구조 데이터 개수
			double[] t_vol,			// IN:  변동성 만기 시점
			double[] vol1, 			// IN: 기초자산 변동성 기간 구조
			double[] vol2, 		// IN: 기초자산 변동성
			int n_vol,			// IN: 변동성 데이터 개수
			double rho,			// IN: 기초자산 상관계수 
			double div1, 
			double div2,		// IN: 기초자산 배당률
			double[] X1,			// IN: 행사가격1
			double[] X2,			// IN: 행사가격2
			double[] X3,			// IN: 행사가격3
			double[] upBarrier,		// IN: Knock-out Barrier
			double downBarrier,		// IN: Knock-in Barrier
			double[] amt1,			// IN: 행사가격1에 해당되는 중도상환 금액
			double[] amt2,			// IN: 행사가격2에 해당되는 중도상환 금액
			double[] amt3,			// IN: 행사가격3에 해당되는 중도상환 금액
			double[] coupon,			// IN: 추가 지급 쿠폰 
			int[] dates, 			// IN: 중간 평가일까지의 일수 
			int[] pay_dates, 			// IN: 중간 지급일까지의 일수 
			int nStrike, 			// IN: 중간평가일 수 
			int downBarrierFlag,		// IN:  downBarrier 유무(0:없음, 1:있음)
			int bUpHitted,  			// IN: Knock-out Barrier Hitting 여부
			int bDownHitted,  		// IN: Knock-in Barrier Hitting 여부
			int nx,					// IN: 주식 축의 분할 개수 
			double max_loss,		// IN: 최대손실
			double[] delta1, 
			double[] delta2,	// OUT: 델타값
			double[] gamma1, 
			double[] gamma2,	// OUT: 감마값 
			double[] cross,			// OUT: 교차미분값 
			double[] theta			// OUT: 쎄타값
		);

	double HiFive2D_FDM_Vega1(	 
			double S10, 
			double S20,			// IN: 기초자산 현재가
			double[] t,			// IN: 기간 구조 시점	
			double[] rf1, 			// IN: 무위험이자율 기간구조
			double[] rf2, 			// IN: 무위험이자율 기간구조
			double[] rd, 			// IN: 할인이자율 기간구조
			int nt,				// IN: 기간 구조 데이터 개수
			double[] t_vol,			// IN:  변동성 만기 시점
			double[] vol1, 			// IN: 기초자산 변동성 기간 구조
			double[] vol2, 		// IN: 기초자산 변동성
			int n_vol,			// IN: 변동성 데이터 개수
			double rho,			// IN: 기초자산 상관계수 
			double div1, 
			double div2,		// IN: 기초자산 배당률
			double[] X1,			// IN: 행사가격1
			double[] X2,			// IN: 행사가격2
			double[] X3,			// IN: 행사가격3
			double[] upBarrier,		// IN: Knock-out Barrier
			double downBarrier,		// IN: Knock-in Barrier
			double[] amt1,			// IN: 행사가격1에 해당되는 중도상환 금액
			double[] amt2,			// IN: 행사가격2에 해당되는 중도상환 금액
			double[] amt3,			// IN: 행사가격3에 해당되는 중도상환 금액
			double[] coupon,			// IN: 추가 지급 쿠폰 
			int[] dates, 			// IN: 중간 평가일까지의 일수 
			int[] pay_dates, 			// IN: 중간 지급일까지의 일수 
			int nStrike, 			// IN: 중간평가일 수 
			int downBarrierFlag,		// IN:  downBarrier 유무(0:없음, 1:있음)
			int bUpHitted,  			// IN: Knock-out Barrier Hitting 여부
			int bDownHitted,  		// IN: Knock-in Barrier Hitting 여부
			int nx,					// IN: 주식 축의 분할 개수 
			double max_loss		// IN: 최대손실
		);

	double HiFive2D_FDM_Vega2(	 
			double S10, 
			double S20,			// IN: 기초자산 현재가
			double[] t,			// IN: 기간 구조 시점	
			double[] rf1, 			// IN: 무위험이자율 기간구조
			double[] rf2, 			// IN: 무위험이자율 기간구조
			double[] rd, 			// IN: 할인이자율 기간구조
			int nt,				// IN: 기간 구조 데이터 개수
			double[] t_vol,			// IN:  변동성 만기 시점
			double[] vol1, 			// IN: 기초자산 변동성 기간 구조
			double[] vol2, 		// IN: 기초자산 변동성
			int n_vol,			// IN: 변동성 데이터 개수
			double rho,			// IN: 기초자산 상관계수 
			double div1, 
			double div2,		// IN: 기초자산 배당률
			double[] X1,			// IN: 행사가격1
			double[] X2,			// IN: 행사가격2
			double[] X3,			// IN: 행사가격3
			double[] upBarrier,		// IN: Knock-out Barrier
			double downBarrier,		// IN: Knock-in Barrier
			double[] amt1,			// IN: 행사가격1에 해당되는 중도상환 금액
			double[] amt2,			// IN: 행사가격2에 해당되는 중도상환 금액
			double[] amt3,			// IN: 행사가격3에 해당되는 중도상환 금액
			double[] coupon,			// IN: 추가 지급 쿠폰 
			int[] dates, 			// IN: 중간 평가일까지의 일수 
			int[] pay_dates, 			// IN: 중간 지급일까지의 일수 
			int nStrike, 			// IN: 중간평가일 수 
			int downBarrierFlag,		// IN:  downBarrier 유무(0:없음, 1:있음)
			int bUpHitted,  			// IN: Knock-out Barrier Hitting 여부
			int bDownHitted,  		// IN: Knock-in Barrier Hitting 여부
			int nx,					// IN: 주식 축의 분할 개수 
			double max_loss		// IN: 최대손실
		);
	
	double HiFive2D_FDM_Rho(	
			double S10, 
			double S20,			// IN: 기초자산 현재가
			double[] t,			// IN: 기간 구조 시점	
			double[] rf1, 			// IN: 무위험이자율 기간구조
			double[] rf2, 			// IN: 무위험이자율 기간구조
			double[] rd, 			// IN: 할인이자율 기간구조
			int nt,				// IN: 기간 구조 데이터 개수
			double[] t_vol,			// IN:  변동성 만기 시점
			double[] vol1, 			// IN: 기초자산 변동성 기간 구조
			double[] vol2, 		// IN: 기초자산 변동성
			int n_vol,			// IN: 변동성 데이터 개수
			double rho,			// IN: 기초자산 상관계수 
			double div1, 
			double div2,		// IN: 기초자산 배당률
			double[] X1,			// IN: 행사가격1
			double[] X2,			// IN: 행사가격2
			double[] X3,			// IN: 행사가격3
			double[] upBarrier,		// IN: Knock-out Barrier
			double downBarrier,		// IN: Knock-in Barrier
			double[] amt1,			// IN: 행사가격1에 해당되는 중도상환 금액
			double[] amt2,			// IN: 행사가격2에 해당되는 중도상환 금액
			double[] amt3,			// IN: 행사가격3에 해당되는 중도상환 금액
			double[] coupon,			// IN: 추가 지급 쿠폰 
			int[] dates, 			// IN: 중간 평가일까지의 일수 
			int[] pay_dates, 			// IN: 중간 지급일까지의 일수 
			int nStrike, 			// IN: 중간평가일 수 
			int downBarrierFlag,		// IN:  downBarrier 유무(0:없음, 1:있음)
			int bUpHitted,  			// IN: Knock-out Barrier Hitting 여부
			int bDownHitted,  		// IN: Knock-in Barrier Hitting 여부
			int nx,					// IN: 주식 축의 분할 개수 
			double max_loss		// IN: 최대손실
		);

}
