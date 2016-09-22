import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestList {
	public static final int N = 50000;
	public static List values;
	
	static {
		Integer[] vals = new Integer[N];
		Random r = new Random();
		
		for(int i=0, currval=0; i < N; i++){
			vals[i] = new Integer(currval);
			currval += r.nextInt(100) + 1;
		}
		
		System.out.println(vals);
		values = Arrays.asList(vals);
		System.out.println(values);
		
	}
	
	static long getTime(List list){
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < N; i++){
			int index = Collections.binarySearch(list, values.get(i));
			if(index != i)
				System.out.println("***** ERROR *****");
		}
		
		return System.currentTimeMillis() - start;
		
	}
	
	static long insertTime(List list){
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < 10000; i++){
			list.add(5000, i);
		}
		return System.currentTimeMillis() - start;
	}
	
	public static void main(String[] args){
		Integer[] a = {4,5,2,1,3};
		System.out.println("a: " + a);
		System.out.println("Arrays.asList(a): " + Arrays.asList(a));
		
		System.out.println("getTime(ArrayList) : " + getTime(new ArrayList(values)));
		System.out.println("getTime(LinkedList) : " + getTime(new LinkedList(values)));
		System.out.println("insertTime(ArrayList) : " + insertTime(new ArrayList(values)));
		System.out.println("insertTime(LinkedList) : " + insertTime(new LinkedList(values)));
	}
}
