package leetcode;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

思路：
 首先对边界上每一个'O'做深度优先搜索，将与其相连的所有'O'改为'-'。
 然后遍历矩阵，将矩阵中所有'O'改为'X',将矩阵中所有'-'变为'O' 
 
 * @author Administrator
 *
 */
public class 被围绕的区域130 {

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
        
        //先处理边框
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
