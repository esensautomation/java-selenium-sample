package com.apothuaud.selenium.cura.pages;

import com.apothuaud.selenium.cura.pages.components.FooterComponent;
import com.apothuaud.selenium.cura.pages.components.TopHeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage {

    private RemoteWebDriver webDriver;
    private String url;

    private TopHeaderComponent topHeader;
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
}
