package com.automation.test;

import com.automation.pages.CartPage;
import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class SortTest extends BaseTest {
    @Test
    public void sortProductsAtoZ(){
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"),ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        List<String> aToz=homePage.asscendingProdNames();
        List<String> zToa=homePage.sortProdByName();
        Collections.sort(aToz,Collections.reverseOrder());

        Assert.assertEquals(aToz,zToa);
    }

    @Test
    public void sortProductsByPrice(){
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"),ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        List<Double> lowToHigh=homePage.asscendingProdNamesByPrice();
        List<Double> highToLow =homePage.sortProdByPrice();
        Collections.sort(lowToHigh,Collections.reverseOrder());

        Assert.assertEquals(lowToHigh, highToLow);
    }

    @Test
    public void addToCartQuantityChecking(){
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"),ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());

        int qty=homePage.clickOnAddToCartOfAllItem();
//        System.out.println(qty);
        String qtyInBadge=homePage.checkQuantityOnShoppingCart();
//        System.out.println(Integer.parseInt(qtyInBadge));
        Assert.assertEquals(qty,Integer.parseInt(qtyInBadge));

        homePage.clickOnShoppingCartLink();
        Assert.assertTrue(cartPage.isCartPageDisplayed());

        int cartPageQty=cartPage.checkQuantityOnCartPage();
        Assert.assertEquals(qty,cartPageQty);
    }
}
