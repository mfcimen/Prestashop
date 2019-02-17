package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@title='Printed Summer Dress'])[4]")
    public WebElement anyProduct4;

    @FindBy(xpath = "//a[@class='cart_block_product_name']")
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

    @FindBy(xpath = "(//a[@class='button ajax_add_to_cart_button btn btn-default'])[3]/span")
    public WebElement addItQuick;

    @FindBy(xpath = "(//img[@class='replace-2x img-responsive'])[3]")
    public WebElement anyProductImg;

    @FindBy(xpath = "(//a[@title='Printed Summer Dress'])[1]")
    public WebElement productInCart;

    @FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    public WebElement emptyCart;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    public WebElement continueShopping;

    @FindBy(xpath = "//a[@class='ajax_cart_block_remove_link']")
    public WebElement removeIcon;

































}
