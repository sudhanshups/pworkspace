package org.sssit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BTest {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("BapplicationContext.xml");
		A a = context.getBean("a", A.class);
		a.display();
	}

}