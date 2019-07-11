package leetcode;

import leetcode.�������ľ���β�α���103.TreeNode;

/**
 * ����һ�����������ж����Ƿ���һ����Ч�Ķ�����������
 * 
 * ����һ��������������������������
 * 
 * �ڵ��������ֻ����С�ڵ�ǰ�ڵ������ �ڵ��������ֻ�������ڵ�ǰ�ڵ������ �������������������������Ҳ�Ƕ����������� ʾ�� 1:
 * 
 * ����: 2 / \ 1 3 ���: true ʾ�� 2:
 * 
 * ����: 5 / \ 1 4 / \ 3 6 ���: false ����: ����Ϊ: [5,1,4,null,null,3,6]�� ���ڵ��ֵΪ 5
 * �����������ӽڵ�ֵΪ 4 ��
 * 
 * ˼·����������������������Ǵ�С��������С�
 * ���������¼ǰһ��ֵ���������ǰһ��ֵ���ڵ��ڵ�ǰֵ���������˵�����Ƕ���������
 * @author Administrator
 *
 */
public class ��֤����������98 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//��¼ǰһ��ֵ
	private static double pre = -Double.MAX_VALUE;
	
	//��¼�ǲ���
	private static boolean flag = true;

	public boolean isValidBST(TreeNode root) {
		inOrder(root);
		return flag;
	}

	/**
	 * �������
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
