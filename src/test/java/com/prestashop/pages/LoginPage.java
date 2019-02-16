package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@id='email']")
    public WebElement loginEmail;

    @FindBy(xpath = "//input[@id='passwd']" )
    public WebElement loginPasswrd;

    @FindBy (xpath ="//button[@id='SubmitLogin']" )
    public WebElement submitBtn;

    @FindBy(xpath = "//a[@class='account']")
    public WebElement accountInfo;





}
