package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(id = "checkout")
    WebElement checkOutBtn;

    public boolean isCartPageDisplayed() {
        return checkOutBtn.isDisplayed();
    }

    public void clickOnCheckoutBtn() {
        checkOutBtn.click();
    }
}
