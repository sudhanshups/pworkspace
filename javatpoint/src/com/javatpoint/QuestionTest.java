package com.javatpoint;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class QuestionTest {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("QuestionapplicationContext.xml");

		Question q = (Question) context.getBean("q");
		q.displayInfo();

	// Another way ---------------------
		Resource r = new ClassPathResource("QuestionapplicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		q = (Question) factory.getBean("q");
		q.displayInfo();

	}
}