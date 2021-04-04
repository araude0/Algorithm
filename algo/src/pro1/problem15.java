package pro1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem15 {
	public static int n, m, k, x;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[] d = new int[300001];
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		x = sc.nextInt();
		
		// �׷����� �ִ� �Ÿ� ���̺� �ʱ�ȭ
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
			d[i] = -1;
		}
		
		// ��� ���� ���� �Է� �ޱ�
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
		}
		
		// ��� ���ñ��� �Ÿ� 0 ����
		d[x] = 0;
		
		// BFS ���� (Queue ���� �� ��� ���� ����)
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			// ���� ���ÿ��� �� �� �ִ� ��� ���� Ȯ��
			for(int i = 0; i < graph.get(now).size(); i++) {
				int nextNode = graph.get(now).get(i);
				
				// ���� �湮���� ���� ���ø� �ִ� �Ÿ� ���� �� Queue�� ����
				if (d[nextNode] == -1) {
					d[nextNode] = d[now] + 1;
					q.offer(nextNode);
				}
			}
		}
		
		boolean check = false;
		
		// �ִ� �Ÿ��� k�� ���� ã��
		for(int i = 1; i <= n; i++) {
			if (d[i] == k) {
				System.out.println(i);
				check = true;
			}
		}
		
		// �ִ� �Ÿ� k�� ���ð� ���ٸ�
		if(!check) System.out.println(-1);
	}

}
