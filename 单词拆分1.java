package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 *给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 * @author Administrator
 *
 */
public class 单词拆分1 {
    
	public boolean wordBreak(String s, List<String> wordDict) {
       if(s == null || wordDict == null||wordDict.size()<=0||s.length()<=0) return false;
       int len = s.length()+1;
       boolean[] dp = new boolean[len];
       dp[0] = true;//dp[i]表示[0,i)可以拆分
       for(int i = 0;i<len;i++){
    	   for(int j = 0;j<i;j++){
    		   if(dp[j]&&wordDict.contains(s.substring(j,i))){
    			   dp[i] = true;
    			   break;
    		   }
    	   }
       }
       
       
		return dp[len-1];
    }
	
	
	public static void main(String[] args) {
		String s = "catsanddog";
//		String s = "leetcode";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		单词拆分1 d = new 单词拆分1();
		System.out.println(d.wordBreak(s, wordDict));
		
		
	}

}
