package leetcode;

import leetcode.����������.TreeNode;

/**
 * ����һ����������ԭ�ؽ���չ��Ϊ����

���磬����������

    1
   / \
  2   5
 / \   \
3   4   6
����չ��Ϊ��

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
public class ������չ��Ϊ����114 {

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
