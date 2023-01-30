package com.coupon.project.manage;
// This is Admin Facade Class
public class AdminFacade extends ClientFacade{

    public AdminFacade()
    {
        super();
        customerDAO=new CustomerDBDAO();
        companiesDAO=new CompaniesDBDAO();
    }

    @Override
    boolean login(String email, String password) {
    	
    	boolean val=false;
    	
    	if(email.equals("Admin") && password.equals("Admin"))
    	{
    		val=true;
    	}
    	else
    	{
    		val=false;
    	}
    	return val;
    }
}
