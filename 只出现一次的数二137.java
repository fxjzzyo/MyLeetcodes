package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ����������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
 * 
 * ˵����
 * 
 * ����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
 * 
 * ʾ�� 1:
 * 
 * ����: [2,2,3,2] ���: 3 ʾ�� 2:
 * 
 * ����: [0,1,0,1,0,1,99] ���: 99
 * 
 * ��򷨣���·˼��
 * 
 * ��������һ��״̬ת����·��ʹ��һ��������3��ʱ���Զ�����Ϊ0�����ʣ�µľ���ֻ����1�ε�����
 * 
 * ��ʼ��ƣ�һ��������λֻ�ܱ�ʾ0����1��Ҳ�����������Լ�¼һ����������һ�λ������Ρ�
 * 
 * x ^ 0 = x; x ^ x = 0; Ҫ��¼����3�Σ���Ҫ����������λ����ô���浥����x�Ͳ����ˡ�������Ҫ����������ÿ������ȡһλ��
 * 
 * ab ^ 00 = ab; ab ^ ab = 00;
 * ���a��b����32λ�ı���������ʹ��a�ĵ�kλ��b�ĵ�kλ�����������λ�����ƣ���ʾ��ǰλ�����˼��Ρ� Ҳ���ǣ�һ��8λ�Ķ�����x�ͱ����16λ����ʾ��
 * 
 * x = x[7] x[6] x[5] x[4] x[3] x[2] x[1] x[0]
 * 
 * x = (a[7]b[7]) (a[6]b[6]) ... (a[1]b[1]) (a[0]b[0])
 * 
 * ���ǣ���������һĻ....
 * 
 * ����һ���߼���·��a��b�����У���ͬλ���ϣ��ֱ�ȡ��һλ���������00->01->10->00��Ҳ���ǿ�ͷ���Ǿ仰�������ֳ���3��ʱ���㡣
 * 
 * ���������� ͳ�ƴ����� �������ٱȽ����ڵ�
 * 
 * @author Administrator
 *
 */
public class ֻ����һ�ε�����137 {

	public static int singleNumber(int[] nums) {
		int a = 0, b = 0;
		for (int i : nums) {
			b = (b ^ i) & ~a;
			a = (a ^ i) & ~b;
		}
		return b;
	}

	public static int singleNumber2(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i += 3) {
			if (nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}
		return nums[nums.length - 1];
	}

	public static int singleNumber3(int[] nums) {
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
		int[] nums = { 2, 2, 3, 2 };
		int singleNumber = singleNumber3(nums);
		System.out.println(singleNumber);

	}

}
