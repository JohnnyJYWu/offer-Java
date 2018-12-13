package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T39_IsBalanced_Solution {
	//平衡二叉树
	/**
	 * .平衡二叉树： 
	 * .它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
	 */
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        
        return getDepth(root) != -1;
    }
	
	private int getDepth(TreeNode root) {
		if(root == null) return 0;

		int left = getDepth(root.left);
        if(left == -1) return -1;
        
        int right = getDepth(root.right);
        if(right == -1) return -1;
        
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
	}
}
