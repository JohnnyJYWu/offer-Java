package offer;

/**
 * @author JohnnyJYWu
 */

public class T18_Mirror {
    //二叉树的镜像
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) return;

        //交换左右子树
        swap(root);
        //分别对root左右子树进行交换，递归调用此方法即可
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
