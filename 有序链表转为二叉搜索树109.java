package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 有序链表转为二叉搜索树109 {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static ListNode findMidNode(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next!=null&&fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	
	public static TreeNode sortedListToBST(ListNode head) {
		if(head == null) return null;
		
		ListNode p = head;
		List<ListNode> ls = new ArrayList<>();
		while(p!=null){
			ls.add(p);
			p = p.next;
		}
		
		return buildTree(ls,0,ls.size()-1);
	}
	
	public static TreeNode buildTree(List<ListNode> ls,int l,int r){
		if(l>r){
			return null;
		}
		//找出中间节点
		int mid = (l+r)/2;
		TreeNode root = new TreeNode(ls.get(mid).val);
		root.left = buildTree(ls,l,mid-1);
		root.right = buildTree(ls,mid+1,r);
		return root;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
