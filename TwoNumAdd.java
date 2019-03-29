package leetcode;

public class TwoNumAdd {
	 public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//�ȿ����������������һ������Ϊ��
        if(l1==null) return l2;
        if(l2 == null) return l1;
        //��¼����
        int num1=0,num2=0;
        //����ָ��
        ListNode p = l1,q = l2;
        //������1ת��Ϊ����
        int i = 0;
        while(p!=null){
        	num1+=(int)Math.pow(10, i)*p.val;
            i++;
            p = p.next;
        }
        //������2ת��Ϊ����
        int j = 0;
        while(q!=null){
        	num2+=(int)Math.pow(10, j)*q.val;
            j++;
            q = q.next;
        }
        //�������
        int sum = num1+num2;
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(sum);
        System.out.println("-----------");
        
        //���ֱ�����
        int k = sum%10;
        ListNode root = new ListNode(k);
        ListNode p1 = root;
        sum = sum/10;
        while(sum!=0){
            int num = sum%10;
            ListNode node = new ListNode(num);
            p1.next = node;
            p1 = p1.next;
            sum = sum/10;
        }
        return root;
        
    }
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode item1 = new ListNode(4);
		ListNode item2 = new ListNode(3);
		
		l1.next = item1;
		item1.next = item2;
		
		ListNode l2 = new ListNode(5);
		ListNode item3 = new ListNode(6);
		ListNode item4 = new ListNode(4);
		
		l2.next = item3;
		item3.next = item4;
		
		ListNode result = addTwoNumbers(l1,l2);
		ListNode p = result;
		while(p!=null){
			System.out.println(p.val);
			p = p.next;
		}

	}

}
