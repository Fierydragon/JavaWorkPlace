import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class CreateLinkedList {
	public static void createLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
		if(root == null) return;
		
		LinkedList<TreeNode> list = null;
		if(level == lists.size()){
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
			
		}
		list.add(root);
		createLinkedList(root.left, lists, level+1);
		createLinkedList(root.right, lists, level+1);
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		
		createLinkedList(root, lists, 0);
		return lists;
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLinkedListBSF(TreeNode root) {
		if(root == null) return null;
		
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		current.add(root);
		
		while(current.size() > 0) {
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			
			for(TreeNode parent : parents){
				if(parent.left != null)
					current.add(parent.left);
				if(parent.right != null) { 
					current.add(parent.right);
				}
			}
		}
		
		return result;
	}
	
	
	public static ArrayList<LinkedList<TreeNode>> createLinkedList(TreeNode root){
		if(root == null) return null;
		
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		createLinkedList1(root, result, 0);
		
		return result;
	}
	
	public static void createLinkedList1(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
		LinkedList<TreeNode> list = null;
		
		if(level == lists.size()){
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		
		list.add(root);
		createLinkedList1(root.left, lists, level+1);
		createLinkedList1(root.right, lists, level+1);
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLinkedListBFS1(TreeNode root){
		if(root == null) return null;
		
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		current.add(root);
		
		while(current.size() > 0){
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			
			for(TreeNode parent : parents){
				if(parent.left != null)
					current.add(parent.left);
				if(parent.right != null)
					current.add(parent.right);
			}
		}
		
		return result;
	}
}