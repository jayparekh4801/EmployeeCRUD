import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditSaveEmployee extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter pr = res.getWriter();
		Employee emp = new Employee();
		emp.setName(req.getParameter("name"));
		emp.setCountryName(req.getParameter("country"));
		emp.setEmailId(req.getParameter("emailId"));
		emp.setPassword(req.getParameter("password"));
		emp.setId(Integer.parseInt(req.getParameter("id")));
		EmployeeDAO eDAO = new EmployeeDAO();
		if(eDAO.updateEmployee(emp)) {
			res.sendRedirect("viewEmployees");
		}
		else {
			pr.println("Employee is not Updated");
		}
	}
}
