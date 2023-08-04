package com.qa.testcases.HomePageTestCases;

import com.qa.base.ApplicationBase;
import com.qa.pageobjects.ContactsPage;
import com.qa.pageobjects.HomePage;
import com.qa.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends ApplicationBase {
    LoginPage objLoginPage;
    HomePage objHomePage;
    ContactsPage objContactsPage;
       public HomePageTest() throws IOException {
        super();

    }
    @BeforeMethod
    public void setUp() throws IOException {
           initialization();
           objLoginPage = new LoginPage();
           String userName = prop.getProperty("username");
           String password = prop.getProperty("password");
           objHomePage = objLoginPage.Login(userName, password);
           String homepageTitle = objHomePage.getPageTitle();
           Assert.assertEquals(homepageTitle,"Cogmento CRM");
    }
    @Test
    public void verifyHomePageTitle() throws IOException {
        objHomePage.moveToHomeLink();
        objContactsPage = objHomePage.clickOnAddContacts();
        String contactsPageTitle = objContactsPage.getPageTitle();
        Assert.assertEquals(contactsPageTitle, "Cogmento CRM", "PageTitle is not matching");

    }
    @AfterMethod
    public void tearDown(){

           driver.quit();
    }

}
