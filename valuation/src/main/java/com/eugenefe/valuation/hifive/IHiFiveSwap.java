package com.eugenefe.valuation.hifive;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IHiFiveSwap extends Library {
	IHiFiveSwap INSTANCE = (IHiFiveSwap)Native.loadLibrary("HiFiveSwap", IHiFiveSwap.class);

	double HiFiveSwap(
			double[] S0,		// IN:  �����ڻ� ���簡 
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
			double[] X1,		// IN:  ��簡��1
			double[] X2,		// IN:  ��簡��2
			double[] X3,		// IN:  ��簡��3
			double[] upBarrier,	// IN:  Knock-out Barrier
			double downBarrier,	// IN:  Knock-in Barrier
			double[] amt1,		// IN:  ��簡��1�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] amt2,		// IN:  ��簡��2�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] amt3,		// IN:  ��簡��3�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] coupon,		// IN:  �߰� ���� ���� 
			int[] dates, 		// IN:  �߰� ���ϱ����� �ϼ� 
			int[] pay_dates, 		// IN:  �߰� �����ϱ����� �ϼ� 
			int nStrike, 		// IN:  �߰����� �� 
			int upBarrierFlag,	// IN:  upBarrier üũ ���(0:����, 1:����)
			int downBarrierFlag,	// IN:  downBarrier ����(0:����, 1:����)
			int[] bUpHitted,  	// IN:  Knock-out Barrier Hitting ����
			int bDownHitted,  	// IN:  Knock-in Barrier Hitting ����
			int nTrials,		// IN:  ����ȸ�� 
			double max_loss,	// IN:	�ִ�ս�
			double[] IR_t,		// IN:  �ݸ� �Ⱓ���� ����
			double[] IR_r,		// IN:  ���� �ݸ� �Ⱓ����
			double[] IR_rd,		// IN:  ���� �ݸ� �Ⱓ����
			int IR_nt,		// IN:  �ݸ� �Ⱓ ���� ������ ����
			int[] IR_Dates,		// IN:  �ݸ� ������ 
			int IR_nDates,		// IN:  �ݸ� ������ ��
			int IR_TimePeriod,	// IN:  �̷� �����ݸ� �Ⱓ �ϼ�
			double IR_Spread,	// IN:  �߰� ���� �ݸ�
			int IR_Prev_Date,	// IN:  ���� �����Ϻ��� ����ϱ��� �ϼ�
			double IR_Prev_r,	// IN:  �̹� ������ �ݸ�(�߰� �ݸ� ����)
			double[] p		// OUT: �ߵ���ȯ Ȯ��
		); 
	double HiFiveSwap_Delta(
			int index,
			double[] S0,		// IN:  �����ڻ� ���簡 
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
			double[] X1,		// IN:  ��簡��1
			double[] X2,		// IN:  ��簡��2
			double[] X3,		// IN:  ��簡��3
			double[] upBarrier,	// IN:  Knock-out Barrier
			double downBarrier,	// IN:  Knock-in Barrier
			double[] amt1,		// IN:  ��簡��1�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] amt2,		// IN:  ��簡��2�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] amt3,		// IN:  ��簡��3�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] coupon,		// IN:  �߰� ���� ���� 
			int[] dates, 		// IN:  �߰� ���ϱ����� �ϼ� 
			int[] pay_dates, 		// IN:  �߰� �����ϱ����� �ϼ� 
			int nStrike, 		// IN:  �߰����� �� 
			int upBarrierFlag,	// IN:  upBarrier üũ ���(0:����, 1:����)
			int downBarrierFlag,	// IN:  downBarrier ����(0:����, 1:����)
			int[] bUpHitted,  	// IN:  Knock-out Barrier Hitting ����
			int bDownHitted,  	// IN:  Knock-in Barrier Hitting ����
			int nTrials,		// IN:  ����ȸ�� 
			double max_loss,	// IN:	�ִ�ս�
			double[] IR_t,		// IN:  �ݸ� �Ⱓ���� ����
			double[] IR_r,		// IN:  ���� �ݸ� �Ⱓ����
			double[] IR_rd,		// IN:  ���� �ݸ� �Ⱓ����
			int IR_nt,		// IN:  �ݸ� �Ⱓ ���� ������ ����
			int[] IR_Dates,		// IN:  �ݸ� ������ 
			int IR_nDates,		// IN:  �ݸ� ������ ��
			int IR_TimePeriod,	// IN:  �̷� �����ݸ� �Ⱓ �ϼ�
			double IR_Spread,	// IN:  �߰� ���� �ݸ�
			int IR_Prev_Date,	// IN:  ���� �����Ϻ��� ����ϱ��� �ϼ�
			double IR_Prev_r	// IN:  �̹� ������ �ݸ�(�߰� �ݸ� ����)
		);
	double HiFiveSwap_Gamma(
			int index,
			double[] S0,		// IN:  �����ڻ� ���簡 
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
			double[] X1,		// IN:  ��簡��1
			double[] X2,		// IN:  ��簡��2
			double[] X3,		// IN:  ��簡��3
			double[] upBarrier,	// IN:  Knock-out Barrier
			double downBarrier,	// IN:  Knock-in Barrier
			double[] amt1,		// IN:  ��簡��1�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] amt2,		// IN:  ��簡��2�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] amt3,		// IN:  ��簡��3�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] coupon,		// IN:  �߰� ���� ���� 
			int[] dates, 		// IN:  �߰� ���ϱ����� �ϼ� 
			int[] pay_dates, 		// IN:  �߰� �����ϱ����� �ϼ� 
			int nStrike, 		// IN:  �߰����� �� 
			int upBarrierFlag,	// IN:  upBarrier üũ ���(0:����, 1:����)
			int downBarrierFlag,	// IN:  downBarrier ����(0:����, 1:����)
			int[] bUpHitted,  	// IN:  Knock-out Barrier Hitting ����
			int bDownHitted,  	// IN:  Knock-in Barrier Hitting ����
			int nTrials,		// IN:  ����ȸ�� 
			double max_loss,	// IN:	�ִ�ս�
			double[] IR_t,		// IN:  �ݸ� �Ⱓ���� ����
			double[] IR_r,		// IN:  ���� �ݸ� �Ⱓ����
			double[] IR_rd,		// IN:  ���� �ݸ� �Ⱓ����
			int IR_nt,		// IN:  �ݸ� �Ⱓ ���� ������ ����
			int[] IR_Dates,		// IN:  �ݸ� ������ 
			int IR_nDates,		// IN:  �ݸ� ������ ��
			int IR_TimePeriod,	// IN:  �̷� �����ݸ� �Ⱓ �ϼ�
			double IR_Spread,	// IN:  �߰� ���� �ݸ�
			int IR_Prev_Date,	// IN:  ���� �����Ϻ��� ����ϱ��� �ϼ�
			double IR_Prev_r	// IN:  �̹� ������ �ݸ�(�߰� �ݸ� ����)
		);
	double HiFiveSwap_Vega(	
			int index,
			double[] S0,		// IN:  �����ڻ� ���簡 
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
			double[] X1,		// IN:  ��簡��1
			double[] X2,		// IN:  ��簡��2
			double[] X3,		// IN:  ��簡��3
			double[] upBarrier,	// IN:  Knock-out Barrier
			double downBarrier,	// IN:  Knock-in Barrier
			double[] amt1,		// IN:  ��簡��1�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] amt2,		// IN:  ��簡��2�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] amt3,		// IN:  ��簡��3�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] coupon,		// IN:  �߰� ���� ���� 
			int[] dates, 		// IN:  �߰� ���ϱ����� �ϼ� 
			int[] pay_dates, 		// IN:  �߰� �����ϱ����� �ϼ� 
			int nStrike, 		// IN:  �߰����� �� 
			int upBarrierFlag,	// IN:  upBarrier üũ ���(0:����, 1:����)
			int downBarrierFlag,	// IN:  downBarrier ����(0:����, 1:����)
			int[] bUpHitted,  	// IN:  Knock-out Barrier Hitting ����
			int bDownHitted,  	// IN:  Knock-in Barrier Hitting ����
			int nTrials,		// IN:  ����ȸ�� 
			double max_loss,	// IN:	�ִ�ս�
			double[] IR_t,		// IN:  �ݸ� �Ⱓ���� ����
			double[] IR_r,		// IN:  ���� �ݸ� �Ⱓ����
			double[] IR_rd,		// IN:  ���� �ݸ� �Ⱓ����
			int IR_nt,		// IN:  �ݸ� �Ⱓ ���� ������ ����
			int[] IR_Dates,		// IN:  �ݸ� ������ 
			int IR_nDates,		// IN:  �ݸ� ������ ��
			int IR_TimePeriod,	// IN:  �̷� �����ݸ� �Ⱓ �ϼ�
			double IR_Spread,	// IN:  �߰� ���� �ݸ�
			int IR_Prev_Date,	// IN:  ���� �����Ϻ��� ����ϱ��� �ϼ�
			double IR_Prev_r	// IN:  �̹� ������ �ݸ�(�߰� �ݸ� ����)
		) ;
	double HiFiveSwap_Theta(
			double[] S0,		// IN:  �����ڻ� ���簡 
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
			double[] X1,		// IN:  ��簡��1
			double[] X2,		// IN:  ��簡��2
			double[] X3,		// IN:  ��簡��3
			double[] upBarrier,	// IN:  Knock-out Barrier
			double downBarrier,	// IN:  Knock-in Barrier
			double[] amt1,		// IN:  ��簡��1�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] amt2,		// IN:  ��簡��2�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] amt3,		// IN:  ��簡��3�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] coupon,		// IN:  �߰� ���� ���� 
			int[] dates, 		// IN:  �߰� ���ϱ����� �ϼ� 
			int[] pay_dates, 		// IN:  �߰� �����ϱ����� �ϼ� 
			int nStrike, 		// IN:  �߰����� �� 
			int upBarrierFlag,	// IN:  upBarrier üũ ���(0:����, 1:����)
			int downBarrierFlag,	// IN:  downBarrier ����(0:����, 1:����)
			int[] bUpHitted,  	// IN:  Knock-out Barrier Hitting ����
			int bDownHitted,  	// IN:  Knock-in Barrier Hitting ����
			int nTrials,		// IN:  ����ȸ�� 
			double max_loss,	// IN:	�ִ�ս�
			double[] IR_t,		// IN:  �ݸ� �Ⱓ���� ����
			double[] IR_r,		// IN:  ���� �ݸ� �Ⱓ����
			double[] IR_rd,		// IN:  ���� �ݸ� �Ⱓ����
			int IR_nt,		// IN:  �ݸ� �Ⱓ ���� ������ ����
			int[] IR_Dates,		// IN:  �ݸ� ������ 
			int IR_nDates,		// IN:  �ݸ� ������ ��
			int IR_TimePeriod,	// IN:  �̷� �����ݸ� �Ⱓ �ϼ�
			double IR_Spread,	// IN:  �߰� ���� �ݸ�
			int IR_Prev_Date,	// IN:  ���� �����Ϻ��� ����ϱ��� �ϼ�
			double IR_Prev_r	// IN:  �̹� ������ �ݸ�(�߰� �ݸ� ����)
		);
	
	double HiFiveSwap_Rho(
			double[] S0,		// IN:  �����ڻ� ���簡 
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
			double[] X1,		// IN:  ��簡��1
			double[] X2,		// IN:  ��簡��2
			double[] X3,		// IN:  ��簡��3
			double[] upBarrier,	// IN:  Knock-out Barrier
			double downBarrier,	// IN:  Knock-in Barrier
			double[] amt1,		// IN:  ��簡��1�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] amt2,		// IN:  ��簡��2�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] amt3,		// IN:  ��簡��3�� �ش�Ǵ� �ߵ���ȯ �ݾ�(��������)
			double[] coupon,		// IN:  �߰� ���� ���� 
			int[] dates, 		// IN:  �߰� ���ϱ����� �ϼ� 
			int[] pay_dates, 		// IN:  �߰� �����ϱ����� �ϼ� 
			int nStrike, 		// IN:  �߰����� �� 
			int upBarrierFlag,	// IN:  upBarrier üũ ���(0:����, 1:����)
			int downBarrierFlag,	// IN:  downBarrier ����(0:����, 1:����)
			int[] bUpHitted,  	// IN:  Knock-out Barrier Hitting ����
			int bDownHitted,  	// IN:  Knock-in Barrier Hitting ����
			int nTrials,		// IN:  ����ȸ�� 
			double max_loss,	// IN:	�ִ�ս�
			double[] IR_t,		// IN:  �ݸ� �Ⱓ���� ����
			double[] IR_r,		// IN:  ���� �ݸ� �Ⱓ����
			double[] IR_rd,		// IN:  ���� �ݸ� �Ⱓ����
			int IR_nt,		// IN:  �ݸ� �Ⱓ ���� ������ ����
			int[] IR_Dates,		// IN:  �ݸ� ������ 
			int IR_nDates,		// IN:  �ݸ� ������ ��
			int IR_TimePeriod,	// IN:  �̷� �����ݸ� �Ⱓ �ϼ�
			double IR_Spread,	// IN:  �߰� ���� �ݸ�
			int IR_Prev_Date,	// IN:  ���� �����Ϻ��� ����ϱ��� �ϼ�
			double IR_Prev_r	// IN:  �̹� ������ �ݸ�(�߰� �ݸ� ����)
		);

}
