package com.apothuaud.selenium.cura.pages;

import com.apothuaud.selenium.cura.pages.components.FooterComponent;
import com.apothuaud.selenium.cura.pages.components.TopHeaderComponent;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HistoryPage {

    private RemoteWebDriver webDriver;
    private String url;

    private TopHeaderComponent topHeader;

    private FooterComponent footer;

    public HistoryPage(RemoteWebDriver webDriver){
        this.webDriver = webDriver;
        this.url = "https://katalon-demo-cura.herokuapp.com/history.php#history";
        this.topHeader = new TopHeaderComponent(webDriver);
        this.footer = new FooterComponent(webDriver);
    }

    public HistoryPage open(){
        webDriver.get(url);
        webDriver.manage().window().maximize();
        return this;
    }
}
