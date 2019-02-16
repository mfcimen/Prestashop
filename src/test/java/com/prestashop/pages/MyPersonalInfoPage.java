package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyPersonalInfoPage  {

    public MyPersonalInfoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='My personal information']")
    public WebElement myPersonalInfoButton;

    @FindBy(xpath = "//a[@class='account']")
    public WebElement accountInfo;

    @FindBy(id = "firstname")
    public WebElement firstName;

    @FindBy(id = "lastname")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(xpath = "(//a[@href='http://automationpractice.com/index.php?controller=my-account'])[3]")
    public WebElement backToYourAccountBtn;

    @FindBy(xpath = "(//a[@href='http://automationpractice.com/index.php?controller=addresses'])[1]")
    public WebElement backToYourAccountBtnFromMyAddress;

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

    @FindBy(xpath = "//button[@class='btn btn-default button button-medium']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    public WebElement errorMessagePassword;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    public WebElement firstNameRequiredMessage;

    @FindBy(xpath = "//a[.='Add a new address']")
    public WebElement newAddressBtn;

    @FindBy(xpath = "//button[@id='submitAddress']")
    public WebElement submitAddressBtn;



}
