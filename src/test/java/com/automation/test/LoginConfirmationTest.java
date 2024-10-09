package com.automation.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginConfirmationTest extends BaseTest {

    @Test(dataProvider = "usernameProvider")
    public void verifyUserCanLogin(String username){
        loginPage.openWebsite();
        loginPage.doLogin(username,"secret_sauce");
        Assert.assertTrue(homePage.isHomePageDisplayed());
        System.out.println("Login page succeeded");
    }

    @DataProvider
    public Object[] usernameProvider(){
        String[] users={"standard_user","locked_out_user","problem_user","performance_glitch_user","error_user","visual_user"};
        return users;
    }
}

