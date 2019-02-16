package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }





}
