package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage{

    @FindBy(css = ".complete-header")
    WebElement orderConfirmationMsg;

    public boolean isOrderConfirmationMsgDisplayed() {
        System.out.println(orderConfirmationMsg.getText());
        return orderConfirmationMsg.isDisplayed();
    }
}
