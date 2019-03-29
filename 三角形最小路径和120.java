package leetcode;

import java.util.List;


/**
 * ����һ�������Σ��ҳ��Զ����µ���С·���͡�ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ�

���磬���������Σ�

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
�Զ����µ���С·����Ϊ 11������2 + 3 + 5 + 1 = 11����

˵����

��������ֻʹ�� O(n) �Ķ���ռ䣨n Ϊ�����ε��������������������⣬��ô����㷨��ܼӷ֡�
 * @author Administrator
 *
 */
public class ��������С·����120 {

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
