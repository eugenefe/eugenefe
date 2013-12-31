package com.eugenefe.valuation.basic;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IPureBond extends Library {
	IPureBond INSTANCE = (IPureBond)Native.loadLibrary("Pure_Bond", IPureBond.class);
	
	double Pure_Bond_Price(	
			double[] t,				// IN: 기간 구조 시점	
			double[] rd, 			// IN: 할인이자율 기간구조
			int 	 nt,					// IN: 기간 구조 데이터 개수
			double   PayAmount,		// IN: 지급액
			int      PayDate			// IN: 지급일까지의 일수
		);


}
