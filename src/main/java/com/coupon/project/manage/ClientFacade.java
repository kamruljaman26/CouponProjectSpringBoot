package com.coupon.project.manage;
//This is CleintFacade abstract Class
abstract class ClientFacade {

   public CompaniesDAO companiesDAO;
   public CustomerDAO customerDAO;
   public CouponDAO couponDAO;

   abstract boolean login(String email,String password);

}
