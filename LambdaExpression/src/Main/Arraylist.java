package Main;

import java.util.ArrayList;
import java.util.List;

public class Arraylist {
	public static void main(String[] args) {
		List<Integer> lists = new ArrayList<>();
		lists.add(8);
		lists.add(9);
		lists.add(12);
		
			lists.forEach(n -> System.out.println(n));
			lists.forEach(n ->{if (n%2==0) System.out.println(n);});
	}
	
}
