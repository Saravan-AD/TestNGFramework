package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
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

    @FindBy(className = "product_sort_container")
    WebElement sortElement;

    @FindBy(className = "inventory_item_name")
    List<WebElement> itemName;

    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPrice;

    @FindBy(xpath = "//button[contains(@id,'remove')]")
    List<WebElement> removeFromCartBtnList;

    public boolean isHomePageDisplayed() {
        return shoppingCartLink.isDisplayed();
    }

    public void clickOnAddToCartOfFirstItem() {
        addToCartBtnList.get(0).click();
    }

    public int clickOnAddToCartOfAllItem() {
        int num=addToCartBtnList.size();
        for(WebElement btn:addToCartBtnList)
            btn.click();
        return num;
    }

    public void clickOnShoppingCartLink() {
        shoppingCartLink.click();
    }

    public String checkQuantityOnShoppingCart(){
        return quantity.getText();
    }

    public void logoutMethod(){
        hamburger.click();
        logout.click();
    }

    public List<String> asscendingProdNames(){
        List<String> prodName=new ArrayList<>();
        for(WebElement item:itemName){
            prodName.add(item.getText());
        }
        return prodName;
    }

    public List<Double> asscendingProdNamesByPrice(){
        List<Double> prodPrice=new ArrayList<>();
        for(WebElement price:itemPrice){
            String priceText = price.getText().replace("$", "").replace(",", "").trim();
            prodPrice.add(Double.parseDouble(priceText));
        }
        Collections.sort(prodPrice);
        return prodPrice;
    }
    public List<String> sortProdByName(){
        Select selectElement=new Select(sortElement);
        selectElement.selectByValue("za");
        List<String> prodName=new ArrayList<>();
        for(WebElement item:itemName){
            prodName.add(item.getText());
        }
        return prodName;
    }

    public List<Double> sortProdByPrice(){
        Select selectElement=new Select(sortElement);
        selectElement.selectByValue("hilo");
        List<Double> prodPrice=new ArrayList<>();
        for(WebElement price:itemPrice){
            String priceText = price.getText().replace("$", "").replace(",", "").trim();
            prodPrice.add(Double.parseDouble(priceText));
        }
        return prodPrice;
    }

    public int removeCount(){
        System.out.println(removeFromCartBtnList.size());
        return removeFromCartBtnList.size();
    }
}
