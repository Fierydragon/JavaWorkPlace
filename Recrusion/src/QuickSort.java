import java.util.ArrayList;

public class QuickSort {
	public static void quickSort(ArrayList<Integer> list, int start, int end) {
		if(end < 0 || start > end || end > list.size() - 1)
			return;
		int left = start;
		int right = end;
		int first = list.get(start);
		int startValue = list.get(left);
		int endValue = list.get(right);
		
		while(right > left) {
			while(endValue > first) {
				right--;
				if(right >= 0) {
					endValue = list.get(right);
				} else
					break;
			}
			
			while(startValue < first){
				left++;
				if(left <= right){
					startValue = list.get(left);
				} else
					break;
			}
			
			if(startValue > first && endValue < first){
				exchange(list, left, right);
			}
			if(left == right && startValue < first) {
				exchange(list, left, start);
			}
		}
		
		quickSort(list, start, left-1);
		quickSort(list, left+1, end);
		//if()
	}
	
	public static void exchange(ArrayList<Integer> list, int first, int second){
		int f = list.get(first);
		int s = list.get(second);
		
		list.set(first, s);
		list.set(second, f);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 10; i > 0; i--) {
			list.add(i);
		}
		System.out.println(list);
		
		quickSort(list, 0, list.size()-1);
		
		System.out.println(list);
	}
}


