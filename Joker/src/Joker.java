import java.util.Scanner;

public class Joker {
	static String compare(String s1, String s2){
		if(s1.length() != s2.length()){
			if(s1.length() == 7)
				return s1;
			else if(s2.length() == 7)
				return s2;
		} else if(s1.length() == s2.length()) {
				char c1 = s1.charAt(0);
				char c2 = s2.charAt(0);
				//System.out.println(getValue(c1) +" " + getValue(c2));
				return getValue(c1) > getValue(c2) ? s1 : s2;
		}
		
		//System.out.println(s1.length() + " " + s2.length());
		return "ERROR";

	}
	
	static int getValue(char c){
		switch(c){
		case'T': return 10;
		case'J': return 11;
		case'Q': return 12;
		case'K': return 13;
		case'A': return 14;
		case'2': return 15;
		case'g': return 16;
		case'G': return 17;
		
		default: return Integer.parseInt(String.valueOf(c));
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			String s = sc.nextLine();
			if(s.contains("joker JOKER"))
				System.out.println("joker JOKER");
			else{
				String s1 = s.replaceAll("10", "T");
				String s2 = s1.replace("joker", "g");
				String s3 = s2.replace("JOKER", "G");
				String[] cards = s3.split("-");
				//System.out.println(s3);
				String r = Joker.compare(cards[0], cards[1]);
				if(r.contains("T"))
					System.out.println(r.replaceAll("T", "10"));
				else if(r.contains("joker"))
					System.out.println("joker");
				else if(r.contains("JOKER"))
					System.out.println("JOKER");
				else
					System.out.println(r);

			}
			
		}
		
		sc.close();
	}
}
