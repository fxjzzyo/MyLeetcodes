package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * 题目描述：
 * 输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 
 * 
 * 解决方法：
 * 枚举所有情况。

对于每一个输入数字，对于已有的排列中每一个字符串，分别加入该数字所代表的每一个字符。

所有是三重for循环。

举例：

初始化排列{""}

1、输入2，代表"abc"

已有排列中只有字符串""，所以得到{"a","b","c"}

2、输入3，代表"def"

(1)对于排列中的首元素"a"，删除"a"，并分别加入'd','e','f'，得到{"b","c","ad","ae","af"}

(2)对于排列中的首元素"b"，删除"b"，并分别加入'd','e','f'，得到{"c","ad","ae","af","bd","be","bf"}

(2)对于排列中的首元素"c"，删除"c"，并分别加入'd','e','f'，得到{"ad","ae","af","bd","be","bf","cd","ce","cf"}

注意

（1）每次添加新字母时，应该先取出现有ress当前的size()，而不是每次都在循环中调用ress.size()，
因为ress.size()是不断增长的。
 
 * 
 * @author Administrator
 *
 */
public class 电话号码的字母组合17 {

	public static List<String> letterCombinations(String digits) {
		List<String> ress = new ArrayList<>();
		if(digits == null || digits.length()<1) return ress;
		ress.add("");
		HashMap<Integer,String> map = new HashMap<>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		for(int i = 0;i<digits.length();i++){
			int size = ress.size();
			for(int j  = 0;j<size;j++){
				String str = ress.remove(0);//取出并删除第一个串
				//与后面的拼接
				for(int k = 0;k<map.get(digits.charAt(i)-'0').length();k++){
					//每拼接出一个，就加入结果集
					ress.add(str+map.get(digits.charAt(i)-'0').charAt(k));
				}
			}
		}
		return ress;
	}

	public static void main(String[] args) {
		List<String> res = letterCombinations("23");
		for(String s:res){
			System.out.println(s);
		}
	}

}
