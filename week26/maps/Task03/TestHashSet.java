package maps.Task03;

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Francisco");
		set.add("Beijing assert ");
		set.add("New York");
		set.add("Paris");
		// true
		/*
		* assert
		*
		* */
		System.out.println(set);
		
		for(String s: set) {
			System.out.print(s.toUpperCase() + " ");
		}
	}

}
