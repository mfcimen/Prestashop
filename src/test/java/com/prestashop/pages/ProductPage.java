package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//img[@class='replace-2x img-responsive'])[3]")
    public WebElement dress3;

    @FindBy(xpath = "(//a[@class='product-name'])[3]")
    public WebElement name3BeforeClick;

    @FindBy(xpath = "(//span[@class='price product-price'])[6]")
    public WebElement price3BeforeClick;

    @FindBy(xpath = "//iframe[contains(@id,'fancybox-frame')]")
    public WebElement iFrame;

    @FindBy(xpath = "//div[contains(@class,'pb-center-column col-xs-12 col-sm-4')]/h1")
    public WebElement name3After;

    @FindBy(xpath = "(//p[@class='our_price_display']/span)[1]")
    public WebElement price3After;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    public WebElement quantity;

    @FindBy(xpath = "//select[@id='group_1']")
    public WebElement defaultSize;

    @FindBy(xpath = "//select[@id='group_1']" )
    public WebElement options;

    @FindBy(xpath = "//span[@id='layer_cart_product_quantity']")
    public WebElement defaultQuantity;

    @FindBy(xpath = "//span[@id='layer_cart_product_attributes']")
    public WebElement selectedSize;

    @FindBy (xpath = "//span[@id='layer_cart_product_title']")
    public WebElement nameInCart;

    @FindBy(xpath = "//span[@id='layer_cart_product_price']")
    public WebElement priceInCart;

    @FindBy (xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']/h2")
    public WebElement confirmMessage;



}
