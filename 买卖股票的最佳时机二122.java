package leetcode;

/**
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�

���һ���㷨�����������ܻ�ȡ�������������Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ����

ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����

ʾ�� 1:

����: [7,1,5,3,6,4]
���: 7
����: �ڵ� 2 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 3 �죨��Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5-1 = 4 ��
     ����ڵ� 4 �죨��Ʊ�۸� = 3����ʱ�����룬�ڵ� 5 �죨��Ʊ�۸� = 6����ʱ������, ��ʽ������ܻ������ = 6-3 = 3 ��
ʾ�� 2:

����: [1,2,3,4,5]
���: 4
����: �ڵ� 1 �죨��Ʊ�۸� = 1����ʱ�����룬�ڵ� 5 �� ����Ʊ�۸� = 5����ʱ������, ��ʽ������ܻ������ = 5-1 = 4 ��
     ע���㲻���ڵ� 1 ��͵� 2 ����������Ʊ��֮���ٽ�����������
     ��Ϊ��������ͬʱ�����˶�ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ��
ʾ�� 3:

����: [7,6,4,3,1]
���: 0
����: �����������, û�н������, �����������Ϊ 0��
 * @author Administrator
 *
 */
public class ������Ʊ�����ʱ����122 {

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int len = prices.length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < len; i++) {
			min = Math.min(min, prices[i]);
			if (prices[i] - min > max) {
				max = prices[i] - min;
				result += max;
				min = prices[i];
				max = 0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };

		int result = maxProfit(prices);
		System.out.println(result);

	}

}
