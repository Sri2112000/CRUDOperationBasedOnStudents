package com.techpalle;
import java.sql.*;

public class Test 
{
	
	private static final String url="jdbc:mysql://localhost:3306/jdbc";
	private static final String username="root";
	private static final String password="admin";
	
	private static Connection con=null;
	private static Statement s=null;
	private static PreparedStatement ps=null;
	
    public static void create()
    {
    	try 
    	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			s=con.createStatement();
		
			s.executeUpdate("create table Employee(eno int primary key,ename varchar(40),esal int)");
		}
    	catch(ClassNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	catch (SQLException e) 
    	{
			System.out.println("table already exist plz  enter different number");
		} 
    	
    	finally
    	{
    		try
    		{
    		if(s!=null)
    			s.close();
    		if(con!=null)
    			con.close();
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    		}
    		
    	}
    	
    }
    public static void insert(int no,String name,int sal)
    {
    	try 
    	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			ps=con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1, no);
			ps.setString(2, name);
			ps.setInt(3, sal);
			ps.executeUpdate();
		}
    	catch(ClassNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	catch (SQLException e) 
    	{
			System.out.println("i have given pk please enter serial number");
		} 
    	
    	finally
    	{
    		try
    		{
    		if(s!=null)
    			s.close();
    		if(con!=null)
    			con.close();
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    		}
    		
    	}
    	
    }
    public static void update(int no,int sal) 
    {
    	try 
    	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			ps=con.prepareStatement("update employee set esal=? where eno=?");
			ps.setInt(1, sal);
			ps.setInt(2, no);
			ps.executeUpdate();
		}
    	catch(ClassNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	catch (SQLException e) 
    	{
			System.out.println("plz enter valid eno");
		} 
    	
    	finally
    	{
    		try
    		{
    		if(s!=null)
    			s.close();
    		if(con!=null)
    			con.close();
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    		}
    		
    	}
    	
    }
    public static void delete(int no)
    {
    	try 
    	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			
	        ps=con.prepareStatement("delete from employee where eno=?");
	        ps.setInt(1,no);
			ps.executeUpdate();
		}
    	catch(ClassNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	catch (SQLException e) 
    	{
			System.out.println("plrase enter valid eno");
		} 
    	
    	finally
    	{
    		try
    		{
    		if(s!=null)
    			s.close();
    		if(con!=null)
    			con.close();
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    		}
    		
    	}
    	
    }
}
