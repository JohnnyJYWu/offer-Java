package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T36_FindFirstCommonNode {
	//两个链表的第一个公共结点
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode node1 = pHead1;
		ListNode node2 = pHead2;
		
		while(node1 != node2) {//公共节点后面即为公共链表
			if(node1 == null) {
				node1 = pHead2;
			} else {
				node1 = node1.next;
			}
			
			if(node2 == null) {
				node2 = pHead1;
			} else {
				node2 = node2.next;
			}
		}
		
		return node1;
    }
}
