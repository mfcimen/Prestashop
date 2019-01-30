package com.prestashop.tests.tests.functional_tests.functional.login;


import com.prestashop.tests.utilities.RegisterInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends RegisterInfo {


    @Test
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
        pages.registrationPage().lastName.sendKeys(lastName);
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

        //        10. Click on My personal information
        pages.registrationPage().myPersonalInfo.click();

        //        11. Verify that personal information is displayed correctly
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("value"), firstname);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), email);

        //        12. Click on Back to your account
        driver.findElement(By.xpath("(//a[@class='btn btn-default button button-small'])[2]")).click();

        //        13. Click on My addresses verify that address information is displayed  correctly
        driver.findElement(By.xpath("//a[.='My addresses']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='address_address1']")).getText(), street);
        String addressConfirm = driver.findElement(By.xpath("(//ul[@class='last_item item box']/li)[5]/span")).getText();
        Assert.assertEquals(addressConfirm.substring(0,addressConfirm.length()-1), city);
        Assert.assertEquals(driver.findElement(By.xpath("((//ul[@class='last_item item box']/li)[5]/span)[2]")).getText(),
                pages.registrationPage().selectState.getFirstSelectedOption().getText());
        //zipcode

        Assert.assertEquals(driver.findElement(By.xpath("((//ul[@class='last_item item box']/li)[5]/span)[3]")).getText(),zipCode);
        //country
        Assert.assertEquals(driver.findElement(By.xpath("((//ul[@class='last_item item box']/li)[6]/span)")).getText(),"United States");
        //mobile number
        Assert.assertEquals(driver.findElement(By.xpath("((//ul[@class='last_item item box']/li)[8]/span)")).getText(),cellphone);
//        14. Click on sign out link
        driver.findElement(By.xpath("//a[@class='logout']")).click();
//        15. Login using the email and password if the current user
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(passwrd);
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
//        16. Verify that correct first and last name is displayed correctly on top right
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='header_user_info']/a/span")).getText(), first_Last_Names);


    }


}
