package com.prestashop.utilities;

import com.prestashop.pages.*;


public class Pages {

    private CartPage cartPage;
    private RegistrationPage registrationPage;
    private MyPersonalInfoPage myPersonalInfoPage;
    private LoginPage loginPage;
    private ProductPage productPage;

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


    public CartPage cartPage(){
        if(cartPage== null){
            cartPage = new CartPage();
        }
        return cartPage;
    }

    public ProductPage productPage(){
        if(productPage== null){
            productPage = new ProductPage();
        }
        return productPage;
    }









}
