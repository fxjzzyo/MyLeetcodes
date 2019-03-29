package leetcode;


/**
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�

���һ���㷨�����������ܻ�ȡ�������������������� ���� ���ס�

ע��: �㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����

ʾ�� 1:

����: [3,3,5,0,0,3,1,4]
���: 6
����: �ڵ� 4 �죨��Ʊ�۸� = 0����ʱ�����룬�ڵ� 6 �죨��Ʊ�۸� = 3����ʱ����������ʽ������ܻ������ = 3-0 = 3 ��
     ����ڵ� 7 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 8 �� ����Ʊ�۸� = 4����ʱ����������ʽ������ܻ������ = 4-1 = 3 ��
ʾ�� 2:

����: [1,2,3,4,5]
���: 4
����: �ڵ� 1 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �� ����Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5-1 = 4 ��   
     ע���㲻���ڵ� 1 ��͵� 2 ����������Ʊ��֮���ٽ�����������   
     ��Ϊ��������ͬʱ�����˶�ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ��
ʾ�� 3:

����: [7,6,4,3,1] 
���: 0 
����: ����������, û�н������, �����������Ϊ 0��
 * @author Administrator
 *
 */
public class ������Ʊ�����ʱ����123 {

	 public static int maxProfit(int[] prices) {
	        int fstBuy = Integer.MIN_VALUE;
	        int fstSell = 0;
	        int secBuy = Integer.MIN_VALUE;
	        int secSell = 0;
	        for(int i = 0;i<prices.length;i++){
	        	fstBuy = Math.max(fstBuy, -prices[i]);
	        	fstSell = Math.max(fstSell, fstBuy+prices[i]);
	        	secBuy = Math.max(secBuy, fstSell - prices[i]);
	        	secSell = Math.max(secSell, secBuy+prices[i]);
	        }
	        return secSell;
	        		
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
