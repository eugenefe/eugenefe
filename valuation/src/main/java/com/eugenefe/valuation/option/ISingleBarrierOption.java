package com.eugenefe.valuation.option;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface ISingleBarrierOption  extends Library {
	
	ISingleBarrierOption pricer = (ISingleBarrierOption)Native.loadLibrary("Option", ISingleBarrierOption.class);
	
	double SingleBarrier(
			int TypeFlag,		// Option Type: �Ʒ� ����
			double S,		// �����ڻ� ���簡
			double X,		// ��簡��
			double H,		// ������ ����
			double Rebate, 		// ������Ʈ �ݾ�
			double T,      		// ��������(��������,��ȯ��)      
			double T1,     		// ��������(����������,��ȯ��)      
			double rf,		// ������ �ݸ�
			double rd,		// ���αݸ�
			double dvd,		// �����		 
			double vol,		// ������
			int bHitted		// ���� ������ ���� ����
		);
	double SingleBarrier_Delta(
			int TypeFlag, double S, double X, double H, double Rebate, double T, double T1, 
			double rf, double rd, double dvd, double vol, int bHitted
			);
	double SingleBarrier_Gamma (
			int TypeFlag, double S, double X, double H, double Rebate, double T, double T1, 
			double rf, double rd, double dvd, double vol, int bHitted
			);

	double SingleBarrier_Vega (
			int TypeFlag, double S, double X, double H, double Rebate, double T, double T1, 
			double rf, double rd, double dvd, double vol, int bHitted
			);

	double SingleBarrier_Theta(
			int TypeFlag, double S, double X, double H, double Rebate, double T, double T1, 
			double rf, double rd, double dvd, double vol, int bHitted
			);

	double SingleBarrier_Rho (
			int TypeFlag, double S, double X, double H, double Rebate, double T, double T1, 
			double rf, double rd, double dvd, double vol, int bHitted
			);

}
