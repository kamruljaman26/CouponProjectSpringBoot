package manage;

public class CustomerFacade extends ClientFacade{

    public int customerID;
    @Override
    boolean login(String email, String password) {
        return false;
    }

    public CustomerFacade()
    {
        super();
        customerDAO=new CustomerDBDAO();
        companiesDAO=new CompaniesDBDAO();
        couponDAO=new CouponsDBDAO();
        
    }

}

