package com.learning.JDBC;

import java.sql.Connection;        // ✅ Correct import
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* Register driver class
 * Create a connection
 * Create a statement/preparedStatement
 * execute query
 * read data using resultSet
 * 
 */
class DbConfig{
	private static final String url="jdbc:mysql://localhost:3306/jdbc_session";
	private static final String username="root";
	private static final String password="yashu123";
	private static Connection con=null;
	public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
//		load driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		if(con==null) {
			con=(Connection) DriverManager.getConnection(url,username,password);
		}
		return con;
	}
	public static void createTable() throws ClassNotFoundException, SQLException {
		String query="Create table employee(empId int(20) primary key,empName varchar(20) not null,deptName varchar(20) not null);";
		Statement st=getDbConnection().createStatement();
		st.execute(query);
		System.out.println("Table Created..!!");
				
				
	}
	public static String addEmployee() throws ClassNotFoundException, SQLException {
		String query="insert into employee values(2,'yash','tester');";
		Statement st=getDbConnection().createStatement();
		int row=st.executeUpdate(query);
		if(row>0) {
			return "Employee added";
		}
		return "Insertion failed";
	}
	public static void readEmployee() throws ClassNotFoundException, SQLException {
		String query="select * from employee;";
		Statement st=getDbConnection().createStatement();
		ResultSet result=st.executeQuery(query);
		while(result.next()) {
			System.out.println("Employee ID:-"+result.getInt(1));
			System.out.println("Employee Name:-"+result.getString(2));
			System.out.println("Employee ID:-"+result.getString(3));
			System.out.println("_______________________________");
			
		}
	}
	public static void readEmployeeById(int id) throws ClassNotFoundException, SQLException {
		String query="select * from employee where empId="+id;
		Statement st=getDbConnection().createStatement();
		ResultSet result=st.executeQuery(query);
		if(result.next()) {
			System.out.println("Employee ID:-"+result.getInt(1));
			System.out.println("Employee Name:-"+result.getString(2));
			System.out.println("Employee ID:-"+result.getString(3));
			System.out.println("_______________________________");
		}
	}
}
public class Test1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		DbConfig.createTable();
//		System.out.println(DbConfig.addEmployee());
//		DbConfig.readEmployee();
		DbConfig.readEmployeeById(1);
		

	}

}
