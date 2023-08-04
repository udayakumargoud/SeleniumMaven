package com.qa.pageobjects;

import com.qa.base.ApplicationBase;
import com.qa.util.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends ApplicationBase {

    public HomePage()throws IOException {

        PageFactory.initElements(driver, this);
    }
    //OR
    @FindBy(xpath="//a[@href='/contacts']/../button")
    WebElement buttonAddContacts;
    @FindBy(xpath="//a[@href='/home']")
    WebElement linkHome;

    //Actions
    public String getPageTitle(){
       return driver.getTitle();
    }
    public ContactsPage clickOnAddContacts() throws IOException {
        buttonAddContacts.click();
        return new ContactsPage();
    }
    public void moveToHomeLink(){
        Util.moveTOElement(linkHome);
    }
}
