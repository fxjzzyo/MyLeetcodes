package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ����Ķ� {

	
	public static int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if(len == 1) return 1;
        //ͳ��Ƶ��
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<len;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        //������Ƶ����Ҳ���Ƕ�
        int max = 0;
        for(int value:map.values()){
            if(value>max) max = value;
        }
        
        System.out.println("degree:---"+max);
        //��Ƶ����Ӧ��Ԫ��
        List<Integer> ns = new ArrayList<>();//����������� ��
        for(int key:map.keySet()){
            if(map.get(key) == max ) ns.add(key);
        }
        
        //ͳ�ư�����ӦԪ�ص������飬������̵ĳ���
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
