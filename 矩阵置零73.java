package leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * ����һ�� m x n �ľ������һ��Ԫ��Ϊ 0�����������к��е�����Ԫ�ض���Ϊ 0����ʹ��ԭ���㷨��

ʾ�� 1:

����: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
���: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
ʾ�� 2:

����: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
���: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
����:

һ��ֱ�ӵĽ��������ʹ��  O(mn) �Ķ���ռ䣬���Ⲣ����һ���õĽ��������
һ���򵥵ĸĽ�������ʹ�� O(m + n) �Ķ���ռ䣬������Ȼ������õĽ��������
�������һ�������ռ�Ľ��������
 * @author Administrator
 *
 */
public class ��������73 {

	public static void setZeroes(int[][] matrix) {
		if (matrix == null)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		// ������¼ ��Ҫ������к���
		List<Integer> ms = new ArrayList<>();
		List<Integer> ns = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (!ms.contains(i)) {
						ms.add(i);
					}
					if (!ns.contains(j)) {
						ns.add(j);
					}

				}
			}
		}
		// �������
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// ������0ʱ���жϣ��Ż�һ��
				if (matrix[i][j] != 0) {
					if (ms.contains(i) || ns.contains(j)) {
						matrix[i][j] = 0;
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
	}

}
