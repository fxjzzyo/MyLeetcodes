package leetcode;

import java.util.HashSet;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
给定数独序列只包含数字 1-9 和字符 '.' 。
给定数独永远是 9x9 形式的。
 * @author Administrator
 *
 */

public class 有效的数独36 {

	//验证一个子数组是否符合
    public static boolean isValidItems(char[] items){
        //用hashset来判断是否有重复的值，一旦有就返回false
        HashSet<Character> set = new HashSet<>();
        for(char c:items){
            if(c>='0'&&c<='9')
                if(!set.add(c)) return false;
        }
        return true;
    }
    
    public static boolean isValidSudoku(char[][] board) {
        int size = board.length;//虽然知道是9
        
        //判断行
        for(int i = 0;i<size;i++){
            if(!isValidItems(board[i])) return false;
        }
        
        
        //判断列
        for(int i = 0;i<size;i++){
            char[] colums = new char[size];
            int index = 0;
            for(int j = 0;j<size;j++){
                colums[index++] = board[j][i];
            }
            if(!isValidItems(colums)) return false;            
        }
        
        //判断小方格
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
