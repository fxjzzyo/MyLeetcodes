package leetcode;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class 最大子序和 {

	/**
	 * 返回最大子序和
	 * 时间复杂度O(n)
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
           if(sum>0){//当前子序列和大于0时，对后面的子序列才会有贡献，才能被包含在最大子序列中
               sum+=nums[i];
           }else{//当前子序列和小于0时，肯定不被包含在后面的最大子序列中，因此重新确定起点
               sum = nums[i];
           }
           res = Math.max(res,sum);
        }
        return res;
    }
	
	/**
	 * 法二动态规划
	 * f(n) = max(f(n-1)+a[n],a[n])
	 * @param nums
	 * @return
	 */
	public static int maxSubArray2(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for(int i = 0;i<nums.length;i++){
           sum = Math.max(nums[i], sum+nums[i]);
           res = Math.max(res,sum);
        }
        return res;
    }
	
	/**
	 * 动态规划 
	 * 其实和第一种方法一样
	 * @param nums
	 * @return
	 */
	public static int maxSubArraydp(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
        	dp[i] = dp[i-1]>0?dp[i-1]+nums[i]:nums[i];
           max = Math.max(max,dp[i]);
        }
        return max;
    }
	
	/**
	 * 分治法
	 * @param nums
	 * @return
	 */
	public static int maxSubArray3(int[] nums) {
        int len = nums.length;
        
        return subMax(nums,0,len-1);
    }
	
	public static int subMax(int[] nums,int left,int r){
		if(left == r) return nums[r];
		
		//划分为左右子数组
		int mid = (left+r)/2;
		int leftMax = subMax(nums,left,mid);
		int rightMax = subMax(nums,mid+1,r);
		
		//求左边部分的最大值
		int leftM = nums[mid];
		int leftSubM = 0;
		for(int i = mid;i>=left;i--){
			leftSubM +=nums[i];
			if(leftSubM>leftM) leftM = leftSubM;
		}
		
		//求右边部分的最大值
		int rightM = nums[mid+1];
		int rightSubM = 0;
		for(int i = mid+1;i<=r;i++){
			rightSubM +=nums[i];
			if(rightSubM>rightM) rightM = rightSubM;
		}
		
		//左右子数组的最大值
		int max = Math.max(rightMax, leftMax);
		//左右两边的和，为当前子数组的最大和
		//再与左右子数组的最大值，做比较，找出最大的
		return Math.max(leftM+rightM,max);
	}
	
	
	/**
	 * 返回最大子序的下标
	 * @param nums
	 * @return
	 */
	public static int[] maxSubArrayIndex(int[] nums) {
		int res[] = new int[2];
        int max = nums[0];
        int sum = 0;
        int start = 0,end = 0;//起始，终点位置下标
        for(int i = 0;i<nums.length;i++){
           if(sum>0){//当前子序列和大于0时，对后面的子序列才会有贡献，才能被包含在最大子序列中
               sum+=nums[i];
           }else{//当前子序列和小于等于0时，肯定不被包含在后面的最大子序列中，因此重新确定起点
               sum = nums[i];
               start = i;//重新确定起点
           }
           if(sum>max){
        	   end = i;//出现最大值时，更新终点
        	   max = sum;
           }
        }
        res[0] = start;
        res[1] = end;
        return res;
    }
	
	
	
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//		int res = maxSubArray(nums);
//		int res = maxSubArray2(nums);
//		int res = maxSubArray3(nums);
		int res = maxSubArraydp(nums);
		System.out.println(res);
		
		int[] maxIndexs = maxSubArrayIndex(nums);
		System.out.println(maxIndexs[0]);
		System.out.println(maxIndexs[1]);
	}

}
