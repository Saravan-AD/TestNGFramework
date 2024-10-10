package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(id = "checkout")
    WebElement checkOutBtn;

    @FindBy(className = "cart_quantity")
    List<WebElement> cartPageQty;

    public boolean isCartPageDisplayed() {
        return checkOutBtn.isDisplayed();
    }

    public void clickOnCheckoutBtn() {
        checkOutBtn.click();
    }

    public int checkQuantityOnCartPage(){
        int quantity=0;
        for(WebElement qty:cartPageQty){
            quantity+=Integer.parseInt(qty.getText());
        }
        return quantity;
    }
}
