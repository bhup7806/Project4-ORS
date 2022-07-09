package in.co.rays.project4.Ctl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.project4.util.ServletUtility;


/**
 * @author bhupendra
 *
 */
@WebFilter(urlPatterns={"/ctl/*","/doc/*"})
public class FrontController implements Filter {
	
	public void destory() {
		
	}
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
HttpServletRequest request=(HttpServletRequest)req;
HttpServletResponse response=(HttpServletResponse)resp;

HttpSession session=request.getSession(true);

String uri=request.getRequestURI();
request.setAttribute("uri", uri);

if(session.getAttribute("user")==null) {
	request.setAttribute("msg","your session has been expired.please re-login. ");
	ServletUtility.forward(ORSView.LOGIN_VIEW,request,response);
}else{
	chain.doFilter(req, resp);
}

}

public void init(FilterConfig conf) {

}

}

