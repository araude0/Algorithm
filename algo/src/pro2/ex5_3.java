package pro2;

import java.util.*;

public class ex5_3 {
	public static int n, m;
	public static int[][] map;
	
	public static boolean dfs(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m) return false;
		
		if (map[x][y] == 0) {
			map[x][y] = 1;
			
			dfs(x - 1, y);
			dfs(x, y + 1);
			dfs(x + 1, y);
			dfs(x, y - 1);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dfs(i, j)) {
					result++;
				}
			}
		}
		System.out.println(result);
	}

}
