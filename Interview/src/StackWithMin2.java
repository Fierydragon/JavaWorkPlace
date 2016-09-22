import java.util.Scanner;
import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
	public Stack<MinNode> min = new Stack<MinNode>();
	
	public void push(int value){
		if(value < min()){
			min.push(new MinNode(value, 1));
		} else if(value == min()) {
			MinNode mn = min.pop();
			mn.nums++;
			min.push(mn);
		}
		super.push(value);
	}
	
	public Integer pop(){
		int value = super.pop();
		MinNode m = min.peek();
		if(value == m.value){
			if(m.nums  > 1){
				m.nums--;
				min.pop();
				min.push(m);
			}
				
			else if(m.nums == 1)
				min.pop();
		}
	
		return value;
	}
	
	public int min(){
		if(this.isEmpty())
			return Integer.MAX_VALUE;
		else
			return min.peek().value;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StackWithMin2 swm = new StackWithMin2();
		while(sc.hasNext()){
			int value = sc.nextInt();
			if(value == -999)
				break;
			if(value == -88){
				System.out.println("Pop(): " + swm.pop());
				System.out.println("Min: " + swm.min());
				continue;
			}
				
			swm.push(value);
			System.out.println("Min: " + swm.min());
		}

		
		System.out.println(swm);
		System.out.println(swm.min);
		sc.close();
	}
}

class MinNode {
	int value;
	int nums;
	
	MinNode(int _value, int _nums){
		value = _value;
		nums = _nums;
	}
}