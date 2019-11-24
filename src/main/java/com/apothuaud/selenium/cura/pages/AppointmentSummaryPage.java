package com.apothuaud.selenium.cura.pages;

import com.apothuaud.selenium.cura.pages.components.FooterComponent;
import com.apothuaud.selenium.cura.pages.components.TopHeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Hello world!
 *
 */
public class AppointmentSummaryPage {

    private RemoteWebDriver webDriver;
    private String url;

    private TopHeaderComponent topHeader;
    private By facilityLabel = By.id("facility");
    private By readmissionLabel = By.id("hospital_readmission");
    private By programLabel = By.id("program");
    private By visitDateLabel = By.id("visit_date");
    private By commentId = By.id("comment");
    private FooterComponent footer;

    public AppointmentSummaryPage(RemoteWebDriver webDriver){
        this.webDriver = webDriver;
        this.url = "https://katalon-demo-cura.herokuapp.com/appointment.php#summary";
        this.topHeader = new TopHeaderComponent(webDriver);
        this.footer = new FooterComponent(webDriver);
    }

    public AppointmentSummaryPage open(){
        webDriver.get(url);
        webDriver.manage().window().maximize();
        return this;
    }

    public boolean isOpened(){
        return webDriver.getCurrentUrl().contentEquals(url);
    }
}
