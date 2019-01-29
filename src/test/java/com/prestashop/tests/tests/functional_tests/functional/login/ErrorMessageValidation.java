package com.prestashop.tests.tests.functional_tests.functional.login;

import com.github.javafaker.Faker;
import com.prestashop.tests.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessageValidation extends TestBase {
    Faker faker = new Faker();
    @Test
    public void errorMessageValidationFirstName() {
//        1. Openbrowser
//        2. Gotohttp://automationpractice.com/index.php
//        3. ClickSigninlink
        driver.findElement(By.xpath("//a[@class='login']")).click();
//        4. Enter new valid email to the email field
        String email = faker.internet().emailAddress();
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(email);
//        5. ClickonCreateAccount
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
//        6. Fillalltherequiredstepsexceptforfirstname


//        String firstName =faker.name().firstName();
//        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(firstName);

        String lastName =faker.name().lastName();
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(lastName);

        String passwrd = faker.internet().password();
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(passwrd);

      //  driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);

        String street =faker.address().streetAddress()+ " "+ faker.address().buildingNumber();
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(street);

        String city =faker.address().cityName();
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(city);

        Select select = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
        select.selectByValue("5");

      //  String california=select.getFirstSelectedOption().getText();

        String zipCode = faker.address().zipCode().substring(0,5);
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(zipCode);

        String cellphone = faker.phoneNumber().cellPhone();
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(cellphone);
//        7. ClickonRegister
        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
//        8. Verifythaterrormessagefirstnameisrequired.isdisplayed
        Assert.assertEquals(driver.findElement(By.xpath("//body[@id='authentication']/div/div/div/div/div/div/ol/li")).getText(), "firstname is required.");
    }
}
