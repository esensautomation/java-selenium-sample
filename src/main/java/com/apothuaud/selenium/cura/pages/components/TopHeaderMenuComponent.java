package com.apothuaud.selenium.cura.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopHeaderMenuComponent {

    private RemoteWebDriver webDriver;

    private By toggleBtn = By.id("menu-toggle");
    private By homeLnk = By.linkText("Home");
    private By loginLnk = By.linkText("Login");
    private By historyLnk = By.linkText("History");
    private By profileLnk = By.linkText("Profile");
    private By logoutLnk = By.linkText("Logout");

    public TopHeaderMenuComponent(RemoteWebDriver webDriver){
        this.webDriver = webDriver;
    }
}
