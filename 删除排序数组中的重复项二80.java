package leetcode;

public class 删除排序数组中的重复项二80 {

	public static int removeDuplicates(int[] nums) {
		 if (nums == null || nums.length == 0)
	            return 0;

	        int n = nums.length;
	        int end = 1;
	        int flag = 0; // 计数，是否出现两次

	        for (int i = 1; i < n; i++) {
	            if (nums[end - 1] == nums[i]) {
	                if (flag == 0) { // 如果只出现一次，那么让该元素继续出现
	                    nums[end] = nums[i];
	                    end++;
	                    flag++;
	                }
	            }
	            if (nums[end - 1] != nums[i]) {
	                nums[end] = nums[i];
	                end++;
	                flag = 0;
	            }
	        }
	        return end;
        
    }
	
	 public static int removeDuplicates2(int[] nums) {
	        if(nums == null || nums.length == 0) return 0;
	        int len = nums.length;
	        int count = 1;
	        int deleCount = 0;
	        for(int i =0;i<len-1;i++){
	            if(count>2){
	                int k = i;
	                int temp = i;
	                //从后面找一个不等于nums[i]的值
	                while(i+1<len&&nums[i] == nums[i+1]){
	                    deleCount++;
	                    i++;
	                }
	                i = i+1;
	                int j = i;
	                //移动覆盖
	                while(j<j+2){
	                    nums[k++] = nums[j++];
	                }
	                count = 1;
	                continue;
	            }
	            if(nums[i] == nums[i+1]){
	                count++;
	            }else{
	                count=1;
	            }
	        }
	        return len-deleCount;
	        
	    }
	
	 //0,0,1,1,1,1,2,3,3
	 public static int removeDuplicates3(int[] nums) {
	        if(nums.length == 0)
	            return 0;
	        int i = 0;
	    	 int j = 1;
	    	 for(j=1;j<nums.length;j++) {
	    		 if(nums[i] != nums[j] ) {
	    			 i++;
	    			 if((j-i)>=1) {
	    				nums[i+1] = nums[j];
	    			 }
	    			 
	    		 }
	    	 }
	        return i+2;
	    }
	 
	public static void main(String[] args) {
//		int[] nums2 = {1,1,1,2,2,3};
		int[] nums2 = {0,0,1,1,1,1,2,3,3};
//		int[] nums2 = {0,1,2,2,2,2,2,3,4,4,4};
//		int[] nums2 = {-49,-49,-49,-48,-48,-45,-44,-44,-43,-43,-42,-39,-39,-39,-38,-38,-37,-37,-37,-36,-35,-34,-34,-34,-33,-33,-33,-33,-32,-32,-31,-30,-30,-29,-29,-29,-28,-27,-27,-25,-25,-25,-25,-25,-24,-23,-23,-23,-22,-21,-21,-21,-21,-21,-21,-20,-19,-18,-18,-17,-17,-17,-17,-17,-16,-14,-14,-14,-14,-12,-11,-10,-9,-9,-9,-8,-8,-8,-8,-8,-8,-7,-7,-7,-6,-5,-4,-4,-3,-3,-3,-3,-2,-2,-2,-2,-1,-1,0,0,1,1,4,6,6,7,8,9,9,10,10,10,10,11,11,11,12,12,12,12,12,13,14,14,14,15,15,16,16,17,17,18,18,20,20,20,20,20,21,21,21,21,21,22,23,23,23,24,24,24,25,25,26,26,27,27,28,28,31,32,32,32,33,33,34,34,35,35,36,36,36,36,37,37,37,38,38,39,40,40,40,42,42,43,43,44,44,44,44,45,46,46,47,47,47,48,48,49,49};
		int removeDuplicates = removeDuplicates3(nums2);
		for(int i = 0;i<removeDuplicates;i++){
			System.out.println(nums2[i]);
		}
		

	}

}
