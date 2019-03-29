package leetcode;

public class 相交链表160 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode node = null;
		// 统计长度
		ListNode a = headA, b = headB;
		int lena = 0, lenb = 0;
		while (a != null) {
			a = a.next;
			lena++;
		}
		while (b != null) {
			b = b.next;
			lenb++;
		}
		//再次指向头部
		a = headA;
		b = headB;
		//对齐
		if (lena > lenb) {
			int k = lena - lenb;
			while (k > 0) {
				a = a.next;
				k--;
			}

		} else {
			int k = lenb - lena;
			while (k > 0) {
				b = b.next;
				k--;
			}
		}
		//寻找交叉点
		while (a != null && b != null) {
			if (a == b) {
				node =  a;
				break;
			}
		}

		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
