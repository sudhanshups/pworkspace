package practice;

//A Java program with overloaded main()
import java.io.*;

public class javaBasic2 {

	// Normal main()
	public static void main(String[] args) {
		System.out.println("Hi Geek (from main)");
		javaBasic2.main("Geek");
	}

	// Overloaded main methods
	public static void main(String arg1) {
		System.out.println("Hi, " + arg1);
		javaBasic2.main("Dear Geek", "My Geek");
	}

	public static void main(String arg1, String arg2) {
		System.out.println("Hi, " + arg1 + ", " + arg2);
		Boolean a = true;
		boolean b = true;
		if(a==b){
			System.out.println("Hi, true");
			System.out.println(a.getClass() + "  ");
		}
	}
}