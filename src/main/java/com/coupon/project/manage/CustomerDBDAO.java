package com.coupon.project.manage;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDBDAO implements  CustomerDAO{
    @Override
    public boolean isCustomerExists(String email, String password) {
        return false;
    }

    @Override
    public void addCustomer(Customer customer) throws Exception {
conn con=new conn();
    	
    	String q="insert into CUSTOMERS values(0,'"+customer.getFirstName()+"','"+customer.getLastName()+"','"+customer.getEmail()+"','"+customer.getPassword()+"')";
    	con.stmt.executeUpdate(q);
    	System.out.println("Customer  Successfully Added");
    }

    @Override
    public void updateCustomer(Customer customer) throws Exception {
    	conn con=new conn();
    	String q="update  CUSTOMERS set First_Name='"+customer.getFirstName()+"',Last_Name='"+customer.getLastName()+"', Email='"+customer.getEmail()+"' , Password='"+customer.getPassword()+"' where id="+customer.getId()+"";

    			con.stmt.executeUpdate(q);
    	System.out.print("Customer Successfully Update");
    			
    }

    @Override
    public void deleteCustomer(int customerId) throws Exception{

    	conn con=new conn();
     	String q="delete  CUSTOMERS where id='"+customerId+"'";
     	con.stmt.executeUpdate(q);
     	System.out.print("Customer Successfully Deleted");
    }

    @Override
    public ArrayList<Customer> getAllCustomer() throws Exception{
    	conn con=new conn();
    	ArrayList<Customer> arr=new ArrayList<>();
    	String q="select * from CUSTOMERS";
    	ResultSet rs=con.stmt.executeQuery(q);
    	
    	while(rs.next())
    	{
    		String id=rs.getString("id");
    		String First_Name=rs.getString("First_Name");
    		String Last_Name=rs.getString("Last_Name");
    		String Email=rs.getString("Email");
    		String Password=rs.getString("Password");

    		Customer cust=new Customer();
    		cust.setId(Integer.parseInt(id));
    		cust.setFirstName(First_Name);
    		cust.setLastName(Last_Name);
    		cust.setEmail(Email);
            cust.setPassword(Password);
            
            arr.add(cust);

    	}
    	
    	return arr;
        

    }

    @Override
    public Customer getOneCustomer(int customerId) throws Exception {
    	conn con=new conn();
        Customer customer=new Customer();
    	String q="select * from CUSTOMERS where id='"+customerId+"'";
    	ResultSet rs=con.stmt.executeQuery(q);
    	
    	if(rs.next())
    	{
    		String id=rs.getString("id");
    		String First_Name=rs.getString("First_Name");
    		String Last_Name=rs.getString("Last_Name");
    		String Email=rs.getString("Email");
    		String Password=rs.getString("Password");
    		
            customer.setId(Integer.parseInt(id));
            customer.setFirstName(First_Name);
            customer.setLastName(Last_Name);
            customer.setEmail(Email);
            customer.setPassword(Password);

    		

    	}
    	
    	return customer;
    }
}
