package com.eugenefe.valuation.option;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IDigitalBarrierOption extends Library {
	
	IDigitalBarrierOption pricer = (IDigitalBarrierOption)Native.loadLibrary("Option", IDigitalBarrierOption.class);
	
	double DigitalBarrier(
			int TypeFlag,		// Option Type: �Ʒ� ����
			double S,		// �����ڻ� ���簡
			double X,		// ��簡��
			double H,		// ������ ����
			double T,		// ��������(��������,��ȯ��)
			double T1,		// ��������(����������,��ȯ��)
			double rf,		// ������ �ݸ�
			double rd,		// ���αݸ�
			double dvd,		// �����
			double vol,		// ������
			double fix_amt,		// ���޾�
			int bHitted		// ���ÿ���
		);

	double DigitalBarrier_Delta (
			int TypeFlag, double S, double X, double H, double T, double T1,
			double rf, double rd, double dvd, double vol, double fix_amt, int bHitted
		);
	double DigitalBarrier_Gamma (
			int TypeFlag, double S, double X, double H, double T, double T1,
			double rf, double rd, double dvd, double vol, double fix_amt, int bHitted
		);
	double DigitalBarrier_Vega (
			int TypeFlag, double S, double X, double H, double T, double T1,
			double rf, double rd, double dvd, double vol, double fix_amt, int bHitted
		);
	double DigitalBarrier_Theta (
			int TypeFlag, double S, double X, double H, double T, double T1,
			double rf, double rd, double dvd, double vol, double fix_amt, int bHitted
		);
	double DigitalBarrier_Rho (
			int TypeFlag, double S, double X, double H, double T, double T1,
			double rf, double rd, double dvd, double vol, double fix_amt, int bHitted
		);

}
