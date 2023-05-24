package offer;

import java.util.ArrayList;

/**
 * @author JohnnyJYWu
 */

public class T62_KthNode {
    //二叉搜索树的第k个结点
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private ArrayList<TreeNode> list = new ArrayList<>();

    public TreeNode KthNode(TreeNode pRoot, int k) {//二叉搜索树，中序遍历即为从小到大的排序
        if (pRoot == null || k <= 0) return null;

        inOrder(pRoot);

        TreeNode kthNode = null;

        if (k <= list.size()) {
            kthNode = list.get(k - 1);
        }

        return kthNode;
    }

    private void inOrder(TreeNode root) {//中序遍历
        if (root == null) return;

        //左
        if (root.left != null) inOrder(root.left);
        //根
        list.add(root);
        //右
        if (root.right != null) inOrder(root.right);
    }
}
