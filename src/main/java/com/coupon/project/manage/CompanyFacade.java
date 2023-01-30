package com.coupon.project.manage;

//This is CompanyFacade Class
public class CompanyFacade extends ClientFacade{
    public int companyId;
    
    public CompanyFacade()
    {
        super();
        customerDAO=new CustomerDBDAO();
        companiesDAO=new CompaniesDBDAO();
        couponDAO=new CouponsDBDAO();
        
    }
    @Override
    boolean login(String email, String password) {
    	
    	
    	
    	
        return true;
    }
    
//    public CompanyFacade()
//    {
//    	companiesDAO=new CompaniesDBDAO();
//    	couponDAO=new CouponsDBDAO();
//    	customerDAO=new CustomerDBDAO();
//    }
    
}
