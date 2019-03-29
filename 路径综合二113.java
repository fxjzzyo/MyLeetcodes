package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.路径总和112.TreeNode;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
 * @author Administrator
 *
 */
public class 路径综合二113 {
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
		// 访问左子树
		pathSumHelp(root.left, sum - root.val);

		// 访问右子树
		pathSumHelp(root.right, sum - root.val);
		
		//删除访问过的节点
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
