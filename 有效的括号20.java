package leetcode;

import java.util.Stack;

public class 有效的括号20 {
	
	/**
	 * 方法一
	 * @param s
	 * @return
	 */
	 public static boolean isValid(String s) {
	        if(s == null || s.length()<1) return true;
	        int len = s.length();
	        Stack<Character> st = new Stack<>();
	        for(int i = 0;i<len;i++){
	            char c = s.charAt(i);
	            if(c == '('||c=='['||c == '{'){
	                st.push(c);
	            }else if(st.isEmpty() && (c == ')'||c==']'||c=='}')){
	                return false;
	            }else if(c == ')'){
	                char t = st.pop();
	                if(t != '('){
	                    return false;
	                }
	            }else if(c == ']'){
	                char t = st.pop();
	                if(t != '['){
	                    return false;
	                }
	            }else if(c == '}'){
	                char t = st.pop();
	                if(t != '{'){
	                    return false;
	                }
	            }
	        }
	        
	        if(st.isEmpty()) return true;
	        else return false;
	        
	    }
	 
	 public static boolean isValid2(String str){
		 Stack<Character> st = new Stack<>();
		 char[] chars = str.toCharArray();
		 for(char c:chars){
			 if(st.size() == 0){
				 st.push(c);
			 }else if(isSym(st.peek(),c)){
				 st.pop();
			 }else{
				 st.push(c);
			 }
		 }
		 return st.size() == 0;
	 }
	 
	private static boolean isSym(Character peek, char c) {
		return peek == '(' && c == ')' || peek == '[' && c == ']' || peek == '{' && c == '}';
	}

	public static void main(String[] args) {
		boolean res = isValid("()");
//		boolean res = isValid2("()");
		System.out.println(res);
	}

}
