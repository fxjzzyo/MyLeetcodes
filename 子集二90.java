package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: [1,2,2] 输出: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * 
 * 典型的回溯法
 * 
 * 加去重
 * @author Administrator
 *
 */
public class 子集二90 {

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> resu = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return resu;
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(nums);
		huisu(resu, temp, nums, 0);
		return resu;
	}

	private static void huisu(List<List<Integer>> resu, List<Integer> temp, int[] nums, int index) {
		if (index >= nums.length) {
			resu.add(new ArrayList<>(temp));
			return;
		}

		resu.add(new ArrayList<>(temp));
		for (int i = index; i < nums.length; i++) {
			if (i != index && nums[i] == nums[i - 1])
				continue;// 去重
			temp.add(nums[i]);
			huisu(resu, temp, nums, i + 1);
			temp.remove(temp.size() - 1);
		}

	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		List<List<Integer>> subsetsWithDup = subsetsWithDup(nums);
		System.out.println(subsetsWithDup);

	}

}
