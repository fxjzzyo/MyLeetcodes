package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author Administrator
 *
 */

public class 子集78 {

	/**
	 * 回溯法
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) return results;
        List<Integer> temp = new ArrayList<>();
        sub(results,temp,nums,0);
        return results;
    }
    
    public static void sub(List<List<Integer>> ress,List<Integer> temp,int[] nums,int n){
        if(n == nums.length){
        	 ress.add(new ArrayList<>(temp));
            return;
        }
        ress.add(new ArrayList<>(temp));
        for(int i = n;i<nums.length;i++){
        	temp.add(nums[i]);
        	sub(ress,temp,nums,i+1);
        	temp.remove(temp.size()-1);
        }
    }
	
    public static void sub2(List<List<Integer>> ress,List<Integer> temp,int[] nums,int n){
        if(n == nums.length){
            ress.add(temp);
            return;
        }
        List<Integer> ls = new ArrayList<>();
        ls.addAll(temp);
        sub(ress,ls,nums,n+1);
        temp.add(nums[n]);
        sub(ress,temp,nums,n+1);
    }
    /**
     * 添加法
     * @param nums
     * @return
     */
	public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> rsp = new ArrayList<>();
        if (nums == null) {
            return rsp;
        }
        rsp.add(new ArrayList<Integer>());
        for(int i: nums){
            int len=rsp.size();
            for(int j=0;j<len;j++){
                List<Integer> temp= new ArrayList<>(rsp.get(j));
                temp.add(i);
                rsp.add(temp);
            }
        }
        return rsp;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> subsets = subsets(nums);
		
		System.out.println(subsets);
	}

}
