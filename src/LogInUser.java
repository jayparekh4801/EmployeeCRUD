import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogInUser extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter pr = res.getWriter();
		HttpSession session = req.getSession();
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		session.setAttribute("userName", userName);
		session.setAttribute("password", password);
		pr.println("<a href = 'viewEmployees'>View Employess</a>");
		pr.println("<h4>logged in succesfully</h4>");
		
		
	}
}
