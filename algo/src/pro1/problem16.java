package pro1;

import java.util.Scanner;

public class problem16 {
	public static int n, m, result = 0;
	public static int[][] arr = new int[8][8];
	public static int[][] temp = new int[8][8];

	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	// dfs를 이용해 바이러스 전파 
	public static void virus(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (temp[nx][ny] == 0) {
					// 해당 위치에 바이러스 배치, 다시 재귀적으로 호출
					temp[nx][ny] = 2;
					virus(nx, ny);
				}
			}
		}
	}
	
	// 안전 영역 크기 계산
	public static int getScore() {
		int score = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0) {
					score += 1;
				}
			}
		}
		return score;
	}
	
	// DFS를 이용해 울타리를 설치하면서 매 번 안정 영역 계산
	public static void dfs(int count) {
		// 울타리가 3개 설치된 경우 
		if (count == 3) {
			// 임시 빈 배열에 현재 맵 복사
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			
			// 바이러스 전파
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (temp[i][j] == 2) {
						virus(i, j);
					}
				}
			}
			
			// 안전 영역 최대값 게산
			result = Math.max(result, getScore());
			return;
		}
		
		// 빈 영역에 울타리 설치
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					count += 1;
					dfs(count);
					arr[i][j] = 0;
					count -= 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		dfs(0);
		System.out.println(result);
	}

}
