package com.prestashop.tests.functional_tests.smoke_tests;

import com.prestashop.utilities.RegisterInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Account extends RegisterInfo {

    @Test(priority = 0)
    public void loginMyAccount() throws InterruptedException {
            pages.registrationPage().signIn.click();
            pages.loginPage().loginEmail.sendKeys(myEmail);
            pages.loginPage().loginPasswrd.sendKeys(myPasswrd);
            pages.registrationPage().loginButton.click();


        pages.myPersonalInfoPage().myPersonalInfoButton.click();

        //VerifytitlecontainsIdentity
        driver.getTitle().contains("Identity");

        firstName = pages.myPersonalInfoPage().firstName.getAttribute("value");
        lastName =  pages.myPersonalInfoPage().lastName.getAttribute("value");
        String firstAndLast = firstName + " " + lastName;
        //System.out.println(firstAndLast);
        Assert.assertEquals(firstAndLast,logingNameUp," first and last name dont match with the name up ");


        //Verify error message “The password you entered is incorrect.”
        pages.myPersonalInfoPage().saveButton.click();
       // Thread.sleep(2000);
        pages.myPersonalInfoPage().errorMessagePassword.isDisplayed();

        // Click on Back to your account
        pages.myPersonalInfoPage().backToYourAccountBtn.click();
        //Verify that title contains My account
        System.out.println(driver.getTitle());
        //Assert.assertTrue( driver.getTitle().contains("My account"));
        pages.myPersonalInfoPage().singOutLink.click();
    }


    @Test(priority = 2)
    public void loginMyAddresses() {

        pages.registrationPage().signIn.click();
        pages.loginPage().loginEmail.sendKeys(myEmail);
        pages.loginPage().loginPasswrd.sendKeys(myPasswrd);
        pages.loginPage().submitBtn.click();
        //Click on My addresses
        pages.myPersonalInfoPage().myAddressBtn.click();
        //Click on Add a new address
        pages.myPersonalInfoPage().newAddressBtn.click();
        //Verify that first name and last name matches the full name on top
        Assert.assertEquals(pages.myPersonalInfoPage().firstName.getAttribute("value"),firstName);
        Assert.assertEquals(pages.myPersonalInfoPage().lastName.getAttribute("value"),lastName);
        //Delete the first name
        pages.myPersonalInfoPage().firstName.clear();
        pages.myPersonalInfoPage().submitAddressBtn.click();
        Assert.assertEquals((pages.myPersonalInfoPage().firstNameRequiredMessage.getAttribute("innerText")),"firstname is required.");
        pages.myPersonalInfoPage().backToYourAccountBtnFromMyAddress.click();
    }


}
