package pro2;

import java.util.*;

public class ex3_4 {
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		while(n != 1) {
			if (n % k == 0) {
				n /= k;
				count++;
			} else {
				n--;
				count++;
			}
		}
		System.out.println(count);
	}

}
