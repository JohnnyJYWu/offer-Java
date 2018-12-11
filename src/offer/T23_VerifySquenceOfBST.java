package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T23_VerifySquenceOfBST {
	//二叉搜索树的后序遍历序列
	/**
	 * .二叉搜索树： 
	 * .若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
	 * .若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
	 * .它的左、右子树也分别为二叉搜索树（二叉排序树）。
	 */
	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence == null || sequence.length == 0) return false;
		
		return verify(sequence, 0, sequence.length - 1);
    }
	
	private boolean verify(int[] sequence, int first, int last) {
    	//终止条件
		if(first >= last) return true;
		
		int rootValue = sequence[last];//后序遍历的根节点为最后一个
		int index = first;
		
		while(sequence[index] <= rootValue && index < last) {//比根节点小的为左子树，大的为右子树
			index ++;
		}
		//此时sequence[index]是第一个比根节点大的值
		//可将sequence[0]~sequence[index-1]认为是左子树，sequence[index]~sequence[last-1]认为是右子树
		for(int i = index; i < last; i ++) {
			if(sequence[i] < rootValue) {//若右子树中存在比根节点小的，则不是二叉搜索树
				return false;
			}
		}
		
		//此时分别对根节点的左右子树进行迭代判断，全部为true则是后序遍历
		return verify(sequence, first, index - 1)
				&& verify(sequence, index, last - 1);//last为根节点
    }
}
