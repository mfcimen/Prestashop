package com.prestashop.tests.tests.functional_tests.functional.login;


import com.prestashop.tests.utilities.RegisterInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends RegisterInfo {


    @Test (priority = 0)
    public void RegistrationTest() throws InterruptedException {
//        1. Openbrowser
//        2. Goto http://automationpractice.com/index.php
//        3. ClickSigninlink
        pages.registrationPage().signIn.click();

//        4. Enter new valid email to the email field
        pages.registrationPage().email.sendKeys(email);

//        5. ClickonCreateAccount
        pages.registrationPage().createAccountBtn.click();
        Thread.sleep(3000);
//        6. Verifythatthatemaillinkdisplayscurrentemail
     //   pages.registrationPage().emailLinkDisplays.isDisplayed();

//        7. Filloutalltherequiredsteps
        pages.registrationPage().firstName.sendKeys(firstname);
        pages.registrationPage().lastName.sendKeys(lastname);


        pages.registrationPage().password.sendKeys(passwrd);

//        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
//        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);

        pages.registrationPage().streetAddress.sendKeys(street);
        pages.registrationPage().cityName.sendKeys(city);

        Thread.sleep(3000);

        pages.registrationPage().select("id_state");
        pages.registrationPage().selectState.selectByVisibleText(stateNo);
        pages.registrationPage().selectState.getFirstSelectedOption().getText();

        pages.registrationPage().zipCode.sendKeys(zipCode);
        pages.registrationPage().cellPhone.sendKeys(cellphone);

        //        8. ClickonRegister
        pages.registrationPage().registerButton.click();

        //        9. Verifythatcorrectfirstandlastnameisdisplayedcorrectlyontopright


        Assert.assertEquals(pages.registrationPage().
                accountInfo.getText(),first_Last_Names,"the name doesnt match");

        pages.registrationPage().logOut.click();

    }


    @Test (dependsOnMethods = "RegistrationTest")
    public void myPersonalInfo() throws InterruptedException {
        login(email,passwrd);


        //        10. Click on My personal information
        pages.myPersonalInfoPage().myPersonalInfoButton.click();
        //        11. Verify that personal information is displayed correctly
        Assert.assertEquals(pages.myPersonalInfoPage().firstName.getAttribute("value"),firstname);
        Assert.assertEquals(pages.myPersonalInfoPage().lastName.getAttribute("value"),lastname);
        Assert.assertEquals(pages.myPersonalInfoPage().email.getAttribute("value"),email);
        //        12. Click on Back to your account
        pages.myPersonalInfoPage().backToYourAccountBtn.click();

        //        13. Click on My addresses verify that address information is displayed  correctly
        pages.myPersonalInfoPage().myAddressBtn.click();

        Assert.assertEquals(pages.myPersonalInfoPage().streetDsplyd.getText(),street);


        Assert.assertEquals(pages.myPersonalInfoPage().city.getText().replace(",","").trim(),city);
        Assert.assertEquals(pages.myPersonalInfoPage().streetDsplyd.getText(),street);
        //zipcode

        Assert.assertEquals(pages.myPersonalInfoPage().zipCodeDsplyd.getText(), zipCode);
        //country
        Assert.assertEquals(pages.myPersonalInfoPage().countryDsplyd.getText(),"United States");
        //mobile number
        Assert.assertEquals(pages.myPersonalInfoPage().phoneNumberDsplyd.getText(),cellphone);
//        14. Click on sign out link
        pages.myPersonalInfoPage().singOutLink.click();



    }

    @Test(priority = 1)
    public void LoginTest(){

        //        15. Login using the email and password if the current user
        pages.registrationPage().signIn.click();
        pages.loginPage().loginEmail.sendKeys(email);
        pages.loginPage().loginPasswrd.sendKeys(passwrd);
        pages.loginPage().submitBtn.click();

//        16. Verify that correct first and last name is displayed correctly on top right
        Assert.assertEquals(pages.myPersonalInfoPage().accountInfo.getText(),first_Last_Names,"the name doesnt match");

    }



}
