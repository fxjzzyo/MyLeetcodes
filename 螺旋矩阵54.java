package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������ m x n ��Ԫ�صľ���m ��, n �У����밴��˳ʱ������˳�򣬷��ؾ����е�����Ԫ�ء�
 * 
 * ʾ�� 1:
 * 
 * ����: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] ���: [1,2,3,6,9,8,7,4,5] ʾ�� 2:
 * 
 * ����: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ] ���:
 * [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * @author Administrator
 *
 */
public class ��������54 {

	public static List<Integer> spiralOrder(int[][] matrix) {
		 List<Integer> results = new ArrayList<>();
			if(matrix == null) return results;
			int rows = matrix.length;
	        if(rows == 0) return results;
			int colums = matrix[0].length;
			
			int i = 0,j = 0;
			int l = 0,t = 0;
	        
			while(i<rows && i>=t && j>=l && j<colums){
	            //����
				while(j<colums){
					results.add(matrix[i][j++]);
				}
				t++;//��������
	            j--;//j�ӹ��ˣ�Խ���ˣ���һ����������ȡ�߽�ֵ�����������
	            i++;//����һ�������ϵ��Ѿ����ʹ��ˣ���������
				if(i>=rows) break;//�Ѿ���ͷ��
	            //����
				while(i<rows){
					results.add(matrix[i++][j]);
				}
				colums--;//�Ҳ�����
	            i--;//��һ��ȡ�߽�ֵ
	            j--;//����һ��
				if(j<l) break;
	            
	            //����
				while(j>=l){
					results.add(matrix[i][j--]);
				}
				rows--;//�ײ�����
				j++;//��һ��ȡ�߽�ֵ
	            i--;//����һ��
	            if(i<t) break;
	            
	            //����
				while(i>=t){
					results.add(matrix[i--][j]);
				}
				l++;//�������
	            i++;//��һ��ȡ�߽�ֵ
	            j++;//����һ��
	            if(j>=colums) break;
			}
			return results;
	}

	public static void main(String[] args) {
		

	}

}
