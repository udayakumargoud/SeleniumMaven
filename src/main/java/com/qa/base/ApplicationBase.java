package com.qa.base;

import com.qa.util.WebDriverFireEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ApplicationBase {

    public static WebDriver driver;
    public static Properties prop;
    WebDriverFireEvent objWebDriverFireEvent;
    EventFiringWebDriver e_driver;

    public  ApplicationBase() throws IOException {
       // FileReader reader=new FileReader("F:/Selenium/SeleniumMaven/src/main/java/com/qa/config/application.properties");
        prop = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/application.properties");
        prop.load(ip);
    }

      public void initialization() throws IOException {
      String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",
                    "F:\\Selenium\\SeleniumMaven\\src\\main\\java\\com\\qa\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            
        } else if (browserName.equalsIgnoreCase("edge")) {
            
        }
        //Event Firing code..
          e_driver = new EventFiringWebDriver(driver);
          objWebDriverFireEvent = new WebDriverFireEvent();
          e_driver.register(objWebDriverFireEvent);
          driver=e_driver;

          driver.manage().window().maximize();
          driver.manage().deleteAllCookies();
          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
          driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
          driver.get(prop.getProperty("url"));


    }


}
