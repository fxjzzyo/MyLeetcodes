package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * �����������飬��дһ���������������ǵĽ�����

ʾ�� 1:

����: nums1 = [1,2,2,1], nums2 = [2,2]
���: [2,2]
ʾ�� 2:

����: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
���: [4,9]
˵����

��������ÿ��Ԫ�س��ֵĴ�����Ӧ��Ԫ�������������г��ֵĴ���һ�¡�
���ǿ��Բ�������������˳��
����:

��������������Ѿ��ź����أ��㽫����Ż�����㷨��
��� nums1 �Ĵ�С�� nums2 С�ܶ࣬���ַ������ţ�
��� nums2 ��Ԫ�ش洢�ڴ����ϣ������ڴ������޵ģ������㲻��һ�μ������е�Ԫ�ص��ڴ��У������ô�죿
 * @author Administrator
 *
 */
public class ��������Ľ�����350 {

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
	        //������
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
	        
	        //��hashMap�������1��Ԫ�أ������ִ���
	        HashMap<Integer,Integer> map = new HashMap<>();
	        for(int n1:nums1){
	        	map.put(n1, map.getOrDefault(n1, 0)+1);
	        }
	        
	        //��������2 
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
