package com.example;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MainApp {
   public static void main(String[] args) {
      
	ApplicationContext context = 
             new ClassPathXmlApplicationContext("Beans.xml");
      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
      obj.getMessage();

/*  ClassPathResource  context1 = new ClassPathResource("Beans.xml");  
	  @SuppressWarnings("deprecation")
      BeanFactory factory=new XmlBeanFactory(context1);
	   
      HelloWorld obj1 = (HelloWorld) factory.getBean("helloWorld");
      System.out.println("Sudhanshu");
      obj1.getMessage();
 */

   }
}