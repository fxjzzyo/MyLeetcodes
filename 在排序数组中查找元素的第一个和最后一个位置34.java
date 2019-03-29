package leetcode;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8 输出: [3,4] 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6 输出: [-1,-1]
 * 
 * @author Administrator
 *
 */
public class 在排序数组中查找元素的第一个和最后一个位置34 {

	public static int[] searchRange(int[] nums, int target) {
		int[] results = { -1, -1 };
		if (nums == null || nums.length == 0)
			return results;
		int len = nums.length;
		int l = 0, r = len - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			// 命中了
			if (nums[mid] == target) {
				// 往左边搜索
				int i = mid;
				while (i >= 0 && nums[i] == target) {
					i--;
				}

				// 往右边搜索
				int j = mid;
				while (j < len && nums[j] == target) {
					j++;
				}
				results[0] = i + 1;
				results[1] = j - 1;
				break;

			} else if (nums[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}

		}
		return results;
	}

	public static void main(String[] args) {
		int[] nums = { 1 };
		int target = 1;
		int[] res = searchRange(nums, target);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}

}
