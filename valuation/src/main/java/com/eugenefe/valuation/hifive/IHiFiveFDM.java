package com.eugenefe.valuation.hifive;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IHiFiveFDM extends Library {
	IHiFiveFDM INSTANCE = (IHiFiveFDM)Native.loadLibrary("takion77_HiFive_FDM", IHiFiveFDM.class);
	
	
	public double HiFive1D_FDM(			// OUT: ����
			double S0, 			// IN: �����ڻ� ���簡
			double[] t,			// IN: �Ⱓ ���� ����	
			double[] rf, 			// IN: ������������ �Ⱓ����
			double[] rd, 			// IN: ���������� �Ⱓ����
			int nt,				// IN: �Ⱓ ���� ������ ����
			double div, 			// IN: �����ڻ� ����
			
			double[] t_vol,			// IN:  ������ ���� ����
			double[] vol, 			// IN: �����ڻ� ������ �Ⱓ ����
			int n_vol,			// IN: ������ ������ ����
			
			double[] X1,			// IN: ��簡��1
			double[] X2,			// IN: ��簡��2
			double[] X3,			// IN: ��簡��3
			
			double[] upBarrier,		// IN: Knock-out Barrier
			double downBarrier,		// IN: Knock-in Barrier
			
			
			double[] amt1,			// IN: ��簡��1�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] amt2,			// IN: ��簡��2�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] amt3,			// IN: ��簡��3�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			
			double[] coupon,			// IN: �߰� ���� ���� 
			int[] dates, 			// IN: �߰� ���ϱ����� �ϼ� 
			int[] pay_dates, 			// IN: �߰� �����ϱ����� �ϼ� 
			int nStrike, 			// IN: �߰����� �� 
			int downBarrierFlag,		// IN:  downBarrier ����(0:����, 1:����)
			int bUpHitted,  			// IN: Knock-out Barrier Hitting ����
			int bDownHitted,  		// IN: Knock-in Barrier Hitting ����
			double max_loss,		// IN: �ִ�ս�

			double[] delta, 			// OUT: ��Ÿ��
			double[] gamma, 		// OUT: ������
			double[] theta			// OUT: ��Ÿ��
		);
	
	public double HiFive1D_FDM_Vega(
			double S0, 			// IN: �����ڻ� ���簡
			double[] t,			// IN: �Ⱓ ���� ����	
			double[] rf, 			// IN: ������������ �Ⱓ����
			double[] rd, 			// IN: ���������� �Ⱓ����
			int nt,				// IN: �Ⱓ ���� ������ ����
			double div, 			// IN: �����ڻ� ����
			double[] t_vol,			// IN:  ������ ���� ����
			double[] vol, 			// IN: �����ڻ� ������ �Ⱓ ����
			int n_vol,			// IN: ������ ������ ����
			double[] X1,			// IN: ��簡��1
			double[] X2,			// IN: ��簡��2
			double[] X3,			// IN: ��簡��3
			double[] upBarrier,		// IN: Knock-out Barrier
			double downBarrier,		// IN: Knock-in Barrier
			double[] amt1,			// IN: ��簡��1�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] amt2,			// IN: ��簡��2�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] amt3,			// IN: ��簡��3�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] coupon,			// IN: �߰� ���� ���� 
			int[] dates, 			// IN: �߰� ���ϱ����� �ϼ� 
			int[] pay_dates, 			// IN: �߰� �����ϱ����� �ϼ� 
			int nStrike, 			// IN: �߰����� �� 
			int downBarrierFlag,		// IN:  downBarrier ����(0:����, 1:����)
			int bUpHitted,  			// IN: Knock-out Barrier Hitting ����
			int bDownHitted,  		// IN: Knock-in Barrier Hitting ����
			double max_loss		// IN: �ִ�ս�
		);

	public double HiFive1D_FDM_Rho(
			double S0, 			// IN: �����ڻ� ���簡
			double[] t,			// IN: �Ⱓ ���� ����	
			double[] rf, 			// IN: ������������ �Ⱓ����
			double[] rd, 			// IN: ���������� �Ⱓ����
			int nt,				// IN: �Ⱓ ���� ������ ����
			double div, 			// IN: �����ڻ� ����
			double[] t_vol,			// IN:  ������ ���� ����
			double[] vol, 			// IN: �����ڻ� ������ �Ⱓ ����
			int n_vol,			// IN: ������ ������ ����
			double[] X1,			// IN: ��簡��1
			double[] X2,			// IN: ��簡��2
			double[] X3,			// IN: ��簡��3
			double[] upBarrier,		// IN: Knock-out Barrier
			double downBarrier,		// IN: Knock-in Barrier
			double[] amt1,			// IN: ��簡��1�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] amt2,			// IN: ��簡��2�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] amt3,			// IN: ��簡��3�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] coupon,			// IN: �߰� ���� ���� 
			int[] dates, 			// IN: �߰� ���ϱ����� �ϼ� 
			int[] pay_dates, 			// IN: �߰� �����ϱ����� �ϼ� 
			int nStrike, 			// IN: �߰����� �� 
			int downBarrierFlag,		// IN:  downBarrier ����(0:����, 1:����)
			int bUpHitted,  			// IN: Knock-out Barrier Hitting ����
			int bDownHitted,  		// IN: Knock-in Barrier Hitting ����
			double max_loss		// IN: �ִ�ս�
		);
	
	public double HiFive2D_FDM(			// OUT: ����
			double S10, 
			double S20,			// IN: �����ڻ� ���簡
			double[] t,			// IN: �Ⱓ ���� ����	
			double[] rf1, 			// IN: ������������ �Ⱓ����
			double[] rf2, 			// IN: ������������ �Ⱓ����
			double[] rd, 			// IN: ���������� �Ⱓ����
			int nt,				// IN: �Ⱓ ���� ������ ����
			double[] t_vol,			// IN:  ������ ���� ����
			double[] vol1, 			// IN: �����ڻ� ������ �Ⱓ ����
			double[] vol2, 		// IN: �����ڻ� ������
			int n_vol,			// IN: ������ ������ ����
			double rho,			// IN: �����ڻ� ������ 
			double div1, 
			double div2,		// IN: �����ڻ� ����
			double[] X1,			// IN: ��簡��1
			double[] X2,			// IN: ��簡��2
			double[] X3,			// IN: ��簡��3
			double[] upBarrier,		// IN: Knock-out Barrier
			double downBarrier,		// IN: Knock-in Barrier
			double[] amt1,			// IN: ��簡��1�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] amt2,			// IN: ��簡��2�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] amt3,			// IN: ��簡��3�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] coupon,			// IN: �߰� ���� ���� 
			int[] dates, 			// IN: �߰� ���ϱ����� �ϼ� 
			int[] pay_dates, 			// IN: �߰� �����ϱ����� �ϼ� 
			int nStrike, 			// IN: �߰����� �� 
			int downBarrierFlag,		// IN:  downBarrier ����(0:����, 1:����)
			int bUpHitted,  			// IN: Knock-out Barrier Hitting ����
			int bDownHitted,  		// IN: Knock-in Barrier Hitting ����
			int nx,					// IN: �ֽ� ���� ���� ���� 
			double max_loss,		// IN: �ִ�ս�
			double[] delta1, 
			double[] delta2,	// OUT: ��Ÿ��
			double[] gamma1, 
			double[] gamma2,	// OUT: ������ 
			double[] cross,			// OUT: �����̺а� 
			double[] theta			// OUT: ��Ÿ��
		);

	double HiFive2D_FDM_Vega1(	 
			double S10, 
			double S20,			// IN: �����ڻ� ���簡
			double[] t,			// IN: �Ⱓ ���� ����	
			double[] rf1, 			// IN: ������������ �Ⱓ����
			double[] rf2, 			// IN: ������������ �Ⱓ����
			double[] rd, 			// IN: ���������� �Ⱓ����
			int nt,				// IN: �Ⱓ ���� ������ ����
			double[] t_vol,			// IN:  ������ ���� ����
			double[] vol1, 			// IN: �����ڻ� ������ �Ⱓ ����
			double[] vol2, 		// IN: �����ڻ� ������
			int n_vol,			// IN: ������ ������ ����
			double rho,			// IN: �����ڻ� ������ 
			double div1, 
			double div2,		// IN: �����ڻ� ����
			double[] X1,			// IN: ��簡��1
			double[] X2,			// IN: ��簡��2
			double[] X3,			// IN: ��簡��3
			double[] upBarrier,		// IN: Knock-out Barrier
			double downBarrier,		// IN: Knock-in Barrier
			double[] amt1,			// IN: ��簡��1�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] amt2,			// IN: ��簡��2�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] amt3,			// IN: ��簡��3�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] coupon,			// IN: �߰� ���� ���� 
			int[] dates, 			// IN: �߰� ���ϱ����� �ϼ� 
			int[] pay_dates, 			// IN: �߰� �����ϱ����� �ϼ� 
			int nStrike, 			// IN: �߰����� �� 
			int downBarrierFlag,		// IN:  downBarrier ����(0:����, 1:����)
			int bUpHitted,  			// IN: Knock-out Barrier Hitting ����
			int bDownHitted,  		// IN: Knock-in Barrier Hitting ����
			int nx,					// IN: �ֽ� ���� ���� ���� 
			double max_loss		// IN: �ִ�ս�
		);

	double HiFive2D_FDM_Vega2(	 
			double S10, 
			double S20,			// IN: �����ڻ� ���簡
			double[] t,			// IN: �Ⱓ ���� ����	
			double[] rf1, 			// IN: ������������ �Ⱓ����
			double[] rf2, 			// IN: ������������ �Ⱓ����
			double[] rd, 			// IN: ���������� �Ⱓ����
			int nt,				// IN: �Ⱓ ���� ������ ����
			double[] t_vol,			// IN:  ������ ���� ����
			double[] vol1, 			// IN: �����ڻ� ������ �Ⱓ ����
			double[] vol2, 		// IN: �����ڻ� ������
			int n_vol,			// IN: ������ ������ ����
			double rho,			// IN: �����ڻ� ������ 
			double div1, 
			double div2,		// IN: �����ڻ� ����
			double[] X1,			// IN: ��簡��1
			double[] X2,			// IN: ��簡��2
			double[] X3,			// IN: ��簡��3
			double[] upBarrier,		// IN: Knock-out Barrier
			double downBarrier,		// IN: Knock-in Barrier
			double[] amt1,			// IN: ��簡��1�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] amt2,			// IN: ��簡��2�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] amt3,			// IN: ��簡��3�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] coupon,			// IN: �߰� ���� ���� 
			int[] dates, 			// IN: �߰� ���ϱ����� �ϼ� 
			int[] pay_dates, 			// IN: �߰� �����ϱ����� �ϼ� 
			int nStrike, 			// IN: �߰����� �� 
			int downBarrierFlag,		// IN:  downBarrier ����(0:����, 1:����)
			int bUpHitted,  			// IN: Knock-out Barrier Hitting ����
			int bDownHitted,  		// IN: Knock-in Barrier Hitting ����
			int nx,					// IN: �ֽ� ���� ���� ���� 
			double max_loss		// IN: �ִ�ս�
		);
	
	double HiFive2D_FDM_Rho(	
			double S10, 
			double S20,			// IN: �����ڻ� ���簡
			double[] t,			// IN: �Ⱓ ���� ����	
			double[] rf1, 			// IN: ������������ �Ⱓ����
			double[] rf2, 			// IN: ������������ �Ⱓ����
			double[] rd, 			// IN: ���������� �Ⱓ����
			int nt,				// IN: �Ⱓ ���� ������ ����
			double[] t_vol,			// IN:  ������ ���� ����
			double[] vol1, 			// IN: �����ڻ� ������ �Ⱓ ����
			double[] vol2, 		// IN: �����ڻ� ������
			int n_vol,			// IN: ������ ������ ����
			double rho,			// IN: �����ڻ� ������ 
			double div1, 
			double div2,		// IN: �����ڻ� ����
			double[] X1,			// IN: ��簡��1
			double[] X2,			// IN: ��簡��2
			double[] X3,			// IN: ��簡��3
			double[] upBarrier,		// IN: Knock-out Barrier
			double downBarrier,		// IN: Knock-in Barrier
			double[] amt1,			// IN: ��簡��1�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] amt2,			// IN: ��簡��2�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] amt3,			// IN: ��簡��3�� �ش�Ǵ� �ߵ���ȯ �ݾ�
			double[] coupon,			// IN: �߰� ���� ���� 
			int[] dates, 			// IN: �߰� ���ϱ����� �ϼ� 
			int[] pay_dates, 			// IN: �߰� �����ϱ����� �ϼ� 
			int nStrike, 			// IN: �߰����� �� 
			int downBarrierFlag,		// IN:  downBarrier ����(0:����, 1:����)
			int bUpHitted,  			// IN: Knock-out Barrier Hitting ����
			int bDownHitted,  		// IN: Knock-in Barrier Hitting ����
			int nx,					// IN: �ֽ� ���� ���� ���� 
			double max_loss		// IN: �ִ�ս�
		);

}
