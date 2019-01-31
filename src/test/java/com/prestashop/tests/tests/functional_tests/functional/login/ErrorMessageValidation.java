package com.prestashop.tests.tests.functional_tests.functional.login;

import com.github.javafaker.Faker;
import com.prestashop.tests.utilities.RegisterInfo;
import com.prestashop.tests.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessageValidation extends RegisterInfo {


    @Test
    public void errorValidationTest() throws InterruptedException {
//        1. Openbrowser
//        2. Goto http://automationpractice.com/index.php
//        3. ClickSigninlink
        pages.registrationPage().signIn.click();

//        4. Enter new valid email to the email field
        pages.registrationPage().email.sendKeys(email);
        System.out.println(email);

//        5. ClickonCreateAccount
        pages.registrationPage().createAccountBtn.click();
        Thread.sleep(3000);
//        6. Verifythatthatemaillinkdisplayscurrentemail
        //   pages.registrationPage().emailLinkDisplays.isDisplayed();

//        7 6. Fillalltherequiredstepsexceptforfirstname
     //   pages.registrationPage().firstName.sendKeys(firstname);
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

        //     8. Verifythaterrormessagefirstnameisrequired.isdisplayed

        Assert.assertEquals(pages.registrationPage().errorMessage.getText(), "firstname is required.");



    }




}
