package leetcode;

/**
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�

��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������

ע���㲻���������Ʊǰ������Ʊ��

ʾ�� 1:

����: [7,1,5,3,6,4]
���: 5
����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ��������������� = 6-1 = 5 ��
     ע���������� 7-1 = 6, ��Ϊ�����۸���Ҫ��������۸�
ʾ�� 2:

����: [7,6,4,3,1]
���: 0
����: �����������, û�н������, �����������Ϊ 0��
 * @author Administrator
 *
 */
public class ������Ʊ�����ʱ��121 {

	public static int maxProfit(int[] prices) {
        if(prices == null || prices.length <=1) return 0;
        int max = Integer.MIN_VALUE;
        int len = prices.length;
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                int va = prices[j] - prices[i];
                if(va<0) va = 0;
                max = Math.max(max,va);
            }
        }
        return max;
    }
	
	public static int maxProfit2(int[] prices) {
        if(prices == null || prices.length <=1) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = prices.length;
        for(int i = 0;i<len;i++){
        	min = Math.min(min, prices[i]);
        	max = Math.max(max, prices[i]-min);
        }
        return max;
    }
	
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		
		int result = maxProfit2(prices);
		System.out.println(result);
	}

}
