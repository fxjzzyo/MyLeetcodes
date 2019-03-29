package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

说明：

分隔时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
输出:
[
  "cats and dog",
  "cat sand dog"
]
 * @author Administrator
 *
 */
public class 单词拆分2 {

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
        dp[0] = true;//dp[i]表示[0,i)可以拆分
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
		
		单词拆分2 d = new 单词拆分2();
		d.wordBreak2(s, wordDict);
		for(String item :d.ans){
			System.out.println(item);
		}
		
		
	}

}
