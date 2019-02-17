package com.prestashop.tests.functional_tests.functional.cart;

import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.RegisterInfo;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends RegisterInfo {
    Actions action;

    @Test
    public void addProductToCart() {
         action = new Actions(driver);
//1.Openbrowser
//2.Gotohttp://automationpractice.com/index.ph
//3.Addanyproductinthehomepagetothecart

        action.moveToElement(pages.cartPage().anyProductImg).build().perform();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(pages.cartPage().addItQuick));
        pages.cartPage().addItQuick.click();
        pages.cartPage().xIcon.click();
        String productBefore = pages.cartPage().anyProduct.getAttribute("title");


//4.Hoveroverthecarticon
        action.moveToElement(pages.cartPage().hoverOverCart).build().perform();

//5.Verifythatcartcontainstheproduct
        Assert.assertTrue(pages.cartPage().anyProduct.isDisplayed());

//6.Loginasanyvaliduser
        login(myEmail, myPasswrd);

//7.Hoveroverthecarticon

        action.moveToElement(pages.cartPage().hoverOverCart).build().perform();
//8.Verifythatcartinformationissameasstep5

        wait.until(ExpectedConditions.visibilityOf(pages.cartPage().productInCart));
        Assert.assertEquals(productBefore, pages.cartPage().productInCart.getText());
        System.out.println(productBefore);
        System.out.println(pages.cartPage().productInCart.getText());


    }


    @Test
    public void cartEmpty() {
        action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
//        1. Openbrowser
//        2. Gotohttp://automationpractice.com/index.php
//        3. Loginasanyvaliduser
        login(myEmail, myPasswrd);
//        4. Gobacktohomepage
        pages.cartPage().companyLogo.click();
//        5. Addanyproductinthehomepagetothecart
        wait.until(ExpectedConditions.visibilityOf(pages.cartPage().anyProduct4));
        pages.cartPage().anyProduct4.click();
        pages.cartPage().addToCart.click();
        String productBefore = pages.cartPage().anyProduct4.getAttribute("title");
        pages.cartPage().xIcon.click();
//        6. Hoveroverthecarticon
        action.moveToElement(pages.cartPage().hoverOverCart).build().perform();

//        wait.until(ExpectedConditions.visibilityOf(pages.cartPage().productInCart));
//        7. Verifythatcartcontainstheproduct
        if(productBefore.contains( pages.cartPage().productInCart.getAttribute("innerText")) );
//        8. Logout
        pages.registrationPage().logOut.click();
//        9. Verifythecartcontainsthewordempty
        Assert.assertTrue(  pages.cartPage().emptyCart.isDisplayed()  );



    }

    @Test
    public void  cartIconDelete() {
        action = new Actions(driver);
//        1. Openbrowser
//        2. Gotohttp://automationpractice.com/index.php
//        3. Addanyproductinthehomepagetothecart
        action.moveToElement(pages.cartPage().anyProductImg).build().perform();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(pages.cartPage().addItQuick));
        pages.cartPage().addItQuick.click();
//        4. ClickonContinueshopping
        pages.cartPage().continueShopping.click();

//        5. Hoveroverthecarticon
        action.moveToElement(pages.cartPage().hoverOverCart).build().perform();
//        6. Clickthextodeletetheproduct
        wait.until(ExpectedConditions.visibilityOf(pages.cartPage().removeIcon));
        pages.cartPage().removeIcon.click();
//        7. VerifywordemptyisdisplayedintheCarticon
        wait.until(ExpectedConditions.visibilityOf(pages.cartPage().emptyCart));
        Assert.assertTrue( pages.cartPage().emptyCart.isDisplayed() );

    }


}