package com.apothuaud.selenium.cura;

import com.apothuaud.selenium.cura.data.TestNGProviders;
import com.apothuaud.selenium.cura.pages.AppointmentPage;
import com.apothuaud.selenium.cura.pages.AppointmentSummaryPage;
import com.apothuaud.selenium.cura.pages.LoginPage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

public class AppointmentFormTest {

    private static final String validUsername = "John Doe";
    private static final String validPassword = "ThisIsNotAPassword";

    @Test(
            dataProviderClass = TestNGProviders.class,
            dataProvider = "all"
    )
    public void shouldBookAppointmentWithValidInfo(String hub, Platform platform, String browser) throws MalformedURLException {

        RemoteWebDriver webDriver = null;

        try{
            URL hubUrl = new URL(hub);
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setPlatform(platform);
            capabilities.setBrowserName(browser);
            webDriver = new RemoteWebDriver(hubUrl, capabilities);

            LoginPage login = new LoginPage(webDriver);
            login.open();
            login.sendForm(validUsername, validPassword);

            AppointmentPage appointment = new AppointmentPage(webDriver);
            Assert.assertTrue(appointment.isOpened());
            appointment.sendForm(AppointmentPage.Facility.TOKYO, true, AppointmentPage.Program.MEDICARE, Calendar.getInstance().getTime(), "Test");

            AppointmentSummaryPage summary = new AppointmentSummaryPage(webDriver);
            Assert.assertTrue(summary.isOpened());
        }

        finally {
            if(webDriver != null) webDriver.quit();
        }
    }
}
