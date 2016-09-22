import java.util.ArrayList;

public class QuickSort {
	static void exchange(ArrayList<Integer> list, int i, int j) {
		if(i == j)
			return;
		
		int temp = list.get(i);
		
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	static void quickSort(ArrayList<Integer> list) {
		sort(list, 0, list.size()-1);
	}
	
	static void sort(ArrayList<Integer> list, int start, int end) {
		if(start >= end)
			return;
		
		int value = list.get(start);
		int s = start, e = end;
		
		while(s < e) {
			while(list.get(e) > value && s < e) {
				e--;			
			}
			while(list.get(s) <= value && s < e) {
				s++;
			}
			exchange(list, s, e);
		}
		
		exchange(list, start, s);
		
		sort(list, start, s-1);
		sort(list, s+1, end);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] array = {41, 51, 32, 45, 3, 59, 41, 98, 1, 69, 11, 22, 77, 83};
		
		for(int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		long startTime = System.nanoTime();
		
		quickSort(list);
		
		long endTime = System.nanoTime();
		long timeConsume = endTime - startTime;
		
		System.out.println(list);
		System.out.println("Time consume: " + timeConsume + " ns");
	}
}
