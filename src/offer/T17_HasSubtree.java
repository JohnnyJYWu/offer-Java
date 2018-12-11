package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T17_HasSubtree {
	//树的子结构
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if(root1 == null || root2 == null) return false;
	    return isSubtree(root1, root2) //root2与root1比较
	    		|| HasSubtree(root1.left, root2) //root2与root1左子树比较，递归逻辑
	    		|| HasSubtree(root1.right, root2); //root2与root1右比较，递归逻辑
	    //以上三种情况任一为true，即证明root2是root1的子结构
    }
	
	private boolean isSubtree(TreeNode root1, TreeNode root2) {
		//终止判定
		if(root1 == null && root2 == null) return true;//为null，能执行到此步且相同，为子结构
	    if(root1 == null) return false;//root1为null，root2不为null，不同，不为子结构
	    if(root2 == null) return true;//root1不为null，root2为null，能执行到此步说明相同，为子结构
	    if(root1.val != root2.val) return false;//root1，root2都不为null，val不同，不为子结构
	    
	    //能执行到此步，说明未判定完，继续对root1，root2的左右子树分别递归此方法进行判断，均为true则为子结构
	    return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
	}
}
