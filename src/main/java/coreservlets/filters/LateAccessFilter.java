package coreservlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LateAccessFilter implements Filter {
	
	private ServletContext servletContext = null;
	
	private String filterName = null;
	
	private int startTime = 0;
	
	private int endTime = 0;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		servletContext.log("filterName:" + filterName + " startTime=" + startTime + "endTime:" + endTime);
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.servletContext = filterConfig.getServletContext();
		this.filterName = filterConfig.getFilterName();
		try {
			this.startTime = Integer.parseInt(filterConfig.getInitParameter("startTime"));
			this.endTime = Integer.parseInt(filterConfig.getInitParameter("endTime"));
		} catch(NumberFormatException e) {
			this.startTime = 22;
			this.endTime = 6;
		}
	}

	
	
	
}
