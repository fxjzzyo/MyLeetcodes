package leetcode;

import java.util.Stack;

/**
 * ���һ��֧�� push��pop��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��

push(x) -- ��Ԫ�� x ����ջ�С�
pop() -- ɾ��ջ����Ԫ�ء�
top() -- ��ȡջ��Ԫ�ء�
getMin() -- ����ջ�е���СԪ�ء�
 * @author Administrator
 *
 */
public class ��Сջ155 {
	class MinStack {

	    public Stack<Integer> s1 = new Stack<>();
	    public Stack<Integer> s2 = new Stack<>();
	    
	    /** initialize your data structure here. */
	    public MinStack() {
	        
	    }
	    
	    public void push(int x) {
	        s1.push(x);
	        if(s2.empty() || s2.peek()>=x){
	            s2.push(x);
	        }
	    }
	    
	    public void pop() {
	    	// Cannot write like the following:
	        // if (s2.peek() == s1.peek()) s2.pop();
	        // s1.pop();
	        
	        int x = s1.pop();
	        if(x == s2.peek()){
	            s2.pop();
	        }
	    }
	    
	    public int top() {
	        return s1.peek();
	    }
	    
	    public int getMin() {
	        return s2.peek();
	    }
	}

	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
	
	/**
	 * ��Ҫע����������Java�ⷨ�е�pop()�У�Ϊʲô������ע�͵������е�д����
	 * ��֮ǰҲ��̫����Ϊɶ���ܶ�����stackͬʱ����peek()�������Ƚϣ����������д����
	 * ��ô����s1��s2��ջ��Ԫ���Ƿ���ȣ���Զ����false������Ϊʲô�أ������Ǿ�Ҫ��Java�Ķ���peek�Ķ����ˣ�
	 * ����peek()�����ķ���ֵ������int���ͣ�����һ��Object���ͣ�����һ�������Ķ������ͣ�
	 * �������ֱ����==���ȽϵĻ�����ô�϶����᷵��true����Ϊ��������ͬ�Ķ���
	 * ��������һ��Ҫ�Ƚ�һ��תΪint�ͣ�Ȼ���ٺ���һ�����бȽϣ��������ܵõ�������Ҫ�Ĵ𰸣�
	 * ��Ҳ��Java��C++��һ����Ҫ�Ĳ�ͬ��ɡ�
	 * 
	 * https://www.cnblogs.com/grandyang/p/4091064.html
	 * 
	 */
	
	
	
	
	
	public static void main(String[] args) {
		

	}

}
