import java.sql.*;
import java.util.*;
public class main {
public static void main(String args[]) throws Exception{
	Scanner sc = new Scanner(System.in);
	//1.Load Register and driver
	//name of the mysql driver
	Class.forName("com.mysql.cj.jdbc.Driver");
	//establish connection with the database
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","admin");
	
}
}
