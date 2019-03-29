package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� n �����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
 * 
 * ���磬���� n = 3�����ɽ��Ϊ��
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * @author Administrator
 *
 */
public class ��������22 {

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		return generateHelp(res,"",0,0,n);
	}

	/**
	 * 
	 * @param res ������
	 * @param string �м����ɵ�һ���Ϸ��Ĵ�
	 * @param i �����ŵĸ���
	 * @param j �����ŵĸ���
	 * @param n ���ŶԶ���
	 * @return
	 */
	private static List<String> generateHelp(List<String> res, String string, int i, int j, int n) {
		if(i>n||j>n) return res;
		if(i == n && j == n) res.add(string);
		if(i>=j){
			//��һ�εĽ��
			String str2 = new String(string);
			generateHelp(res, str2+"(", i+1, j, n);
			generateHelp(res, str2+")", i, j+1, n);
		}
		
		return res;
	}

	public static void main(String[] args) {
		List<String> res = generateParenthesis(10);
		for(String s : res){
			System.out.println(s);
		}
	}

}
