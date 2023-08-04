package com.qa.pageobjects;

import com.qa.base.ApplicationBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class ContactsPage extends ApplicationBase {

    public ContactsPage()throws IOException {

        PageFactory.initElements(driver, this);
    }
    //OR
    @FindBy(name="first_name")
    WebElement inputBoxFirstName;

    @FindBy(name="last_name")
    WebElement inputBoxLastName;

    @FindBy(xpath="//button[@class='ui linkedin button']")
    WebElement buttonSave;

    @FindBy(xpath = "//*[@class='large user red icon']/..")
    WebElement staticTextContact;



    //Actions
    public String getPageTitle(){
       return driver.getTitle();
    }

    public void createNewContact(String fName, String lName){
        inputBoxFirstName.sendKeys(fName);
        inputBoxLastName.sendKeys(lName);
        buttonSave.click();
    }
    public String getContactName(){
        return staticTextContact.getText();
    }




}
