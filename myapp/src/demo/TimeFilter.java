package demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


public class TimeFilter implements Filter {

    private FilterConfig config=null;
	
	public void init(FilterConfig fConfig) throws ServletException {
	this.config=config;
	}

    public TimeFilter() {
    }

	public void destroy() {
		config=null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	long t1=System.currentTimeMillis();
	chain.doFilter(request, response);
	long t2=System.currentTimeMillis();
	HttpServletRequest httpRequest=(HttpServletRequest)request;
	String myURI=httpRequest.getRequestURI();
	System.out.println(myURI +": " +(t2-t1));
	
	}


}
