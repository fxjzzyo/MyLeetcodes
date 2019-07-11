package leetcode;


/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * ����һ��������������ÿ����㶼���һ�� 0-9 �����֣�ÿ���Ӹ���Ҷ�ӽڵ��·��������һ�����֡�
 * 
 * ���磬�Ӹ���Ҷ�ӽڵ�·�� 1->2->3 �������� 123��
 * 
 * ����Ӹ���Ҷ�ӽڵ����ɵ���������֮�͡�
 * 
 * ˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣
 * 
 * ʾ�� 1:
 * 
 * ����: [1,2,3] 1 / \ 2 3 ���: 25 ����: �Ӹ���Ҷ�ӽڵ�·�� 1->2 �������� 12. �Ӹ���Ҷ�ӽڵ�·�� 1->3 ��������
 * 13. ��ˣ������ܺ� = 12 + 13 = 25. ʾ�� 2:
 * 
 * ����: [4,9,0,5,1] 4 / \ 9 0 / \ 5 1 ���: 1026 ����: �Ӹ���Ҷ�ӽڵ�·�� 4->9->5 �������� 495.
 * �Ӹ���Ҷ�ӽڵ�·�� 4->9->1 �������� 491. �Ӹ���Ҷ�ӽڵ�·�� 4->0 �������� 40. ��ˣ������ܺ� = 495 + 491 + 40
 * = 1026.
 * 
 * @author Administrator
 *
 */
public class �����Ҷ�ӽڵ�����֮��129 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static int sumNumbers(TreeNode root) {
		return helper(root, 0);
	}

	public static int helper(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return sum * 10 + root.val;
		}
		return helper(root.left, sum * 10 + root.val) + helper(root.right, sum * 10 + root.val);
	}

	public static void main(String[] args) {
		

	}

}
