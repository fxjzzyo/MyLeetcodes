package leetcode;

import java.util.Stack;

public class ¶Ô³Æ¶þ²æÊ÷ {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSym(root.left, root.right);
	}

	public static boolean isSym(TreeNode r1, TreeNode r2) {
		if (r1 == null && r2 == null)
			return true;
		if (r1 == null || r2 == null)
			return false;
		return r1.val == r2.val && isSym(r1.left, r2.right) && isSym(r1.right, r2.left);
	}

	public static boolean isSymmetric2(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root.left);
		s.push(root.right);
		while(!s.isEmpty()){
			
			TreeNode p = s.pop();
			TreeNode q = s.pop();
			
			if(p == null && q == null) continue;
			if(p == null || q == null) return false;
			if(p.val!=q.val) return false;
			s.push(p.left);
			s.push(q.right);
			s.push(p.right);
			s.push(q.left);
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		root.left = left;
		root.right = right;

		TreeNode left2 = new TreeNode(3);
		TreeNode right2 = new TreeNode(4);
		left.left = left2;
		left.right = right2;

		TreeNode left3 = new TreeNode(4);
		TreeNode right3 = new TreeNode(3);

		right.left = left3;
		right.right = right3;

//		boolean isSym = isSymmetric(root);
		boolean isSym = isSymmetric2(root);
		System.out.println(isSym);

	}

}
