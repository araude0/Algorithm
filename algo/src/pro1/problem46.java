package pro1;

import java.util.*;

class Point46 {
	int x;
	int y;
	
	public Point46(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class problem46 {
	private static int n, minX, minY, minDist;
	private static int[][] map, dist;
	private static int sharkX = -1, sharkY = -1, sharkSize = 2;
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};
	private static int count = 0, result = 0;
	
	public static void bfs(int x, int y) {
		Queue<Point46> queue = new LinkedList<>();
		queue.add(new Point46(x, y));
		
		while(!queue.isEmpty()) {
			Point46 p = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx < 1 || nx > n || ny < 1 || ny > n) continue;
				if (dist[nx][ny] != 0 || map[nx][ny] > sharkSize) continue;
				
				dist[nx][ny]  = dist[p.x][p.y] + 1;
				
				if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
					if (minDist > dist[nx][ny]) {
						minX = nx;
						minY = ny;
						minDist = dist[nx][ny];
					} else if (minDist == dist[nx][ny]) {
						if (minX == nx) {
							if (minY > ny) {
								minX = nx;
								minY = ny;
							}
						} else if (minX > nx) {
							minX = nx;
							minY = ny;
						}
					}
				}
				queue.add(new Point46(nx, ny));
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
				
				if (map[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				}
			}
		}
		
		while (true) {
			dist = new int[n + 1][n + 1];
			minX = Integer.MAX_VALUE;
			minY = Integer.MAX_VALUE;
			minDist = Integer.MAX_VALUE;
			
			bfs(sharkX, sharkY);
			
			if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
				count++;
				map[minX][minY] = 0;
				sharkX = minX;
				sharkY = minY;
				result += dist[minX][minY];
				
				if (count == sharkSize) {
					sharkSize++;
					count = 0;
				}
			} else {
				break;
			}
		}
		System.out.println(result);
	}

}
