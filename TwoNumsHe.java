package leetcode;

import java.util.Arrays;

public class TwoNumsHe {
	
	public int[] twoSum(int[] nums, int target) {
		 int len = nums.length;
	        int[] results = new int[2];
	        for(int i =0;i<len;i++){
	            for(int j = i+1;j<len;j++){
	                if(nums[i]+nums[j] == target){
	                    results[0] = i;
	                    results[1] = j;
	                    return results;
	                }
	            }
	        }
	        return null;
    }
	
	public static void main(String[] args) {
		

	}

}
