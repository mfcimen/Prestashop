package com.prestashop.tests.tests.functional_tests.functional.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.prestashop.tests.utilities.TestBase;

public class CartDetails extends TestBase {
    @Test
    public void cartDetails() throws InterruptedException {
//1. Openbrowser
//2. Gotohttp://automationpractice.com/index.php
//3. Clickonanyproductthatisnotonsale
        driver.findElement(By.xpath("(//a[@title='Printed Summer Dress'])[4]")).click();

//4. Enter a random quantity between 2 and 5
        driver.findElement(By.id("quantity_wanted")).clear();
        int random =(int)(Math.random()* 5 +1);
        driver.findElement(By.id("quantity_wanted")).sendKeys("" +random);

//5. Select a different size
        Select select = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
        select.selectByValue("2");

//6. Clickonaddtocart
        driver.findElement(By.xpath("//button[@class='exclusive']")).click();

//7. VerifyconfirmationmessageProductsuccessfullyaddedtoyourshoppingcart
        String confirmationMessage = driver.findElement(By.xpath("//i[@class='icon-ok']/..")).getAttribute("innerText").trim();
      Assert.assertEquals(confirmationMessage,"Product successfully added to your shopping cart");
        Thread.sleep(2000);
//8. Dismisstheconfirmationwindowbyclickingonthexicon
        driver.findElement(By.xpath("//span[@class='cross']")).click();

    Thread.sleep(5000);
//9. Clickonthecompanylogo
        driver.findElement(By.xpath("//img[@alt='My Store']")).click();

//10. Click on any product that is on sale
    driver.findElement(By.xpath("(//a[@class='product_img_link'])[7]")).click();

//11. Enter a random quantity between 2 and 5
        Thread.sleep(5000);
        WebElement iframe = driver.findElement(By.xpath("(//iframe)[4]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
        int random2 =(int)(Math.random()* 5 +2);
        driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys(""+random2);

//12. Select a different size
        Select select2 = new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
        select2.selectByValue("3");

//13. Click on add to cart
        driver.findElement(By.id("add_to_cart")).click();

//14. Verify confirmation message Product successfully added to yourshopping cart
        Assert.assertEquals(driver.findElement(By.xpath("//i[@class='icon-ok']/..")).getAttribute("innerText").trim(),"Product successfully added to your shopping cart");
//15. Dismiss the confirmation window by clicking on the x icon
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='cross']")).click();
//16. Hover over the Cart icon
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[@title='View my shopping cart']"))).build().perform();

//17. Verify that correct total is displayed
        Thread.sleep(4000);
        Assert.assertTrue(driver.findElement(
                By.xpath("//span[.='Total']"))
                .isDisplayed());


//18. Verify that total is correct based on the price and item count of the
//products you added to cart. (Shipping is always $2)

        String price1 = driver.findElement(By.xpath("(//span[@class='price'])[1]")).getAttribute("innerText");
        String price2 = driver.findElement(By.xpath("(//span[@class='price'])[2]")).getAttribute("innerText");

        Thread.sleep(2000);
        price1 = price1.substring(1);
        price2 = price2.substring(1);

        Thread.sleep(2000);

        Double prc1=Double.parseDouble(price1);
        Double prc2=Double.parseDouble(price2);
        Thread.sleep(2000);
        System.out.println(prc1);
        System.out.println(prc2);
        System.out.println("the Total: " + (prc1+prc2));

        Thread.sleep(2000);
        String shipping = driver.findElement(By.xpath("//span[@class='price cart_block_shipping_cost ajax_cart_shipping_cost']")).getAttribute("innerText");
        shipping=shipping.substring(shipping.indexOf("$")+1);
        Double ship = Double.parseDouble(shipping);

        Thread.sleep(2000);
        String totalPrice = driver.findElement(By.xpath("//span[@class='price cart_block_total ajax_block_cart_total']")).getAttribute("innerText").trim();
        totalPrice = totalPrice.substring(totalPrice.indexOf("$")+1);

        Thread.sleep(2000);

        Double totalPriceD = Double.parseDouble(totalPrice);
        totalPrice+=ship;
        Thread.sleep(4000);
        System.out.println("total price by webpage: "+totalPriceD);

        Assert.assertEquals(totalPriceD,(prc1+prc2+ship));







    }
}