
public class Savings {
	static double saving(float money, int months, double interestRate) {
		double sum =  0;
		double multiple = 1 + interestRate / 12;
		
		for(int i = 0; i < months; i++) {
			sum = sum * multiple + money;
		}
		return sum;
	}
	
	public static void main(String[] arsg) {
		int money1 = 2000;
		int months = 35 * 12;
		double interestRate = 0.12;
		
		double sum = saving(money1, months, interestRate);
		System.out.println(sum);
	}
}