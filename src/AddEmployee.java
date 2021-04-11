import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddEmployee extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter pr = res.getWriter();
		Employee emp = new Employee();
		emp.setName(req.getParameter("name"));
		emp.setEmailId(req.getParameter("emailId"));
		emp.setCountryName(req.getParameter("country"));
		emp.setPassword(req.getParameter("password"));
		EmployeeDAO eDAO = new EmployeeDAO();
		if(eDAO.saveEmployee(emp)) {
			req.getRequestDispatcher("NewFile.html").include(req, res);
			pr.println("Employee Saved Succesfully");

		}
		else {
			pr.println("Employee Is Not Saved");
			req.getRequestDispatcher("NewFile.html");
		}
	}
	
}
