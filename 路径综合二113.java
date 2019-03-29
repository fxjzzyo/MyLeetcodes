package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.·���ܺ�112.TreeNode;

/**
 * ����һ����������һ��Ŀ��ͣ��ҵ����дӸ��ڵ㵽Ҷ�ӽڵ�·���ܺ͵��ڸ���Ŀ��͵�·����

˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

ʾ��:
�������¶��������Լ�Ŀ��� sum = 22��

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
����:

[
   [5,4,11,2],
   [5,8,4,5]
]
 * @author Administrator
 *
 */
public class ·���ۺ϶�113 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<List<Integer>> result = new ArrayList<>();
	public static List<Integer> temp = new ArrayList<>();

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null)
			return result;
		pathSumHelp(root, sum);
		return result;
	}
	private static void pathSumHelp(TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		temp.add(root.val);

		if (root.left == null && root.right == null) {
			if (sum == root.val) {
				result.add(new ArrayList<>(temp));
			}
		}
		// ����������
		pathSumHelp(root.left, sum - root.val);

		// ����������
		pathSumHelp(root.right, sum - root.val);
		
		//ɾ�����ʹ��Ľڵ�
		temp.remove(temp.size() - 1);

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		
		List<List<Integer>> result = pathSum(root,4);
		/*for(List<Integer> res:result){
			for(Integer i : res){
				System.out.print(i+" ");
			}
			System.out.println();
		}*/
		System.out.println(result);
	}

}
