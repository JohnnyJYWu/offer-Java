package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T26_Convert {
	//二叉搜索树与双向链表
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}

	private TreeNode pre = null;//用于记录上一个节点
	private TreeNode head = null;
	
	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree == null) return null;
		
		inOrder(pRootOfTree);
		
		return head;
    }
	
	private void inOrder(TreeNode node) {
		if(node == null) return;
		
		//实质上是中序遍历，改节点的指针。left代表双向链表的prev指针，right代表next
		//左
		inOrder(node.left);
		
		//根
		//改指针的指向（只需与上一个节点相连即可）
		node.left = pre;//连上一个
		if(pre != null) {//如果上一个不为null，连此时这个
			pre.right = node;
		}
		pre = node;//将pre移向此时这个节点，为下一次迭代做准备
		
		if(head == null) head = node;//只在第一次找到最小节点时作为头结点
		
		//右
		inOrder(node.right);
	}
}
