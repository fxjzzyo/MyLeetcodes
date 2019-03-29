package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 
 * 示例:
 * 
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * 
 * @author Administrator
 *
 */
public class 螺旋矩阵二59 {

	public static int[][] generateMatrix(int n) {
		int[][] results = new int[n][n];
		for (int i = 0; i < n; i++) {
		}
		int l = 0, t = 0, r = n - 1, b = n - 1;
		int index = 1;
		while (l <= r && t <= b) {
			// 只有一行
			if (t == b) {
				for (int i = l; i <= r; i++) {
					results[t][i] = index++;
				}
				break;
			}

			// 只有一列
			if (l == r) {
				for (int i = t; i <= b; i++) {
					results[i][l] = index++;
				}
				break;
			}

			// 向右
			for (int i = l; i < r; i++) {
				results[t][i] = index++;
			}

			// 向下
			for (int i = t; i < b; i++) {
				results[i][r] = index++;
			}

			// 向左
			for (int i = r; i > l; i--) {
				results[b][i] = index++;
			}

			// 向上
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
