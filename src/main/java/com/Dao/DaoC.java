package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Emp;

public class DaoC{
	
	public int insertdata(Emp e) {
		int status = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","root");
			PreparedStatement ps = con.prepareStatement("insert into employee(name,email,address,city) values(?,?,?,?)");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getAddress());
			ps.setString(4, e.getCity());

			status = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	
	public static List<Emp> getAllEmployees() {
		List<Emp> list = new ArrayList<Emp>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","root");
			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setAddress(rs.getString(4));
				e.setCity(rs.getString(5));
				list.add(e);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		return list;
	}
	
	public static int delete(int id) {
		 int status=0;  
	        try{  
	        	Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","root"); 
	            PreparedStatement ps=con.prepareStatement("delete from employee where id=?");  
	            ps.setInt(1,id);  	
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
		
	}
	
	public static Emp getEmployeeById(int id){
		   Emp e=new Emp();  
	          
	        try{  
	        	Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","root");
	            PreparedStatement ps=con.prepareStatement("select * from employee where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                
	                e.setEmail(rs.getString(3));  
	                e.setAddress(rs.getString(4));
	                e.setCity(rs.getString(5));
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	}
	
	public static int update(Emp e) {
		int status=0;  
        try{  
        	Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","root");
            PreparedStatement ps=con.prepareStatement("update employee set name=?,email=?,address=?,city=? where id=?");  
            ps.setString(1,e.getName());      
            ps.setString(2,e.getEmail());  
            ps.setString(3,e.getAddress());
            ps.setString(4, e.getCity());
            ps.setInt(5,e.getId());
            
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
	}

	
}
