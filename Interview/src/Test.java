import java.util.Scanner;
//腾讯笔试。。。2道编程题
public class Test {
	static int sum = 0;
	static void geohash(int n, int min, int max) {
		if(max - min < 6)
			return;
		
		int temp = min + (max - min) / 2;
		
		if(n > temp) {
			System.out.print(1);
			geohash(n, temp, max);
		} else if(n < temp) {
			System.out.print(0);
			geohash(n, min, temp);
		}
		
		return;
	}
	
	static boolean isPrime(int n) {
		if(n == 1)
			return true;
		
		for(int i = n-1; i > 1; i--) {
			if(n % i != 0)
				continue;
			else
				return false;
		}
		
		return true;
	}
	
	static boolean isBothPrime(int n, int m) {
		if(n == m)
			return isPrime(n);
		else 
			return isPrime(n) && isPrime(m);
	}
	
	static void primeNum(int num) {
		if(num % 2 == 0) {
			int temp = num / 2;
			int n = temp;
			int m = n;
			
			for(int i = 0; i < temp; i++) {
				if(isBothPrime(n-i, m+i))
					sum++;
			}
		} else {
			int temp = num / 2;
			int n = temp;
			int m = n + 1;
			
			for(int i = 0; i < temp; i++){
				if(isBothPrime(n-i, m+i))
					sum++;
			}
		}
		System.out.println(sum);
		sum = 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			String s = sc.nextLine();
			int n = Integer.valueOf(s);
			
//			题目一的测试代码：
//			if(n >= 0) {
//				geohash(n, 0, 90);
//			} else {
//				geohash(n, -90, 0);
//			}
			
//			题目二的测试代码：
			primeNum(n);
		}
		
		sc.close();
	}
}