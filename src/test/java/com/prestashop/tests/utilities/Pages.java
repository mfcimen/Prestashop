package com.prestashop.tests.utilities;

import com.prestashop.tests.pages.RegistrationPage;

public class Pages {

    private RegistrationPage registrationPage;

    public RegistrationPage registrationPage(){
        if(registrationPage== null){
            registrationPage = new RegistrationPage();
        }
        return registrationPage;
    }







}
