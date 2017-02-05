package collection;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityQueue<>();
		for(int i = 0;i<10;i++){
			queue.offer(i);
		}
		System.out.println(queue);
		int len = queue.size();
		for (int i = 0; i < len; i++) {
			System.out.print(queue.poll());
			
		}
		
	}

}
