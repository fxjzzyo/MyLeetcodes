package leetcode;

public class 仅仅反转字母917 {

	 public static String reverseOnlyLetters(String S) {
	        if(S == null || S.length()==0) return S;
	        char[] cs = S.toCharArray();
	        int l =0,r = cs.length-1;
	        while(l<r){
	            if(isCase(cs[l]) && isCase(cs[r])){
	                swap(cs,l,r);
	                l++;
	                r--;
	            }else if(!isCase(cs[l])){
	                l++;
	            }else if(!isCase(cs[r])){
	                r--;
	            }
	        }
	        return String.valueOf(cs);
	    }
	    //判断是否是字母
	    public static boolean isCase(char c){
	        return (c>='a' && c<='z') || (c>='A' && c<='Z');
	    }
	    //交换两个元素
	    public static void swap(char[] cs,int l,int r){
	        char temp = cs[l];
	        cs[l] = cs[r];
	        cs[r] = temp;
	    }
	
	
	public static void main(String[] args) {
		String s = reverseOnlyLetters("ab-cd");
		System.out.println(s);

	}

}
