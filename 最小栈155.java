package leetcode;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
 * @author Administrator
 *
 */
public class 最小栈155 {
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
	 * 需要注意的是上面的Java解法中的pop()中，为什么不能用注释掉那两行的写法，
	 * 我之前也不太明白为啥不能对两个stack同时调用peek()函数来比较，如果是这种写法，
	 * 那么不管s1和s2对栈顶元素是否相等，永远返回false。这是为什么呢，这我们就要到Java的对于peek的定义了，
	 * 对于peek()函数的返回值并不是int类型，而是一个Object类型，这是一个基本的对象类型，
	 * 如果我们直接用==来比较的话，那么肯定不会返回true，因为是两个不同的对象，
	 * 所以我们一定要先将一个转为int型，然后再和另一个进行比较，这样才能得到我们想要的答案，
	 * 这也是Java和C++的一个重要的不同点吧。
	 * 
	 * https://www.cnblogs.com/grandyang/p/4091064.html
	 * 
	 */
	
	
	
	
	
	public static void main(String[] args) {
		

	}

}
