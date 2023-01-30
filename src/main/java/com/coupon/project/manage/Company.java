package manage;

import java.util.ArrayList;
//This is Company Class
public class Company {
    public int id;
    public String email,password,name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Company()
    {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(ArrayList<Coupon> coupons) {
        this.coupons = coupons;
    }

    public ArrayList<Coupon> coupons;

}
