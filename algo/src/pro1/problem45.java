package pro1;

import java.util.*;

public class problem45 {
	
	static final int NONE = 0;
	static final int IMPOSSIBLE = 1;
	static final int NOT_DETERMINED = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for (int tc = 0; tc < testCase; tc++) {
			int n = sc.nextInt();
			
			int[] indegree = new int[n + 1];
			int[][] graph = new int[n + 1][n + 1];
			
			int[] t = new int[n];
			for (int i = 0; i < n; i++) {
				t[i] = sc.nextInt();
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					graph[t[i]][t[j]] = 1;
					indegree[t[j]]++;
				}
			}
			
			int m = sc.nextInt();
			
			for (int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if (graph[a][b] == 1) {
					graph[a][b] = 0;
					graph[b][a] = 1;
					indegree[a]++;
					indegree[b]--;
				} else {
					graph[b][a] = 0;
					graph[a][b] = 1;
					indegree[a]--;
					indegree[b]++;
				}
			}
			
			Queue<Integer> queue = new LinkedList<>();
			int[] rankings = new int[n];
			
			for (int i = 1; i <= n; i++) {
				if (indegree[i] == 0) {
					queue.add(i);
				}
			}
			
			int ans = NONE;
			for (int i = 0; i < n; i++) {
				if (queue.isEmpty()) {
					ans = IMPOSSIBLE;
					break;
				}
				if (queue.size() > 1) {
					ans = NOT_DETERMINED;
					break;
				}
				
				int u = queue.poll();
				rankings[i] = u;
				
				for (int j = 1; j < n + 1; j++) {
					if (graph[u][j] == 1) {
						indegree[j]--;
						
						if (indegree[j] == 0) queue.add(j);
					}
				}
			}
			
			if (ans == IMPOSSIBLE) {
				System.out.println("IMPOSSIBLE");
			} else if (ans == NOT_DETERMINED) {
				System.out.println("?");
			} else if (ans == NONE) {
				for (int rank : rankings) {
					System.out.print(rank + " ");
				}
				System.out.println();
			}
		}

	}

}
