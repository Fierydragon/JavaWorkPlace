import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class JudgeBalance {
	public int getHeight(Node n){
		if(n == null) return 0;
		return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
	}
	
	public boolean isBalanced(Node root){
		if(root == null) return true;
		int leftChild = getHeight(root.left);
		int rightChild = getHeight(root.right);
		int heightDiff = leftChild - rightChild;
		
		if(Math.abs(heightDiff) > 1) {
			return false;
		} else {
			return isBalance(root.left) && isBalance(root.right);
		}
	}
	
	
	
	
	public int checkHeight(Node n){
		if(n == null) return 0;
		
		int left = checkHeight(n.left); 
		if(left == -1) 
			return -1;
		int right = checkHeight(n.right);
		if(right == -1)
			return -1;
		
		int heightDiff = left - right;
		
		if(Math.abs(heightDiff) > 1)
			return -1;
		else
			return Math.max(left, right) + 1;
		
	}
	
	public boolean isBalanced(Node root){
		if(checkHeight(root) == -1)
			return false;
		return checkHeight(root.left) && checkHeight(root.right);
		
	}
	
}