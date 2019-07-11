package leetcode;


/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * @author Administrator
 *
 */
public class 解码方法91 {

	/**
	 * 法一 动态规划
	 * @param s
	 * @return
	 */
	public static int numDecodings(String s) {
        int len = s.length();
        if(len == 0 || len==1 && s.charAt(0) == '0') return 0;
        if(len == 1) return 1;
        int[] dp = new int[len+1];
        dp[0] = 1;
        for(int i = 0;i<len;i++){
            dp[i+1] = s.charAt(i) == '0'?0:dp[i];
            if(i>0 && (s.charAt(i-1) == '1'||s.charAt(i-1) == '2' && s.charAt(i)<='6')){
                dp[i+1] += dp[i-1];
            }
        }
        return dp[len];
    }
	
	/**
	 * 法二 递归
	 * @param s
	 * @return
	 */
	public static int numDecodings2(String s) {
        int len = s.length();
        if(len == 0 || len==1 && s.charAt(0) == '0') return 0;
        if(len == 1) return 1;
        
        int num = dfs(s,0,0);
        
        return num;
    }
	
	private static int dfs(String s, int i,int num) {
		if(i == s.length()){
			num++;
			return num;
		}
		if(s.charAt(i) == '0') return num;
		num = dfs(s,i+1,num);
		if(i<=s.length()-2 && judge(s.charAt(i),s.charAt(i+1))){
			num = dfs(s,i+2,num);
		}
		return num;
		
	}

	 private static boolean judge(char a,char b){
	        int num = (a-'0')*10+(b-'0');
	        if(num>=1&&num<=26)
	            return true;
	        return false;
	    }
	public static void main(String[] args) {
		int numDecodings = numDecodings2("226");
		System.out.println(numDecodings);

	}

}
