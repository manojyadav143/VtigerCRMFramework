package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;




public class ReadDataFromDataBase 
{
public static void main(String[] args) throws SQLException
{
//step 1: create an instance for driver
	// Driver should be imported from com.mysql.cj.jdbc.driver
	//new Driver() throws sql exception
	Driver dbDriver = new Driver();
	
	//step 2:Register to the dbdriver
	//DriverManager is in java.sqlpackage
	DriverManager.registerDriver(dbDriver);
	 
	//step 3:establish database connection
	//statement should be imported from java.sql package
	Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/manoj","root","root");
	
	//step 4:create statement 
	//statement should be imported from java.sql package
	Statement statement=connect.createStatement();
	
	//step 5:create Execute query to fetch the data
	int result= statement .executeUpdate("insert into students(id,name,address) values (104,'Def','Bangalore');");
	ResultSet result1 = statement.executeQuery("select * from students;");
	if(result==1)
	{
		System.out.println("DB Updated successfully");
	}
	else
	{
		System.out.println("DB not Updated ");
	}
	while(result1.next())
	{
		System.out.println(result1.getInt("id")+"\t"+result1.getString("name")+"\t"+result1.getString("address"));
	}
	//step 6:close database
	connect.close();
}

}
