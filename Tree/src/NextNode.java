import javax.swing.tree.TreeNode;

public class NextNode {
	public static TreeNode inorderNextNode(TreeNode n) {
		if(n has right subtree) 
			return leftest right subtree node;
		
		while(n is right child of n.parent){
			n = n.parent();
		}
		if(n == root)
			return null;
		
		return n.parent();
	}
	
	
	public static TreeNode inorderNextNode(TreeNode n) {
		if(n == null) return null;
		
		if(n.right != null){
			return leftMostChild(n.right);
		}
		
		TreeNode current = n;
		TreeNode parent = n.parent;
		
		while(parent != null && parent.left != current){
			parent = current.parent;
			current = parent;
		}
		
		return parent;
	}
	
	public static TreeNode leftMostChild(TreeNode n){
		if(n == null) return null;
		
		while(n.left != null){
			n = n.left;
		}
		return n;
	}
}