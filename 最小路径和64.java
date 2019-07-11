package leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。

典型的动态规划：
 dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
 
 * @author Administrator
 *
 */
public class 最小路径和64 {

	/**
	 * 动态规划
	 * @param grid
	 * @return
	 */
	 public static int minPathSum(int[][] grid) {
	        if(grid == null) return 0;
	        
	        int m = grid.length;
	        int n = grid[0].length;
	        int[][] dp = new int[m][n];
	        
	        for(int i = 0;i<m;i++){
	            for(int j = 0;j<n;j++){
	                if(i == 0 && j == 0){
	                    dp[i][j] = grid[i][j];
	                }else if(i == 0 && j!=0){
	                    dp[i][j] = dp[i][j-1]+grid[i][j];
	                }else if(i!=0 && j==0){
	                    dp[i][j] = dp[i-1][j]+grid[i][j];
	                }
	                else{
	                    dp[i][j] = grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
	                }
	            }
	        }
	        return dp[m-1][n-1];
	    }
	
	 
	 /**
	  * 动态规划 分开写的思路清晰点
	  * @param grid
	  * @return
	  */
	 public static int minPathSum2(int[][] grid) {
		 
	        if(grid == null) return 0;
	        
	        int m = grid.length;
	        int n = grid[0].length;
	        int[][] dp = new int[m][n];
	        
	        //第一个位置
	        dp[0][0] = grid[0][0];
	        
	        //行
	        for(int i = 1;i<m;i++){
	        	dp[i][0] = dp[i-1][0]+grid[i][0];
	        }
	        
	        //列
	        for(int i = 1;i<n;i++){
	        	dp[0][i] = dp[0][i-1]+grid[0][i];
	        }
	        
	        //行和列
	        for(int i = 1;i<m;i++){
	            for(int j = 1;j<n;j++){
	            	dp[i][j] = grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
	            }
	        }
	        return dp[m-1][n-1];
	    }
	public static void main(String[] args) {
		int[][] grid = {{1,3,1},
		  {1,5,1},
		  {4,2,1}};
		int minPathSum2 = minPathSum2(grid);
		System.out.println(minPathSum2);

	}

}
