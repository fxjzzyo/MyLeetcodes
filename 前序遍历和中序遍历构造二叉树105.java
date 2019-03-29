package leetcode;

import leetcode.�Գƶ�����.TreeNode;

public class ǰ�����������������������105 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return builderHelp(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
	}

	public static TreeNode builderHelp(int[] inorder, int is, int ie, int[] preorder, int ps, int pe) {
		if (is > ie)
			return null;
		// �������ڵ�
		int rootVal = preorder[ps];
		TreeNode root = new TreeNode(rootVal);

		// �ҳ����ڵ������������λ��
		int im = is;
		while (im < ie && inorder[im] != rootVal) {
			im++;
		}

		root.left = builderHelp(inorder, is, im - 1, preorder, ps+1, ps+1 + (im - 1 - is));
		root.right = builderHelp(inorder, im + 1, ie, preorder, ps + 1 + im - is, pe);
		return root;
	}

	
	
	
	
	
	
	
	public static TreeNode buildHelp(int[] inorder,int is,int ie,int[] preorder,int ps,int pe){
		if(ps>pe) return null;
		int rootVal = preorder[ps];
		TreeNode root = new TreeNode(rootVal);
		
		//�ҵ����ڵ��������е�λ��
		int rootIndex = is;
		while(rootIndex<ie&&inorder[rootIndex]!=rootVal) rootIndex++;
		
		//������������
		root.left = builderHelp(inorder, is, rootIndex-1, preorder, ps+1, ps+1+rootIndex-1-is);
		root.right = builderHelp(inorder, rootIndex+1, ie, preorder, ps+1+rootIndex-is, pe);
		return root;
	}
	
	public static TreeNode buildBinaryTree(int[] preorder,int[] inorder){
		int len = preorder.length;
		
		return buildHelp(preorder,0,len-1,inorder,0,len-1);
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
