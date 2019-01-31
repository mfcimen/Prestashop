package com.prestashop.tests.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected SoftAssert softAssert;
    protected Pages pages;


    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        pages = new Pages();
        driver.manage().window().maximize();
        actions = new Actions(driver);
        softAssert = new SoftAssert();
        driver.get(ConfigurationReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
       Thread.sleep(8000);
       // Driver.closeDriver();
        softAssert.assertAll();
    }


    public void login(String email, String passwrd) {
        pages.registrationPage().signIn.click();
        pages.loginPage().loginEmail.sendKeys(email);
        pages.loginPage().loginPasswrd.sendKeys(passwrd);
        pages.registrationPage().loginButton.click();
    }

    //random number generator
    public static int randomNumber(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }
}
