package leetcode;

/**
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 * 
 * ( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��
 * 
 * ����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��
 * 
 * ����Լ��������в������ظ���Ԫ�ء�
 * 
 * ����㷨ʱ�临�Ӷȱ����� O(log n) ����
 * 
 * ʾ�� 1:
 * 
 * ����: nums = [4,5,6,7,0,1,2], target = 0 ���: 4 
 * ʾ�� 2:
 * 
 * ����: nums = [4,5,6,7,0,1,2], target = 3 ���: -1
 * 
 * @author Administrator
 *
 */
public class ������ת��������33 {

	public static int search(int[] nums, int target) {
		return searchHelp(nums, 0, nums.length - 1, target);

	}

	public static int searchHelp(int[] nums, int l, int h, int target) {
		if (l > h) {
			return -1;
		}

		int mid = (l + h) / 2;
		if (nums[mid] == target)
			return mid;
		else if (nums[mid] < nums[h]) {
			if (target > nums[mid] && target <= nums[h]) {
				return searchHelp(nums, mid + 1, h, target);
			} else {
				return searchHelp(nums, l, mid - 1, target);
			}
		} else {
			if (target < nums[mid] && target >= nums[l]) {
				return searchHelp(nums, l, mid - 1, target);
			} else {
				return searchHelp(nums, mid + 1, h, target);
			}
		}

	}

	public static void main(String[] args) {
		int[] nums= {4,5,6,7,0,1,2};
		int target = 0;
		int res = search(nums, target);
		System.out.println(res);
	}

}
