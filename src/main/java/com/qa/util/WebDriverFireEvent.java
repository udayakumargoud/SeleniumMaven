package com.qa.util;

import com.qa.base.ApplicationBase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.IOException;

public class WebDriverFireEvent extends ApplicationBase implements WebDriverEventListener {
    public WebDriverFireEvent() throws IOException {
    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        System.out.println("Trying to accept the Alert..");
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        System.out.println("Alert has been accepted..");
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        System.out.println("Alert has been dismissed..");
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        System.out.println("Trying to dismiss the Alert");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Trying to navigate to URL"+ url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to URL"+ url);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("Trying to navigate back ");
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("Navigated back..");
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Trying to navigate Forward ");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        System.out.println("Navigated Forward..");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        System.out.println("Trying to Refresh ");
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        System.out.println("Page has been Refreshed..");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find an element"+element);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found element by locator.."+element);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on an element"+element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on an element"+element);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Trying to enter Text"+keysToSend+" into the element"+element);
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Entered Text"+keysToSend+" into the element"+element);
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        System.out.println("Trying to the execute script.."+script);
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        System.out.println("Executed the script.."+script);
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("Trying to switch to new window.."+windowName);
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("Switched to new window.."+windowName);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.println("Exception occurred.."+throwable.getMessage());
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        System.out.println("Trying to get the text of the element.."+element);
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        System.out.println("Got the text of the element.."+element);
    }
}
