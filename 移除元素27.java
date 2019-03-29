package leetcode;

import java.util.Arrays;

/**
 * ����һ������ nums ��һ��ֵ val������Ҫԭ���Ƴ�������ֵ���� val ��Ԫ�أ������Ƴ���������³��ȡ�
 * 
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 * 
 * Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 * 
 * ʾ�� 1:
 * 
 * ���� nums = [3,2,2,3], val = 3,
 * 
 * ����Ӧ�÷����µĳ��� 2, ���� nums �е�ǰ����Ԫ�ؾ�Ϊ 2��
 * 
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء� ʾ�� 2:
 * 
 * ���� nums = [0,1,2,2,3,0,4,2], val = 2,
 * 
 * ����Ӧ�÷����µĳ��� 5, ���� nums �е�ǰ���Ԫ��Ϊ 0, 1, 3, 0, 4��
 * 
 * ע�������Ԫ�ؿ�Ϊ����˳��
 * 
 * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء� ˵��:
 * 
 * Ϊʲô������ֵ��������������Ĵ���������?
 * 
 * ��ע�⣬�����������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�
 * 
 * ����������ڲ���������:
 * 
 * // nums ���ԡ����á���ʽ���ݵġ�Ҳ����˵������ʵ�����κο��� int len = removeElement(nums, val);
 * 
 * // �ں������޸�����������ڵ������ǿɼ��ġ� // ������ĺ������صĳ���, �����ӡ�������иó��ȷ�Χ�ڵ�����Ԫ�ء� for (int i = 0;
 * i < len; i++) { print(nums[i]); }
 * 
 * @author Administrator
 *
 */
public class �Ƴ�Ԫ��27 {

	public static int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0)
			return 0;

		Arrays.sort(nums);
		int res = 0;
		int len = nums.length;

		for (int i = 0, j = 0; i < len;) {
			if (nums[i] != val) {
				res++;
				nums[j++] = nums[i];
			}
			while (++i < len && nums[i] == val)
				;
		}
		return res;

	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		int res = removeElement(nums, 3);

		for (int i = 0; i < res; i++) {
			System.out.println(nums[i] + " ");
		}

	}

}
