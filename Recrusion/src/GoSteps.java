import java.util.Scanner;

public class GoSteps {
	protected static int MAX = 500;
	protected static int[] s = new int[MAX];
	public static int step(int n) {
		if(n == 0) return 1;
		if(n < 0) return 0;
		
		if(s[n] != 0) return s[n];
		
		int sum = 0;
		System.out.println("n:" + n);
		sum += step(n-1);
		sum += step(n-2);
		sum += step(n-3);
		s[n] = sum;
		return sum;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = 0;
		
		while(sc.hasNext()){
			n = sc.nextInt();
			if(n == -1){
				break;
			}
			//sum = 0;
			int m = step(n);
			System.out.println(m);
		}
		sc.close();
	}
}
