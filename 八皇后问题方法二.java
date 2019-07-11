package leetcode;

import java.util.ArrayList;
import java.util.List;

public class �˻ʺ����ⷽ���� {

	//��¼������
	private int count = 0;
	
	//��¼ÿһ�лʺ��λ��
	private int[] queen = new int[8];
	
	//��¼�������б�
	private List<List<String>> results = new ArrayList<>();
	
	/**
	 * ��Ҫ�Ļ��ݺ���
	 * @param row
	 */
	public void queen(int row){
		if(row == 8){
			//ͳ�Ʒ�����
			count++;
			//��ӡ����
			showAnswer();
			//�����ͳ�Ƴ��б���ʽ
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
	 * �������֯���б����ʽ
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
	 * ��ӡ�Ϸ��Ľ��
	 */
	private void showAnswer() {
		System.out.println("���ǣ�");
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
	 * �ж��Ƿ��ܷ��ûʺ�
	 * @param row
	 * @return
	 */
	private boolean isOk(int row) {
		//�����ж�ǰ��������뵱ǰ�з��õĻʺ��Ƿ��ͻ
		for(int j = 0;j!=row;j++){
			//��ͬһ�С��ڸ��Խ���(���ϵ�����)�������Խ���(���ϵ�����)�����ǳ�ͻ��
			if(queen[row]==queen[j] || row+queen[row] == j+queen[j]|| row-queen[row] == j-queen[j]){
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		�˻ʺ����ⷽ���� qu = new �˻ʺ����ⷽ����();
		qu.queen(0);//���м���
		System.out.println(qu.count);//��ӡ������
		System.out.println(qu.results);//���б����ʽ��ӡ����

	}

}
