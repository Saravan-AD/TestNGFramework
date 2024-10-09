package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartLink;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    List<WebElement> addToCartBtnList;

    @FindBy(className = "shopping_cart_badge")
    WebElement quantity;

    @FindBy(id = "react-burger-menu-btn")
    WebElement hamburger;

    @FindBy(id = "logout_sidebar_link")
    WebElement logout;

    public boolean isHomePageDisplayed() {
        return shoppingCartLink.isDisplayed();
    }

    public void clickOnAddToCartOfFirstItem() {
        addToCartBtnList.get(0).click();
    }

    public void clickOnShoppingCartLink() {
        shoppingCartLink.click();
    }

    public String checkQuantityOnShoppingCart(){
        System.out.println(quantity.getText());
        return quantity.getText();
    }

    public void logoutMethod(){
        hamburger.click();
        logout.click();
    }

}
