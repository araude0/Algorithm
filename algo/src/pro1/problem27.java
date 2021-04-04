package pro1;

import java.util.*;

public class problem27 {
	public static int lowerbound(int[] arr, int target, int start, int end) {
		while(start < end) {
			int mid = (start + end) / 2;
			if (arr[mid] >= target) end = mid;
			else start = mid + 1;
		}
		return end;
	}
	
	public static int upperbound(int[] arr, int target, int start, int end) {
		while(start < end) {
			int mid = (start + end) / 2;
			if (arr[mid] > target) end = mid;
			else start = mid + 1;
		}
		return end;
	}
	
	public static int countByRange(int[] arr, int leftValue, int rightValue) {
		int leftIndex = lowerbound(arr, leftValue, 0, arr.length);
		int rightIndex = upperbound(arr, rightValue, 0, arr.length);
		
		return rightIndex - leftIndex;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt = countByRange(arr, x, x);
		
		if (cnt == 0) System.out.println(-1);
		else System.out.println(cnt);
	}

}
