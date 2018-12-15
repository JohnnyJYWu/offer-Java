package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JohnnyJYWu
 * 
 */

public class T60_Print {
	//把二叉树打印成多行（二叉树层输出）
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		if(pRoot == null) return result;
		
		//使用队列实现，不断按层压入及输出
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		
		queue1.add(pRoot);
		
		while(!queue1.isEmpty() || !queue2.isEmpty()) {
			if(!queue1.isEmpty()) {
				ArrayList<Integer> list = new ArrayList<>();
				while(!queue1.isEmpty()) {
					TreeNode node = queue1.poll();
					list.add(node.val);
					
					if(node.left != null) queue2.add(node.left);
					if(node.right != null) queue2.add(node.right);
				}
				result.add(list);
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				while(!queue2.isEmpty()) {
					TreeNode node = queue2.poll();
					list.add(node.val);
					
					if(node.left != null) queue1.add(node.left);
					if(node.right != null) queue1.add(node.right);
				}
				result.add(list);
			}
		}
		
		return result;
    }
}
