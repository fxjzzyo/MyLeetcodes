package leetcode;

import java.util.Arrays;

/**
 * 
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 
 * 思路：
 * 
 * 先假设第一个元素为众数，计数器置为1，遍历数组，当遇到相同的元素时，计数器加1，否则减1，
 * 任何计算器为0的时候，就假设下一个元素为众数，计数器再置为1。
 * 循环结束时，返回我们假设的众数，即要求的众数。
 * 注意：这是求数学意义上“众数”的方法，没有验证题目中的大于n/2的要求
 * 
 * 要验证的话还要加
 * 
 * 
 * @author Administrator
 *
 */
public class 求众数169 {

	public static int majorityElement(int[] nums) {
	       int resu = nums[0];
	        int time = 1;
	        for(int i = 1;i<nums.length;i++){
	            if(nums[i] == resu){
	                time++;
	            }else{
	                time--;
	                if(time==0){
	                    resu = nums[++i];
	                    time++;
	                }
	            }
	        }
	        return resu;
	        
	    }
	
	/**
	 * 法二
	 * 摩尔投票法
	 * @param nums
	 * @return
	 */
	public static int majorityElement2(int[] nums) {
	       int resu = -1;//记录那个众数
	        int time = 0;//记录次数
	        //统计
	        for(int n:nums){
	        	if(time == 0){
	        		resu = n;
	        		time++;
	        		
	        	}else{
	        		if(resu == n){
	        			time++;
	        		}else{
	        			time--;
	        		}
	        	}
	        }
	        //找出那个众数
	        int count = 0;
	        if(time<=0) return -1;
	        for(int n:nums){
	        	if(n == resu) count++;
	        }
	       if(count>nums.length/2) return resu;
	       else return -1;
	    }
	
	/**
	 * 法三
	 * @param nums
	 * @return
	 */
	 public static int majorityElement3(int[] nums) {
			Arrays.sort(nums);
			return nums[nums.length / 2];
		}
	
	public static void main(String[] args) {
		int[] nums = {3,2,3};
		int majorityElement = majorityElement2(nums);
		System.out.println(majorityElement);

	}

}
