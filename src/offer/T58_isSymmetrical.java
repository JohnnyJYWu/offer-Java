package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T58_isSymmetrical {
	//对称的二叉树
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) return true;
        
        return isSymmetricalTree(pRoot.left, pRoot.right);
    }
	
	private boolean isSymmetricalTree(TreeNode left, TreeNode right) {
		if(left == null && right == null) return true;
		if(left == null) return false;
		if(right == null) return false;
		
		return left.val == right.val
				&& isSymmetricalTree(left.left, right.right)
				&& isSymmetricalTree(left.right, right.left);
	}
}
