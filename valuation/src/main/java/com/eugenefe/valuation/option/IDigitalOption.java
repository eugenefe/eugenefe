package com.eugenefe.valuation.option;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IDigitalOption extends Library {
	
	IDigitalOption pricer = (IDigitalOption)Native.loadLibrary("Option", IDigitalOption.class);
	
	double DigitalOption(
			int TypeFlag,		// Option Type: 1�̸� ��, 2�̸� ǲ
			double S,		// �����ڻ� ���簡
			double X,		// ��簡��
			double T,		// ��������(��������,��ȯ��)
			double T1,		// ��������(����������,��ȯ��)
			double rf,		// ������ �ݸ�
			double rd,		// ���αݸ�
			double dvd,		// �����
			double vol,		// ������
			double fix_amt		// ���޾�
		);
	double DigitalOption_Delta(
			int TypeFlag,		// Option Type: 1�̸� ��, 2�̸� ǲ
			double S,		// �����ڻ� ���簡
			double X,		// ��簡��
			double T,		// ��������(��������,��ȯ��)
			double T1,		// ��������(����������,��ȯ��)
			double rf,		// ������ �ݸ�
			double rd,		// ���αݸ�
			double dvd,		// �����
			double vol,		// ������
			double fix_amt		// ���޾�
			);
	double DigitalOption_Gamma (
			int TypeFlag,		// Option Type: 1�̸� ��, 2�̸� ǲ
			double S,		// �����ڻ� ���簡
			double X,		// ��簡��
			double T,		// ��������(��������,��ȯ��)
			double T1,		// ��������(����������,��ȯ��)
			double rf,		// ������ �ݸ�
			double rd,		// ���αݸ�
			double dvd,		// �����
			double vol,		// ������
			double fix_amt		// ���޾�
			);

	
	double DigitalOption_Vega (
			int TypeFlag,		// Option Type: 1�̸� ��, 2�̸� ǲ
			double S,		// �����ڻ� ���簡
			double X,		// ��簡��
			double T,		// ��������(��������,��ȯ��)
			double T1,		// ��������(����������,��ȯ��)
			double rf,		// ������ �ݸ�
			double rd,		// ���αݸ�
			double dvd,		// �����
			double vol,		// ������
			double fix_amt		// ���޾�
			);
	double DigitalOption_Theta (
			int TypeFlag,		// Option Type: 1�̸� ��, 2�̸� ǲ
			double S,		// �����ڻ� ���簡
			double X,		// ��簡��
			double T,		// ��������(��������,��ȯ��)
			double T1,		// ��������(����������,��ȯ��)
			double rf,		// ������ �ݸ�
			double rd,		// ���αݸ�
			double dvd,		// �����
			double vol,		// ������
			double fix_amt		// ���޾�
	);
	
	double DigitalOption_Rho (
			int TypeFlag,		// Option Type: 1�̸� ��, 2�̸� ǲ
			double S,		// �����ڻ� ���簡
			double X,		// ��簡��
			double T,		// ��������(��������,��ȯ��)
			double T1,		// ��������(����������,��ȯ��)
			double rf,		// ������ �ݸ�
			double rd,		// ���αݸ�
			double dvd,		// �����
			double vol,		// ������
			double fix_amt		// ���޾�
			);

}
