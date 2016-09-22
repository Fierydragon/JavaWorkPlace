import java.util.ArrayList;
import java.util.Scanner;

public class GraphyTraversal {
	public static int X = 0;
	public static int Y	= 0;
	private static int[][] values = null;
	private static int s = 0;
	public static void traversal(int x, int y){
		if(x == X || y == Y)
			return;
		
		if(x == X-1 && y == Y-1){
			s++;
			return;
		}
			
		
		if(x < X)
			traversal(x+1, y);
		if(y < Y)
			traversal(x, y+1);
		//System.out.println("(" + x + "," + y + ")");
		
	}
	
	public static ArrayList<Point> ps = new ArrayList<Point>();
	public static void traversalBFS() {
		
		while(!ps.isEmpty()){
			Point p = ps.remove(0);
			if(p.x + 1 < X)
				ps.add(new Point(p.x+1, p.y));
			if(p.y + 1 < Y)
				ps.add(new Point(p.x, p.y+1));
			
			if(p.x == X-1 && p.y == Y-1)
				s++;
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();
		
		values = new int[X][Y];
		
		for(int i = 0; i < X; i++){
			for(int j = 0; j < Y; j++){
				values[i][j] = sc.nextInt();
			}
		}
		sc.close();
		//BFS
//		ps.add(new Point(0,0));
//		traversalBFS();
		
		//DFS
    	traversal(0, 0);
		
		System.out.println(s);
		
	}
}

class Point {
	int x;
	int y;
	
	Point(int _x, int _y){
		x = _x;
		y = _y;
	}
}
