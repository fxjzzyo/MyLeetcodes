package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�������� n������һ������ 1 �� n2 ����Ԫ�أ���Ԫ�ذ�˳ʱ��˳���������е������ξ���
 * 
 * ʾ��:
 * 
 * ����: 3 ���: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * 
 * @author Administrator
 *
 */
public class ���������59 {

	public static int[][] generateMatrix(int n) {
		int[][] results = new int[n][n];
		for (int i = 0; i < n; i++) {
		}
		int l = 0, t = 0, r = n - 1, b = n - 1;
		int index = 1;
		while (l <= r && t <= b) {
			// ֻ��һ��
			if (t == b) {
				for (int i = l; i <= r; i++) {
					results[t][i] = index++;
				}
				break;
			}

			// ֻ��һ��
			if (l == r) {
				for (int i = t; i <= b; i++) {
					results[i][l] = index++;
				}
				break;
			}

			// ����
			for (int i = l; i < r; i++) {
				results[t][i] = index++;
			}

			// ����
			for (int i = t; i < b; i++) {
				results[i][r] = index++;
			}

			// ����
			for (int i = r; i > l; i--) {
				results[b][i] = index++;
			}

			// ����
			for (int i = b; i > t; i--) {
				results[i][l] = index++;
			}

			l++;
			r--;
			t++;
			b--;

		}
		return results;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
