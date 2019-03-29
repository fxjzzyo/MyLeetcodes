package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] 输出: [1,2,3,6,9,8,7,4,5] 示例 2:
 * 
 * 输入: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ] 输出:
 * [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * @author Administrator
 *
 */
public class 螺旋矩阵54 {

	public static List<Integer> spiralOrder(int[][] matrix) {
		 List<Integer> results = new ArrayList<>();
			if(matrix == null) return results;
			int rows = matrix.length;
	        if(rows == 0) return results;
			int colums = matrix[0].length;
			
			int i = 0,j = 0;
			int l = 0,t = 0;
	        
			while(i<rows && i>=t && j>=l && j<colums){
	            //向右
				while(j<colums){
					results.add(matrix[i][j++]);
				}
				t++;//顶部内缩
	            j--;//j加过了，越界了，减一，减回来，取边界值，后面的类似
	            i++;//向下一个，角上的已经访问过了，后面类似
				if(i>=rows) break;//已经到头了
	            //向下
				while(i<rows){
					results.add(matrix[i++][j]);
				}
				colums--;//右侧内缩
	            i--;//减一，取边界值
	            j--;//向左一个
				if(j<l) break;
	            
	            //向左
				while(j>=l){
					results.add(matrix[i][j--]);
				}
				rows--;//底部内缩
				j++;//加一，取边界值
	            i--;//向上一个
	            if(i<t) break;
	            
	            //向上
				while(i>=t){
					results.add(matrix[i--][j]);
				}
				l++;//左侧内缩
	            i++;//加一，取边界值
	            j++;//向右一个
	            if(j>=colums) break;
			}
			return results;
	}

	public static void main(String[] args) {
		

	}

}
