package com.eugenefe.valuation.exotic;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IAsianBasket extends Library {
	IAsianBasket INSTANCE = (IAsianBasket)Native.loadLibrary("AsianBasket", IAsianBasket.class);
	
	double AsianBasket(
			double[] S0,		// IN:  기초자산 현재가(백분율) 
			double[] t,		// IN:  기간 구조 시점	
			double[] rf, 		// IN:  무위험이자율 기간구조
			double[] rd, 		// IN:  할인이자율 기간구조
			int nt,			// IN:  기간 구조 데이터 개수
			double[] t_vol,		// IN:  변동성 만기 시점
			double[] vol,		// IN:  기초자산 변동성 
			int n_vol,		// IN:  각 변동성 데이터 개수
			double[] rho,		// IN:  기초자산 상관계수
			double[] div,		// IN:  기초자산 배당율 
			int nStock,		// IN:  기초자산 개수
			double X,		// IN:  행사가격 
			double PartRate,		// IN:  참여율 
			int[] Dates,		// IN:  중간평가일(계산일부터 일수)
			int nDates,		// IN:  중간평가일 개수
			int PaymentDate,	// IN:  만기지급일(계산일부터 일수)
			double[] Weight,		// IN:  바스켓 가중치 
			double[] PrevRates,	// IN:  지난 평가일 바스켓 수익률
			int nPrevRates,	// IN:  지난 평가일 수
			int OptionType,		// IN:  옵션종류(1:call, 2:put)
			int nTrials		// IN:  시행회수 
		);
	double AsianBasket_Delta(
			int index,
			double[] S0,		// IN:  기초자산 현재가(백분율) 
			double[] t,		// IN:  기간 구조 시점	
			double[] rf, 		// IN:  무위험이자율 기간구조
			double[] rd, 		// IN:  할인이자율 기간구조
			int nt,			// IN:  기간 구조 데이터 개수
			double[] t_vol,		// IN:  변동성 만기 시점
			double[] vol,		// IN:  기초자산 변동성 
			int n_vol,		// IN:  각 변동성 데이터 개수
			double[] rho,		// IN:  기초자산 상관계수
			double[] div,		// IN:  기초자산 배당율 
			int nStock,		// IN:  기초자산 개수
			double X,		// IN:  행사가격 
			double PartRate,		// IN:  참여율 
			int[] Dates,		// IN:  중간평가일(계산일부터 일수)
			int nDates,		// IN:  중간평가일 개수
			int PaymentDate,	// IN:  만기지급일(계산일부터 일수)
			double[] Weight,		// IN:  바스켓 가중치 
			double[] PrevRates,	// IN:  지난 평가일 바스켓 수익률
			int nPrevRates,	// IN:  지난 평가일 수
			int OptionType,		// IN:  옵션종류(1:call, 2:put)
			int nTrials		// IN:  시행회수 
		);
	
	double AsianBasket_Gamma(
			int index,
			double[] S0,		// IN:  기초자산 현재가(백분율) 
			double[] t,		// IN:  기간 구조 시점	
			double[] rf, 		// IN:  무위험이자율 기간구조
			double[] rd, 		// IN:  할인이자율 기간구조
			int nt,			// IN:  기간 구조 데이터 개수
			double[] t_vol,		// IN:  변동성 만기 시점
			double[] vol,		// IN:  기초자산 변동성 
			int n_vol,		// IN:  각 변동성 데이터 개수
			double[] rho,		// IN:  기초자산 상관계수
			double[] div,		// IN:  기초자산 배당율 
			int nStock,		// IN:  기초자산 개수
			double X,		// IN:  행사가격 
			double PartRate,		// IN:  참여율 
			int[] Dates,		// IN:  중간평가일(계산일부터 일수)
			int nDates,		// IN:  중간평가일 개수
			int PaymentDate,	// IN:  만기지급일(계산일부터 일수)
			double[] Weight,		// IN:  바스켓 가중치 
			double[] PrevRates,	// IN:  지난 평가일 바스켓 수익률
			int nPrevRates,	// IN:  지난 평가일 수
			int OptionType,		// IN:  옵션종류(1:call, 2:put)
			int nTrials		// IN:  시행회수 
		);
	double AsianBasket_Vega(
			int index,
			double[] S0,		// IN:  기초자산 현재가(백분율) 
			double[] t,		// IN:  기간 구조 시점	
			double[] rf, 		// IN:  무위험이자율 기간구조
			double[] rd, 		// IN:  할인이자율 기간구조
			int nt,			// IN:  기간 구조 데이터 개수
			double[] t_vol,		// IN:  변동성 만기 시점
			double[] vol,		// IN:  기초자산 변동성 
			int n_vol,		// IN:  각 변동성 데이터 개수
			double[] rho,		// IN:  기초자산 상관계수
			double[] div,		// IN:  기초자산 배당율 
			int nStock,		// IN:  기초자산 개수
			double X,		// IN:  행사가격 
			double PartRate,		// IN:  참여율 
			int[] Dates,		// IN:  중간평가일(계산일부터 일수)
			int nDates,		// IN:  중간평가일 개수
			int PaymentDate,	// IN:  만기지급일(계산일부터 일수)
			double[] Weight,		// IN:  바스켓 가중치 
			double[] PrevRates,	// IN:  지난 평가일 바스켓 수익률
			int nPrevRates,	// IN:  지난 평가일 수
			int OptionType,		// IN:  옵션종류(1:call, 2:put)
			int nTrials		// IN:  시행회수 
		);
	double AsianBasket_Theta(
			double[] S0,		// IN:  기초자산 현재가(백분율) 
			double[] t,		// IN:  기간 구조 시점	
			double[] rf, 		// IN:  무위험이자율 기간구조
			double[] rd, 		// IN:  할인이자율 기간구조
			int nt,			// IN:  기간 구조 데이터 개수
			double[] t_vol,		// IN:  변동성 만기 시점
			double[] vol,		// IN:  기초자산 변동성 
			int n_vol,		// IN:  각 변동성 데이터 개수
			double[] rho,		// IN:  기초자산 상관계수
			double[] div,		// IN:  기초자산 배당율 
			int nStock,		// IN:  기초자산 개수
			double X,		// IN:  행사가격 
			double PartRate,		// IN:  참여율 
			int[] Dates,		// IN:  중간평가일(계산일부터 일수)
			int nDates,		// IN:  중간평가일 개수
			int PaymentDate,	// IN:  만기지급일(계산일부터 일수)
			double[] Weight,		// IN:  바스켓 가중치 
			double[] PrevRates,	// IN:  지난 평가일 바스켓 수익률
			int nPrevRates,	// IN:  지난 평가일 수
			int OptionType,		// IN:  옵션종류(1:call, 2:put)
			int nTrials		// IN:  시행회수  
		);
	double AsianBasket_Rho(
			double[] S0,		// IN:  기초자산 현재가(백분율) 
			double[] t,		// IN:  기간 구조 시점	
			double[] rf, 		// IN:  무위험이자율 기간구조
			double[] rd, 		// IN:  할인이자율 기간구조
			int nt,			// IN:  기간 구조 데이터 개수
			double[] t_vol,		// IN:  변동성 만기 시점
			double[] vol,		// IN:  기초자산 변동성 
			int n_vol,		// IN:  각 변동성 데이터 개수
			double[] rho,		// IN:  기초자산 상관계수
			double[] div,		// IN:  기초자산 배당율 
			int nStock,		// IN:  기초자산 개수
			double X,		// IN:  행사가격 
			double PartRate,		// IN:  참여율 
			int[] Dates,		// IN:  중간평가일(계산일부터 일수)
			int nDates,		// IN:  중간평가일 개수
			int PaymentDate,	// IN:  만기지급일(계산일부터 일수)
			double[] Weight,		// IN:  바스켓 가중치 
			double[] PrevRates,	// IN:  지난 평가일 바스켓 수익률
			int nPrevRates,	// IN:  지난 평가일 수
			int OptionType,		// IN:  옵션종류(1:call, 2:put)
			int nTrials		// IN:  시행회수 
		);


}
