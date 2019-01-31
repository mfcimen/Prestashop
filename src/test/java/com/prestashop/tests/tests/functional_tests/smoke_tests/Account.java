package com.prestashop.tests.tests.functional_tests.smoke_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.prestashop.tests.utilities.TestBase;

public class Account extends TestBase {

    static String myEmail="mfeyyazcimen@gmail.com";
    static String myPasswrd="mfc12345";
    static String logingNameUp;
    static String firstName="";
    static String lastName="";

    @BeforeMethod
    public void url() {
        driver.get("http://automationpractice.com/index.php");
    }




    @Test(priority = 0)
    public void loginMyAccount() throws InterruptedException {
       driver.findElement(By.xpath("//a[@class='login']")).click();

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys(myEmail);
        WebElement passwd = driver.findElement(By.xpath("//input[@id='passwd']"));
        passwd.sendKeys(myPasswrd);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();

        driver.getTitle().contains("My Account");
        driver.findElement(By.xpath("//a[.='Muhammed Cimen']")).isDisplayed();

        logingNameUp = driver.findElement(By.xpath("//a[.='Muhammed Cimen']")).getText();

    }

    @Test (priority = 1)
    public void myPersonalInformation() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=identity']")).click();
        //VerifytitlecontainsIdentity
        driver.getTitle().contains("Identity");

        firstName = driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("value");
        lastName =  driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("value");
        String firstAndLast = firstName + " " + lastName;
        //System.out.println(firstAndLast);
        Assert.assertEquals(firstAndLast,logingNameUp," first and last name dont match with the name up ");


        driver.findElement(By.xpath("//button[@class='btn btn-default button button-medium']")).click();

        //Verify error message “The password you entered is incorrect.”
       // Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).isDisplayed();
        // Click on Back to your account
        driver.findElement(By.xpath("(//a[@class='btn btn-default button button-small']/span)[2]")).click();
        //Verify that title contains My account
        Assert.assertTrue(  driver.getTitle().contains( "My account"));
    }


    @Test(priority = 2)
    public void loginMyAddresses() {
        //Click on My addresses
        driver.findElement(By.xpath("//a[.='My addresses']")).click();
        //Click on Add a new address
        driver.findElement(By.xpath("//a[.='Add a new address']")).click();
        //Verify that first name and last name matches the full name on top
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("value"),lastName);
        //Delete the first name
        driver.findElement(By.xpath("//input[@id='firstname']")).clear();
        driver.findElement(By.xpath("//button[@id='submitAddress']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText(),"firstname is required.");

    }






}
