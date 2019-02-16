package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@title='Printed Summer Dress'])[4]")
    public WebElement anyProduct;

    @FindBy(id = "quantity_wanted")
    public WebElement quantityWanted;

    @FindBy(xpath = "//select[@id='group_1']")
    public WebElement selectSize;

    @FindBy(xpath = "//button[@class='exclusive']")
    public WebElement cartButton;

    @FindBy(xpath = "//i[@class='icon-ok']/..")
    public  WebElement confirmationMessage;

    @FindBy(xpath = "//span[@class='cross']")
    public WebElement xIcon;

    @FindBy(xpath = "//img[@alt='My Store']")
    public WebElement companyLogo;

    @FindBy(xpath = "(//a[@class='product_img_link'])[7]")
    public WebElement productOnSale;

    @FindBy(xpath = "(//iframe)[4]")
    public WebElement iFrame;

    @FindBy(id = "add_to_cart")
    public WebElement addToCart;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    public WebElement hoverOverCart;

    @FindBy(xpath = "(//span[@class='price'])[1]")
    public WebElement price1;

    @FindBy (xpath = "(//span[@class='price'])[2]")
    public WebElement price2;

    @FindBy (xpath = "//span[@class='price cart_block_shipping_cost ajax_cart_shipping_cost']")
    public WebElement shipping;

    @FindBy(xpath = "//span[@class='price cart_block_total ajax_block_cart_total']")
    public WebElement totalPrice;

    @FindBy(xpath = "//span[.='Total']")
    public WebElement cartDropDown;

































}
