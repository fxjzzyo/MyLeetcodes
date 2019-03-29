package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 *����һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict���ж� s �Ƿ���Ա��ո���Ϊһ���������ֵ��г��ֵĵ��ʡ�

˵����

���ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
����Լ����ֵ���û���ظ��ĵ��ʡ�
ʾ�� 1��

����: s = "leetcode", wordDict = ["leet", "code"]
���: true
����: ���� true ��Ϊ "leetcode" ���Ա���ֳ� "leet code"��
ʾ�� 2��

����: s = "applepenapple", wordDict = ["apple", "pen"]
���: true
����: ���� true ��Ϊ "applepenapple" ���Ա���ֳ� "apple pen apple"��
     ע��������ظ�ʹ���ֵ��еĵ��ʡ�
ʾ�� 3��

����: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
���: false
 * @author Administrator
 *
 */
public class ���ʲ��1 {
    
	public boolean wordBreak(String s, List<String> wordDict) {
       if(s == null || wordDict == null||wordDict.size()<=0||s.length()<=0) return false;
       int len = s.length()+1;
       boolean[] dp = new boolean[len];
       dp[0] = true;//dp[i]��ʾ[0,i)���Բ��
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
		
		���ʲ��1 d = new ���ʲ��1();
		System.out.println(d.wordBreak(s, wordDict));
		
		
	}

}
