package leetcode;

import java.util.HashMap;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 
 * 说明：
 * 
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 
 * 示例 1:
 * 
 * 输入: [2,2,1] 输出: 1 示例 2:
 * 
 * 输入: [4,1,2,1,2] 输出: 4
 * 
 * 思路： 方法一：利用异或原理（推荐） 方法二：hashmap统计次数
 * 
 * 任何数与0异或都得任何数
 * 
 * 两个相同的数异或得0
 * 
 * 
 * @author Administrator
 *
 */
public class 只出现一次的数136 {

	public static int singleNumber(int[] nums) {

		int resu = 0;
		for (int i : nums) {
			resu = resu ^ i;
		}
		return resu;

	}

	public static int singleNumber2(int[] nums) {
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
		int[] nums = { 2, 2, 1 };
		int singleNumber = singleNumber(nums);
		System.out.println(singleNumber);

	}

}
