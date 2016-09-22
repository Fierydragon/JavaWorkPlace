import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StackWithMin3 extends Stack<Integer>{
	Stack<Integer> s2;
	StackWithMin3(){
		s2 = new Stack<Integer>();
	}
	
	public Integer min(){
		if(s2.isEmpty())
			return Integer.MAX_VALUE;
		return s2.peek();
	}
	
	public void push(int value){
		if(value <= min())
			s2.push(value);
		super.push(value);
	}
	
	public Integer pop(){
		int value = super.pop();
		if(value == min())
			s2.pop();
		return value;
	}
	
	public static void main(String[] args){
		ArrayList<Integer> s = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++){
			s.add(i);
		}
		System.out.println("s = " + s);
		ArrayList<Integer> t = s;
		t.set(7, 1000);
		System.out.println("s = " + s);
		
		Scanner sc = new Scanner(System.in);
		StackWithMin3 swm = new StackWithMin3();
		
		while(sc.hasNext()){
			int value = sc.nextInt();
			if(value == -999)
				break;
			else if(value == -1){
				System.out.println("Pop(): " + swm.pop());
				System.out.println(swm);
				System.out.println("Min: " + swm.min());
				continue;
			}
			swm.push(value);
			System.out.println(swm);
			System.out.println(swm.min());
		}
		
		sc.close();
	}

}
