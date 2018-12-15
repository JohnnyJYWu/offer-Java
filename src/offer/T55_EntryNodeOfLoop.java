package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JohnnyJYWu
 * 
 */

public class T55_EntryNodeOfLoop {
	//链表中环的入口结点
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	//判断是否有环，两个指针，一个一次一步，一个一次两步，相遇则有环
	//如果链表存在环，在相遇时，让一个指针在相遇点出发，另一个指针在链表首部出发
	//然后两个指针同步每次走一步，当它们相遇时，就是环的入口处。
    public ListNode EntryNodeOfLoop(ListNode pHead) {
    	if(pHead == null || pHead.next == null) return null;
    	
    	ListNode node1 = pHead;
    	ListNode node2 = pHead;
    	
    	while(node1 != null && node2 != null) {
    		node1 = node1.next;
    		node2 = node2.next.next;
    		
    		if(node1 == node2) break;
    	}
    	
    	if(node1 != null && node2 != null) {
        	node1 = pHead;
        	while(node1 != node2) {
            	node1 = node1.next;
            	node2 = node2.next;
        	}
        	return node1;
    	}
    	
    	return null;
    }
    
    //哈希表，重复的第一个结点即为环入口
    public ListNode EntryNodeOfLoop_1(ListNode pHead) {
    	if(pHead == null || pHead.next == null) return null;
    	
    	ListNode node = pHead;
    	Set<ListNode> set = new HashSet<>();
    	
    	while(node != null) {
    		if(set.contains(node)) {
    			return node;
    		} else {
    			set.add(node);
    			node = node.next;
    		}
    	}
    	
    	return null;
    }
}
