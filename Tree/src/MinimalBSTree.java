import java.util.ArrayList;
import java.util.LinkedList;

public class MinimalBSTree {
	public static TreeNode createMinimalBSTree(int[] val, int start, int end){
		if(end < start) return null;
		
		int mid = (end - start) / 2;
		TreeNode root = new TreeNode(val[mid]);
		
		root.left = createMinimalBSTree(val, start, mid-1);
		root.right = createMinimalBSTree(val, mid+1, end);
		
		return root;
	}
	
	public static TreeNode createMinimalBSTree(int val[]) {
		return createMinimalBSTree(val, 0, val.length-1);
	}
}
