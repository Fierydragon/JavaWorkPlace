
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashTest {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		  for(int i=0;i<100;i++)
		  {
		   map.put(i, "123");
		  }
		  
		//方法一：效率比方法二高
		
		for(Entry<Integer, String> entry:map.entrySet()){
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		
		//方法二：

//		for(Object obj : map.keySet()) {     
//		      Object key = obj;     
//		      Object value = map.get(obj);     
//		      System.out.println(value);
//		  }
//
//		//二.遍历HashSet
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < 100; i++){
			set.add(1);
		}
		
		for(Iterator it = set.iterator(); it.hasNext();){
			int i = (int) it.next();
			System.out.println("i = " + i);
		}
		
//
//		Set set = new HashSet();
//
//		  for(int i=0;i<100;i++)
//		  {
//		   set .add("123");
//		  }
//
//		for(Iterator it=set.iterator();it.hasNext();)
//		  {
//		   System.out.println(it.next());
//		  }
//
//		//三.遍历Hashtable(同步、线程安全的)
//
		Hashtable<Integer, String> table = new Hashtable<Integer, String>();
		
		for(int i = 0; i < 100; i++) {
			table.put(i, "999");
		}
		for(Entry<Integer, String> entry : table.entrySet()){
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		System.out.println(table.get(100));

//		  //遍历key
//		  Enumeration e = table.keys();
		  
//		  while( e. hasMoreElements() ){
//
//		  System.out.println( e.nextElement() );
//
//		  }
//		  //遍历value
//		  e = table.elements();
//
//		  while( e. hasMoreElements() ){
//
//		  System.out.println( e.nextElement() );
//
//		  }
	}
}
