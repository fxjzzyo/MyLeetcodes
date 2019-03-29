package leetcode;

/**
 * ����һ���ǿն����������������·���͡�

�����У�·��������Ϊһ������������ڵ�������ﵽ����ڵ�����С���·�����ٰ���һ���ڵ㣬�Ҳ�һ���������ڵ㡣

ʾ�� 1:

����: [1,2,3]

       1
      / \
     2   3

���: 6
ʾ�� 2:

����: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

���: 42
 */
import leetcode.����������.TreeNode;

public class �������е����·����124 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static int ret = Integer.MIN_VALUE;

	public static int maxPathSum(TreeNode root) {
		/**
		 * ��������һ���ڵ�, �������·�������ýڵ�, ��ôֻ�������������: 
		 * 1.�����������������ɵĺ�·��ֵ�ϴ���Ǹ����ϸýڵ��ֵ���򸸽ڵ���ݹ������·��
		 * 2.���������������·����,
		 * ���ϸýڵ��ֵ���������յ����·��
		 **/
		getMax(root);
		return ret;
	}

	private static int getMax(TreeNode r) {
		if (r == null)
			return 0;
		int left = Math.max(0, getMax(r.left)); // �������·����Ϊ����Ӧ����0��ʾ���·������������
		int right = Math.max(0, getMax(r.right));
		ret = Math.max(ret, r.val + left + right); // �ж��ڸýڵ��������������·�����Ƿ���ڵ�ǰ���·����
		return Math.max(left, right) + r.val;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		
		int result = maxPathSum(root);
		System.out.println(result);
		
	}

}
