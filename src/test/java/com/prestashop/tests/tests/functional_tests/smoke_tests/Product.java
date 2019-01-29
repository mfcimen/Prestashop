package com.prestashop.tests.tests.functional_tests.smoke_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.prestashop.tests.utilities.TestBase;

import java.util.List;

public class Product extends TestBase {

    static String name3BeforeClick= "";
    static String price3BeforeClick="";
    @Test(priority = 0)
    public void price(){
        WebElement dress3 = driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[3]"));
        // String nameExtraWay =  driver.findElement(By.xpath("(//a[@class='product-name'])[3]")).getAttribute("title");
         name3BeforeClick =  driver.findElement(By.xpath("(//a[@class='product-name'])[3]")).getText();
         price3BeforeClick = driver.findElement(By.xpath("(//span[@class='price product-price'])[6]")).getText();
        System.out.println(name3BeforeClick);
        System.out.println(price3BeforeClick);
        //driver.findElement(By.xpath("(//span[@class='price product-price'])[6]")).click();
        dress3.click();
        System.out.println("next page");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'fancybox-frame')]")));
        String name3After = driver.findElement(By.xpath("//div[contains(@class,'pb-center-column col-xs-12 col-sm-4')]/h1")).getText();
        System.out.println(name3After);
        String price3After = driver.findElement(By.xpath("(//p[@class='our_price_display']/span)[1]")).getText();
        System.out.println(price3After);

        //Verifythatsamenameandpricedisplayedasonthehomepage

        Assert.assertEquals(name3BeforeClick,name3After,"Names are different");
        Assert.assertEquals(price3BeforeClick,price3After,"Prices are different");

    }


    @Test (priority = 1)
    public void details() {
        WebElement dress3 = driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[3]"));
        dress3.click();
        System.out.println("next page");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'fancybox-frame')]")));
        System.out.println("Quantity : "+driver.findElement(By.xpath("(//input[@value='1'])[2]")).getAttribute("value")   );

        //thatdefaultquantityis1
        String defaultQuantity = driver.findElement(By.xpath("(//input[@value='1'])[2]")).getAttribute("value");
        Assert.assertEquals(driver.findElement(By.xpath("(//input[@value='1'])[2]")).getAttribute("value"), "1", "default quantity is not 1");

        //verify that default size is S

        System.out.println( "Default size : "+driver.findElement(By.xpath("//select[@id='group_1']/option[@title='S']")).getText() );
        Assert.assertEquals(driver.findElement(By.xpath("//select[@id='group_1']/option[@title='S']")).getText(), "S", "default size is not S");

        //Verifyt hat size options are S,M,L


       WebElement options = driver.findElement(By.xpath("//select[@id='group_1']"));
       Select dropdownOptions = new Select(options);
       List<WebElement>list = dropdownOptions.getOptions();

        Assert.assertEquals(list.get(0).getText(),"S");
        Assert.assertEquals(list.get(1).getText(),"M");
        Assert.assertEquals(list.get(2).getText(),"L");

    }


    @Test (priority = 2)
    public void addToCart() {
        WebElement dress3 = driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[3]"));
        dress3.click();
        System.out.println("next page");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'fancybox-frame')]")));
        driver.findElement(By.xpath("//span[.='Add to cart']")).click();

        // Verifyconfirmationmessage“Productsuccessfullyaddedtoyourshopping cart
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']/h2")).getText(),"Product successfully added to your shopping cart",
                "the output is different");

        // that default quantity is 1
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']")).getText(),"1", "Quantity doesnt match");

        String chosenSize = driver.findElement(By.xpath("//span[@id='layer_cart_product_attributes']")).getText();
        if(chosenSize.contains("S")) {
            System.out.println("The size is S");

        } else {
            System.out.println("The size is not S");
        }

          String nameIntheCart = driver.findElement(By.xpath("//span[@id='layer_cart_product_title']")).getText();
          String priceIntheCart = driver.findElement(By.xpath("//span[@id='layer_cart_product_price']")).getText();

        //Verify that same name and price displayed as on the home page
        Assert.assertEquals(name3BeforeClick,nameIntheCart);
          Assert.assertEquals(price3BeforeClick,priceIntheCart);

    }

}
