import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Tower {
	public static ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>(3);
	
	public static void moveDisks(int n, Stack<Integer> origin, Stack<Integer> dest, Stack<Integer> tmp){
		if(n == 0) return;
		if(origin.size() >= n){
			if(n > 1)
				moveDisks(n-1, origin, tmp, dest);
			{
				int value = origin.pop();
				dest.push(value);
				System.out.print("move: " + value + "\n"+ stacks.get(0) + " , " + stacks.get(1) + " , " + stacks.get(2));
				System.out.println();
			}
			moveDisks(n-1, tmp, dest, origin);
		}

		
	}
	
	public static void main(String[] args){
		Stack<Integer> origin = new Stack<Integer>();
		Stack<Integer> tmp = new Stack<Integer>();
		Stack<Integer> dest = new Stack<Integer>();
		stacks.add(origin);
		stacks.add(tmp);
		stacks.add(dest);
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			int value = sc.nextInt();
			
			if(value == -99)
				break;
			else if(value == -1){
				moveDisks(origin.size(), origin, dest, tmp);
				origin.removeAllElements();
				dest.removeAllElements();
				tmp.removeAllElements();
				
				continue;
			}
			
			origin.push(value);
		}
		sc.close();
	}
}

