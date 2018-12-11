package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T14_FindKthToTail {
	//链表中倒数第 K 个结点
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public ListNode FindKthToTail(ListNode head, int k) {
		if(head == null) return null;
		
		ListNode node1 = head;
		ListNode node2 = head;
		
		while(node1 != null && k > 0) {//node1移动k次，还有n-k次会指空
			node1 = node1.next;
			k --;
		}
		
		if(k > 0) return null;
		
		while(node1 != null) {//移动n-k次，此时node2到n-k+1个节点，即倒数第k个节点
			node1 = node1.next;
			node2 = node2.next;
		}
		
		return node2;
	}
}
