package com.qa.testcases.ContactsPageTestCases;

import com.qa.base.ApplicationBase;
import com.qa.pageobjects.ContactsPage;
import com.qa.pageobjects.HomePage;
import com.qa.pageobjects.LoginPage;
import com.qa.util.Util;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactsPageTest extends ApplicationBase {
    LoginPage objLoginPage;
    HomePage objHomePage;
    ContactsPage objContactsPage;
    Util objUtil;
    public ContactsPageTest() throws IOException {
        super();
    }
    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        objLoginPage = new LoginPage();

        String userName = prop.getProperty("username");
        String password = prop.getProperty("password");
        objHomePage = objLoginPage.Login(userName, password);
        objHomePage.moveToHomeLink();
        objContactsPage = objHomePage.clickOnAddContacts();
    }

    @Test(dataProvider = "getTestData")
    public void verifyContactCreation(String UserName, String Password){
        String firstName = UserName;
        String lastName = Password;
        objContactsPage.createNewContact(firstName,lastName);
        String contactName = objContactsPage.getContactName();
        Assert.assertEquals(contactName,firstName+" "+lastName,"Contact Name is not matching");

    }
    @DataProvider
    public Object[][] getTestData() throws IOException {
        objUtil = new Util();
      Object[][] testData = objUtil.getTestData("Contacts");
    return testData;
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
