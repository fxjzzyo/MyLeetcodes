package leetcode;

public class 验证回文串125 {

	public static boolean isPalindrome(String s) {
		if (s == null || s.length() < 1)
			return true;
		int len = s.length();
		int l = 0, r = len - 1;
		while (l < r) {
			char la = s.charAt(l);
			char ra = s.charAt(r);
			while(!isValid(la)){
				l++;
				la = s.charAt(l);
			}
			while(!isValid(ra)){
				r--;
				ra = s.charAt(r);
			}
			String ls = new String(s.charAt(l)+"");
			String rs = new String(s.charAt(r)+"");
			if (!ls.equalsIgnoreCase(rs)) {
				return false;
			}
			l++;
			r--;
		}
		return true;

	}
	
	/**
	 * 判断这个字符是否是数字或字母
	 * @param c
	 * @return
	 */
	public static boolean isValid(char c){
		return c>='a'&&c<='z'||c>='A'&&c<='Z'||c>='0'&&c<='9';
	}

	public static void main(String[] args) {
		boolean result = isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(result);
		
//		String ls = new String('A'+"");
//		int a = 'a';//97
//		int z = 'z';//122
//		int A = 'A';//65
//		int Z = 'Z';//90
//		int ling = '0';//48
//		int jiu = '9';//57
//		System.out.println(z);
//		System.out.println(z);

	}

}
