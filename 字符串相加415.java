package leetcode;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 
 * 注意：
 * 
 * num1 和num2 的长度都小于 5100. num1 和num2 都只包含数字 0-9. num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * 153
 * 878
 * 
 * 1031
 * @author Administrator
 *
 */
public class 字符串相加415 {
	public static String addStrings(String num1, String num2) {
		if(num1 == null || num1.length()<1) return num2;
		if(num2 == null || num2.length()<1) return num1;
		StringBuilder sb = new StringBuilder();
		int len1 = num1.length();
		int len2 = num2.length();
		int i = len1-1;
		int j = len2 - 1;
		int jin = 0;//标识进位
		while(i>=0&&j>=0){
			int n1 = num1.charAt(i)-'0';
			int n2 = num2.charAt(j)-'0';
			int sum = n1+n2+jin;
			sb.append(sum%10);
			if(sum>9){
				jin = 1;
			}else{
				jin = 0;
			}
			i--;
			j--;
		}
		while(i>=0){
			int n1 = num1.charAt(i)-'0';
			int sum = n1+jin;
			sb.append(sum%10);
			if(sum>9){
				jin = 1;
			}else{
				jin = 0;
			}
			i--;
		}
		while(j>=0){
			int n2 = num2.charAt(j)-'0';
			int sum = n2+jin;
			sb.append(sum%10);
			if(sum>9){
				jin = 1;
			}else{
				jin = 0;
			}
			j--;
		}
		if(jin!=0) sb.append(1);
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String res = addStrings("123","9988");
		System.out.println(res);
	}

}
