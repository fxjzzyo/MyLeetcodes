package leetcode;

import leetcode.����������.TreeNode;


/**
 * ��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������

�����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1��

ʾ��:

������������: [-10,-3,0,5,9],

һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������

      0
     / \
   -3   9
   /   /
 -10  5
 * @author Administrator
 *
 */
public class ����������ת��Ϊ����������108 {
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
