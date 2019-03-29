package leetcode;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class �������� {

	/**
	 * ������������
	 * ʱ�临�Ӷ�O(n)
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
           if(sum>0){//��ǰ�����кʹ���0ʱ���Ժ���������вŻ��й��ף����ܱ������������������
               sum+=nums[i];
           }else{//��ǰ�����к�С��0ʱ���϶����������ں��������������У��������ȷ�����
               sum = nums[i];
           }
           res = Math.max(res,sum);
        }
        return res;
    }
	
	/**
	 * ������̬�滮
	 * f(n) = max(f(n-1)+a[n],a[n])
	 * @param nums
	 * @return
	 */
	public static int maxSubArray2(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for(int i = 0;i<nums.length;i++){
           sum = Math.max(nums[i], sum+nums[i]);
           res = Math.max(res,sum);
        }
        return res;
    }
	
	/**
	 * ��̬�滮 
	 * ��ʵ�͵�һ�ַ���һ��
	 * @param nums
	 * @return
	 */
	public static int maxSubArraydp(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
        	dp[i] = dp[i-1]>0?dp[i-1]+nums[i]:nums[i];
           max = Math.max(max,dp[i]);
        }
        return max;
    }
	
	/**
	 * ���η�
	 * @param nums
	 * @return
	 */
	public static int maxSubArray3(int[] nums) {
        int len = nums.length;
        
        return subMax(nums,0,len-1);
    }
	
	public static int subMax(int[] nums,int left,int r){
		if(left == r) return nums[r];
		
		//����Ϊ����������
		int mid = (left+r)/2;
		int leftMax = subMax(nums,left,mid);
		int rightMax = subMax(nums,mid+1,r);
		
		//����߲��ֵ����ֵ
		int leftM = nums[mid];
		int leftSubM = 0;
		for(int i = mid;i>=left;i--){
			leftSubM +=nums[i];
			if(leftSubM>leftM) leftM = leftSubM;
		}
		
		//���ұ߲��ֵ����ֵ
		int rightM = nums[mid+1];
		int rightSubM = 0;
		for(int i = mid+1;i<=r;i++){
			rightSubM +=nums[i];
			if(rightSubM>rightM) rightM = rightSubM;
		}
		
		//��������������ֵ
		int max = Math.max(rightMax, leftMax);
		//�������ߵĺͣ�Ϊ��ǰ�����������
		//������������������ֵ�����Ƚϣ��ҳ�����
		return Math.max(leftM+rightM,max);
	}
	
	
	/**
	 * �������������±�
	 * @param nums
	 * @return
	 */
	public static int[] maxSubArrayIndex(int[] nums) {
		int res[] = new int[2];
        int max = nums[0];
        int sum = 0;
        int start = 0,end = 0;//��ʼ���յ�λ���±�
        for(int i = 0;i<nums.length;i++){
           if(sum>0){//��ǰ�����кʹ���0ʱ���Ժ���������вŻ��й��ף����ܱ������������������
               sum+=nums[i];
           }else{//��ǰ�����к�С�ڵ���0ʱ���϶����������ں��������������У��������ȷ�����
               sum = nums[i];
               start = i;//����ȷ�����
           }
           if(sum>max){
        	   end = i;//�������ֵʱ�������յ�
        	   max = sum;
           }
        }
        res[0] = start;
        res[1] = end;
        return res;
    }
	
	
	
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//		int res = maxSubArray(nums);
//		int res = maxSubArray2(nums);
//		int res = maxSubArray3(nums);
		int res = maxSubArraydp(nums);
		System.out.println(res);
		
		int[] maxIndexs = maxSubArrayIndex(nums);
		System.out.println(maxIndexs[0]);
		System.out.println(maxIndexs[1]);
	}

}
