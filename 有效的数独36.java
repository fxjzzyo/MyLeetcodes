package leetcode;

import java.util.HashSet;

/**
 * �ж�һ�� 9x9 �������Ƿ���Ч��ֻ��Ҫ�������¹�����֤�Ѿ�����������Ƿ���Ч���ɡ�

���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�


һ����Ч�������������ѱ���䣩��һ���ǿɽ�ġ�
ֻ��Ҫ�������Ϲ�����֤�Ѿ�����������Ƿ���Ч���ɡ�
������������ֻ�������� 1-9 ���ַ� '.' ��
����������Զ�� 9x9 ��ʽ�ġ�
 * @author Administrator
 *
 */

public class ��Ч������36 {

	//��֤һ���������Ƿ����
    public static boolean isValidItems(char[] items){
        //��hashset���ж��Ƿ����ظ���ֵ��һ���оͷ���false
        HashSet<Character> set = new HashSet<>();
        for(char c:items){
            if(c>='0'&&c<='9')
                if(!set.add(c)) return false;
        }
        return true;
    }
    
    public static boolean isValidSudoku(char[][] board) {
        int size = board.length;//��Ȼ֪����9
        
        //�ж���
        for(int i = 0;i<size;i++){
            if(!isValidItems(board[i])) return false;
        }
        
        
        //�ж���
        for(int i = 0;i<size;i++){
            char[] colums = new char[size];
            int index = 0;
            for(int j = 0;j<size;j++){
                colums[index++] = board[j][i];
            }
            if(!isValidItems(colums)) return false;            
        }
        
        //�ж�С����
        for(int i = 0;i<size;i+=3){
            for(int j = 0;j<size;j+=3){
                char[] cs = new char[9]; 
                int index = 0;
                for(int k = i;k<i+3;k++){
                    for(int l = j;l<j+3;l++){
                        cs[index++] = board[k][l];
                    }
                }
                if(!isValidItems(cs)) return false; 
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		

	}

}
