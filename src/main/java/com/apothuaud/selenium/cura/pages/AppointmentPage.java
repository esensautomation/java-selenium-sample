package com.apothuaud.selenium.cura.pages;

import com.apothuaud.selenium.cura.pages.components.FooterComponent;
import com.apothuaud.selenium.cura.pages.components.TopHeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class AppointmentPage {

    private RemoteWebDriver webDriver;
    private String url;

    private TopHeaderComponent topHeader;
    private By facilitySelect = By.id("combo_facility");
    private By hospitalReadmissionCheckbox = By.id("chk_hospotal_readmission");
    private By medicareProgramRadioBtn = By.id("radio_program_medicare");
    private By medicaidProgramRadioBtn = By.id("radio_program_medicaid");
    private By noneProgramRadioBtn = By.id("radio_program_none");
    private By visitDateField = By.id("txt_visit_date");
    private By commentTextArea = By.id("txt_comment");
    private By bookAppointmentBtn = By.id("btn-book-appointment");
    private FooterComponent footer;

    public enum Facility{
        TOKYO("Tokyo CURA Healthcare Center"),
        HONGKONG("Hongkong CURA Healthcare Center"),
        SEOUL("Seoul CURA Healthcare Center"),
        ;
        String value;
        Facility(String value){
            this.value = value;
        }
        public String getValue(){
            return value;
        }
    }

    public enum Program{
        MEDICARE, MEDICAID, NONE;
    }

    SimpleDateFormat visitDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public AppointmentPage(RemoteWebDriver webDriver){
        this.webDriver = webDriver;
        this.url = "https://katalon-demo-cura.herokuapp.com/#appointment";
        this.topHeader = new TopHeaderComponent(webDriver);
        this.footer = new FooterComponent(webDriver);
    }

    public AppointmentPage open(){
        webDriver.get(url);
        webDriver.manage().window().maximize();
        return this;
    }

    public boolean isOpened(){
        return webDriver.getCurrentUrl().contentEquals(url);
    }

    public AppointmentPage sendForm(Facility facility, boolean readmission, Program program, Date visitDate, String comment){
        Select select = new Select(webDriver.findElement(facilitySelect));
        select.selectByValue(facility.getValue());
        if(readmission) webDriver.findElement(hospitalReadmissionCheckbox).click();
        switch (program){
            case MEDICARE:
                webDriver.findElement(medicareProgramRadioBtn).click();
                break;
            case MEDICAID:
                webDriver.findElement(medicaidProgramRadioBtn).click();
                break;
            case NONE:
                webDriver.findElement(noneProgramRadioBtn).click();
                break;
        }
        String formatDate = visitDateFormat.format(visitDate);
        webDriver.findElement(visitDateField).sendKeys(formatDate);
        webDriver.findElement(commentTextArea).sendKeys(comment);
        webDriver.findElement(bookAppointmentBtn).click();
        return this;
    }
}
