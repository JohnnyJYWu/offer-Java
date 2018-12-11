package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JohnnyJYWu
 * 
 */

public class T22_PrintFromTopToBottom {
	//从上往下打印二叉树（二叉树层输出）
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		
		if(root == null) return list;
		
		//使用队列实现，不断按层压入及输出
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			//先左后右按顺序压入子节点
			if(tmp.left != null) queue.add(tmp.left);
			if(tmp.right != null) queue.add(tmp.right);
			
			list.add(tmp.val);
		}
		
		return list;
    }
}
