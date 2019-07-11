package leetcode;

/**
 * ����һ�������Ǹ������� m x n �������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��

˵����ÿ��ֻ�����»��������ƶ�һ����

ʾ��:

����:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
���: 7
����: ��Ϊ·�� 1��3��1��1��1 ���ܺ���С��

���͵Ķ�̬�滮��
 dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
 
 * @author Administrator
 *
 */
public class ��С·����64 {

	/**
	 * ��̬�滮
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
	  * ��̬�滮 �ֿ�д��˼·������
	  * @param grid
	  * @return
	  */
	 public static int minPathSum2(int[][] grid) {
		 
	        if(grid == null) return 0;
	        
	        int m = grid.length;
	        int n = grid[0].length;
	        int[][] dp = new int[m][n];
	        
	        //��һ��λ��
	        dp[0][0] = grid[0][0];
	        
	        //��
	        for(int i = 1;i<m;i++){
	        	dp[i][0] = dp[i-1][0]+grid[i][0];
	        }
	        
	        //��
	        for(int i = 1;i<n;i++){
	        	dp[0][i] = dp[0][i-1]+grid[0][i];
	        }
	        
	        //�к���
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
