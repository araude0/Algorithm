package pro1;

import java.util.ArrayList;
import java.util.Scanner;

class Combination {
	private int n;
	private int r;
	private int[] now;
	private ArrayList<ArrayList<PositionS>> result;
	
	public Combination(int n, int r) {
		this.n = n;
		this.r = r;
		now = new int[r];
		result = new ArrayList<ArrayList<PositionS>>();
	}
	
	public ArrayList<ArrayList<PositionS>> getResult() {
		return result;
	}
	
	public void combination(ArrayList<PositionS> arr, int depth, int index, int target) {
		if (depth == r) {
			ArrayList<PositionS> temp = new ArrayList<PositionS>();
			for (int i = 0; i < now.length; i++) {
				temp.add(arr.get(now[i]));
			}
			result.add(temp);
			return;
		}
		
		if (target == n) return;
		now[index] = target;
		combination(arr, depth + 1, index + 1, target + 1);
		combination(arr, depth, index, target + 1);
	}
}

class PositionS {
	private int x;
	private int y;
	
	public PositionS(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}

public class program20 {
	public static int n;
	public static char[][] board = new char[6][6];
	public static ArrayList<PositionS> teacher = new ArrayList<>();
	public static ArrayList<PositionS> spaces = new ArrayList<>();
	
	public static boolean watch(int x, int y, int direction) {
		if (direction == 0) {
			while (y >= 0) {
				if (board[x][y] == 'S') {
					return true;
				}
				if (board[x][y] == 'O') {
					return false;
				}
				y -= 1;
			}
		}
		if (direction == 1) {
			while (y < n) {
				if (board[x][y] == 'S') {
					return true;
				}
				if (board[x][y] == 'O') {
					return false;
				}
				y += 1;
			}
		}
		if (direction == 2) {
			while (x >= 0) {
				if (board[x][y] == 'S') {
					return true;
				}
				if (board[x][y] == 'O') {
					return false;
				}
				x -= 1;
			}
		}
		if (direction == 3) {
			while (x < 0) {
				if (board[x][y] == 'S') {
					return true;
				}
				if (board[x][y] == 'O') {
					return false;
				}
				x += 1;
			}
		}
		return false;
	}

	public static boolean process() {
		for (int i = 0; i < teacher.size(); i++) {
			int x = teacher.get(i).getX();
			int y = teacher.get(i).getY();
			
			for (int j = 0; j < 4; j++) {
				if (watch(x, y, j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.next().charAt(0);
				if (board[i][j] == 'T') {
					teacher.add(new PositionS(i, j));
				}
				if (board[i][j] == 'X') {
					spaces.add(new PositionS(i, j));
				}
			}
		}
		
		Combination comb = new Combination(spaces.size(), 3);
		comb.combination(spaces, 0, 0, 0);
		ArrayList<ArrayList<PositionS>> spaceList = comb.getResult();
		
		boolean found = false;
		for (int i = 0; i < spaceList.size(); i++) {
			for (int j = 0; j < spaceList.get(i).size(); j++) {
				int x = spaceList.get(i).get(j).getX();
				int y = spaceList.get(i).get(j).getY();
				board[x][y] = 'O';
			}
		
			if (!process()) {
				found = true;
				break;
			}

			for (int j = 0; j < spaceList.get(i).size(); j++) {
				int x = spaceList.get(i).get(j).getX();
				int y = spaceList.get(i).get(j).getY();
				board[x][y] = 'X';
			}
		}
		
		if (found) System.out.println("YES");
		else System.out.println("NO");
	}
}
