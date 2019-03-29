package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * ����һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict�����ַ��������ӿո�������һ�����ӣ�ʹ�þ��������еĵ��ʶ��ڴʵ��С�����������Щ���ܵľ��ӡ�

˵����

�ָ�ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
����Լ����ֵ���û���ظ��ĵ��ʡ�
ʾ�� 1��

����:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
���:
[
  "cats and dog",
  "cat sand dog"
]
 * @author Administrator
 *
 */
public class ���ʲ��2 {

	private List<String> ans = new ArrayList<>();
    private Set<String> set = new HashSet<>();
    private int maxLen = 0;
    private boolean[] dp;
    private String ss;
    
	public  List<String> wordBreak(String s, List<String> wordDict) {
		ss = s;
        dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (String word : wordDict) {
            set.add(word);
            maxLen = Math.max(maxLen, word.length());
        }            
        
        for (int i = 0; i < s.length(); i++) {
            if (dp[i]) {
                for (int j = i + 1; j <= Math.min(i + maxLen, s.length()); j++) {
                    if (set.contains(s.substring(i, j)))
                        dp[j] = true;
                }                
            }
        }
        if (dp[dp.length - 1]) split(new StringBuilder(), 0);
        return ans;
    }
	
	public List<String> wordBreak2(String s, List<String> wordDict) {
        if(s == null||wordDict == null || s.length()<=0||wordDict.size()<=0) return ans;
        int len = s.length()+1;
        ss = s;
        dp = new boolean[len];
        dp[0] = false;
        for(String word:wordDict){
            set.add(word);
            maxLen = Math.max(maxLen,word.length());
        }
        dp[0] = true;//dp[i]��ʾ[0,i)���Բ��
        for(int i = 0;i<len;i++){
     	   for(int j = 0;j<i;j++){
     		   if(dp[j]&&wordDict.contains(s.substring(j,i))){
     			   dp[i] = true;
     			   break;
     		   }
     	   }
        }
        System.out.println(dp[len-1]);
        if(dp[len-1]) split(new StringBuilder(),0);
        return ans;
        
        
    }
	
	private void split(StringBuilder sb, int start) {
        if (start >= ss.length()) {
            ans.add(sb.substring(0, sb.length() - 1));
            return;
        }        
        if (dp[start]) {
            System.out.println(start);
            for (int i = start + 1; i <= Math.min(start + maxLen, ss.length()); i++) {
                String word = ss.substring(start, i);
                if (set.contains(word)) {
                    sb.append(word + " ");
                    split(sb, i);
                    sb.delete(sb.length() - 1 - word.length(), sb.length());
                }
            }
        }
    }
	
	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		���ʲ��2 d = new ���ʲ��2();
		d.wordBreak2(s, wordDict);
		for(String item :d.ans){
			System.out.println(item);
		}
		
		
	}

}
