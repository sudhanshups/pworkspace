package practice.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestHashMap {
	public static void main(String args[]) {
		Map<Integer, String> map = new HashMap<>();
		map.put(100, "Amit");
		map.put(101, "Vijay");
		map.put(102, "Rahul");
		for ( Entry m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}
}