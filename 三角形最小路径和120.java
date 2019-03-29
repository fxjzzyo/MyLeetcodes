package leetcode;

import java.util.List;


/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * @author Administrator
 *
 */
public class 三角形最小路径和120 {

	 public static int minimumTotal(List<List<Integer>> triangle) {
	        if(triangle == null || triangle.size() == 0) return 0;
	        int len = triangle.size();
	        int[][] dp = new int[len+1][len+1];
	        for(int i = len-1;i>=0;i--){
	            List<Integer> temp = triangle.get(i);
	            for(int j = 0;j<temp.size();j++){
	                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+temp.get(j);
	            }
	        }
	        
	        return dp[0][0];
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
