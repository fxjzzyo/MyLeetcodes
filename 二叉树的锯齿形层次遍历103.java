package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class 二叉树的锯齿形层次遍历103 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		boolean flag = true;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()){
			int size = q.size();
			
			if(flag){
				List<Integer> temp = new ArrayList<>();
				for(int i = 0;i<size;i++){
					TreeNode no = q.poll();
					
					temp.add(no.val);
					if(no.left!=null) q.offer(no.left);
					if(no.right!=null) q.offer(no.right);
				}
				flag = !flag;
				result.add(temp);
			}else{
				List<Integer> temp = new ArrayList<>();
				for(int i = size-1;i>=0;i--){
					TreeNode no = q.poll();
					
					temp.add(no.val);
					if(no.left!=null) q.offer(no.left);
					if(no.right!=null) q.offer(no.right);
				}
				flag = !flag;
				result.add(temp);
			}
			
			
		}
		
		return result;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
