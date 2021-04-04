package pro1;

import java.util.*;

class Point {
	int num, x, y, z;
	
	Point(int num, int x, int y, int z) {
		this.num = num;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

class Edge44 implements Comparable<Edge44> {
	int start, end, weight;
	
	Edge44(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge44 other) {
		return this.weight - other.weight;
	}
}

public class problem44 {
	static int n;
	static int[] parent = new int[100001];
	static ArrayList<Edge44> edges = new ArrayList<>();
	
	public static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			points[i] = new Point(i, x, y, z);
		}

		Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
		for (int i = 0; i < n - 1; i++) {
			int weight = Math.abs(points[i].x - points[i + 1].x);
			edges.add(new Edge44(points[i].num, points[i + 1].num, weight));
		}
		
		Arrays.sort(points, (p1, p2) -> p1.y - p2.y);
		for (int i = 0; i < n - 1; i++) {
			int weight = Math.abs(points[i].y - points[i + 1].y);
			edges.add(new Edge44(points[i].num, points[i + 1].num, weight));
		}
		
		Arrays.sort(points, (p1, p2) -> p1.z - p2.z);
		for (int i = 0; i < n - 1; i++) {
			int weight = Math.abs(points[i].z - points[i + 1].z);
			edges.add(new Edge44(points[i].num, points[i + 1].num, weight));
		}
		
		Collections.sort(edges);
		
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		int result = 0;
		for (int i = 0; i < edges.size(); i++) {
			Edge44 edge = edges.get(i);
			
			if (find(edge.start) != find(edge.end)) {
				result += edge.weight;
				union(edge.start, edge.end);
			}
		}
		System.out.println(result);
	}

}
