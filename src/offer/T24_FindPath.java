package offer;

import java.util.ArrayList;

/**
 * @author JohnnyJYWu
 * 
 */

public class T24_FindPath {
	//二叉树中和为某一值的路径
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null) return result;
        
        ArrayList<Integer> path = new ArrayList<>();
        findPathDFS(root, target, path);
        
		return result;
    }
	
	private void findPathDFS(TreeNode node, int target, ArrayList<Integer> path) {
		if(node == null) return;
		
		path.add(node.val);
		target -= node.val;//减法的思想，目标值能减为0则是一条路径
		if(target == 0 && node.left == null && node.right == null) {//已经到达叶子节点且targe正好减完
			result.add(new ArrayList<Integer>(path));
		} else if(target > 0) {//若>0则继续对其左右子节点进行迭代判断
			findPathDFS(node.left, target, path);
			findPathDFS(node.right, target, path);
		}
		
		path.remove(path.size() - 1);//此步重要，迭代过程中需把当前值在path中移除以保证路径正确，相当于回退到上一步的路径
	}
}
