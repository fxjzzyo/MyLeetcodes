package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]
说明:

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
 * @author Administrator
 *
 */
public class 两个数组的交集349 {

	
	 public static int[] intersection(int[] nums1, int[] nums2) {
	        if(nums1 == null || nums2 == null || nums1.length == 0||
	          nums2.length == 0) return new int[0];
	        List<Integer> l1 = new ArrayList<>();
	        List<Integer> l2 = new ArrayList<>();
	        for(int n1:nums1){
	            l1.add(n1);
	        }
	        for(int n2:nums2){
	            if(l1.contains(n2))
	                if(!l2.contains(n2))
	                    l2.add(n2);
	        }
	        int len = l2.size();
	        int[] result = new int[len];
	        for(int i = 0;i<len;i++){
	            result[i] = l2.get(i);
	        }
	        return result;
	    }
	
	 public static int[] intersection2(int[] nums1, int[] nums2) {
	        if(nums1 == null || nums2 == null || nums1.length == 0||
	          nums2.length == 0) return new int[0];
	        List<Integer> l1 = new ArrayList<>();
	        //先排序
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        
	        for(int i = 0,j = 0;i<nums1.length&&j<nums2.length;){
	        	if(nums1[i] == nums2[j]){
	        		if(l1.size() == 0|| (nums1[i]^l1.get(l1.size()-1))!=0)
	        			l1.add(nums1[i]);
	        		i++;
	        		j++;
	        	}else if(nums1[i]>nums2[j]){
	        		j++;
	        	}else{
	        		i++;
	        	}
	        }
	        
	        int len = l1.size();
	        int[] result = new int[len];
	        for(int i = 0;i<len;i++){
	            result[i] = l1.get(i);
	        }
	       
	        return result;
	    }
	
	 
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		
		int[] result = intersection2(nums1, nums2);
		for(int re:result){
			System.out.println(re);
		}
	}

}
