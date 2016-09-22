import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.tree.TreeNode;

public class FindSumTreeNodeic {
	static ArrayList<TreeNode> path = new ArrayList<TreeNode>();
	static int target = 0;
	
	public static void findSum(TreeNode n, int sum, int target) {
		if(n == null) return;
		
		path.add(root);
		sum += n.data;
		
		if(sum == target)
			System.out.println(n);
		
		findSum(n.left);
		findSum(n.right);
		
		path.remove(n);
	}
	
	public static void findSum(TreeNode root){
		if(root == null) return;
		else
			findSum(root, 0, target);
		
		findSum(root.left);
		findSum(root.right);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Tree root = new Tree();
		while(sc.hasNext()) {
			target = sc.nextInt();
			if(target == -999)
				break;
			
			findSum(root);
		}
	}
	
	
	
	
	
	
	
	
	public static void findSum(TreeNode n, int sum, int[] path, int level) {
		if(n == null) return;
		
		int s = 0;
		for(int i = level; i <= 0; i--){
			s += path[i];
			
			if(s == sum)
				print(path, i, level);
		}
		
		path[level] = n.data;
		
		findSum(n.left, sum, path, level+1);
		findSum(n.right, sum, path, level+1);
		
		path[level] = Integer.MIN_VALUE;
		
	}
	
	static void print(int[] path, int start, int end){
		StringBuffer sb = new StringBuffer();
		for(int i = start; i <= end; i++){
			sb.append(path[i] + " ");
		}
		System.out.println(sb.toString());
	}
	
	public static void findSum1(TreeNode root){
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int[] path = new int[depth(root)];
		
		findSum(root, sum, path, 0);
	}
	
	static int depth(TreeNode root){
		if(root == null) return 0;
		
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}
}
