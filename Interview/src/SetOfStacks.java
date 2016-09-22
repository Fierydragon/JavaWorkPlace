import java.util.Stack;
import java.util.Scanner;

public class SetOfStacks {
	Stack<StackNode> set = new Stack<StackNode>();
	
	void push(int element){
		if(checkPushCapacity()){
			StackNode sn = set.peek();
			sn.s.push(element);
			sn.elements++;
		} else {
			set.push(new StackNode());
			StackNode sn = set.peek();
			sn.s.push(element);
			sn.elements++;
		}
	}
	
	int pop(){
		if(checkPopCapacity()){
			StackNode sn = set.peek();
			sn.elements--;
			
			return sn.s.pop();
		} else {
			set.pop();
			StackNode sn = set.peek();
			sn.elements--;
			
			return sn.s.pop();
		}
		
	}
	
	boolean checkPushCapacity(){
		if(set.empty())
			set.push(new StackNode());
		if(set.peek().s.empty() || set.peek().elements < 5)
			return true;
		else
			return false;
	}
	
	boolean checkPopCapacity(){
		if(set.peek().s.empty())
			return false;
		else
			return true;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SetOfStacks sos = new SetOfStacks();
		
		while(sc.hasNext()){
			int data = sc.nextInt();
			if(data == -1)
				break;
			sos.push(data);
		}
		sc.close();
	}
}

class StackNode{
	public static final int CAPACITY = 5;
	
	Stack<Integer> s = new Stack<Integer>();
	int elements = 0;
}