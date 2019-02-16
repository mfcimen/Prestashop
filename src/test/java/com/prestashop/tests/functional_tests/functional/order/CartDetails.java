package com.prestashop.tests.functional_tests.functional.order;

import com.prestashop.utilities.Driver;
import com.prestashop.utilities.RegisterInfo;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CartDetails extends TestBase {


    @Test
    public void cartDetails() throws InterruptedException {
//1. Openbrowser
//2. Gotohttp://automationpractice.com/index.php
        goHomePage();

//3. Clickonanyproductthatisnotonsale
        pages.cartPage().anyProduct.click();

//4. Enter a random quantity between 2 and 5
        pages.cartPage().quantityWanted.click();
        int random = randomNumber(1,5);
        pages.cartPage().quantityWanted.sendKeys(""+ random);

//5. Select a different size
        //TODO might not work ..check it
        Select select = new Select(pages.cartPage().selectSize);
        select.selectByValue("2");

//6. Clickonaddtocart
        pages.cartPage().addToCart.click();

//7. VerifyconfirmationmessageProductsuccessfullyaddedtoyourshoppingcart
        String confirmationMessage = pages.cartPage().confirmationMessage.getAttribute("innerText").trim();
      Assert.assertEquals(confirmationMessage,"Product successfully added to your shopping cart");
        Thread.sleep(2000);
//8. Dismisstheconfirmationwindowbyclickingonthexicon
        pages.cartPage().xIcon.click();

    Thread.sleep(5000);
//9. Clickonthecompanylogo
        pages.cartPage().companyLogo.click();

//10. Click on any product that is on sale
        pages.cartPage().productOnSale.click();

//11. Enter a random quantity between 2 and 5
        Thread.sleep(5000);
        WebElement iframe = pages.cartPage().iFrame;
        driver.switchTo().frame(iframe);

        //TODO check it..xpath might be different
        pages.cartPage().quantityWanted.clear();
        int random2 =(int)(Math.random()* 5 +2);
        pages.cartPage().quantityWanted.sendKeys(""+random2);

//12. Select a different size
        Select select2 = new Select(pages.cartPage().selectSize);
        select2.selectByValue("3");

//13. Click on add to cart
        pages.cartPage().addToCart.click();

//14. Verify confirmation message Product successfully added to yourshopping cart
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        Assert.assertEquals(pages.cartPage().confirmationMessage.getAttribute("innerText").trim(),
                "Product successfully added to your shopping cart");
//15. Dismiss the confirmation window by clicking on the x icon
        Thread.sleep(2000);
        pages.cartPage().xIcon.click();
//16. Hover over the Cart icon
        Actions action = new Actions(driver);
        action.moveToElement(pages.cartPage().hoverOverCart).build().perform();

//17. Verify that correct total is displayed

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Total']")));
        Assert.assertTrue(pages.cartPage().cartDropDown
                .isDisplayed());


//18. Verify that total is correct based on the price and item count of the
//products you added to cart. (Shipping is always $2)

        String price1 = pages.cartPage().price1.getAttribute("innerText");
        String price2 = pages.cartPage().price2.getAttribute("innerText");

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
        String shipping = pages.cartPage().shipping.getAttribute("innerText");
        shipping=shipping.substring(shipping.indexOf("$")+1);
        Double ship = Double.parseDouble(shipping);

        Thread.sleep(2000);
        String totalPrice = pages.cartPage().totalPrice.getAttribute("innerText").trim();
        totalPrice = totalPrice.substring(totalPrice.indexOf("$")+1);

        Thread.sleep(2000);

        Double totalPriceD = Double.parseDouble(totalPrice);
        totalPrice+=ship;
        Thread.sleep(4000);
        System.out.println("total price by webpage: "+totalPriceD);

        Assert.assertEquals(totalPriceD,(prc1+prc2+ship));







    }
}