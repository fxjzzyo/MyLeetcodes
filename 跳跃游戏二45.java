package leetcode;


/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
说明:

假设你总是可以到达数组的最后一个位置。
 * @author Administrator
 *
 */
public class 跳跃游戏二45 {

	 public static int jump(int[] nums) {
	        if(nums.length == 1) return 0;
	        int step = 0;//步数
	        int reach = 0;//最优的下一跳位置
	        int maxReach = 0;//当前所能到达的最大位置
	        for(int i = 0;i<nums.length;i++){
	            maxReach = Math.max(maxReach,nums[i]+i);
	            if(maxReach>=nums.length-1) return step+1;
	            if(i == reach){
	                step++;
	                reach = maxReach;
	            }
	        }
	        return step;
	    }
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		int res = jump(nums);
		System.out.println(res);
	}

}
