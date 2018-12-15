package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T61_SerializeBiTree {
	//序列化二叉树（此题无标答，因为没有序列化的具体要求）
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	//此解采用先序遍历，null则保存为#
	public String Serialize(TreeNode root) {
		if(root == null) return "";
		
		StringBuilder sb = new StringBuilder();
        serialize(root, sb);
		
		return sb.toString();
	}
	
	private void serialize(TreeNode root, StringBuilder sb) {
		if(root == null) {
			sb.append("#,");
			return;
		}
		
		sb.append(root.val);
		sb.append(",");
		serialize(root.left, sb);
		serialize(root.right, sb);
	}
	   
	public TreeNode Deserialize(String str) {
		if(str == null || str.length() == 0) return null;

		String[] strs = str.split(",");
		index = 0;
		return deserialize(strs);
	}
	
	private int index;
	
	private TreeNode deserialize(String[] strs) {
		if(!strs[index].equals("#")) {
			TreeNode node = new TreeNode(Integer.parseInt(strs[index]));
			index ++;
			node.left = deserialize(strs);
			node.right = deserialize(strs);
			return node;
		} else {
			index ++;
		}
		return null;
	}
}
