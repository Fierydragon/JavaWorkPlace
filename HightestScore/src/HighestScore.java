import java.util.Scanner;

public class HighestScore {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			sc.nextLine();
			int[] scores = new int[n];
			for(int i = 0; i < n; i++){
				scores[i] = sc.nextInt();
			}
			
			int n1 = 0;
			int n2 = 0;
			
			while(m != 0){
				String c = sc.next();
				n1 = sc.nextInt();
				n2 = sc.nextInt();
				if(c.equals("Q")){
					if(n1 > n2){
						int tmp = n2;
						n2 = n1;
						n1 = tmp;
					}
					
					int max = 0;
					for(int i = n1-1; i < n2; i++){
						if(max < scores[i]){
							max = scores[i];
						}
							
					}
					System.out.println(max);
				} else if(c.equals("U")) {
					scores[n1-1] = n2;
				}
				m--;
			}	
		}
		
		sc.close();
	}

}
