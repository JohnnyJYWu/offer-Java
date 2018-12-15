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
		
		//step1：在每个结点的后面（或者说每个结点与下一个结点中间）插入【新结点】
		//该新结点为克隆结点，这么做是为了连接random结点
		RandomListNode tmp = pHead;
		while(tmp != null) {
			RandomListNode cloneNode = new RandomListNode(tmp.label);
			
			//插入clone结点
			cloneNode.next = tmp.next;
			tmp.next = cloneNode;
			//移到原链表的下一个结点
			tmp = cloneNode.next;
		}
		
		//step2：连接random结点
		tmp = pHead;
		while(tmp != null) {
			RandomListNode cloneNode = tmp.next;
			if(tmp.random != null) {
				cloneNode.random = tmp.random.next;//tmp.random是原链表的结点，tmp.random.next才是那个结点的clone结点
			}
			tmp = cloneNode.next;
		}
		
		//step3：拆分链表（详见图片）
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
