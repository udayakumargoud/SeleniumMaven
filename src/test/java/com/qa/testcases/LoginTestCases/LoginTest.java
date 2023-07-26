package com.qa.testcases.LoginTestCases;

import com.qa.base.ApplicationBase;
import com.qa.pageobjects.homepage.HomePage;
import com.qa.pageobjects.login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends ApplicationBase {
    LoginPage objLoginPage;
    HomePage objHomePage;
       public LoginTest() throws IOException {
        super();

    }
    @BeforeMethod
    public void setUp() throws IOException {
           initialization();
           objLoginPage = new LoginPage();

    }
    @Test
    public void verifyLogin() throws IOException {
        String userName = prop.getProperty("username");
        String password = prop.getProperty("password");
        objHomePage = objLoginPage.Login(userName, password);
        String homepageTitle = objHomePage.getPageTitle();
        Assert.assertEquals(homepageTitle,"Cogmento CRM");
    }
    @AfterMethod
    public void tearDown(){

           driver.quit();
    }

}
