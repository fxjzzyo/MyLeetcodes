package leetcode;

/**
 * 在二维网格 grid 上，有 4 种类型的方格：

1 表示起始方格。且只有一个起始方格。
2 表示结束方格，且只有一个结束方格。
0 表示我们可以走过的空方格。
-1 表示我们无法跨越的障碍。
返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。

 

示例 1：

输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
输出：2
解释：我们有以下两条路径：
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

示例 2：

输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
输出：4
解释：我们有以下四条路径： 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
示例 3：

输入：[[0,1],[2,0]]
输出：0
解释：
没有一条路能完全穿过每一个空的方格一次。
请注意，起始和结束方格可以位于网格中的任意位置。
 

提示：

1 <= grid.length * grid[0].length <= 20

思路：回溯法
 * @author Administrator
 *
 */
public class 不同路径三980 {

	 public static int uniquePathsIII(int[][] grid) {
	        int sum = 0;
	        int a = 0;
	        int b = 0;
	        for(int i = 0;i<grid.length;i++){
	            for(int j = 0;j<grid[0].length;j++){
	                if(grid[i][j] == 0) sum++;
	                else if(grid[i][j] == 1){
	                    a = i;
	                    b = j;
	                    sum++;
	                }
	            }
	        }
	        
	        return huisu(grid,a,b,sum,0);
	        
	    }
	    
	    public static int huisu(int[][] grid,int i,int j,int sum,int now){
	        int s = 0;
	        if(grid[i][j] == -1) return 0;
	        else if(grid[i][j] == 2){
	            if(now == sum) return 1;
	            else return 0;
	        }
	        else if(grid[i][j] == 0||grid[i][j] == 1){
	            grid[i][j] = -1;
	            now++;
	            if(j+1<grid[0].length) s+=huisu(grid,i,j+1,sum,now);
	            if(i+1<grid.length) s+=huisu(grid,i+1,j,sum,now);
	            if(j-1>=0) s+=huisu(grid,i,j-1,sum,now);
	            if(i-1>=0) s+=huisu(grid,i-1,j,sum,now);
	            grid[i][j] = 0;
	        }
	        return s;
	    }
	
	public static void main(String[] args) {
		int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
		int uniquePathsIII = uniquePathsIII(grid);
		System.out.println(uniquePathsIII);
	}

}
