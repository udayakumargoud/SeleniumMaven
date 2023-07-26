package com.qa.pageobjects.homepage;

import com.qa.base.ApplicationBase;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends ApplicationBase {

    public HomePage()throws IOException {

        PageFactory.initElements(driver, this);
    }
    //OR


    //Actions
    public String getPageTitle(){
       return driver.getTitle();
    }
}
