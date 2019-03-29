package leetcode;

import leetcode.�������е����·����124.TreeNode;

/**
 * 
 * 
 * ����һ����������һ��Ŀ��ͣ��жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽڵ��·��������·�������нڵ�ֵ��ӵ���Ŀ��͡�
 * 
 * ˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * 
 * ʾ��: �������¶��������Լ�Ŀ��� sum = 22��
 * 
 * 5 / \ 4 8 / / \ 11 13 4 / \ \ 7 2 1 ���� true, ��Ϊ����Ŀ���Ϊ 22 �ĸ��ڵ㵽Ҷ�ӽڵ��·��
 * 5->4->11->2��
 * 
 * @author Administrator
 *
 */
public class ·���ܺ�112 {

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
