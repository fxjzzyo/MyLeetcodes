package leetcode;

import leetcode.二叉树的锯齿形层次遍历103.TreeNode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 节点的左子树只包含小于当前节点的数。 节点的右子树只包含大于当前节点的数。 所有左子树和右子树自身必须也是二叉搜索树。 示例 1:
 * 
 * 输入: 2 / \ 1 3 输出: true 示例 2:
 * 
 * 输入: 5 / \ 1 4 / \ 3 6 输出: false 解释: 输入为: [5,1,4,null,null,3,6]。 根节点的值为 5
 * ，但是其右子节点值为 4 。
 * 
 * 思路：二叉搜索树的中序遍历是从小到大的序列。
 * 中序遍历记录前一个值，如果出现前一个值大于等于当前值的情况，就说明不是二叉搜索树
 * @author Administrator
 *
 */
public class 验证二叉搜索树98 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//记录前一个值
	private static double pre = -Double.MAX_VALUE;
	
	//记录是不是
	private static boolean flag = true;

	public boolean isValidBST(TreeNode root) {
		inOrder(root);
		return flag;
	}

	/**
	 * 中序遍历
	 * @param root
	 */
	public static void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			double now = root.val;
			if (pre >= now) {
				flag = false;
				return;
			}
			pre = now;
			inOrder(root.right);
		}
	}

	public static void main(String[] args) {

	}

}
