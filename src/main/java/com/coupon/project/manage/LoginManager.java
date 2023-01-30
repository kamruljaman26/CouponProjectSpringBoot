package com.coupon.project.manage;

public class LoginManager {
    /**
     * Runs this operation.
     */
    LoginManager instance;

    public LoginManager()
    {

    }
    public boolean login(String email,String password)
    {
        boolean val=true;
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

    public LoginManager getInstance() {
        return instance;
    }
}
