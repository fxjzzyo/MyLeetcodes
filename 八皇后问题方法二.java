package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 八皇后问题方法二 {

	//记录方案数
	private int count = 0;
	
	//记录每一行皇后的位置
	private int[] queen = new int[8];
	
	//记录方案的列表
	private List<List<String>> results = new ArrayList<>();
	
	/**
	 * 主要的回溯函数
	 * @param row
	 */
	public void queen(int row){
		if(row == 8){
			//统计方案数
			count++;
			//打印方案
			showAnswer();
			//将结果统计成列表形式
			generateAnswer();
		}else{
			for(int j = 0;j<8;j++){
				queen[row] = j;
				if(isOk(row))
					queen(row+1);
			}
		}
	}
	
	/**
	 * 将结果组织成列表的形式
	 */
	private void generateAnswer(){
		List<String> ans = new ArrayList<>();
		for(int i = 0;i<8;i++){
			StringBuilder sb = new StringBuilder();
			for(int j = 0;j<8;j++){
				if(queen[i] == j){
					sb.append("Q");
				}else{
					sb.append(".");
				}
			}
			ans.add(sb.toString());
		}
		results.add(ans);
	}
	
	/**
	 * 打印合法的结果
	 */
	private void showAnswer() {
		System.out.println("答案是：");
		for(int i = 0;i<8;i++){
			for(int j = 0;j<8;j++){
				if(queen[i] == j){
					System.out.print("Q");
				}else{
					System.out.print(".");
				}
			}
			System.out.println();
		}
		
	}

	/**
	 * 判断是否能放置皇后
	 * @param row
	 * @return
	 */
	private boolean isOk(int row) {
		//依次判断前面的行中与当前行放置的皇后是否冲突
		for(int j = 0;j!=row;j++){
			//在同一列、在副对角线(右上到左下)、在主对角线(左上到右下)，都是冲突的
			if(queen[row]==queen[j] || row+queen[row] == j+queen[j]|| row-queen[row] == j-queen[j]){
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		八皇后问题方法二 qu = new 八皇后问题方法二();
		qu.queen(0);//进行计算
		System.out.println(qu.count);//打印方案数
		System.out.println(qu.results);//以列表的形式打印方案

	}

}
