package com.prestashop.pages;


import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage {

    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "a.login")
    public WebElement signIn;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement email;

    @FindBy (xpath ="//button[@id='SubmitCreate']" )
    public WebElement createAccountBtn;

    @FindBy (xpath = "//input[@id='email']")
    public WebElement emailLinkDisplays;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    public  WebElement firstName;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement password;

    @FindBy (xpath = "//input[@id='address1']")
    public WebElement streetAddress;

    @FindBy(xpath = "//input[@id='city']" )
    public WebElement cityName;

    @FindBy(id = "id_state")
    public Select selectState;

    @FindBy(xpath = "//input[@id='postcode']")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    public WebElement cellPhone;

    @FindBy(xpath = "//button[@id='submitAccount']")
    public WebElement registerButton;

    @FindBy(xpath = "//a[@class='account']")
    public WebElement accountInfo;

    @FindBy(xpath = "//a[@class='logout']")
    public WebElement logOut;

    @FindBy(id = "SubmitLogin")
    public WebElement loginButton;

    @FindBy(xpath = "//body[@id='authentication']/div/div/div/div/div/div/ol/li")
        public WebElement errorMessage;




     public void select(String id){
         selectState = new Select(Driver.getDriver().findElement(By.id(id)));

     }



















}
