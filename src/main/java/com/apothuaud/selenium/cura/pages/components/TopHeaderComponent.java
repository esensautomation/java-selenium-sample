package com.apothuaud.selenium.cura.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopHeaderComponent {

    private RemoteWebDriver webDriver;

    private TopHeaderMenuComponent menu;
    private By makeApptmtBtn = By.id("btn-make-appointment");

    public TopHeaderComponent(RemoteWebDriver webDriver){
        this.webDriver = webDriver;
    }
}
