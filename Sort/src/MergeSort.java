
public class MergeSort {
	
	static void mergeSort(int[] array, int left, int right) {
		if(left < right){
			int middle = (left + right) / 2;
			mergeSort(array, left, middle);
			mergeSort(array, middle+1, right);
			merge(array, left, middle, right);
		}
	}
	
	static void merge(int[] array, int left, int middle, int right) {
		int[] helper = new int [right - left + 1];
		for(int i = 0, j = left; j < right+1; i++, j++){
			helper[i] = array[j];
		}
		
		int l = 0, m = middle - left + 1;
		int n = 0;
		while(l < middle - left + 1 && m < right - left + 1) {
			if(helper[l] < helper[m]){
				array[left+n] = helper[l];
				l++;
			} else {
				array[left+n] = helper[m];
				m++;
			}
			n++;
		}
		
		int remain = middle - left - l + 1;
		
		for(int i = 0; i < remain; i++) {
			array[left+n] = helper[l];
			n++;
			l++;
		}
		
	}
	
	static void merge1(int[] array, int left, int middle, int right) {
		int helper[] = new int [right+1];
		
		for(int i = left; i <= right; i ++ ) {
			helper[i] = array[i];
		}
		
		int l = left, r = middle + 1, index = left;
		while(l <= middle && r <= right) {
			if(helper[l] < helper[r]) {
				array[index] = helper[l];
				l++;
			} else {
				array[index] = helper[r];
				r++;
			}
			index++;
		}
		
		int remain = middle - l + 1;
		
		for(int i = 0; i < remain; i++, l++, index++) {
			array[index] = helper[l];
		}
	}
	
	public static void main(String[] args) {
		int[] array = {19, 7, 68, 5, 57, 3, 22, 17, 13, 11, 79};
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]);
			if(i != array.length - 1)
				System.out.print(", ");
		}
		System.out.println();
		
		long start = System.nanoTime();
		mergeSort(array, 0, 10);
		long end = System.nanoTime();
		long timeConsume = end - start;
		System.out.println("Time consume: " + timeConsume + " ns.");
		
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]);
			if(i != array.length - 1)
				System.out.print(", ");
		}
		System.out.println();
	}
}
