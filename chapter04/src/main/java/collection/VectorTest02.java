package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VectorTest02 {

	public static void main(String[] args) {

		List<String> list = new LinkedList<String>();
		
		list.add("둘리");
		list.add("마이콜");
		list.add("도우넛");
		
		// 순회1
		int count = list.size();
		for(int i=0; i<count; i++) {
			System.out.println(list.get(i));
		}
		
		list.remove(1);
		
		// 순회2
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		// 순회3
		for(String s : list) {
			System.out.println(s);
		}
	}
}
