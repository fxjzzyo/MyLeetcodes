package leetcode;

/**
 * �ڶ�ά���� grid �ϣ��� 4 �����͵ķ���

1 ��ʾ��ʼ������ֻ��һ����ʼ����
2 ��ʾ����������ֻ��һ����������
0 ��ʾ���ǿ����߹��Ŀշ���
-1 ��ʾ�����޷���Խ���ϰ���
�������ĸ������ϡ��¡����ң�������ʱ������ʼ���񵽽�������Ĳ�ͬ·������Ŀ��ÿһ�����ϰ�����Ҫͨ��һ�Ρ�

 

ʾ�� 1��

���룺[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
�����2
���ͣ���������������·����
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

ʾ�� 2��

���룺[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
�����4
���ͣ���������������·���� 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
ʾ�� 3��

���룺[[0,1],[2,0]]
�����0
���ͣ�
û��һ��·����ȫ����ÿһ���յķ���һ�Ρ�
��ע�⣬��ʼ�ͽ����������λ�������е�����λ�á�
 

��ʾ��

1 <= grid.length * grid[0].length <= 20

˼·�����ݷ�
 * @author Administrator
 *
 */
public class ��ͬ·����980 {

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
