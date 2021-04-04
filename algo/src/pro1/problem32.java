package pro1;

import java.util.Scanner;

public class problem32 {
	static int n;
	static int[][] dp = new int[500][500];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				dp[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				int up, upleft;
				if (j == 0) upleft = 0;
				else upleft = dp[i - 1][j - 1];
				if (j == i) up = 0;
				else up = dp[i - 1][j];
				dp[i][j] += Math.max(up, upleft);
			}
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp[n - 1][i]);
		}
		System.out.println(result);
	}

}
