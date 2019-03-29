package leetcode;

/**
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�
 * 
 * ���һ���㷨�����������ܻ�ȡ�������������������� k �ʽ��ס�
 * 
 * ע��: �㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����
 * 
 * ʾ�� 1:
 * 
 * ����: [2,4,1], k = 2 ���: 2 ����: �ڵ� 1 �� (��Ʊ�۸� = 2) ��ʱ�����룬�ڵ� 2 �� (��Ʊ�۸� = 4)
 * ��ʱ����������ʽ������ܻ������ = 4-2 = 2 �� ʾ�� 2:
 * 
 * ����: [3,2,6,5,0,3], k = 2 ���: 7 ����: �ڵ� 2 �� (��Ʊ�۸� = 2) ��ʱ�����룬�ڵ� 3 �� (��Ʊ�۸� = 6)
 * ��ʱ������, ��ʽ������ܻ������ = 6-2 = 4 �� ����ڵ� 5 �� (��Ʊ�۸� = 0) ��ʱ�����룬�ڵ� 6 �� (��Ʊ�۸� = 3)
 * ��ʱ������, ��ʽ������ܻ������ = 3-0 = 3 ��
 * 
 * @author Administrator
 *
 */
public class ���Ʊ�����ʱ����188 {

	public static int maxProfit(int k, int[] prices) {
		if(prices == null || prices.length<=1||k<1) return 0;
		int len = prices.length;
		//��k>len/2ʱ�������˻�Ϊ������Ʊ�����ʱ�ڶ�
		if(k>=len/2) return greedy(prices);
		int result = 0;
		int[][] pros = new int[k][2];
		for(int p:prices){
			for(int i = 0;i<k;i++){
				if(i == 0)
					pros[i][0] = Math.max(pros[i][0], -p);
				else
					pros[i][0] = Math.max(pros[i][0], pros[i-1][1]-p);
				pros[i][1] = Math.max(pros[i][1], pros[i][0]+p);
				
			}
		}
		return pros[k-1][1];
	}

	/**
	 * ���Ʊ�����ʱ����
	 * @param prices
	 * @return
	 */
	public static int greedy(int[] prices){
        int max = 0;
        for(int i = 1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
                max+= (prices[i]-prices[i-1]);
        }
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
