package com.javatpoint;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
	public static void main(String[] args) {
		ApplicationContext context1 = new ClassPathXmlApplicationContext("StudentapplicationContext.xml");
		Student student1 = (Student) context1.getBean("studentbean");
		student1.displayInfo();

		Resource resource = new ClassPathResource("StudentapplicationContext.xml");
		@SuppressWarnings("deprecation")
		BeanFactory factory = new XmlBeanFactory(resource);

		Student student = (Student) factory.getBean("studentbean");
		student.displayInfo();
	}
}