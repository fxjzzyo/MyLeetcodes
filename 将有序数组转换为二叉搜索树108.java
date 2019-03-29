package leetcode;

import leetcode.二叉树遍历.TreeNode;


/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 * @author Administrator
 *
 */
public class 将有序数组转换为二叉搜索树108 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		TreeNode root = null;
		if(nums == null || nums.length<1) return root;
		int len  = nums.length;
		int l = 0,r = len-1;
		return generateHelp(nums, l, r);
	}
	
	public static TreeNode generateHelp(int[] nums,int l,int r){
		if(l>r){
			return null;
		}
		int mid = (l+r)/2;
		TreeNode root = new TreeNode(nums[mid]);
		
		root.left = generateHelp(nums, l, mid-1);
		root.right = generateHelp(nums, mid+1, r);
		
		return root;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
