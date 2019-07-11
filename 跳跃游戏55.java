package leetcode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

思路：
从后往前遍历数组，如果遇到的元素可以到达最后一行，则截断后边的元素。
否则继续往前，若最后剩下的元素大于1个，则可以判断为假。否则就是真，时间复杂度O(n)就可以，
 * @author Administrator
 *
 */
public class 跳跃游戏55 {

	public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int len = nums.length;
        int n = 1;
        for(int i = len-2;i>=0;i--){
            if(nums[i]>=n){
                n = 1;
            }else{
                n++;
            }
            if(i == 0 && n>1){
                return false;
            }
            
        }
        return true;
    }
	
	/**
	 * 贪心法
	 * @param nums
	 * @return
	 */
	public static boolean canJump2(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int len = nums.length;
        int maxReach = 0;//当前所能到达的最大位置
        for(int i = 0;i<len;i++){
        	if(i>maxReach) return false;
        	maxReach = Math.max(maxReach, nums[i]+i);
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,14};
		int[] nums2 = {3,2,1,0,4};
		boolean canJump = canJump2(nums);
		boolean canJump2 = canJump2(nums2);
		System.out.println(canJump);
		System.out.println(canJump2);
	}

}
