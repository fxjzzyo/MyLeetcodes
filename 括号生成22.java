package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * @author Administrator
 *
 */
public class 括号生成22 {

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		return generateHelp(res,"",0,0,n);
	}

	/**
	 * 
	 * @param res 保存结果
	 * @param string 中间生成的一个合法的串
	 * @param i 左括号的个数
	 * @param j 右括号的个数
	 * @param n 括号对儿数
	 * @return
	 */
	private static List<String> generateHelp(List<String> res, String string, int i, int j, int n) {
		if(i>n||j>n) return res;
		if(i == n && j == n) res.add(string);
		if(i>=j){
			//上一次的结果
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
