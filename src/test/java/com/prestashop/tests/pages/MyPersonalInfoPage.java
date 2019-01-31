package com.prestashop.tests.pages;

import com.prestashop.tests.utilities.Driver;
import com.prestashop.tests.utilities.RegisterInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyPersonalInfoPage  {

    public MyPersonalInfoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='My personal information']/span")
    public WebElement myPersonalInfoButton;

    @FindBy(xpath = "//a[@class='account']")
    public WebElement accountInfo;

    @FindBy(id = "firstname")
    public WebElement firstName;

    @FindBy(id = "lastname")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(xpath = "(//a[@class='btn btn-default button button-small'])[2]")
    public WebElement backToYourAccountBtn;

    @FindBy(xpath = "//a[.='My addresses']")
    public WebElement myAddressBtn;

    @FindBy(xpath =  "//span[@class='address_address1'] " )
    public WebElement streetDsplyd;

    @FindBy(xpath = "(//ul[@class='last_item item box']/li)[5]/span")
    public WebElement city;

    @FindBy(xpath = "((//ul[@class='last_item item box']/li)[5]/span)[2]")
    public WebElement stateDsplyd;

    @FindBy(xpath = "((//ul[@class='last_item item box']/li)[5]/span)[3]")
    public WebElement zipCodeDsplyd;

    @FindBy(xpath = "((//ul[@class='last_item item box']/li)[6]/span)")
    public WebElement countryDsplyd;

    @FindBy (xpath = "((//ul[@class='last_item item box']/li)[8]/span)")
    public WebElement phoneNumberDsplyd;

    @FindBy(xpath = "//a[@class='logout']")
    public WebElement singOutLink;

}
