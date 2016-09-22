import java.util.ArrayList;

public class RadixSort {
	static int findMaxDigit(ArrayList<Integer> list) {
		int max = 0;
		for(int i = 0; i < list.size(); i++) {
			if(max < list.get(i)) {
				max = list.get(i);
			}
		}
		int n = 0;
		for(; max != 0; max /= 10) {
			n++;
		}
		
		return n;
	}
	static void showBuket(ArrayList<ArrayList<Integer>> buket) {
		for(int i = 0; i < buket.size(); i++) {
			for(int j = 0; j < buket.get(i).size(); j++) {
				if(j == 0)
					System.out.print(i + ": [");
				if(j != buket.get(i).size() - 1)
					System.out.print(buket.get(i).get(j) + ", ");
				
				if(j == buket.get(i).size() - 1) {
					System.out.println(buket.get(i).get(j) + "]");
				}
			}
		}
	}
	
	static void radixSort(ArrayList<Integer> list) {
		int n = findMaxDigit(list);
		//System.out.println(n);
		
		ArrayList<ArrayList<Integer>> buket = new ArrayList<ArrayList<Integer>>(10);
		//ArrayList<Integer> newList = new ArrayList<Integer>(list);
		for(int i = 0; i < 10; i++) {
			ArrayList<Integer> b = new ArrayList<Integer>();
			buket.add(b);
		}
		int m = 0, k = 1, temp = 0;
		
		for(;n != 0; n--) {
			for(int i = 0; i < list.size(); i++) {
				m = list.get(i);
				m /= k;
				//System.out.println("m = " + m); 
				temp = m % 10;
				buket.get(temp).add(list.get(i));
			}
			
			//showBuket(buket);
			list.clear();
			//System.out.println(list);
			
			for(int i = 0; i < buket.size(); i++) {
				for(int j = 0; j < buket.get(i).size(); j++){
					list.add(buket.get(i).get(j));
				}
				buket.get(i).clear();
			}
			k *= 10;
			//System.out.println("gaga");
		}
	}
//   My buket sort program:
//
//	public static void main(String[] args) {
//		int[] array = {12, 14 , 87, 3, 6, 42, 53, 76, 65, 81};
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		
//		for(int i = 0; i < array.length; i++) {
//			list.add(array[i]);
//		}
//		long startTime = System.nanoTime();
//		radixSort(list);
//		long endTime = System.nanoTime();
//		long timeConsume = endTime - startTime;
//		
//		System.out.println(list);
//		System.out.println("TimeConsume: " + timeConsume + " ns.");
//	}
	
	public static void sort(int[] number, int d) //d表示最大的数有多少位
    {
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][]temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[]order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while(m <= d)
        {
            for(int i = 0; i < number.length; i++)
            {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for(int i = 0; i < 10; i++)
            {
                if(order[i] != 0)
                    for(int j = 0; j < order[i]; j++)
                    {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }
	
    public static void main(String[] args)
    {
        int[]data =
        {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
        
        long startTime = System.nanoTime();
        RadixSort.sort(data, 3);
        long endTime = System.nanoTime();
        long timeConsume = endTime - startTime;
        System.out.println("Time consume: " + timeConsume + " ns.");
        
        for(int i = 0; i < data.length; i++)
        {
            System.out.println(data[i] + "");
        }
    }
    
}