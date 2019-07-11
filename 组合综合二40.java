package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 * @author Administrator
 *
 */
public class 组合综合二40 {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();

		// 排序
		Arrays.sort(candidates);

		find(results, temp, candidates, target, 0);
		return results;
	}

	public static void find(List<List<Integer>> ress, List<Integer> temp, int[] cands, int target, int num) {
		if (target == 0) {
			ress.add(new ArrayList<>(temp));// 深拷贝
			return;
		}

		if (cands[0] > target)
			return;
		for (int i = num; i < cands.length && cands[i] <= target; i++) {
			temp.add(cands[i]);
			// 递归 注意此处是i+1，和上题不同
			find(ress, temp, cands, target - cands[i], i + 1);
			temp.remove(temp.size()-1);
			// 跳过重复
			while (i < cands.length - 1 && cands[i] == cands[i + 1])
				i++;

		}

	}

	/**
	 * 第二种写法
	 * @param ress
	 * @param temp
	 * @param cands
	 * @param target
	 * @param num
	 */
	 public void find2(List<List<Integer>> ress,List<Integer> temp,int[]  cands,int target,int num){
	        if(target == 0){
	            ress.add(temp);
	            return;
	        }
	        
	        if(cands[0]>target) return;
	        for(int i=num;i<cands.length&&cands[i]<=target;i++){
	            //深拷贝
	            List<Integer> ls = new ArrayList<>(temp);
             int n = cands[i];
	            ls.add(n);
	            //递归 注意此处是i+1，和上题不同
	            find(ress,ls,cands,target-n,i+1);
             //跳过重复
             while(i<cands.length-1&&cands[i] == cands[i+1]) i++;
             
	        }
	        
	    }
	
	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> combinationSum = combinationSum2(candidates,target);
		
		System.out.println(combinationSum);

	}

}
