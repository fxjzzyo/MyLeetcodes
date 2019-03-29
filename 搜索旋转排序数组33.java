package leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3 输出: -1
 * 
 * @author Administrator
 *
 */
public class 搜索旋转排序数组33 {

	public static int search(int[] nums, int target) {
		return searchHelp(nums, 0, nums.length - 1, target);

	}

	public static int searchHelp(int[] nums, int l, int h, int target) {
		if (l > h) {
			return -1;
		}

		int mid = (l + h) / 2;
		if (nums[mid] == target)
			return mid;
		else if (nums[mid] < nums[h]) {
			if (target > nums[mid] && target <= nums[h]) {
				return searchHelp(nums, mid + 1, h, target);
			} else {
				return searchHelp(nums, l, mid - 1, target);
			}
		} else {
			if (target < nums[mid] && target >= nums[l]) {
				return searchHelp(nums, l, mid - 1, target);
			} else {
				return searchHelp(nums, mid + 1, h, target);
			}
		}

	}

	public static void main(String[] args) {
		int[] nums= {4,5,6,7,0,1,2};
		int target = 0;
		int res = search(nums, target);
		System.out.println(res);
	}

}
