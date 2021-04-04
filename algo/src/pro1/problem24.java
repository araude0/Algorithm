package pro1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class problem24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			array.add(sc.nextInt());
		}
		
		Collections.sort(array);
		
		System.out.println(array.get((n - 1) / 2));
	}

}
