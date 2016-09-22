
public class Subtree {
	boolean containsTree(TreeNode t1, TreeNode t2){
		if(t2 == null) return true;
		
		return subtree(t1, t2);
	}
	
	boolean subtree(TreeNode t1, TreeNode t2) {
		if(t1 == null) return false;
		
		if(t1.data == t2.data){
			return matchTree(t1, t2);
		}
		return (subtree(t1.left, t2) || subtree(t1.right, t2));
	}
	
	boolean matchTree(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null) return true;
		
		if(t1 == null || t2 == null) return false;
		
		if(t1.data != t2.data) return false;
		
		return (matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right));
	}
}
