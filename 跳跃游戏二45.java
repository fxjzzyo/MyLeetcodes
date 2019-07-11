package leetcode;


/**
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�

�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�

���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�

ʾ��:

����: [2,3,1,1,4]
���: 2
����: �������һ��λ�õ���С��Ծ���� 2��
     ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�
˵��:

���������ǿ��Ե�����������һ��λ�á�
 * @author Administrator
 *
 */
public class ��Ծ��Ϸ��45 {

	 public static int jump(int[] nums) {
	        if(nums.length == 1) return 0;
	        int step = 0;//����
	        int reach = 0;//���ŵ���һ��λ��
	        int maxReach = 0;//��ǰ���ܵ�������λ��
	        for(int i = 0;i<nums.length;i++){
	            maxReach = Math.max(maxReach,nums[i]+i);
	            if(maxReach>=nums.length-1) return step+1;
	            if(i == reach){
	                step++;
	                reach = maxReach;
	            }
	        }
	        return step;
	    }
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		int res = jump(nums);
		System.out.println(res);
	}

}
