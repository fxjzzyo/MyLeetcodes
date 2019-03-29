package leetcode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @author Administrator
 *
 */
public class 买卖股票的最佳时机121 {

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
