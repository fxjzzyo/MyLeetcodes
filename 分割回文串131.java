package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]

思路：又是回溯法啊啊啊
 * @author Administrator
 *
 */
public class 分割回文串131 {

	 static List<List<String>> resu = new ArrayList<>();
	 static List<String> temp = new ArrayList<>();
    public static List<List<String>> partition(String s) {
       
        if(s == null || s.length() == 0) return resu;
        int len = s.length();
        
        generate(s);
        return resu;
    }
    
    public static void generate(String s){
        if(s.length() == 0){
            resu.add(new ArrayList<>(temp));
        }else{
            for(int i=1;i<=s.length();i++){
                String ss = s.substring(0,i);
                if(isHuiwen(ss)){
                    temp.add(ss);
                    generate(s.substring(i));
                    temp.remove(temp.size()-1);
                }
            } 
        }
       
       
    }
    
    public static boolean isHuiwen(String s){
        int len = s.length();
        int l = 0;
        int r = len-1;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
	
	public static void main(String[] args) {
		String s = "aab";
		List<List<String>> partition = partition(s);
		System.out.println(partition);

	}

}
