package com.eugenefe.valuation.exotic;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IAsianBasket extends Library {
	IAsianBasket INSTANCE = (IAsianBasket)Native.loadLibrary("AsianBasket", IAsianBasket.class);
	
	double AsianBasket(
			double[] S0,		// IN:  �����ڻ� ���簡(�����) 
			double[] t,		// IN:  �Ⱓ ���� ����	
			double[] rf, 		// IN:  ������������ �Ⱓ����
			double[] rd, 		// IN:  ���������� �Ⱓ����
			int nt,			// IN:  �Ⱓ ���� ������ ����
			double[] t_vol,		// IN:  ������ ���� ����
			double[] vol,		// IN:  �����ڻ� ������ 
			int n_vol,		// IN:  �� ������ ������ ����
			double[] rho,		// IN:  �����ڻ� ������
			double[] div,		// IN:  �����ڻ� ����� 
			int nStock,		// IN:  �����ڻ� ����
			double X,		// IN:  ��簡�� 
			double PartRate,		// IN:  ������ 
			int[] Dates,		// IN:  �߰�����(����Ϻ��� �ϼ�)
			int nDates,		// IN:  �߰����� ����
			int PaymentDate,	// IN:  ����������(����Ϻ��� �ϼ�)
			double[] Weight,		// IN:  �ٽ��� ����ġ 
			double[] PrevRates,	// IN:  ���� ���� �ٽ��� ���ͷ�
			int nPrevRates,	// IN:  ���� ���� ��
			int OptionType,		// IN:  �ɼ�����(1:call, 2:put)
			int nTrials		// IN:  ����ȸ�� 
		);
	double AsianBasket_Delta(
			int index,
			double[] S0,		// IN:  �����ڻ� ���簡(�����) 
			double[] t,		// IN:  �Ⱓ ���� ����	
			double[] rf, 		// IN:  ������������ �Ⱓ����
			double[] rd, 		// IN:  ���������� �Ⱓ����
			int nt,			// IN:  �Ⱓ ���� ������ ����
			double[] t_vol,		// IN:  ������ ���� ����
			double[] vol,		// IN:  �����ڻ� ������ 
			int n_vol,		// IN:  �� ������ ������ ����
			double[] rho,		// IN:  �����ڻ� ������
			double[] div,		// IN:  �����ڻ� ����� 
			int nStock,		// IN:  �����ڻ� ����
			double X,		// IN:  ��簡�� 
			double PartRate,		// IN:  ������ 
			int[] Dates,		// IN:  �߰�����(����Ϻ��� �ϼ�)
			int nDates,		// IN:  �߰����� ����
			int PaymentDate,	// IN:  ����������(����Ϻ��� �ϼ�)
			double[] Weight,		// IN:  �ٽ��� ����ġ 
			double[] PrevRates,	// IN:  ���� ���� �ٽ��� ���ͷ�
			int nPrevRates,	// IN:  ���� ���� ��
			int OptionType,		// IN:  �ɼ�����(1:call, 2:put)
			int nTrials		// IN:  ����ȸ�� 
		);
	
	double AsianBasket_Gamma(
			int index,
			double[] S0,		// IN:  �����ڻ� ���簡(�����) 
			double[] t,		// IN:  �Ⱓ ���� ����	
			double[] rf, 		// IN:  ������������ �Ⱓ����
			double[] rd, 		// IN:  ���������� �Ⱓ����
			int nt,			// IN:  �Ⱓ ���� ������ ����
			double[] t_vol,		// IN:  ������ ���� ����
			double[] vol,		// IN:  �����ڻ� ������ 
			int n_vol,		// IN:  �� ������ ������ ����
			double[] rho,		// IN:  �����ڻ� ������
			double[] div,		// IN:  �����ڻ� ����� 
			int nStock,		// IN:  �����ڻ� ����
			double X,		// IN:  ��簡�� 
			double PartRate,		// IN:  ������ 
			int[] Dates,		// IN:  �߰�����(����Ϻ��� �ϼ�)
			int nDates,		// IN:  �߰����� ����
			int PaymentDate,	// IN:  ����������(����Ϻ��� �ϼ�)
			double[] Weight,		// IN:  �ٽ��� ����ġ 
			double[] PrevRates,	// IN:  ���� ���� �ٽ��� ���ͷ�
			int nPrevRates,	// IN:  ���� ���� ��
			int OptionType,		// IN:  �ɼ�����(1:call, 2:put)
			int nTrials		// IN:  ����ȸ�� 
		);
	double AsianBasket_Vega(
			int index,
			double[] S0,		// IN:  �����ڻ� ���簡(�����) 
			double[] t,		// IN:  �Ⱓ ���� ����	
			double[] rf, 		// IN:  ������������ �Ⱓ����
			double[] rd, 		// IN:  ���������� �Ⱓ����
			int nt,			// IN:  �Ⱓ ���� ������ ����
			double[] t_vol,		// IN:  ������ ���� ����
			double[] vol,		// IN:  �����ڻ� ������ 
			int n_vol,		// IN:  �� ������ ������ ����
			double[] rho,		// IN:  �����ڻ� ������
			double[] div,		// IN:  �����ڻ� ����� 
			int nStock,		// IN:  �����ڻ� ����
			double X,		// IN:  ��簡�� 
			double PartRate,		// IN:  ������ 
			int[] Dates,		// IN:  �߰�����(����Ϻ��� �ϼ�)
			int nDates,		// IN:  �߰����� ����
			int PaymentDate,	// IN:  ����������(����Ϻ��� �ϼ�)
			double[] Weight,		// IN:  �ٽ��� ����ġ 
			double[] PrevRates,	// IN:  ���� ���� �ٽ��� ���ͷ�
			int nPrevRates,	// IN:  ���� ���� ��
			int OptionType,		// IN:  �ɼ�����(1:call, 2:put)
			int nTrials		// IN:  ����ȸ�� 
		);
	double AsianBasket_Theta(
			double[] S0,		// IN:  �����ڻ� ���簡(�����) 
			double[] t,		// IN:  �Ⱓ ���� ����	
			double[] rf, 		// IN:  ������������ �Ⱓ����
			double[] rd, 		// IN:  ���������� �Ⱓ����
			int nt,			// IN:  �Ⱓ ���� ������ ����
			double[] t_vol,		// IN:  ������ ���� ����
			double[] vol,		// IN:  �����ڻ� ������ 
			int n_vol,		// IN:  �� ������ ������ ����
			double[] rho,		// IN:  �����ڻ� ������
			double[] div,		// IN:  �����ڻ� ����� 
			int nStock,		// IN:  �����ڻ� ����
			double X,		// IN:  ��簡�� 
			double PartRate,		// IN:  ������ 
			int[] Dates,		// IN:  �߰�����(����Ϻ��� �ϼ�)
			int nDates,		// IN:  �߰����� ����
			int PaymentDate,	// IN:  ����������(����Ϻ��� �ϼ�)
			double[] Weight,		// IN:  �ٽ��� ����ġ 
			double[] PrevRates,	// IN:  ���� ���� �ٽ��� ���ͷ�
			int nPrevRates,	// IN:  ���� ���� ��
			int OptionType,		// IN:  �ɼ�����(1:call, 2:put)
			int nTrials		// IN:  ����ȸ��  
		);
	double AsianBasket_Rho(
			double[] S0,		// IN:  �����ڻ� ���簡(�����) 
			double[] t,		// IN:  �Ⱓ ���� ����	
			double[] rf, 		// IN:  ������������ �Ⱓ����
			double[] rd, 		// IN:  ���������� �Ⱓ����
			int nt,			// IN:  �Ⱓ ���� ������ ����
			double[] t_vol,		// IN:  ������ ���� ����
			double[] vol,		// IN:  �����ڻ� ������ 
			int n_vol,		// IN:  �� ������ ������ ����
			double[] rho,		// IN:  �����ڻ� ������
			double[] div,		// IN:  �����ڻ� ����� 
			int nStock,		// IN:  �����ڻ� ����
			double X,		// IN:  ��簡�� 
			double PartRate,		// IN:  ������ 
			int[] Dates,		// IN:  �߰�����(����Ϻ��� �ϼ�)
			int nDates,		// IN:  �߰����� ����
			int PaymentDate,	// IN:  ����������(����Ϻ��� �ϼ�)
			double[] Weight,		// IN:  �ٽ��� ����ġ 
			double[] PrevRates,	// IN:  ���� ���� �ٽ��� ���ͷ�
			int nPrevRates,	// IN:  ���� ���� ��
			int OptionType,		// IN:  �ɼ�����(1:call, 2:put)
			int nTrials		// IN:  ����ȸ�� 
		);


}
