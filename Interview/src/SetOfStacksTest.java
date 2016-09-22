import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class SetOfStacksTest {
	ArrayList<QuantityStack<Integer>> stacks = new ArrayList<QuantityStack<Integer>>();
	
	public void push(int value){
		QuantityStack<Integer> last = getLastStack();
		if(last != null && !last.isFull()){
			last.push(value);
		} else {
			last = new QuantityStack<Integer>();
			last.push(value);
			stacks.add(last);
		}
	}
	public int pop(){
		Stack<Integer> last = getLastStack();
		int v = last.pop();
		if(last.isEmpty()){
			stacks.remove(last);
		}
		return v;
	}
	
	public QuantityStack<Integer> getLastStack() {
		if(stacks.size() == 0)
			return null;
		return stacks.get(stacks.size() - 1);
	}
	
	public void	display(){
		System.out.println("SetOfStacks:");
				
		for(QuantityStack<Integer> qs : stacks){
			System.out.println(qs);
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SetOfStacksTest sost = new SetOfStacksTest();
		
		while(sc.hasNext()){
			int value = sc.nextInt();
			if(value == -999)
				break;
			
			else if(value == -1){
				sost.pop();
				sost.display();
				continue;
			} else {
				sost.push(value);
				sost.display();
			}	
		}
		sc.close();
	}
}

class QuantityStack<Integer> extends Stack<Integer> {
	public static final int MAX_CAPACITY = 5;
	public boolean isFull(){
		System.out.println("size:" + this.size());
		
		if(this.size() == MAX_CAPACITY){
			return true;
		}
		return false;
	}
}