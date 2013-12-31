package com.eugenefe.valuation.option;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public interface IPlainOption extends Library {
	
	IPlainOption pricer = (IPlainOption)Native.loadLibrary((Platform.isWindows()? "takion77_Option": "OptionLinux"), IPlainOption.class);
	
	public double BSOption(
			int TypeFlag,	// Option Type: 1�̸� ��, 2�̸� ǲ
			double S,		// �����ڻ� ���簡				
			double X,		// ��簡��
			double T,		// ��������(��������,��ȯ��)
			double T1,		// ��������(����������,��ȯ��)
			double rf,		// ������ �ݸ�
			double rd,		// ���αݸ�
			double dvd,		// �����
			double vol		// ������
		);
	
	public double BSOption_Delta(
			int TypeFlag
			, double S
			, double X
			, double T
			, double T1
			, double rf
			, double rd
			, double dvd
			, double vol
			);
	public double BSOption_Gamma(
			int TypeFlag
			, double S
			, double X
			, double T
			, double T1
			, double rf
			, double rd
			, double dvd
			, double vol
			);


	public double BSOption_Vega(
			int TypeFlag
			, double S
			, double X
			, double T
			, double T1
			, double rf
			, double rd
			, double dvd
			, double vol
			);


	public double BSOption_Theta(
			int TypeFlag
			, double S
			, double X
			, double T
			, double T1
			, double rf
			, double rd
			, double dvd
			, double vol
			);

	public double BSOption_Rho(  
			int TypeFlag
			, double S
			, double X
			, double T
			, double T1
			, double rf
			, double rd
			, double dvd
			, double vol
			);
}
