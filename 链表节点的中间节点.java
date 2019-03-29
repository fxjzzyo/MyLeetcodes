package leetcode;


public class 链表节点的中间节点 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public static ListNode middleNode(ListNode head) {
        if(head == null) return null;
       
        ListNode fast  = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast.next == null){
            return slow;
        }else{
            return slow.next;
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
