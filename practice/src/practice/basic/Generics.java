package practice.basic;

import java.util.*;

class MyGen<T> {
	T obj;

	void add(T obj) {
		this.obj = obj;
	}

	T get() {
		return obj;
	}
}
/*
 * T - Type E - Element K - Key N - Number V - Value
 */

public class Generics {
	public static void main(String[] args) {
		MyGen<Integer> m = new MyGen<Integer>();
		m.add(2);
		// m.add("vivek");//Compile time error
		System.out.println(m.get());

		MyGen<String> n = new MyGen<String>();
		n.add("sudhanshu");
		// m.add("vivek");//Compile time error
		System.out.println(n.get());

		Integer[] intArray = { 10, 20, 30, 40, 50 };
		Character[] charArray = { 'J', 'A', 'V', 'A', 'T', 'P', 'O', 'I', 'N', 'T' };

		System.out.println("Printing Integer Array");
		printArray(intArray);

		System.out.println("Printing Character Array");
		printArray(charArray);
	}

	public static <E> void printArray(E[] elements) {
		for (E element : elements) {
			System.out.println(element);
		}
		System.out.println();
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
class RandomizedSet {
	Map<Integer, Integer> map;
	List<Integer> vals;
	/** Initialize your data structure here. */
	public RandomizedSet() {
		map = new HashMap<>();
		vals = new ArrayList<>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		map.put(val, vals.size());
		vals.add(val);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int last = vals.get(vals.size() - 1);
		vals.set(map.get(val), last);
		map.put(last, map.get(val));
		map.remove(val);
		vals.remove(vals.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		Random rand = new Random();
		int r = rand.nextInt(vals.size());
		return vals.get(r);
	}
}


