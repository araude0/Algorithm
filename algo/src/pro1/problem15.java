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
		
		// 그래프와 최단 거리 테이블 초기화
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
			d[i] = -1;
		}
		
		// 모든 도로 정보 입력 받기
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
		}
		
		// 출발 도시까지 거리 0 설정
		d[x] = 0;
		
		// BFS 수행 (Queue 생성 및 출발 도시 삽입)
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			// 현재 도시에서 갈 수 있는 모든 도시 확인
			for(int i = 0; i < graph.get(now).size(); i++) {
				int nextNode = graph.get(now).get(i);
				
				// 아직 방문하지 않은 도시면 최단 거리 갱신 및 Queue에 삽입
				if (d[nextNode] == -1) {
					d[nextNode] = d[now] + 1;
					q.offer(nextNode);
				}
			}
		}
		
		boolean check = false;
		
		// 최단 거리가 k인 도시 찾기
		for(int i = 1; i <= n; i++) {
			if (d[i] == k) {
				System.out.println(i);
				check = true;
			}
		}
		
		// 최단 거리 k인 도시가 없다면
		if(!check) System.out.println(-1);
	}

}
