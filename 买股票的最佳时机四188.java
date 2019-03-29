package leetcode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 示例 1:
 * 
 * 输入: [2,4,1], k = 2 输出: 2 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4)
 * 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 示例 2:
 * 
 * 输入: [3,2,6,5,0,3], k = 2 输出: 7 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6)
 * 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3)
 * 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * 
 * @author Administrator
 *
 */
public class 买股票的最佳时机四188 {

	public static int maxProfit(int k, int[] prices) {
		if(prices == null || prices.length<=1||k<1) return 0;
		int len = prices.length;
		//当k>len/2时，问题退化为买卖股票的最佳时期二
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
	 * 买股票的最佳时机二
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
