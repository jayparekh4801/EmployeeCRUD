import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditEmployee extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter pr = res.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		Employee emp = EmployeeDAO.getEmployee(id);
		pr.println("<h1>Update Employee</h1>");
		pr.println("<form action = 'saveEditEmployee' method = 'post'>");
		pr.println("<table>");
		pr.println("<tr><td><input type = 'hidden' name = 'id' value = '" + emp.getId() + "'/></td></tr>");
		pr.println("<tr><th>Name : </th><td><input type = 'text' name = 'name' value = '" + emp.getName() + "'/></td></tr>");
		pr.println("<tr><th>EmailId : </th><td><input type = 'text' name = 'emailId' value = '" + emp.getEmailId() + "'/></td></tr>");
		pr.println("<tr><th>Country : </th><td><input type = 'text' name = 'country' value = '" + emp.getCountryName() + "'/></td></tr>");
		pr.println("<tr><th>Password : </th><td><input type = 'password' name = 'password' value = '" + emp.getPassword() + "'/></td></tr>");
		pr.println("<tr><td><button type = 'submit'>EDIT AND SAVE</button></td></tr>");
		pr.println("</table>");
		pr.println("</form>");
		
	}	
}
