package leetcode;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"
示例 2:

输入: n = 4, k = 9
输出: "2314"

思路：康拓展开 https://blog.csdn.net/lttree/article/details/24798653

 * @author Administrator
 *
 */
public class 第k个排列60 {

	public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] fac = {1,1,2,6,24,120,720,5040,40320};
        int i,j,t;
        boolean[] mark = new boolean[10];
        k--;
        for(i = 0;i<n;i++){
            t = k/fac[n-1-i];
            for(j = 1;j<=n;j++){
                if(!mark[j]){
                    if(t == 0) break;
                    t--;
                }
            }
            sb.append(""+j);
            mark[j] = true;
            k%=fac[n-i-1];
        }
        
        return sb.toString();
    }
    
	
	public static void main(String[] args) {
		String permutation = getPermutation(3,3);
		System.out.println(permutation);
		
		

	}

}
