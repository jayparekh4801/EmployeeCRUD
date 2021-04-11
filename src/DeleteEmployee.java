import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteEmployee extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter pr = res.getWriter();
		EmployeeDAO eDAO = new EmployeeDAO();
		int id = Integer.parseInt(req.getParameter("id"));
		if(eDAO.deleteEmployee(id) > 0) {
			pr.println("EMployee Deleted");
			res.sendRedirect("viewEmployees");
		}
	}
}
