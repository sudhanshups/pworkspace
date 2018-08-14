package com.javatpoint;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class EmployeeTest {
	public static void main(String[] args) {

		ApplicationContext context1 = new ClassPathXmlApplicationContext("EmployeeapplicationContext.xml");
		Address address = (Address) context1.getBean("a1");

		System.out.println(address.toString());

		Employee employee = (Employee) context1.getBean("e");
		employee.show();

		//----------------
		Resource r = new ClassPathResource("EmployeeapplicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		Employee s = (Employee) factory.getBean("e");
		s.show();
	}
}