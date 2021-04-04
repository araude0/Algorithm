package pro1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ���̷��� ������ �����ϰ� ��ȣ�� ������ ���� Ŭ���� ����
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

	// ���� ��ȣ ���� �� (��������)
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
				
				// �ش� ��ġ�� ���̷����� ���� ���
				if (graph[i][j] != 0) {
					// ���̷��� ����, �ð�, x, y ����
					viruses.add(new Virus(graph[i][j], 0, i, j));
				}
			}
		}
		
		// ���� ���� ť�� �ű��
		Collections.sort(viruses);
		Queue<Virus> q = new LinkedList<Virus>();
		for (int i = 0; i < viruses.size(); i++) {
			q.offer(viruses.get(i));
		}
		
		int targetS = sc.nextInt();
		int targetX = sc.nextInt();
		int targetY = sc.nextInt();
		
		// BFS ����
		while(!q.isEmpty()) {
			Virus virus = q.poll();
			// ��Ȯ�� s�ʰ� �ǰų� ť�� �� ������ �ݺ�
			if (virus.getSecond() == targetS) break;
			
			// �����¿� Ȯ��
			for (int i = 0; i < 4; i++) {
				int nx = virus.getX() + dx[i];
				int ny = virus.getY() + dy[i];
				
				// �ش� ��ġ�� �̵� ������ ���
				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					// ���� �湮���� ���� ��ġ�� ���̷��� �ְ� ť�� ����
					if (graph[nx][ny] == 0) {
						graph[nx][ny] = virus.getIndex();
						q.offer(new Virus(graph[nx][ny], virus.getSecond() + 1, nx, ny));
					}
				}
			}
		}
		
		// �������� (1, 1)���� ���������� graph�� (0, 0)�����̹Ƿ� 1�� ���ش�
		System.out.println(graph[targetX - 1][targetY - 1]);
	}

}
