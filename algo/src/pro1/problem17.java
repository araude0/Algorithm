package pro1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 바이러스 정보를 저장하고 번호순 정렬을 위해 클래스 정의
class Virus implements Comparable<Virus> {
	private int index, second, x, y;

	public Virus(int index, int second, int x, int y) {
		this.index = index;
		this.second = second;
		this.x = x;
		this.y = y;
	}

	public int getIndex() {
		return this.index;
	}

	public int getSecond() {
		return this.second;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	// 정령 번호 낮은 순 (오름차순)
	@Override
	public int compareTo(Virus other) {
		if (this.index < other.index) {
			return -1;
		}
		return 1;
	}

	
}

public class problem17 {
	public static int n, k = 0;
	public static int[][] graph = new int[200][200];
	public static ArrayList<Virus> viruses = new ArrayList<Virus>();
	
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = sc.nextInt();
				
				// 해당 위치에 바이러스가 있을 경우
				if (graph[i][j] != 0) {
					// 바이러스 종류, 시간, x, y 삽입
					viruses.add(new Virus(graph[i][j], 0, i, j));
				}
			}
		}
		
		// 정렬 이후 큐로 옮기기
		Collections.sort(viruses);
		Queue<Virus> q = new LinkedList<Virus>();
		for (int i = 0; i < viruses.size(); i++) {
			q.offer(viruses.get(i));
		}
		
		int targetS = sc.nextInt();
		int targetX = sc.nextInt();
		int targetY = sc.nextInt();
		
		// BFS 진행
		while(!q.isEmpty()) {
			Virus virus = q.poll();
			// 정확히 s초가 되거나 큐가 빌 때까지 반복
			if (virus.getSecond() == targetS) break;
			
			// 상하좌우 확인
			for (int i = 0; i < 4; i++) {
				int nx = virus.getX() + dx[i];
				int ny = virus.getY() + dy[i];
				
				// 해당 위치로 이동 가능한 경우
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					// 아직 방문하지 않은 위치면 바이러스 넣고 큐에 삽입
					if (graph[nx][ny] == 0) {
						graph[nx][ny] = virus.getIndex();
						q.offer(new Virus(graph[nx][ny], virus.getSecond() + 1, nx, ny));
					}
				}
			}
		}
		
		// 문제에선 (1, 1)부터 시작이지만 graph는 (0, 0)부터이므로 1씩 빼준다
		System.out.println(graph[targetX - 1][targetY - 1]);
	}

}
