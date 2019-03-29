package leetcode;

import leetcode.二叉树中的最大路径和124.TreeNode;

/**
 * 
 * 
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例: 给定如下二叉树，以及目标和 sum = 22，
 * 
 * 5 / \ 4 8 / / \ 11 13 4 / \ \ 7 2 1 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径
 * 5->4->11->2。
 * 
 * @author Administrator
 *
 */
public class 路径总和112 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	
	
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.left == null && root.right == null){
			return sum-root.val == 0;
		}
		
		return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		
		boolean result = hasPathSum(root,4);
		System.out.println(result);

	}

}
