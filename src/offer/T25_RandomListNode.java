package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T25_RandomListNode {
	//复杂链表的复制
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
	public RandomListNode Clone(RandomListNode pHead) {
		if(pHead == null) return null;
		
		//step1：在每个节点的后面（或者说每个节点与下一个节点中间）插入【新节点】
		//该新节点为克隆节点，这么做是为了连接random节点
		RandomListNode tmp = pHead;
		while(tmp != null) {
			RandomListNode cloneNode = new RandomListNode(tmp.label);
			
			//插入clone节点
			cloneNode.next = tmp.next;
			tmp.next = cloneNode;
			//移到原链表的下一个节点
			tmp = cloneNode.next;
		}
		
		//step2：连接random节点
		tmp = pHead;
		while(tmp != null) {
			RandomListNode cloneNode = tmp.next;
			if(tmp.random != null) {
				cloneNode.random = tmp.random.next;//tmp.random是原链表的节点，tmp.random.next才是那个节点的clone节点
			}
			tmp = cloneNode.next;
		}
		
		//step3：拆分链表，1 3 5 7···为原链表，2 4 6 8···为clone链表
		tmp = pHead;
		RandomListNode cloneHead = tmp.next;
		while(tmp.next != null) {
			RandomListNode node = tmp.next;
			tmp.next = node.next;
			tmp = node;
		}
		
		return cloneHead;
    }
}
