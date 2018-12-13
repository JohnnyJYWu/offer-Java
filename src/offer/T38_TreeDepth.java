package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T38_TreeDepth {
	//二叉树的深度
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        
        return 1//当前节点深度1
        		+ Math.max(TreeDepth(root.left), TreeDepth(root.right));//分别对左右子树递归计算深度，取深度更大的一个
    }
}
