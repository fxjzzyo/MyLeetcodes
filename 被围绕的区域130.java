package leetcode;

/**
 * ����һ����ά�ľ��󣬰��� 'X' �� 'O'����ĸ O����

�ҵ����б� 'X' Χ�Ƶ����򣬲�����Щ���������е� 'O' �� 'X' ��䡣

ʾ��:

X X X X
X O O X
X X O X
X O X X
������ĺ����󣬾����Ϊ��

X X X X
X X X X
X X X X
X O X X
����:

��Χ�Ƶ����䲻������ڱ߽��ϣ����仰˵���κα߽��ϵ� 'O' �����ᱻ���Ϊ 'X'��
 �κβ��ڱ߽��ϣ�����߽��ϵ� 'O' ������ 'O' ���ն��ᱻ���Ϊ 'X'��
 �������Ԫ����ˮƽ��ֱ�������ڣ���������ǡ��������ġ�

˼·��
 ���ȶԱ߽���ÿһ��'O'�������������������������������'O'��Ϊ'-'��
 Ȼ��������󣬽�����������'O'��Ϊ'X',������������'-'��Ϊ'O' 
 
 * @author Administrator
 *
 */
public class ��Χ�Ƶ�����130 {

	public static void dfs(char[][] board,int i,int j){
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!='O'){
            return;
        }
        
        board[i][j] = '-';
        dfs(board,i-1,j);
        dfs(board,i,j-1);
        dfs(board,i+1,j);
        dfs(board,i,j+1);
        
    }
    
    
    public static void solve(char[][] board) {
        if(board == null ||board.length == 0) return;
        int cow = board.length;
        int cols = board[0].length;
        
        //�ȴ���߿�
         for(int i = 0;i<cow;i++){
            dfs(board,i,0);
            dfs(board,i,cols-1);
        }
        
         for(int j = 0;j<cols;j++){
            dfs(board,0,j);
            dfs(board,cow-1,j);
        }
        
        
        for(int i = 0;i<cow;i++){
            for(int j = 0;j<cols;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '-'){
                    board[i][j] = 'O';
                }
            }
        }
    }
	
	public static void main(String[] args) {
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		solve(board);
		for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
            	System.out.print(board[i][j]+",");
            }
            System.out.println();
        }

	}

}
