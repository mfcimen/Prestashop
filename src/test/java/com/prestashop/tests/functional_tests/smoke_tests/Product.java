package com.prestashop.tests.functional_tests.smoke_tests;

import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Product extends TestBase {

    static String name3BeforeClick= "";
    static String price3BeforeClick="";


    @Test(priority = 0)
    public void price(){
        WebElement dress3 = pages.productPage().dress3;

         name3BeforeClick =  pages.productPage().name3BeforeClick.getAttribute("innerText");
         price3BeforeClick = pages.productPage().price3BeforeClick.getAttribute("innerText");
        System.out.println(name3BeforeClick);
        System.out.println(price3BeforeClick);

        dress3.click();
        System.out.println("next page");
        driver.switchTo().frame(pages.productPage().iFrame);
        String name3After =pages.productPage().name3After.getText();
        System.out.println(name3After);
        String price3After = pages.productPage().price3After.getText();
        System.out.println(price3After);

        //Verifythatsamenameandpricedisplayedasonthehomepage

        Assert.assertEquals(name3BeforeClick,name3After,"Names are different");
        Assert.assertEquals(price3BeforeClick,price3After,"Prices are different");

    }


    @Test (priority = 1)
    public void details() throws InterruptedException {

        pages.productPage().dress3.click();
        System.out.println("next page");
        driver.switchTo().frame(pages.productPage().iFrame);
        System.out.println("Quantity : "+pages.productPage().quantity.getAttribute("value")   );

        //thatdefaultquantityis1
//        String defaultQuantity = pages.productPage().defaultQuantity.getAttribute("value").trim();
//        System.out.println("Default quantity :  " + defaultQuantity);
        Assert.assertEquals(pages.productPage().quantity.getAttribute("value").trim(), "1", "default quantity is not 1");

        //verify that default size is S
        WebElement options = pages.productPage().options;
        Select dropdownOptions = new Select(options);
        List<WebElement>list = dropdownOptions.getOptions();
        Assert.assertEquals(dropdownOptions.getFirstSelectedOption().getText(), "S");

        //Verifyt hat size options are S,M,L
        Assert.assertEquals(list.get(0).getText(),"S");
        Assert.assertEquals(list.get(1).getText(),"M");
        Assert.assertEquals(list.get(2).getText(),"L");

    }


    @Test (priority = 2)
    public void addToCart() {

        pages.productPage().dress3.click();
        System.out.println("next page");
        driver.switchTo().frame(pages.productPage().iFrame);
        pages.cartPage().addToCart.click();


        //TODO call the confirmation message from CartPage but it might not work

        // Verifyconfirmationmessage“Productsuccessfullyaddedtoyourshopping cart
//        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']/h2")).getText(),"Product successfully added to your shopping cart",
//                "the output is different");

        Assert.assertEquals(pages.productPage().confirmMessage.getText(),
                "Product successfully added to your shopping cart",
                "the output is different");




        // that default quantity is 1
        Assert.assertEquals(pages.productPage().defaultQuantity.getText(),"1", "Quantity doesnt match");


        String chosenSize = pages.productPage().selectedSize.getText();
        if(chosenSize.contains("S")) {
            System.out.println("The size is S");

        } else {
            System.out.println("The size is not S");
        }

          String nameIntheCart = pages.productPage().nameInCart.getText();
          String priceIntheCart = pages.productPage().priceInCart.getText();
          name3BeforeClick =  pages.productPage().name3BeforeClick.getAttribute("innerText");
          price3BeforeClick = pages.productPage().price3BeforeClick.getAttribute("innerText");
          //Verify that same name and price displayed as on the home page
          Assert.assertEquals(name3BeforeClick.trim(),nameIntheCart);
          Assert.assertEquals(price3BeforeClick.trim(),priceIntheCart);

    }

}
