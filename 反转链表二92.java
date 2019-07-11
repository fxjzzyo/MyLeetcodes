package leetcode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
 * @author Administrator
 *
 */
public class 反转链表二92 {
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	 public static ListNode reverseBetween(ListNode head, int m, int n) {
	        ListNode pre = null;
	        ListNode temp = head;
	        int flag = 0;
	        if(m == 1){
	            pre = new ListNode(0);
	            pre.next = head;
	            temp = pre;
	            flag = 1;
	        }
	        while(m>1 && head!=null){
	            pre = head;
	            head = head.next;
	            m--;
	            n--;
	        }
	        
	        while(n>1){
	            ListNode node = head.next;
	            head.next = node.next;
	            node.next = pre.next;
	            pre.next = node;
	            n--;
	        }
	        if(flag == 1) return temp.next;
	        return temp;
	        
	    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ListNode newHead = reverseBetween(head,2,4);
		
		while(newHead!=null){
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
		

	}

}
