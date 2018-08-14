package demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class MyWebAppListener implements ServletContextListener, HttpSessionListener {

  
    public MyWebAppListener() {
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
    System.out.println("Deployed : "+servletContextEvent.getServletContext().getContextPath());
    }
    
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
     System.out.println("UnDeployed : "+servletContextEvent.getServletContext().getContextPath());
    }

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
     System.out.println("Deployed : "+httpSessionEvent.getSession().getId());
    	   
    }


    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
    System.out.println("UnDeployed : "+httpSessionEvent.getSession().getId());
    }
    
}
