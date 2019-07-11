package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 
 * 说明：
 * 
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 
 * 示例 1:
 * 
 * 输入: [2,2,3,2] 输出: 3 示例 2:
 * 
 * 输入: [0,1,0,1,0,1,99] 输出: 99
 * 
 * 异或法，电路思想
 * 
 * 如果能设计一个状态转换电路，使得一个数出现3次时能自动抵消为0，最后剩下的就是只出现1次的数。
 * 
 * 开始设计：一个二进制位只能表示0或者1。也就是天生可以记录一个数出现了一次还是两次。
 * 
 * x ^ 0 = x; x ^ x = 0; 要记录出现3次，需要两个二进制位。那么上面单独的x就不行了。我们需要两个变量，每个变量取一位：
 * 
 * ab ^ 00 = ab; ab ^ ab = 00;
 * 这里，a、b都是32位的变量。我们使用a的第k位与b的第k位组合起来的两位二进制，表示当前位出现了几次。 也就是，一个8位的二进制x就变成了16位来表示。
 * 
 * x = x[7] x[6] x[5] x[4] x[3] x[2] x[1] x[0]
 * 
 * x = (a[7]b[7]) (a[6]b[6]) ... (a[1]b[1]) (a[0]b[0])
 * 
 * 于是，就有了这一幕....
 * 
 * 它是一个逻辑电路，a、b变量中，相同位置上，分别取出一位，负责完成00->01->10->00，也就是开头的那句话，当数字出现3次时置零。
 * 
 * 其他方法： 统计次数； 先排序，再比较相邻的
 * 
 * @author Administrator
 *
 */
public class 只出现一次的数二137 {

	public static int singleNumber(int[] nums) {
		int a = 0, b = 0;
		for (int i : nums) {
			b = (b ^ i) & ~a;
			a = (a ^ i) & ~b;
		}
		return b;
	}

	public static int singleNumber2(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i += 3) {
			if (nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}
		return nums[nums.length - 1];
	}

	public static int singleNumber3(int[] nums) {
		int len = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		int resu = 0;
		for (Integer i : map.keySet()) {
			if (map.get(i) == 1) {
				resu = i;
				break;
			}
		}
		return resu;

	}
	public static void main(String[] args) {
		int[] nums = { 2, 2, 3, 2 };
		int singleNumber = singleNumber3(nums);
		System.out.println(singleNumber);

	}

}
