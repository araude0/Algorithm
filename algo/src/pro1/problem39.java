package pro1;

import java.util.*;

class Node39 implements Comparable<Node39> {
	private int x;
	private int y;
	private int distance;
	
	public Node39(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getDistance() {
		return this.distance;
	}
	@Override
	public int compareTo(Node39 other) {
		if (this.distance < other.distance) {
			return -1;
		}
		return 1;
	}
}

public class problem39 {
	public static final int INF = (int) 1e9;
	public static int[][] graph = new int[125][125];
	public static int[][] d = new int[125][125];
	public static int testCase, n;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		
		for (int tc = 0; tc < testCase; tc++) {
			n = sc.nextInt();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < n; i++) {
				Arrays.fill(d[i], INF);
			}
			
			int x = 0, y = 0;
			PriorityQueue<Node39> pq = new PriorityQueue<>();
			pq.offer(new Node39(0, 0, graph[x][y]));
			d[x][y] = graph[x][y];
			
			while(!pq.isEmpty()) {
				Node39 node = pq.poll();
				int dist = node.getDistance();
				x = node.getX();
				y = node.getY();
				
				if (d[x][y] < dist) continue;
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					
					int cost = dist + graph[nx][ny];
					if (cost < d[nx][ny]) {
						d[nx][ny] = cost;
						pq.offer(new Node39(nx, ny, cost));
					}
				}
			}
			System.out.println(d[n - 1][n - 1]);
		}

	}

}
