package leetcode;

import leetcode.二叉树遍历.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为链表。

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 * @author Administrator
 *
 */
public class 二叉树展开为链表114 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode p = root;
        while(p.right!=null){
            p = p.right;
        }
        p.right = temp;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
