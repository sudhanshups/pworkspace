package practice;
import java.util.*;

public class TestArrayList {
	public static void main(String args[]) {

		// public class ArrayList<E> extends AbstractList<E> implements List<E>,
		// RandomAccess, Cloneable, Serializable

		List<String> lt = new ArrayList<>();
		lt.add("Ravi");// Adding object in arraylist
		lt.add("Vijay");
		lt.add("Ravi");
		lt.add("Ajay");

		// Traversing list through Iterator
		Iterator itr = lt.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		for (String obj : lt)
			System.out.println(obj);

		LinkedList<String> al = new LinkedList<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ravi");
		al.add("Ajay");

		Iterator<String> itr1 = al.iterator();
		while (itr1.hasNext()) {
			System.out.println(itr1.next());
		}
	}
}