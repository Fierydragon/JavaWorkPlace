import java.util.Scanner;
import java.util.Stack;


public class StackWithMin extends Stack<NodeWithMin>{

	public void push(int value){
		int min = Math.min(value, min());
		super.push(new NodeWithMin(value, min));
	}
	
	public int min(){
		//if(!this.isEmpty())
		if(!this.isEmpty())
			return peek().min;
		else
			return Integer.MAX_VALUE;
	}
	
	public void display(){
		System.out.println(this);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StackWithMin swm = new StackWithMin();
		
		while(sc.hasNext()){
			int value = sc.nextInt();
			
			if(value == -999)
				break;
			
			swm.push(value);
		}
		sc.close();
		swm.display();
		
	}
}

class NodeWithMin{
	int value;
	int min;
	
	NodeWithMin(int _value, int _min){
		value = _value;
		min = _min;
	}
}