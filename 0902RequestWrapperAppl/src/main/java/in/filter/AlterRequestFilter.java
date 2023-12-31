package in.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import in.CustomisedRequest.CustomisedRequest;


@WebFilter("/test")
public class AlterRequestFilter extends HttpFilter implements Filter {
	
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("The control is in AlterRequestFilter");
		HttpServletRequest hreq = (HttpServletRequest) request;
		CustomisedRequest creq = new CustomisedRequest(hreq);
		chain.doFilter(creq, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
