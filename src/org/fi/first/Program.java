package org.fi.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program
{

	public static void main(String[] args)
	{
		//1. Declare all variables required for connection
		Connection connection = null;
		Statement stSelect = null;
		ResultSet result = null;
		
		//2. Load to the database driver into memory
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			// The above is also responsible for registering itself with the Driver manager
			
			//3. Establish a connection using DriverManager
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdacdelhi","root","cdac");
			
			//4. Create a statement that will allow me to fire queries
			stSelect = connection.createStatement();
			result = stSelect.executeQuery("select * from harshal0027");
			// result = stSelect.executeQuery("select * from  users_0044 where username='cdac' ");
			
			//5. Iterate over the result generated to display the data
			while(result.next()) {
				System.out.println(result.getString("username"));
				System.out.println(result.getString("password"));
				System.out.println(result.getString(3));
				System.out.println(result.getString(4));
				System.out.println("----------------------------");
			}
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try
			{
				if(result!=null)
				{
					result.close();
				}
				if(stSelect!=null)
				{
					stSelect.close();
				}
				if(connection!=null)
				{
					connection.close();
				}
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//6. Close the connection and other resources
		
	}

}