package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JohnnyJYWu
 * 
 */

public class T4_reConstructBinaryTree {
	//重建二叉树
	//Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	private Map<Integer, Integer> map = new HashMap<>();//用于查找中序遍历数组中，每个值对应的索引
	
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
	    for(int i = 0; i < in.length; i ++) {
	    	map.put(in[i], i);//key: in的值，value: 值在in中位置
	    }
		
		return getBiTree(pre, 0, pre.length - 1, 
							in, 0, in.length - 1);
	}
	
	private TreeNode getBiTree(int[] pre, int preLeft, int preRight, //前序遍历及当前在前序遍历中的区间
								int[] in, int inLeft, int inRight) { //中序遍历及当前在前序遍历中的区间
	    if(preLeft == preRight) {//即根据前序遍历，当前结点无子结点
	    	return new TreeNode(pre[preLeft]);
	    }
	    if(preLeft > preRight || inLeft > inRight) {
	    	return null;
	    }
	    
	    TreeNode root = new TreeNode(pre[preLeft]);
	    int inIndex = map.get(root.val);
	    int leftTreeSize = inIndex - inLeft;//该结点左半部分的结点数
	    
	    //递归，获取左子树及右子树
	    root.left = getBiTree(pre, preLeft + 1, preLeft + leftTreeSize, //左半部分在前序遍历中的区间
	    						in, inLeft, inIndex - 1);//左半部分在中序遍历中的区间
	    root.right = getBiTree(pre, preLeft + 1 + leftTreeSize, preRight, //右半部分在前序遍历中的区间
	    						in, inIndex + 1, inRight);//右半部分在中序遍历中的区间
	    
	    return root;
	}
}
