package com.apothuaud.selenium.cura.pages;

import com.apothuaud.selenium.cura.pages.components.FooterComponent;
import com.apothuaud.selenium.cura.pages.components.TopHeaderComponent;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Hello world!
 *
 */
public class HomePage {

    private RemoteWebDriver webDriver;
    private String url;

    private TopHeaderComponent topHeader;

    private FooterComponent footer;

    public HomePage(RemoteWebDriver webDriver){
        this.webDriver = webDriver;
        this.url = "https://katalon-demo-cura.herokuapp.com/";
        this.topHeader = new TopHeaderComponent(webDriver);
        this.footer = new FooterComponent(webDriver);
    }

    public HomePage open(){
        webDriver.get(url);
        webDriver.manage().window().maximize();
        return this;
    }
}
