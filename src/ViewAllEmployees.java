import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.*;

public class ViewAllEmployees extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter pr = res.getWriter();
		List<Employee> employees = new ArrayList<Employee>();
		EmployeeDAO eDAO = new EmployeeDAO();
		employees = eDAO.getAllEmployees();
		pr.println("<a href = 'NewFile.html'>Add Employee</a>");
		pr.println("<h1>Employee List</h1>");
		pr.println("<table><tr><th>Id</th><th>Name</th><th>Password</th><th>Email Id</th><th>Country Name</th></tr>");
		for(Employee e : employees) {
			pr.println("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmailId()+"</td><td>"
					+ e.getCountryName()+"</td><td><a href='editEmployee?id="+e.getId()+"'>Edit</a></td><td><a href='deleteEmployee?id="+e.getId()+"'>Delete</a></td>");
		}
		pr.println("</table>");
	}
}
