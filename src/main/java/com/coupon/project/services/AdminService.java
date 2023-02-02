package com.coupon.project.services;

import com.coupon.project.entities.Company;
import com.coupon.project.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService extends ClientService{


    // todo implements methods

    /**
     * validate admin email and password
     * @param email admin
     * @param password admin
     * @return login status
     */
    public boolean login(String email, String password){
        return email.equals("admin") && password.equals("admin");
    }

    //  company ---------------------------------------

    public Company addCompany(Company company){
        return null;
    }

    public Company updateCompany(Company company){
        return null;
    }

    public boolean deleteCompany(int companyId){
        return false;
    }

    public ArrayList<Company> getAllCompanies(){
        return null;
    }

    public ArrayList<Company> getOneCompanies(int companyId){
        return null;
    }

    // customer ---------------------------------------

    public Customer addCustomer(Customer customer){
        return null;
    }

    public Customer updateCustomer(Customer customer){
        return null;
    }

    public boolean deleteCustomer(int customerId){
        return false;
    }

    public ArrayList<Customer> getAllCustomers(){
        return null;
    }

    public ArrayList<Customer> getOneCustomer(int customerId){
        return null;
    }

}
