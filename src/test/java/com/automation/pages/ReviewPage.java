package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ReviewPage extends BasePage {

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPrice;

    @FindBy(className = "summary_tax_label")
    WebElement tax;

    @FindBy(className = "summary_total_label")
    WebElement total;

    public boolean isReviewPageDisplayed() {
        return finishBtn.isDisplayed();
    }

    public double priceCalc(){
        List<Double> prodPrice=new ArrayList<>();
        for(WebElement price:itemPrice){
            String priceText = price.getText().replace("$", "").replace(",", "").trim();
            prodPrice.add(Double.parseDouble(priceText));
        }
        double sumPrice = prodPrice.stream().mapToDouble(Double::doubleValue).sum();
        String priceText = tax.getText().replace("Tax:", "").replace("$","").trim();
        sumPrice=sumPrice+Double.parseDouble(priceText);
        return sumPrice;
    }

    public double getTotalPrice(){
        String priceText = total.getText().replace("Total:", "").replace("$","").trim();
        return Double.parseDouble(priceText);
    }

    public void clickOnFinishBtn() {
        finishBtn.click();
    }
}
