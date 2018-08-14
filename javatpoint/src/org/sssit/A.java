package org.sssit;

public class A {
	B b;

	A() {
		System.out.println("a is created");
	}

	public B getB1() {
		return b;
	}

	public void setB1(B b) {
		this.b = b;
	}

	void print() {
		System.out.println("hello a");
	}

	void display() {
		print();
		b.print();
	}
}