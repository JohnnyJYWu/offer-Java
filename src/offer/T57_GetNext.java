package offer;

/**
 * @author JohnnyJYWu
 */

public class T57_GetNext {
    //二叉树的下一个结点
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;

        if (pNode.right != null) {//该结点有右子树，进行中序遍历即可
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else {//该结点无右子树，则需返回
            while (pNode.next != null) {
                if (pNode.next.left == pNode) {//若该结点是父结点的左孩子
                    return pNode.next;
                } else {//若是右孩子,则向上移动
                    pNode = pNode.next;
                }
            }
        }

        return null;
    }
}
