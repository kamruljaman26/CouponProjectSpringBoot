package manage;

import java.sql.ResultSet;
import java.util.ArrayList;
//This is CouponDBDAO Class
public class CouponsDBDAO implements CouponDAO{
    @Override
    public void addCoupon(Coupon coupon) throws Exception{
conn con=new conn();
    	
String start=coupon.getStartDate().getYear()+"-"+coupon.getStartDate().getMonth()+"-"+coupon.getStartDate().getDate();
String end=coupon.getEndDate().getYear()+"-"+coupon.getEndDate().getMonth()+"-"+coupon.getEndDate().getDate();


    	String q="insert into COUPONS values(0,"+coupon.getCompanyID()+",'"+coupon.getCategory()+"','"+coupon.getDescription()+"','"+start+"','"+end+"',"+coupon.getAmount()+","+coupon.getPrice()+",'"+coupon.getImage()+"')";
    	con.stmt.executeUpdate(q);
    	System.out.println("Coupon Successfully Added");
    	
    }

    @Override
    public void updateCoupon(Coupon coupon) {

    }

    @Override
    public void deleteCoupon(Coupon coupon) {

    }

    @Override
    public ArrayList<Coupon> getAllCoupon() throws Exception {
         

        			conn con=new conn();
     	ArrayList<Coupon> arr=new ArrayList<>();
     	String q="select * from COUPONS";
     	ResultSet rs=con.stmt.executeQuery(q);
     	
     	while(rs.next())
     	{
     		 Coupon c=new Coupon();
             c.setStartDate(null);
             c.setEndDate(null);

             String id=rs.getString("id");
             String comp_id=rs.getString("Company_ID ");
             String Title=rs.getString("Title ");
             String Desc=rs.getString("Description ");
             String Amount=rs.getString("Amount");
             String price=rs.getString("price");

             c.setId(Integer.parseInt(id));
             c.setCompanyID(Integer.parseInt(comp_id));
             c.setCategory(Category.Restaurant);
             c.setAmount(Integer.parseInt(Amount));
             c.setPrice(Double.parseDouble(price));
             
             arr.add(c);
             

     	}
     	
     	return arr;

    }
    

    @Override
    public ArrayList<Coupon> getCustomerCoupons(Category category)
   throws Exception {

        String cc=category.toString();
        conn con=new conn();
        ArrayList<Coupon> arr=new ArrayList<>();
        String q="select * from COUPONS  where Title="+cc+"";
        
        ResultSet rs=con.stmt.executeQuery(q);

        while(rs.next())
        {
            Coupon c=new Coupon();
            c.setStartDate(null);
            c.setEndDate(null);

            String id=rs.getString("id");
            String comp_id=rs.getString("Company_ID ");
            String Title=rs.getString("Title ");
            String Desc=rs.getString("Description ");
            String Amount=rs.getString("Amount");
            String price=rs.getString("price");

            c.setId(Integer.parseInt(id));
            c.setCompanyID(Integer.parseInt(comp_id));
            c.setCategory(Category.Restaurant);
            c.setAmount(Integer.parseInt(Amount));
            c.setPrice(Double.parseDouble(price));

            arr.add(c);


        }

        return arr;

    }


    @Override
    public Coupon getOneCoupon(int couponId) {
        return null;
    }

    @Override
    public void addCouponPurchase(int custId, int coupId) throws Exception {
    	conn con=new conn();
    	String q="insert into COUPONS values("+custId+","+coupId+")";
    	con.stmt.executeUpdate(q);
    	System.out.println("Coupon Successfully Added");
    }

    @Override
    public void deleteCouponPurchase(int custID, int CoupId) throws Exception{

    	
    }
}
