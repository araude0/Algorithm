package pro1;

import java.util.PriorityQueue;
import java.util.Scanner;

public class problem26 {
	private static int n, result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			q.offer(sc.nextInt());
		}
		
		while(q.size() != 1) {
			int one = q.poll();
			int two = q.poll();
			
			int summary = one + two;
			result += summary;
			q.offer(summary);
		}
		System.out.println(result);
	}

}
