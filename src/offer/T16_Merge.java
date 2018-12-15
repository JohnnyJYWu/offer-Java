package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T16_Merge {
	//合并两个排序的链表
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode head = new ListNode(-9999);
		ListNode tmp = head;
		
		while(list1 != null && list2 != null) {
			if(list1.val < list2.val) {//比较两个链表当前结点的值，小的先插入新链表
				tmp.next = list1;
				list1 = list1.next;
			} else {
				tmp.next = list2;
				list2 = list2.next;
			}
			tmp = tmp.next;
		}
		
		//容错，将剩余链表补到新链表结尾，此时能保持单调不减
		if(list1 != null) tmp.next = list1;
		if(list2 != null) tmp.next = list2;
		
		return head.next;//记得head为声明的无意义表头，head.next才是新链表的头
    }
}
