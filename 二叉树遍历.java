package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 二叉树遍历 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	/**
	 * 前序遍历 递归
	 * @param root
	 */
	public static void preOrder1(TreeNode root){
		if(root!=null){
			System.out.println(root.val);
			preOrder1(root.left);
			preOrder1(root.right);
		}
	}
	
	/**
	 * 中序遍历 递归
	 * @param root
	 */
	public static void inOrder1(TreeNode root){
		if(root!=null){
			inOrder1(root.left);
			System.out.println(root.val);
			inOrder1(root.right);
		}
	}
	
	/**
	 * 后序遍历 递归
	 * @param root
	 */
	public static void postOrder1(TreeNode root){
		if(root!=null){
			postOrder2(root.left);
			postOrder2(root.right);
			System.out.println(root.val);
		}
	}
	
	/**
	 * 前序 非递归
	 * @param root
	 */
	public static void preOrder2(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode p = root;
		while(p!=null || !s.isEmpty()){
			
			while(p!=null){
				System.out.println(p.val);
				s.push(p);
				p = p.left;
			}
			
			if(!s.isEmpty()){
				p = s.pop();
				p = p.right;
			}
			
		}
	}
	
	/**
	 * 中序遍历 非递归
	 * @param root
	 */
	public static void inOrder2(TreeNode root){
		if(root==null) return;
		Stack<TreeNode> s = new Stack<>();
		TreeNode p = root;
		while(p!=null || !s.isEmpty()){
			while(p!=null){
				s.push(p);
				p = p.left;
			}
			
			if(!s.isEmpty()){
				p = s.pop();
				System.out.println(p.val);
				p = p.right;
			}
			
		}
	}
	
	/**
	 * 后序遍历 非递归
	 * @param root
	 */
	public static void postOrder2(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> s = new Stack<>();
		TreeNode cur = root;
		TreeNode pre = null;
		s.push(cur);
		while(!s.isEmpty()){
			 cur = s.peek();
			if(cur.left == null && cur.right==null ||
					(pre!=null && (cur.left == pre||cur.right == pre))){
				System.out.println(cur.val);
				s.pop();
				pre = cur;
			}else{
				if(cur.right!=null) s.push(cur.right);
				if(cur.left!=null) s.push(cur.left);
			}
		}
		
	}
	
	/**
	 * 二叉树层次遍历 非递归
	 * @param root
	 */
	public static void levelOrder(TreeNode root){
		if(root ==null) return;
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode p = root;
		q.offer(p);
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			System.out.println(node.val);
			if(node.left!=null) q.offer(node.left);
			if(node.right!=null) q.offer(node.right);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
