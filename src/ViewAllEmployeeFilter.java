import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ViewAllEmployeeFilter implements Filter{
	FilterConfig config;
	
	public void init(FilterConfig config) {
		this.config = config;
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		PrintWriter pr = res.getWriter();
		HttpServletRequest requ = (HttpServletRequest)req;
		HttpServletResponse resp = (HttpServletResponse)res;
		
		HttpSession session = requ.getSession(false);
		if(session == null) {
			pr.println("<h1>Log In</h1>");
			pr.println("<form action = 'logIn' method = 'post'>");
			pr.println("<table>");
			pr.println("<tr><th>Username: </th><td><input type = 'text' name = 'userName'/></td></tr>'");
			pr.println("<tr><th>Password: </th><td><input type = 'text' name = 'password'/></td></tr>'");
			pr.println("</table>");
			pr.println("<button type = 'submit'>Log In</button>");
			pr.println("</form>");
		}
		
		if(session.getAttribute("userName").equals("jayparekh0408")){
			chain.doFilter(req, res);
		}
		
		else {
			pr.println("you are not authorised to edit");
		}
		
		System.out.println(config.getInitParameter("FilterFor"));
	}
	
}
