package leetcode;

/**
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�

�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�

�ж����Ƿ��ܹ��������һ��λ�á�

ʾ�� 1:

����: [2,3,1,1,4]
���: true
����: ��λ�� 0 �� 1 �� 1 ��, Ȼ���� 3 ���������һ��λ�á�
ʾ�� 2:

����: [3,2,1,0,4]
���: false
����: �������������ܻᵽ������Ϊ 3 ��λ�á�����λ�õ������Ծ������ 0 �� ��������Զ�����ܵ������һ��λ�á�

˼·��
�Ӻ���ǰ�������飬���������Ԫ�ؿ��Ե������һ�У���ضϺ�ߵ�Ԫ�ء�
���������ǰ�������ʣ�µ�Ԫ�ش���1����������ж�Ϊ�١���������棬ʱ�临�Ӷ�O(n)�Ϳ��ԣ�
 * @author Administrator
 *
 */
public class ��Ծ��Ϸ55 {

	public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int len = nums.length;
        int n = 1;
        for(int i = len-2;i>=0;i--){
            if(nums[i]>=n){
                n = 1;
            }else{
                n++;
            }
            if(i == 0 && n>1){
                return false;
            }
            
        }
        return true;
    }
	
	/**
	 * ̰�ķ�
	 * @param nums
	 * @return
	 */
	public static boolean canJump2(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int len = nums.length;
        int maxReach = 0;//��ǰ���ܵ�������λ��
        for(int i = 0;i<len;i++){
        	if(i>maxReach) return false;
        	maxReach = Math.max(maxReach, nums[i]+i);
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,14};
		int[] nums2 = {3,2,1,0,4};
		boolean canJump = canJump2(nums);
		boolean canJump2 = canJump2(nums2);
		System.out.println(canJump);
		System.out.println(canJump2);
	}

}
