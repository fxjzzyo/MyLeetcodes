package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针116 {
	
	public static class Node{
		int val;
		Node left;
		Node right;
		Node next;
	}
	
	public static Node connect(Node root) {
		if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                Node n = q.poll();
                
                if(n.left!=null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);
                if(i == size-1){
                    n.next = null;break;
                }
                if(!q.isEmpty()){
                    n.next = q.peek();
                }
            }
            
            
        }
        return root;  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
