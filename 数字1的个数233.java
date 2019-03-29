package leetcode;

/**
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。

示例:

输入: 13
输出: 6 
解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 * @author Administrator
 *
 */
public class 数字1的个数233 {
	
	
	public static int countDigitOne(int n) {
		int result = 0;
		int a = 1,b=1;
		while(n>0){
			result+= (n+8)/10 * a + (n%10 == 1?1:0) * b;
			b+=n%10*a;
			a*=10;
			n /= 10;
		}
		
		return result;
	}

	public static void main(String[] args) {
		int countDigitOne = countDigitOne(13);
		System.out.println(countDigitOne);

	}

}
