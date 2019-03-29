package leetcode;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 
 * 示例 1:
 * 
 * 输入: 3 输出: 0 解释: 3! = 6, 尾数中没有零。 示例 2:
 * 
 * 输入: 5 输出: 1 解释: 5! = 120, 尾数中有 1 个零. 说明: 你算法的时间复杂度应为 O(log n) 。
 * 
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class 阶乘后的零172 {

	
	public static int trailingZeroes(int n) {
		//只需要算5的个数就好了
		int result = 0;
        while(n>0){
            n /= 5;
            result+=n;
        }
		return result;
		
	}

	public static void main(String[] args) {
		int trailingZeroes = trailingZeroes(13);
		System.out.println(trailingZeroes);

	}

}
