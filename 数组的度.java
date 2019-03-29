package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 数组的度 {

	
	public static int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if(len == 1) return 1;
        //统计频数
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<len;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        //找最大的频数，也就是度
        int max = 0;
        for(int value:map.values()){
            if(value>max) max = value;
        }
        
        System.out.println("degree:---"+max);
        //找频数对应的元素
        List<Integer> ns = new ArrayList<>();//保存出现最多的 数
        for(int key:map.keySet()){
            if(map.get(key) == max ) ns.add(key);
        }
        
        //统计包含对应元素的子数组，并找最短的长度
        int min = Integer.MAX_VALUE;
        for(Integer n:ns){
        	System.out.println("n:---"+n);
            int l = 0,r = len-1;
            while(l<r){
                if(nums[l] == n&&nums[r] == n) break;
                else if(nums[l]!=n&&nums[r] == n) l++;
                else if(nums[l] == n&&nums[r] != n) r--;
                else {l++;r--;}
            }
            min = Math.min(min,r - l+1);
        }
        return min;
        
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,2,3,1};
		// TODO Auto-generated method stub
		int res = findShortestSubArray(nums);
		System.out.println(res);
	}

}
