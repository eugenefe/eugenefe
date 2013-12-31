package com.eugenefe.valuation.basic;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IPureBond extends Library {
	IPureBond INSTANCE = (IPureBond)Native.loadLibrary("Pure_Bond", IPureBond.class);
	
	double Pure_Bond_Price(	
			double[] t,				// IN: �Ⱓ ���� ����	
			double[] rd, 			// IN: ���������� �Ⱓ����
			int 	 nt,					// IN: �Ⱓ ���� ������ ����
			double   PayAmount,		// IN: ���޾�
			int      PayDate			// IN: �����ϱ����� �ϼ�
		);


}
