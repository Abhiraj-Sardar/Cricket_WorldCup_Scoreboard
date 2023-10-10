import java.sql.*;
import java.util.*;
public class main {
public static void main(String args[]) throws Exception{
	Scanner sc = new Scanner(System.in);
	//1.Load Register and driver
	//name of the mysql driver
	Class.forName("com.mysql.cj.jdbc.Driver");
	//2.establish connection with the database
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","admin");
	//3.create the statement object
	Statement st =con.createStatement();
	boolean flag=true;
	while(flag)
	{
		System.out.println("Enter the choice: ");
		System.out.println("1.View The Scoreboard");
		System.out.println("2.Insert The new Record");
		System.out.println("3.Update The Record");
		System.out.println("2.Delete The  Record");
		System.out.println("5.Exit");
		
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			viewTable(st);
			break;
		case 2:
			//Insert
			insertTable(st,sc);
			break;
		case 3:
			updateTable(st,sc);
			break;
		case 4:
			deleteTable(st,sc);
			break;
		default:
			flag=false;
		}
	}
}
public static void viewTable(Statement st) throws Exception{
	String sql="select * from scoreboard;";
	ResultSet rs=st.executeQuery(sql);
	System.out.println("ID\t| NAME\t| RUNS\t| BALLS\t");
	while(rs.next()) {
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
	}
	System.out.println("---------------------------------");
}
public static void insertTable(Statement st,Scanner sc) throws Exception{
	System.out.println("Enter Id of the player:");
	int id=sc.nextInt();
	System.out.println("Enter Name of the player:");
	String name=sc.next();
	System.out.println("Enter Runs of the player:");
	int runs=sc.nextInt();
	System.out.println("In how many balls??:");
	int balls=sc.nextInt();
	
	String str="insert into scoreboard values("+id+",'"+name+"',"+runs+","+balls+")";
	int rows=st.executeUpdate(str);
	System.out.println(rows+" Row Inserted");
	System.out.println("---------------------------------");
}

public static void updateTable(Statement st,Scanner sc) throws Exception{
	System.out.println("Enter Id of the player:");
	int  id=sc.nextInt();
	System.out.println("Enter new Runs of the player:");
	int  runs=sc.nextInt();
	System.out.println("In how many balls??:");
	 int balls=sc.nextInt();
	
	String updatequery="Update scoreboard set runs="+runs+",balls="+balls+" where id="+id+"";
	int rows=st.executeUpdate(updatequery);
	System.out.println(rows+" Row Updated");
	System.out.println("---------------------------------");
}
public static void deleteTable(Statement st,Scanner sc) throws Exception{
	System.out.println("Enter Id of the player:");
	int id=sc.nextInt();
	String deletequery="delete from scoreboard where id="+id+"";
	int rows=st.executeUpdate(deletequery);
	System.out.println(rows+" Row deleted");
	System.out.println("---------------------------------");
}

}
