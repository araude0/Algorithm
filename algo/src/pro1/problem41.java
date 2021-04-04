package pro1;

import java.util.*;

public class problem41 {
	public static int n, m;
	public static int[] parent = new int[501];
	
	public static int findParent(int x) {
		if (x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int x = sc.nextInt();
				if (x == 1) {
					unionParent(i + 1, j + 1);
				}
			}
		}
		
		ArrayList<Integer> plan = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			plan.add(sc.nextInt());
		}
		
		boolean result = true;
		for (int i = 0; i < m - 1; i++) {
			if (findParent(plan.get(i)) != findParent(plan.get(i + 1))) {
				result = false;
			}
		}
		
		if (result) System.out.println("YES");
		else System.out.println("NO");
	}

}
