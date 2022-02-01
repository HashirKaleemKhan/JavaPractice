package jdbcPractice;
import java.sql.*;
import java.util.Scanner;

public class DemoJdbc {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/student";
		String uname = "root";
		String pass = "sibi@soft";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Scanner sc=new Scanner(System.in);  
		System.out.print("Press 1 to view records"+ "\n" +"Press 2 to insert records"+ "\n" +"Press 3 to update records"+ "\n" +
									"Press 4 to delete records :");  
		
		int n= sc.nextInt(); 
		
		
			switch(n) {
			  case 1:
				  printRecords(con);
				  break;
			  case 2:
			      insertRecords(con);
			      break;
			  case 3:
				  updateRecords(con);
				  break;
			  case 4:
				  deleteRecords(con);
				   break;
			  default:
			    System.out.println("Enter correctly...");
			     
		}	

		
	}
	public static void printRecords(Connection con) throws Exception
	{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from students");
		while(rs.next())
		{
	            //System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+ rs.getInt(4));
				//OR
				int id = rs.getInt("id");
	            String name = rs.getString("fname");
	            String email = rs.getString("email");
	            int age = rs.getInt("age");
	            System.out.println(id + " " + name + " " + email+ " " + age);
		}
		
	}
	
	
	public static void insertRecords(Connection con) throws Exception
	{
		PreparedStatement stmt = con.prepareStatement("insert into students (fname, email, age) values (?,?,?)");  	
		stmt.setString(1, "Ishwar");
		stmt.setString(2,"ishwarlal@gmail.com");
		stmt.setInt(3,45);
		int i=stmt.executeUpdate();  
		System.out.println(i+" records inserted"+"\n"+"Updated Table is: "); 
		printRecords(con);
		
	}
	
	
	public static void updateRecords(Connection con) throws Exception
	{
		PreparedStatement stmt=con.prepareStatement("update students set fname=? where age=?");  
		stmt.setString(1,"Ilyas"); 
		stmt.setInt(2,45);  
		int i=stmt.executeUpdate();  
		System.out.println(i+" records updated"+"\n"+"Updated Table is: "); 
		printRecords(con);
		
	}
	
	public static void deleteRecords(Connection con) throws Exception
	{
		PreparedStatement stmt=con.prepareStatement("delete from students where fname=?");  
		stmt.setString(1,"Ilyas");  
		int i=stmt.executeUpdate();  
		System.out.println(i+" records deleted"+"\n"+"Updated Table is: "); 
		printRecords(con);
	}
}
