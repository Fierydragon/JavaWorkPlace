
public class BinarySearchTree {
	public static boolean checkBST(TreeNode root) {
		if(root == null) return true;
		
		else if(root.left.data > root.right.data || root.left.data > root.data || root.data >= root.right.data)
			return false;
		else
			return checkBST(root.left) && checkBST(root.right);
	}
	
	public static boolean isBST(TreeNode root){
		if(root == null) return true;
		
		return checkBST(root);
	}
	
	
	public static int index = 0;
	public static boolean isBST(TreeNode root,IntWrapper min){
		if(root == null) return true;
		
		if(!isBST(root.left, min))
			return false;
		
		if(root.data > min.value)
			min.value = root.data;
		else
			return false;
		
		if(!isBST(root.right, min))
			return false;
		
		return true;
	}
	
	public static boolean isBST(TreeNode root){
		IntWrapper iw = new IntWrapper();
		return isBST(root, iw);
	}
	
	public static boolean isBST(TreeNode root, int min, int max){
		if(root == null) return true;
		
		if(root.data < min || root.data >= max)
			return false;
		
		if(!isBST(root.left, min, root.data) || !isBST(root.right, root.data, max))
			return false;
		
		return true;
	}
	
	public static boolean checkBST(TreeNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
}

class IntWrapper {
	public int value = Integer.MIN_VALUE;
}