package leetcode;


/**
 * һ��������ĸ A-Z ����Ϣͨ�����·�ʽ�����˱��룺

'A' -> 1
'B' -> 2
...
'Z' -> 26
����һ��ֻ�������ֵķǿ��ַ������������뷽����������

ʾ�� 1:

����: "12"
���: 2
����: �����Խ���Ϊ "AB"��1 2������ "L"��12����
ʾ�� 2:

����: "226"
���: 3
����: �����Խ���Ϊ "BZ" (2 26), "VF" (22 6), ���� "BBF" (2 2 6) ��
 * @author Administrator
 *
 */
public class ���뷽��91 {

	/**
	 * ��һ ��̬�滮
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
	 * ���� �ݹ�
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
