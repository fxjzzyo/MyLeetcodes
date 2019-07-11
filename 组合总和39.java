package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 * @author Administrator
 *
 */
public class 组合总和39 {

	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> results  = new ArrayList<>();
	        List<Integer> temp = new ArrayList<>();
	        //排序
	        Arrays.sort(candidates);
	        find(results,temp,candidates,target,0);
	        return results;
	    }
	    
	    
	    public static void find(List<List<Integer>> ress,List<Integer> temp,int[] cands,int target,int num){
	        if(target == 0){
	            ress.add(new ArrayList<>(temp));//深拷贝
	            return;
	        }
	        
	        if(cands[0]>target) return;
	        for(int i=num;i<cands.length&&cands[i]<=target;i++){
	            temp.add(cands[i]);
	            //递归
	            find(ress,temp,cands,target-cands[i],i);
	            temp.remove(temp.size()-1);//回退
	        }
	        
	    }
	    
	    /**
	     * 回溯的第二种写法
	     * @param ress
	     * @param temp
	     * @param cands
	     * @param target
	     * @param num
	     */
	    public void find2(List<List<Integer>> ress,List<Integer> temp,int[] cands,int target,int num){
	        if(target == 0){
	            ress.add(temp);
	            return;
	        }
	        
	        if(cands[0]>target) return;
	        for(int i=num;i<cands.length&&cands[i]<=target;i++){
	            //深拷贝
	            List<Integer> ls = new ArrayList<>(temp);
	            ls.add(cands[i]);
	            //递归
	            find(ress,ls,cands,target-cands[i],i);
	        }
	        
	    }
	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> combinationSum = combinationSum(candidates,target);
		
		System.out.println(combinationSum);
		
	}

}
