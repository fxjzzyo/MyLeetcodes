package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���ַ��� s���� s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����ǻ��Ĵ���

���� s ���п��ܵķָ����

ʾ��:

����: "aab"
���:
[
  ["aa","b"],
  ["a","a","b"]
]

˼·�����ǻ��ݷ�������
 * @author Administrator
 *
 */
public class �ָ���Ĵ�131 {

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
