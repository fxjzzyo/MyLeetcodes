package leetcode;

/**
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
 * 
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
 * 
 * ���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����
 * 
 * �����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
 * 
 * ˵����m �� n ��ֵ�������� 100��
 * 
 * ʾ�� 1:
 * 
 * ����: [ [0,0,0], [0,1,0], [0,0,0] ] ���: 2 ����: 3x3 ��������м���һ���ϰ�� �����Ͻǵ����½�һ���� 2
 * ����ͬ��·���� 1. ���� -> ���� -> ���� -> ���� 2. ���� -> ���� -> ���� -> ����
 * 
 * ���ǵ��͵Ķ�̬�滮
 * 
 * @author Administrator
 *
 */
public class ��ͬ·����63 {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0)
			return 0;
		int rows = obstacleGrid.length;
		int columns = obstacleGrid[0].length;

		int[][] dp = new int[rows][columns];

		if (obstacleGrid[0][0] == 1) {
			dp[0][0] = 0;
		} else {
			dp[0][0] = 1;
		}

		// �У���߿�
		for (int i = 1; i < rows; i++) {
			if (obstacleGrid[i][0] == 1) {
				dp[i][0] = 0;
			} else {
				dp[i][0] = dp[i - 1][0];
			}
		}

		// �У��ϱ߿�
		for (int i = 1; i < columns; i++) {
			if (obstacleGrid[0][i] == 1) {
				dp[0][i] = 0;
			} else {
				dp[0][i] = dp[0][i - 1];
			}
		}

		// ���У��ڲ���
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[rows - 1][columns - 1];
	}

	public static void main(String[] args) {
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int uniquePathsWithObstacles = uniquePathsWithObstacles(obstacleGrid);
		System.out.println(uniquePathsWithObstacles);
	}
}
