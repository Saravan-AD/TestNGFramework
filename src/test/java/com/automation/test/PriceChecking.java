package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PriceChecking extends BaseTest {
    @Test
    public void addToCartQuantityChecking() {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());

        int qty = homePage.clickOnAddToCartOfAllItem();
        String qtyInBadge = homePage.checkQuantityOnShoppingCart();
        Assert.assertEquals(qty, Integer.parseInt(qtyInBadge));

        homePage.clickOnShoppingCartLink();
        Assert.assertTrue(cartPage.isCartPageDisplayed());
        cartPage.clickOnCheckoutBtn();

        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
        checkoutPage.fillShippingInfo();
        checkoutPage.clickOnContinueBtn();

        Assert.assertTrue(reviewPage.isReviewPageDisplayed());
        double totalPrice= reviewPage.priceCalc();
        Assert.assertEquals(reviewPage.getTotalPrice(),totalPrice);
    }
}
