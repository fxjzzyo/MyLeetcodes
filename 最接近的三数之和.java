package leetcode;

import java.util.Arrays;

public class 最接近的三数之和 {
	public static int threeSumClosest(int[] nums, int target) {
		if(nums == null || nums.length == 0) return 0;
		int len = nums.length;
		int min = Integer.MAX_VALUE;
		int result = 0;
		for(int i = 0;i<len-2;i++){
			for(int j = i+1;j<len-1;j++){
				for(int k = j+1;k<len;k++){
					int sum = nums[i] +nums[j]+nums[k];
					int tempR = Math.abs(sum - target);
					if(tempR<min){
						min = tempR; 
						result = sum;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,2,1,4};
		int res = threeSumClosest(nums, 1);
		System.out.println(res);
	}

}
