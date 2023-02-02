package com.coupon.project.services;

import com.coupon.project.entities.Company;
import com.coupon.project.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService extends ClientService {


    // todo implements methods

    /**
     * validate admin email and password
     *
     * @param email    admin
     * @param password admin
     * @return login status
     */
    public boolean login(String email, String password) {
        return email.equals("admin") && password.equals("admin");
    }

    //  company ---------------------------------------

    public Company addCompany(Company company) {
        return companyRepo.save(company);
    }

    public Company updateCompany(Company company) {
        return companyRepo.save(company);
    }

    public boolean deleteCompany(int companyId) {
        try {
            companyRepo.deleteById(companyId);
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // debug
            return false;
        }
    }

    public ArrayList<Company> getAllCompanies() {
        // convert iterator to an array list
        ArrayList<Company> allCompanies = new ArrayList<>();
        companyRepo.findAll().forEach(allCompanies::add);
        return allCompanies;
    }

    public Company getOneCompany(int companyId) {
        try {
            return companyRepo.findById(companyId).get();
        }catch (Exception e){
            e.printStackTrace(); // debug
            // if not found return null
            return null;
        }
    }

    // customer ---------------------------------------

    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public boolean deleteCustomer(int customerId) {
        try {
            customerRepo.deleteById(customerId);
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // debug
            return false;
        }    }

    public ArrayList<Customer> getAllCustomers() {
        // convert iterator to an array list
        ArrayList<Customer> allCustomers = new ArrayList<>();
        customerRepo.findAll().forEach(allCustomers::add);
        return allCustomers;
    }

    public Customer getOneCustomer(int customerId) {
        try {
            return customerRepo.findById(customerId).get();
        }catch (Exception e){
            e.printStackTrace(); // debug
            // if not found return null
            return null;
        }
    }

}
