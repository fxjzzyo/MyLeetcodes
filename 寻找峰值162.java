package leetcode;


/**
 * ��ֵԪ����ָ��ֵ������������ֵ��Ԫ�ء�

����һ���������� nums������ nums[i] �� nums[i+1]���ҵ���ֵԪ�ز�������������

������ܰ��������ֵ������������£������κ�һ����ֵ����λ�ü��ɡ�

����Լ��� nums[-1] = nums[n] = -�ޡ�

ʾ�� 1:

����: nums = [1,2,3,1]
���: 2
����: 3 �Ƿ�ֵԪ�أ���ĺ���Ӧ�÷��������� 2��
ʾ�� 2:

����: nums = [1,2,1,3,5,6,4]
���: 1 �� 5 
����: ��ĺ������Է������� 1�����ֵԪ��Ϊ 2��
     ���߷������� 5�� ���ֵԪ��Ϊ 6��
˵��:

��ĽⷨӦ���� O(logN) ʱ�临�Ӷȵġ�
 * @author Administrator
 *
 */
public class Ѱ�ҷ�ֵ162 {

	 public static int findPeakElement(int[] nums) {
	        int len = nums.length;
	        int l = 0;
	        int r = len-1;
	        while(l<r){
	            int mid =  l+(r-l)/2;
	            if(nums[mid]>nums[mid+1]){
	                r = mid;
	            }else{
	                l  = mid+1;
	            }
	        }
	        return l;
	    }
	
	public static void main(String[] args) {
		
		int[] nums = {1,2,1,3,5,6,4};
		int findPeakElement = findPeakElement(nums);
		System.out.println(findPeakElement);
	}

}
