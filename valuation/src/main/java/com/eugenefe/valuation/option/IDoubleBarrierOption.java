package com.eugenefe.valuation.option;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IDoubleBarrierOption extends Library {
	
	IDoubleBarrierOption pricer = (IDoubleBarrierOption)Native.loadLibrary("Option", IDoubleBarrierOption.class);
	double DoubleBarrier(
			int TypeFlag,		// Option Type: �Ʒ� ����
			double S,		// �����ڻ� ���簡
			double X,		// ��簡��
			double L,		// ���� �ּҰ�
			double U,		// ���� �ִ밪
			double T,		// ��������(��������,��ȯ��)
			double T1,		// ��������(����������,��ȯ��)
			double rf,		// ������ �ݸ�
			double rd,		// ���αݸ�
			double dvd,		// �����
			double vol,		// ������
			double bHitted		// ���� ���� ����
		);
	double DoubleBarrier_Delta (
			int TypeFlag, double S, double X, double L, double U, double T, double T1,
			double rf, double rd, double dvd, double vol, double bHitted
		);
	double DoubleBarrier_Gamma (
			int TypeFlag, double S, double X, double L, double U, double T, double T1,
			double rf, double rd, double dvd, double vol, double bHitted
		);
	double DoubleBarrier_Vega (
			int TypeFlag, double S, double X, double L, double U, double T, double T1,
			double rf, double rd, double dvd, double vol, double bHitted
		);
	double DoubleBarrier_Theta (
			int TypeFlag, double S, double X, double L, double U, double T, double T1,
			double rf, double rd, double dvd, double vol, double bHitted
		);
	double DoubleBarrier_Rho (
			int TypeFlag, double S, double X, double L, double U, double T, double T1,
			double rf, double rd, double dvd, double vol, double bHitted
		);

}
