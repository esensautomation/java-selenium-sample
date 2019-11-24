package com.apothuaud.selenium.cura.pages;

import com.apothuaud.selenium.cura.pages.components.FooterComponent;
import com.apothuaud.selenium.cura.pages.components.TopHeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage {

    private RemoteWebDriver webDriver;
    private String url;

    private TopHeaderComponent topHeader;
    private By alertMessage = By.xpath("//p[contains(@class, 'text-danger')]");
    private By usernameField = By.id("txt-username");
    private By passwordField = By.id("txt-password");
    private By loginBtn = By.id("btn-login");
    private FooterComponent footer;

    public LoginPage(RemoteWebDriver webDriver){
        this.webDriver = webDriver;
        this.url = "https://katalon-demo-cura.herokuapp.com/profile.php#login";
        this.topHeader = new TopHeaderComponent(webDriver);
        this.footer = new FooterComponent(webDriver);
    }

    public LoginPage open(){
        webDriver.get(url);
        webDriver.manage().window().maximize();
        return this;
    }

    public boolean isOpened(){
        return webDriver.getCurrentUrl().contentEquals(url);
    }

    public LoginPage sendForm(String username, String password){
        webDriver.findElement(usernameField).sendKeys(username);
        webDriver.findElement(passwordField).sendKeys(password);
        webDriver.findElement(loginBtn).click();
        return this;
    }

    public boolean hasAlert(String expected) {
        try{
            WebElement alert = webDriver.findElement(alertMessage);
            return alert.getText().contains(expected);
        }catch (Exception e) {
            return false;
        }
    }
}
