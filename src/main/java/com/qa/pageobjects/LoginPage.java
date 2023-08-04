package com.qa.pageobjects;

import com.qa.base.ApplicationBase;
import com.qa.pageobjects.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends ApplicationBase {

    public LoginPage() throws IOException {
       PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//input[@name='email']")
    WebElement userName;
    @FindBy(xpath="//input[@name='password']")
    WebElement password;
    @FindBy(xpath="//div[text()='Login']")
    WebElement loginbutton;


    //actions

    public HomePage Login(String usrName, String pwd) throws IOException {
        userName.sendKeys(usrName);
        password.sendKeys(pwd);
        loginbutton.click();
        return new HomePage();
    }
}
