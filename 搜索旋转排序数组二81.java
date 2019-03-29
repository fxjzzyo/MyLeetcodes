package leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * 
 * 示例 1:
 * 
 * 输入: nums = [2,5,6,0,0,1,2], target = 0 输出: true 示例 2:
 * 
 * 输入: nums = [2,5,6,0,0,1,2], target = 3 输出: false 进阶:
 * 
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * 
 * @author Administrator
 *
 */
public class 搜索旋转排序数组二81 {

	public static boolean search(int[] nums, int target) {
		return searchHelp(nums, 0, nums.length - 1, target);
	}

	public static boolean searchHelp(int[] nums, int l, int h, int target) {
		if (l > h) {
			return false;
		}
		int mid = (l+h)/2;
        if(nums[mid] == target) return true;
        else if(nums[mid]<nums[l]){
            if(target>nums[mid]&&target<=nums[h]){
                return searchHelp(nums,mid+1,h,target);
            }else{
                return searchHelp(nums,l,mid-1,target);
            }
        }else if(nums[l]<nums[mid]){
            if(target<nums[mid]&&target>=nums[l]){
                return searchHelp(nums,l,mid-1,target);
            }else{
                return searchHelp(nums,mid+1,h,target);
            }
        }else{
            return searchHelp(nums,l+1,h,target);
        }
	}

	public static void main(String[] args) {
		int[] nums= {1,1,3,1};
		int target = 3;
		boolean res = search(nums, target);
		System.out.println(res);

	}

}
