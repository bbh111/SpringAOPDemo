package com.demoAop.service;

import com.demoAop.entities.Account;

public class LoginService {
    public boolean authenticateAccount(Account account){
        return account.getUsername().equals("sa")&&account.getPassword().equals("123");
    }
}
