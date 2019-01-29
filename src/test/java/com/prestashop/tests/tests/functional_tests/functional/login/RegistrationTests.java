package com.prestashop.tests.tests.functional_tests.functional.login;

import com.github.javafaker.Faker;
import com.prestashop.tests.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    Faker faker = new Faker();
    @Test
    public void RegistrationTest() throws InterruptedException {
//        1. Openbrowser
//        2. Goto http://automationpractice.com/index.php
//        3. ClickSigninlink
        driver.findElement(By.xpath("//a[@class='login']")).click();
//        4. Enter new valid email to the email field
        String email = faker.internet().emailAddress();
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(email);
//        5. ClickonCreateAccount
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
//        6. Verifythatthatemaillinkdisplayscurrentemail
        driver.findElement(By.xpath("//input[@id='email']")).isDisplayed();

//        7. Filloutalltherequiredsteps
        String firstName =faker.name().firstName();
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(firstName);

        String lastName =faker.name().lastName();
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(lastName);

        String passwrd = faker.internet().password();
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(passwrd);

        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);

        String street =faker.address().streetAddress()+ " "+ faker.address().buildingNumber();
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(street);

        String city =faker.address().cityName();
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(city);

        Select select = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
        select.selectByValue("5");


        String california=select.getFirstSelectedOption().getText();

        String zipCode = faker.address().zipCode().substring(0,5);
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(zipCode);

        String cellphone = faker.phoneNumber().cellPhone();
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(cellphone);

        //        8. ClickonRegister
        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

        //        9. Verifythatcorrectfirstandlastnameisdisplayedcorrectlyontopright

        String firstLastNames= firstName+ " "+ lastName;
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='account']")).getText(),firstLastNames,"the name doesnt match");

        //        10. Click on My personal information

        driver.findElement(By.xpath("//a[.='My personal information']")).click();

        //        11. Verify that personal information is displayed correctly
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value"), email);

        //        12. Click on Back to your account
        driver.findElement(By.xpath("(//a[@class='btn btn-default button button-small'])[2]")).click();

        //        13. Click on My addresses verify that address information is displayed  correctly
        driver.findElement(By.xpath("//a[.='My addresses']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='address_address1']")).getText(), street);
        String addressConfirm = driver.findElement(By.xpath("(//ul[@class='last_item item box']/li)[5]/span")).getText();
        Assert.assertEquals(addressConfirm.substring(0,addressConfirm.length()-1), city);
        Assert.assertEquals(driver.findElement(By.xpath("((//ul[@class='last_item item box']/li)[5]/span)[2]")).getText(),california );
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
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='header_user_info']/a/span")).getText(), firstLastNames);


    }


}
