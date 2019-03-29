package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumsHe {
	public void swap(int[] num,int i,int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		// 先排序
		int len = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<>();
		for(int i = 0;i<len;i++){
			if(i>0&&nums[i] == nums[i-1]) continue;//略过重复元素
			int left = i+1;
			int right = len-1;
			int newTarget = 0 - nums[i];
			while(left<right){
				if(nums[left]+nums[right] == newTarget){
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[left]);
					temp.add(nums[right]);
					results.add(temp);
					left++;
					right--;
					while(left<right&&nums[left]==nums[left-1]){
						left++;
					}
					while(left<right&&nums[right]==nums[right+1]){
						right--;
					}
				}else if(nums[left]+nums[right] > newTarget){
					right--;
				}else{
					left++;
				}
			}
		}
		
		return results;
	}

	public static void main(String[] args) {
//		 int[] nums = {-1,0,1,2,-1,-4};
		int[] nums = { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 };
		ThreeNumsHe th = new ThreeNumsHe();
		List<List<Integer>> results = new ArrayList<>();
		results = th.threeSum(nums);

		for (List<Integer> tem : results) {
			for (Integer num : tem) {
				System.out.print(num + ", ");
			}
			System.out.println();
		}

	}

}
