package manage;

import java.sql.ResultSet;
import java.util.ArrayList;
//This is CompaniesDBDAO Class
public class CompaniesDBDAO implements CompaniesDAO{


    @Override
    public boolean isCompanyExists(String email, String password) throws Exception {
    	conn con=new conn();
    	
    	boolean val=false;
    	
    	String q="select * from COMPANIES where Email='"+email+"' AND Password='"+password+"'";
    ResultSet rs=con.stmt.executeQuery(q);
    	if(rs.next())
    	{
    		val=true;
    	}
    	else
    	{
    		val=false;
    	}
    	
    	
        return val;
    }

    @Override
    public void addCompany(Company company) throws Exception{
      
    	conn con=new conn();
    	
    	String q="insert into COMPANIES values(0,'"+company.getName()+"','"+company.getEmail()+"','"+company.getPassword()+"')";
    	con.stmt.executeUpdate(q);
    	System.out.println("Company Successfully Added");
    	
    	
    }

    @Override
    public void updateCompany(Company company) throws Exception {
    	
    	conn con=new conn();
    	String q="update  COMPANIES set Name='"+company.getName()+"', Email='"+company.getEmail()+"' , Password='"+company.getPassword()+"' where id="+company.getId()+"";

    			con.stmt.executeUpdate(q);
    	System.out.print("Company Successfully Update");
    			
    }

    @Override
    public void deleteCompany(int companyId) throws Exception{
              conn con=new conn();
             	String q="delete  COMPANIES where id='"+companyId+"'";
             	con.stmt.executeUpdate(q);
             	System.out.print("Company Successfully Deleted");
             	
    }

    @Override
    public ArrayList<Company> getAllCompanies() throws Exception{
    	conn con=new conn();
    	ArrayList<Company> arr=new ArrayList<>();
    	String q="select * from COMPANIES";
    	ResultSet rs=con.stmt.executeQuery(q);
    	
    	while(rs.next())
    	{
    		String id=rs.getString("id");
    		String Name=rs.getString("Name");
    		String Email=rs.getString("Email");
    		String Password=rs.getString("Password");
    		
    		Company company=new Company();
    		company.setId(Integer.parseInt(id));
    		company.setName(Name);
    		company.setEmail(Email);
    		company.setPassword(Password);
    		
    		arr.add(company);
    	}
    	
    	return arr;
        
    }

    @Override
    public Company getOneCompany(int companyId) throws Exception{
    	conn con=new conn();
        Company company=new Company();
    	String q="select * from COMPANIES where id='"+companyId+"'";
    	ResultSet rs=con.stmt.executeQuery(q);
    	
    	if(rs.next())
    	{
    		String id=rs.getString("id");
    		String Name=rs.getString("Name");
    		String Email=rs.getString("Email");
    		String Password=rs.getString("Password");
    		
    		company.setId(Integer.parseInt(id));
    		company.setName(Name);
    		company.setEmail(Email);
    		company.setPassword(Password);


    		

    	}
    	
    	return company;
        
    }
}
