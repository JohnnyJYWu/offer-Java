package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author JohnnyJYWu
 * 
 */

public class T59_Print {
	//按之字形顺序打印二叉树
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
		
		Stack<TreeNode> stack1 = new Stack<>();//存奇数行
		Stack<TreeNode> stack2 = new Stack<>();//存偶数行
		
		stack1.push(pRoot);
		
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			if(!stack1.isEmpty()) {
				ArrayList<Integer> list = new ArrayList<>();
				while(!stack1.isEmpty()) {
					TreeNode node = stack1.pop();
					list.add(node.val);
					
					if(node.left != null) stack2.push(node.left);
					if(node.right != null) stack2.push(node.right);
				}
				result.add(list);
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				while(!stack2.isEmpty()) {
					TreeNode node = stack2.pop();
					list.add(node.val);

					if(node.right != null) stack1.push(node.right);
					if(node.left != null) stack1.push(node.left);
				}
				result.add(list);
			}
		}
		
		return result;
    }
}
