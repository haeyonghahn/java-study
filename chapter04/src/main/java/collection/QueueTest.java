package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {

		Queue<String> q = new LinkedList<String>();
		
		q.offer("둘리");
		q.offer("마이콜");
		q.offer("또치");
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		// 비어있는 경우, null를 리턴한다.
		System.out.println(q.poll());
		
		q.offer("둘리");
		q.offer("마이콜");
		q.offer("또치");
		
		System.out.println(q.peek());
	}
}
