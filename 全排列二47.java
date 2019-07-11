package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

思路：回溯，加去重
 * @author Administrator
 *
 */
public class 全排列二47 {

	 public static List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> ress = new ArrayList<>();
	        
	        if(nums == null || nums.length == 0) return ress;
	        generate(ress,nums,0);
	        return ress;
	    }
	    
	    public static void generate(List<List<Integer>> ress,int[] nums,int pos){
	        if(pos == nums.length){
	            List<Integer> temp = new ArrayList<>();
	            for(int i = 0;i<nums.length;i++){
	                temp.add(nums[i]);
	            }
	            //去重
	            if(!ress.contains(temp))
	            	ress.add(temp);
	            return;
	        }
	        
	        for(int i = pos;i<nums.length;i++){
	        	//再去重（加快一点速度）
                if(pos!=i && nums[pos] == nums[i]) continue;
	            swap(nums,pos,i);
	            generate(ress,nums,pos+1);
	            swap(nums,pos,i);
	        }
	        
	    }
	    
	    public static void swap(int[] nums,int i,int j){
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	
	public static void main(String[] args) {
		int[] nums = {2,2,1,1};
		List<List<Integer>> permute = permute(nums);
		System.out.println(permute);
	}

}
