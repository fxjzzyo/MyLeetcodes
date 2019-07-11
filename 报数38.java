package leetcode;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 
 * 1. 1 
 * 2. 11 
 * 3. 21 
 * 4. 1211 
 * 5. 111221 
 * 1 被读作 "one 1" ("一个一") , 即 11。 
 * 11 被读作"two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2", "one 1" （"一个二" , "一个一") , 即 1211。
 * 
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 
 * 注意：整数顺序将表示为一个字符串。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1 输出: "1" 示例 2:
 * 
 * 输入: 4 输出: "1211"
 * 
 * 
 * 思路：
 * 本次n读取的是n-1的结果
 * 如，2读取的是1的结果“1”，即一个一：11
 * 再如，3读取的是2的结果“11”，即两个一：21
 * 
 * @author Administrator
 *
 */
public class 报数38 {

	public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		String s = "1";// 第一次读1
		// 从2开始读
		for (int i = 2; i <= n; i++) {
			// 记录本次读取的结果
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < s.length(); j++) {
				// 统计重复字的次数
				int times = 1;
				while (j < s.length() - 1 && s.charAt(j) == s.charAt(j + 1)) {
					times++;
					j++;
				}
				// 记录有几个这样的字
				sb.append(times);
				// 这样的字
				sb.append(s.charAt(j));

			}
			// 本次结果是为了下次遍历读取的
			s = sb.toString();
		}
		return s;
	}

	public static void main(String[] args) {
		String s = countAndSay(5);
		System.out.println(s);
	}

}
