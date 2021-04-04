package pro2;

import java.util.*;

class Student implements Comparable<Student> {
	public String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public int compareTo(Student other) {
		return this.score - other.score;
	}
	
	
	
}

public class ex6_3 {
	public static ArrayList<Student> s = new ArrayList<>(); 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			int score = sc.nextInt();
			s.add(new Student(name, score));
		}
		
		Collections.sort(s);
		
		for (int i = 0; i < s.size(); i++) {
			System.out.print(s.get(i).name + " ");
		}
		
	}

}
