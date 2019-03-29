package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * 给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。
进阶:

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @author Administrator
 *
 */
public class 两个数组的交集二350 {

	 public static int[] intersect(int[] nums1, int[] nums2) {
	        List<Integer> results = new ArrayList<>();
	        if(nums1==null || nums2 == null||nums1.length == 0||nums2.length == 0) return new int[0];
	        
	        ArrayList<Integer> l1 = new ArrayList<Integer>();
	        ArrayList<Integer> l2 = new ArrayList<Integer>();
	        for(int n1:nums1){
	        	l1.add(n1);
	        }
	        for(int n2:nums2){
	        	l2.add(n2);
	        }
	        
	        for(Integer num:l1){
	        	if(l2.contains(num)){
	        		results.add(num);
	        		l2.remove(num);
	        	}
	        }
	        int[] ress = new int[results.size()];
	        for(int i = 0;i<results.size();i++){
	        	ress[i] = results.get(i);
	        }
	        return ress;
	    }
	
	 
	 public static int[] intersect2(int[] nums1, int[] nums2) {
	        if(nums1 == null || nums2 == null || nums1.length == 0||
	          nums2.length == 0) return new int[0];
	        List<Integer> l1 = new ArrayList<>();
	        //先排序
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        
	        for(int i = 0,j = 0;i<nums1.length&&j<nums2.length;){
	        	if(nums1[i] == nums2[j]){
	        		l1.add(nums1[1]);
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
	
	 
	 public static int[] intersect3(int[] nums1, int[] nums2) {
	        if(nums1 == null || nums2 == null || nums1.length == 0||
	          nums2.length == 0) return new int[0];
	        List<Integer> l1 = new ArrayList<>();
	        
	        //用hashMap存放数组1的元素，及出现次数
	        HashMap<Integer,Integer> map = new HashMap<>();
	        for(int n1:nums1){
	        	map.put(n1, map.getOrDefault(n1, 0)+1);
	        }
	        
	        //遍历数组2 
	        for(int n2:nums2){
	        	if(map.get(n2)!=0){
	        		l1.add(n2);
	        		map.put(n2, map.get(n2)-1);
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
		
		int[] result = intersect3(nums1, nums2);
		for(int re:result){
			System.out.println(re);
		}
	}

}
