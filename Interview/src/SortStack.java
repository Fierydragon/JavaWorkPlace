import java.util.Scanner;
import java.util.Stack;

public class SortStack {
	public static Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> sortedStack = new Stack<Integer>();
		
		while(!s.isEmpty()){
			int value = s.pop();
			
			while(!sortedStack.isEmpty() && value < sortedStack.peek() ){
				s.push(sortedStack.pop());
			}
			
			sortedStack.push(value);
		}
		return sortedStack;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> sortedStack = null;
		
		while(sc.hasNext()){
			int value = sc.nextInt();
			
			if(value == -1){
				System.out.println("Before: " + s);
				if(sortedStack == null)
					sortedStack = SortStack.sort(s);
				else {
					sortedStack.addAll(SortStack.sort(s));
					System.out.println(sortedStack);
					sortedStack = SortStack.sort(sortedStack);
				}
					
				System.out.println(sortedStack);
				continue;
			}
			if(value == -99){
				sortedStack = null;
				continue;
			}
			
			s.push(value);
		}
		
		sc.close();
	}
}
