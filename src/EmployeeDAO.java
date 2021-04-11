import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	private static Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/Company";
		String user = "root";
		String password = "vnhmhJi#7ms";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public boolean saveEmployee(Employee emp){
		Connection con = getConnection();
		boolean saveStatus = false;
		String query = "insert into EMPS(Name, Password, EmailId, country) values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getPassword());
			ps.setString(3, emp.getEmailId());
			ps.setString(4, emp.getCountryName());
			saveStatus = !ps.execute();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return saveStatus;
		
	}
	
	public boolean updateEmployee(Employee emp) {
		Connection con = getConnection();
		boolean updateStatus = false;
		String query = "update EMPS set Name = ?, Password = ?, EmailId = ?, country = ? where Id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getPassword());
			ps.setString(3, emp.getEmailId());
			ps.setString(4, emp.getCountryName());
			ps.setInt(5, emp.getId());
			updateStatus = !ps.execute();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return updateStatus;
	}
	
	public int deleteEmployee(int id) {
		Connection con = getConnection();
		int deleteStatus = 0;
		String query = "delete from EMPS where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			deleteStatus = ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return deleteStatus;
	}
	
	public static Employee getEmployee(int id) {
		Connection con = getConnection();
		String query = "select * from EMPS where id = ?";
		Employee emp = new Employee();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			emp.setId(rs.getInt("Id"));
			emp.setName(rs.getString("Name"));
			emp.setEmailId(rs.getString("EmailId"));
			emp.setCountryName(rs.getString("country"));
			emp.setPassword(rs.getString("Password"));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}
	
	public static List<Employee> getAllEmployees() {
		Connection con = getConnection();
		List<Employee> employees = new ArrayList<Employee> ();
		String query = "select * from EMPS";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("Id"));
				emp.setName(rs.getString("Name"));
				emp.setEmailId(rs.getString("EmailId"));
				emp.setCountryName(rs.getString("country"));
				emp.setPassword(rs.getString("Password"));
				employees.add(emp);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		return employees;
		
	}

}
