package manage;

import java.util.ArrayList;
//This is CompaniesDAo Interface
public interface CompaniesDAO {

     boolean isCompanyExists(String email,String password) throws Exception;
     void addCompany(Company company)throws Exception;
     void updateCompany(Company company) throws Exception;
     void deleteCompany(int companyId) throws Exception;
     ArrayList<Company> getAllCompanies() throws Exception;
     Company getOneCompany(int companyId) throws Exception;

}
