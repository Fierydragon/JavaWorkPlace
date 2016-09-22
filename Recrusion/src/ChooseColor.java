import java.util.*;
import java.util.Map.Entry;
import java.util.function.BiFunction;

public class ChooseColor {
	//static Color color = Color.red;
	public static void choose(Color c) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map.put("1", 9);
		map1.put("1", 7);
		map.putAll(map1);
		
		for(Entry<String, Integer> entry : map1.entrySet()) {
			Integer value = map.merge(entry.getKey(), entry.getValue(), new BiFunction<Integer, Integer, Integer>() {
				public Integer apply(Integer t, Integer u) {
					
					return t + u;
				}
			});
		}
		
		for(Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		Color[] colors = Color.values();
		choose(Color.red);
		
		for(int i = 0; i < colors.length; i ++ ) {
			System.out.println(colors[i]);
		}
		
		String test = "Hello world, I like this day !a";
		StringTokenizer st = new StringTokenizer(test, " ");
		int count = st.countTokens();
		
		System.out.println(count);
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		loop : for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					if(k == 6) {
						break loop;
					}
					System.out.print(k);
				}
			}
		}
	}
}

enum Color {
	red, yellow, blue;
}