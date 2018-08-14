package practice;

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
