package leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例 1:

输入: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
示例 2:

输入: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
进阶:

一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个常数空间的解决方案吗？
 * @author Administrator
 *
 */
public class 矩阵置零73 {

	public static void setZeroes(int[][] matrix) {
		if (matrix == null)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		// 用来记录 需要置零的行和列
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
		// 置零操作
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 不等于0时才判断，优化一下
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
