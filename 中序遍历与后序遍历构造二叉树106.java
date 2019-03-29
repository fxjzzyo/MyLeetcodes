package leetcode;

import leetcode.对称二叉树.TreeNode;

public class 中序遍历与后序遍历构造二叉树106 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return builderHelp(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
	}
	
	
	public static TreeNode builderHelp(int[] inorder,int is,int ie,int[] postorder,int ps,int pe){
		if(is>ie) return null;
		//构建根节点
		int rootVal = postorder[pe];
		TreeNode root = new TreeNode(rootVal);
		
		//找出根节点在中序遍历的位置
		int im = is;
		while(im<ie && inorder[im]!= rootVal){
			im++;
		}
		
		root.left = builderHelp(inorder,is,im-1,postorder,ps,ps+(im-1-is));
		root.right = builderHelp(inorder, im+1, ie, postorder, ps+im-is, pe-1);
		return root;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public static TreeNode buildHelp(int[] inorder,int is,int ie,int[] postorder,int ps,int pe){
		if(is>ie) return null;
		int rootVal = postorder[pe];
		TreeNode root = new TreeNode(rootVal);
		//找到根节点在中序中对应的位置
		int index = is;
		while(index<ie&&inorder[index]!=rootVal) index++;
		//构建左右子树
		root.left = buildHelp(inorder, is, index-1, postorder, ps, ps+index-1-is);
		root.right = buildHelp(inorder, index+1, ie, postorder, ps+index-is, pe-1);
		return root;
	}
	
	public static TreeNode buildBinaryTree(int[] inorder,int[] postorder){
		int len = inorder.length;
		return buildHelp(inorder,0,len-1,postorder,0,len-1);
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
