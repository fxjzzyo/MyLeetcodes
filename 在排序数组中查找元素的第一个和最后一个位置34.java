package leetcode;

/**
 * ����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
 * 
 * ����㷨ʱ�临�Ӷȱ����� O(log n) ����
 * 
 * ��������в�����Ŀ��ֵ������ [-1, -1]��
 * 
 * ʾ�� 1:
 * 
 * ����: nums = [5,7,7,8,8,10], target = 8 ���: [3,4] ʾ�� 2:
 * 
 * ����: nums = [5,7,7,8,8,10], target = 6 ���: [-1,-1]
 * 
 * @author Administrator
 *
 */
public class �����������в���Ԫ�صĵ�һ�������һ��λ��34 {

	public static int[] searchRange(int[] nums, int target) {
		int[] results = { -1, -1 };
		if (nums == null || nums.length == 0)
			return results;
		int len = nums.length;
		int l = 0, r = len - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			// ������
			if (nums[mid] == target) {
				// ���������
				int i = mid;
				while (i >= 0 && nums[i] == target) {
					i--;
				}

				// ���ұ�����
				int j = mid;
				while (j < len && nums[j] == target) {
					j++;
				}
				results[0] = i + 1;
				results[1] = j - 1;
				break;

			} else if (nums[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}

		}
		return results;
	}

	public static void main(String[] args) {
		int[] nums = { 1 };
		int target = 1;
		int[] res = searchRange(nums, target);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}

}
