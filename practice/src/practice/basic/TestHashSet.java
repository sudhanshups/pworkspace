package practice.basic;

import java.util.*;

public class TestHashSet {
	public static void main(String args[]) {
		// Creating HashSet and adding elements
		Set<String> set = new HashSet<>();
		set.add("Ravi");
		set.add("Vijay");
		set.add("Ravi");
		set.add("Ajay");
//		 Traversing elements
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		LinkedHashSet<String> set1 = new LinkedHashSet<>();
		set1.add("Ajay");
		set1.add("Ravi");
		set1.add("Vijay");
		set1.add("Ravi");
		Iterator<String> itr1 = set1.iterator();
		System.out.println("===============");

		while (itr1.hasNext()) {
			System.out.println(itr1.next());
		}
		System.out.println("===============");

		Set<String> set2 = new TreeSet<>();
		set2.add("Ajay");
		set2.add("Ravi");
		set2.add("Vijay");
		set2.add("Ravi");
		Iterator<String> itr2 = set2.iterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}
	}
}