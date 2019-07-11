package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����

ʾ��:

����: ["eat", "tea", "tan", "ate", "nat", "bat"],
���:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
˵����

���������ΪСд��ĸ��
�����Ǵ������˳��
 * @author Administrator
 *
 */
public class ��ĸ��λ�ʷ���49 {

	 public static List<List<String>> groupAnagrams(String[] strs) {
	        List<List<String>> ress = new ArrayList<>();
	        if(strs == null||strs.length == 0) return ress;
	        
	        HashMap<String,List<String>> map = new HashMap<>();
	        for(String s:strs){
	            char[] cs = s.toCharArray();
	            Arrays.sort(cs);
	            String sortStr = String.valueOf(cs);
	            if(!map.containsKey(sortStr)){
	                map.put(sortStr,new ArrayList<String>());
	            }
	            map.get(sortStr).add(s);
	        }
	        ress.addAll(map.values());
	        return ress;
	        
	    }
	
	public static void main(String[] args) {
		String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> groupAnagrams = groupAnagrams(s);
		System.out.println(groupAnagrams);

	}

}
