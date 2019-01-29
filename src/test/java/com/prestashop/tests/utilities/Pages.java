package com.prestashop.tests.utilities;

public class Pages {
    private LoginPage loginPage;

    public LoginPage login(){
        if(loginPage== null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }






}
