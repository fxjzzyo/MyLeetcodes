package leetcode;

/**
 * ����һ������ n������ 1 ... n Ϊ�ڵ���ɵĶ����������ж����֣�

ʾ��:

����: 3
���: 5
����:
���� n = 3, һ���� 5 �ֲ�ͬ�ṹ�Ķ���������:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   ˼·������n���ڵ���ڶ����������ĸ�����G(n)��1Ϊ���ڵ㣬2Ϊ���ڵ㣬...��nΪ���ڵ㣬��1Ϊ���ڵ�ʱ��
   ���������ڵ����Ϊ0���������ڵ����Ϊn-1��ͬ��2Ϊ���ڵ�ʱ�����������ڵ����Ϊ1���������ڵ�Ϊn-2��
   ���Կɵ�G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
   
   ��̬�滮
 * @author Administrator
 *
 */
public class ��ͬ�Ķ���������96 {

	 public static int numTrees(int n) {
	        int[] dp = new int[n+1];
	        dp[0] = 1;
	        dp[1] = 1;
	        for(int i = 2;i<n+1;i++){
	            for(int j = i-1;j>=0;j--){
	                dp[i] += dp[j]*dp[i-j-1];
	            }
	        }
	        return dp[n];
	    }
	
	public static void main(String[] args) {
		int n = 3;
		int numTrees = numTrees(n);
		System.out.println(numTrees);

	}

}
