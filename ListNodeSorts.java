package leetcode;

public class ListNodeSorts {

	/**
	 * ����Ľڵ���
	 * @author fxjzzyo
	 *
	 */
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){this.val = val;}
	}
	
	/**
	 * ���������ڵ��ֵ
	 * @param i
	 * @param j
	 */
	public static void swap(ListNode i,ListNode j){
		int temp = i.val;
		i.val = j.val;
		j.val = temp;
	}
	
	/**
	 * ð������
	 * @param head
	 * @return
	 */
	public static ListNode bubbleSort(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode p = null;
		
		boolean isExchanged = true;
		while(isExchanged&&p!=head.next){
			
			ListNode q = head;
			isExchanged = false;
			for(;q.next!=null&&q.next!=p;q = q.next){
				if(q.val>q.next.val){
					int temp = q.val;
					q.val = q.next.val;
					q.next.val = temp;
					isExchanged = true;
				}
			}
			p = q;
		}
		return head;
	}
	
	/**
	 * ��������
	 * ���������㷨����ֱ�ӽ����ڵ㣬ʱ�临�Ӷ�O��n^2��,�ռ临�Ӷ�O��1����
	 * @param head
	 * @return
	 */
	public static ListNode insertSort(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode pStart = new ListNode(0);//��Ӹ�����ͷ�ڵ�
		pStart.next = head;
		ListNode p = head.next;
		ListNode pend = head;
		while(p!=null){
			ListNode temp = pStart.next;
			ListNode pre = pStart;
			while(temp!=p&&p.val>temp.val){
				temp = temp.next;
				pre = pre.next;
			}
			if(temp == p) pend = p;
			else{
				pend.next = p.next;
				p.next = temp;
				pre.next = p;
			}
			p = pend.next;
		}
		head = pStart.next;
		return head;
	}
	
	/**
	 * ѡ������
	 * ѡ�������㷨��ֻ�ǽ����ڵ��valֵ��ʱ�临�Ӷ�O��n^2��,�ռ临�Ӷ�O��1����
	 * @param head
	 * @return
	 */
	public static ListNode selectSort(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode pStart = new ListNode(0);//��Ӹ�����ͷ�ڵ�
		pStart.next = head;
		ListNode tailNode = pStart;//ָ�����ź����β���ڵ�
		
		while(tailNode.next!=null){
			ListNode minNode = tailNode.next;
			ListNode p = tailNode.next.next;
			//Ѱ��δ���򲿷ֵ���С�ڵ�
			while(p!=null){
				if(p.val<minNode.val){
					minNode = p;
				}
				p = p.next;
			}
			//����ֵ
			int temp = tailNode.next.val;
			tailNode.next.val = minNode.val;
			minNode.val = temp;
			
			tailNode = tailNode.next;
		}
		head = pStart.next;
		return head;
	}
	
	private static ListNode partation(ListNode head, ListNode tail) {
		int ppv = head.val;
		ListNode p = head;
		for(ListNode i = p.next;i!=tail;i = i.next){
			if(i.val<ppv){
				p = p.next;
				if(i!=p){
					swap(i,p);
				}
			}
		}
		swap(p,head);
		return p;
	}
	
	public static void quickSort(ListNode head,ListNode tail){
		if(head!=tail&&head.next!=tail){
			ListNode p = partation(head,tail);
			quickSort(head,p);
			quickSort(p.next,tail);
		}
	}

	/**
	 * ��������1
	 * ��������1���㷨ֻ�����ڵ��valֵ��ƽ��ʱ�临�Ӷ�O��nlogn��,�����ǵݹ�ջ�ռ�Ļ��ռ临�Ӷ���O��1����
	 * @param head
	 * @return
	 */
	public static ListNode quickSort(ListNode head){
		if(head == null || head.next == null) return head;
		quickSort(head,null);
		return head;
	}
	
	public static ListNode partation2(ListNode preNode,ListNode head,ListNode tail){
		int ppv = head.val;
		//����������ֱ��¼�Ȼ�׼С�Ľڵ� �� �Ȼ�׼��Ľڵ�
		ListNode small = new ListNode(0);
		ListNode big = new ListNode(0);
		ListNode s = small,b = big;
		
		for(ListNode i = head.next;i!=tail;i=i.next){
			if(i.val<ppv){
				s.next = i;
				s = s.next;
			}else{
				b.next = i;
				b = b.next;
			}
		}
		//��ǰ���ڵ㡢С������׼�ڵ㡢������β�� ��������
		b.next = tail;
		s.next = head;
		head.next = big.next;
		preNode.next = small.next;
		
		return head;
		
	}
	
	public static void quickSort2(ListNode preNode,ListNode head,ListNode tail){
		if(head!=tail && head.next!=tail ){
			ListNode p = partation2(preNode,head,tail);
			quickSort2(preNode,preNode.next,p);
			quickSort2(p,p.next,tail);
		}
	}
	
	/**
	 * ��������2
	 * ��������2���㷨��������ڵ㣬ƽ��ʱ�临�Ӷ�O��nlogn��,�����ǵݹ�ջ�ռ�Ļ��ռ临�Ӷ���O��1����
	 * @param node
	 * @return
	 */
	public static ListNode quickSort2(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode preNode = new ListNode(0);//��Ӹ�����ͷ�ڵ�
		preNode.next = head;
		quickSort2(preNode,head,null);
		return preNode.next;
	}
	
	/**
	 * �ϲ���������Ϊ��������
	 * @param l1
	 * @param l2
	 * @return
	 */
	private static ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode pNode = new ListNode(0);
		ListNode p = pNode;
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){
				p.next = l1;
				l1 = l1.next;
			}else{
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		
		if(l1!=null){
			p.next = l1;
		}
		if(l2!=null){
			p.next = l2;
		}
		return pNode.next;
	}
	
	/**
	 * �鲢����
	 * �鲢�����㷨��������ڵ㣬ʱ�临�Ӷ�O��nlogn��,�����ǵݹ�ջ�ռ�Ļ��ռ临�Ӷ���O��1����
	 * @param head
	 */
	public static ListNode mergeSort(ListNode head){
		if(head == null || head.next == null) return head;
		//������ָ�뷨��������ֳ�������
		ListNode slow = head,fast = head;
		while(fast.next!=null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow.next;//��벿��
		slow.next = null;//�Ͽ�
		//�ݹ鴦������������
		ListNode l1 = mergeSort(head);
		ListNode l2 = mergeSort(fast);
		//�ϲ�����������Ϊ��������
		return merge(l1,l2);
	}


	/**
	 * ��ӡ����
	 * @param head
	 */
	public static void printList(ListNode head){
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		//��������
		ListNode head = new ListNode(3);
		ListNode node1 = new ListNode(5);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(1);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		System.out.println("---------����ǰ-------");
		printList(head);
		
		//����
//		head = mergeSort(head);
//		head = bubbleSort(head);
//		head = insertSort(head);
//		head = selectSort(head);
//		head = quickSort(head);
		head = quickSort2(head);
		
		System.out.println("---------�����-------");
		printList(head);
	}

}
