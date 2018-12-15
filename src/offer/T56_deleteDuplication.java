package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T56_deleteDuplication {
	//删除链表中重复的结点
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
    public ListNode deleteDuplication(ListNode pHead) {
    	if(pHead == null) return null;
    	
    	ListNode preNode = null;
    	ListNode node = pHead;
    	
    	while(node != null) {
    		if(node.next != null && node.val == node.next.val) {
    			int val = node.val;
    			while(node.next != null && node.next.val == val) {
    				node = node.next;
    			}
    			
    			if(preNode == null) {
    				//能执行到此步说明此时头结点重复了
    				//改变pHead使其指向第一个不重复的结点
    				pHead = node.next;
    			} else {
    				//改指针，去掉中间重复的链
    				preNode.next = node.next;
    			}
    		} else {
    			preNode = node;
    		}
    		node = node.next;
    	}
    	
    	return pHead;
    }
}
