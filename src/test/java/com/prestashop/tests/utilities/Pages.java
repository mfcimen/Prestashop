package com.prestashop.tests.utilities;

import com.prestashop.tests.pages.LoginPage;
import com.prestashop.tests.pages.MyPersonalInfoPage;
import com.prestashop.tests.pages.RegistrationPage;


public class Pages {

    private RegistrationPage registrationPage;
    private MyPersonalInfoPage myPersonalInfoPage;
    private LoginPage loginPage;

    public RegistrationPage registrationPage(){
        if(registrationPage== null){
            registrationPage = new RegistrationPage();
        }
        return registrationPage;
    }


    public MyPersonalInfoPage myPersonalInfoPage(){
        if(myPersonalInfoPage== null){
            myPersonalInfoPage = new MyPersonalInfoPage();
        }
        return myPersonalInfoPage;
    }

    public LoginPage loginPage(){
        if(loginPage== null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }








}
