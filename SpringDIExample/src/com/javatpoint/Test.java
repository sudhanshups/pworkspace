package com.javatpoint;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		Student student = (Student) factory.getBean("studentbean");
		student.displayInfo();
		
		Student sb1 = (Student) factory.getBean("sb1"); //name constructor
		sb1.display();
		
		Student sb2 = (Student) factory.getBean("sb2");//name constructor
		sb2.display();
		
		Student sb3 = (Student) factory.getBean("sb3"); //roll constructor
		sb3.display();
		
		Student sb4 = (Student) factory.getBean("sb4"); //roll and name  constructor
		sb4.display();
		
		Student sb5 = (Student) factory.getBean("sb5"); //name, roll and subject constructor
		sb5.display();
		
		Student sb6 = (Student) factory.getBean("sb6"); //Using properties of parent bean
		sb6.display();
		
		Student sb7 = (Student) factory.getBean("sb7"); //name, roll and subject constructor
		sb7.display();
		
		Subject s = (Subject) factory.getBean("subj");
		s.sayHi();
		System.out.println(s.getSubject());
	}
}