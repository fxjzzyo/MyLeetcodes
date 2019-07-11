package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
 * @author Administrator
 *
 */
public class 字母异位词分组49 {

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
