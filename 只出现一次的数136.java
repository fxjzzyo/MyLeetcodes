package leetcode;

import java.util.HashMap;

/**
 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
 * 
 * ˵����
 * 
 * ����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
 * 
 * ʾ�� 1:
 * 
 * ����: [2,2,1] ���: 1 ʾ�� 2:
 * 
 * ����: [4,1,2,1,2] ���: 4
 * 
 * ˼·�� ����һ���������ԭ���Ƽ��� ��������hashmapͳ�ƴ���
 * 
 * �κ�����0��򶼵��κ���
 * 
 * ������ͬ��������0
 * 
 * 
 * @author Administrator
 *
 */
public class ֻ����һ�ε���136 {

	public static int singleNumber(int[] nums) {

		int resu = 0;
		for (int i : nums) {
			resu = resu ^ i;
		}
		return resu;

	}

	public static int singleNumber2(int[] nums) {
		int len = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		int resu = 0;
		for (Integer i : map.keySet()) {
			if (map.get(i) == 1) {
				resu = i;
				break;
			}
		}
		return resu;

	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1 };
		int singleNumber = singleNumber(nums);
		System.out.println(singleNumber);

	}

}
