package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * ��Ŀ������
 * ���룺"23"
�����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 
 * 
 * ���������
 * ö�����������

����ÿһ���������֣��������е�������ÿһ���ַ������ֱ����������������ÿһ���ַ���

����������forѭ����

������

��ʼ������{""}

1������2������"abc"

����������ֻ���ַ���""�����Եõ�{"a","b","c"}

2������3������"def"

(1)���������е���Ԫ��"a"��ɾ��"a"�����ֱ����'d','e','f'���õ�{"b","c","ad","ae","af"}

(2)���������е���Ԫ��"b"��ɾ��"b"�����ֱ����'d','e','f'���õ�{"c","ad","ae","af","bd","be","bf"}

(2)���������е���Ԫ��"c"��ɾ��"c"�����ֱ����'d','e','f'���õ�{"ad","ae","af","bd","be","bf","cd","ce","cf"}

ע��

��1��ÿ���������ĸʱ��Ӧ����ȡ������ress��ǰ��size()��������ÿ�ζ���ѭ���е���ress.size()��
��Ϊress.size()�ǲ��������ġ�
 
 * 
 * @author Administrator
 *
 */
public class �绰�������ĸ���17 {

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
				String str = ress.remove(0);//ȡ����ɾ����һ����
				//������ƴ��
				for(int k = 0;k<map.get(digits.charAt(i)-'0').length();k++){
					//ÿƴ�ӳ�һ�����ͼ�������
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
