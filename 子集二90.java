package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ�����ܰ����ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
 * 
 * ˵�����⼯���ܰ����ظ����Ӽ���
 * 
 * ʾ��:
 * 
 * ����: [1,2,2] ���: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * 
 * ���͵Ļ��ݷ�
 * 
 * ��ȥ��
 * @author Administrator
 *
 */
public class �Ӽ���90 {

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> resu = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return resu;
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(nums);
		huisu(resu, temp, nums, 0);
		return resu;
	}

	private static void huisu(List<List<Integer>> resu, List<Integer> temp, int[] nums, int index) {
		if (index >= nums.length) {
			resu.add(new ArrayList<>(temp));
			return;
		}

		resu.add(new ArrayList<>(temp));
		for (int i = index; i < nums.length; i++) {
			if (i != index && nums[i] == nums[i - 1])
				continue;// ȥ��
			temp.add(nums[i]);
			huisu(resu, temp, nums, i + 1);
			temp.remove(temp.size() - 1);
		}

	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		List<List<Integer>> subsetsWithDup = subsetsWithDup(nums);
		System.out.println(subsetsWithDup);

	}

}
