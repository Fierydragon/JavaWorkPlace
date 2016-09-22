
public class Queen {
	public static int NUM = 8;
	public static int[] c = new int[NUM];
	public static int n = 0;
	
	public static void placeQueen(int r) {
		if(r == NUM) {
			n++;
			return;
		}
		//n++;
		for(int i = 0; i < NUM; i++) {
			c[r] = i;
			boolean ok = true;
			for(int j = 0; j < r; j++){
				if(c[r] == c[j] || Math.abs(r - j) == Math.abs(c[r] - c[j])) {
					ok = false;
					break;
				}		
			}
			if(ok){
				placeQueen(r+1);
			}

		}
		return;
	}
	
	public static void main(String[] args) {
		placeQueen(0);
		
		System.out.println(n);
	}
}
