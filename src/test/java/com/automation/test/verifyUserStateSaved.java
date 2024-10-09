package com.automation.test;

import com.automation.pages.HomePage;
import com.automation.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class verifyUserStateSaved extends BaseTest {
    @Test(dataProvider = "getValidCredentials")
    public void verifyUserCanLoginWithValidCred(String username, String password) {
        loginPage.openWebsite();
        loginPage.doLogin(username, password);
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @DataProvider
    public Object[][] getValidCredentials() {
        ExcelUtils excelUtils = new ExcelUtils("Credentials.xlsx", "ValidData");
        List<List<String>> tableData = excelUtils.getData();
        Object[][] data = new Object[tableData.size()][tableData.get(0).size()];

        for (int i = 0; i < tableData.size(); i++) {
            List<String> row = tableData.get(i);
            for (int j = 0; j < row.size(); j++) {
                data[i][j] = tableData.get(i).get(j);
            }
        }

        return data;
    }
//    @Test
//    public void userState() throws InterruptedException {
//        loginPage.openWebsite();
//        loginPage.doLogin("standard_user", "secret_sauce");
//
//        Assert.assertTrue(homePage.isHomePageDisplayed());
//        homePage.clickOnAddToCartOfFirstItem();
//
//        Assert.assertEquals(homePage.checkQuantityOnShoppingCart(),"1");
//        homePage.logoutMethod();
//        loginPage.doLogin("standard_user", "secret_sauce");
//
//        Assert.assertTrue(homePage.isHomePageDisplayed());
//
//
//        Assert.assertEquals(homePage.checkQuantityOnShoppingCart(),"1");
//    }
}
