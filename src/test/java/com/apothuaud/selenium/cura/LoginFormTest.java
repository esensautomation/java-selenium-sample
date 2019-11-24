package com.apothuaud.selenium.cura;

import com.apothuaud.selenium.cura.data.TestNGProviders;
import com.apothuaud.selenium.cura.pages.AppointmentPage;
import com.apothuaud.selenium.cura.pages.HomePage;
import com.apothuaud.selenium.cura.pages.LoginPage;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginFormTest {

    private static final String validUsername = "John Doe";
    private static final String validPassword = "ThisIsNotAPassword";
    private static final String invalidUsername = "Jane Die";
    private static final String invalidPassword = "ThisIsAPassword";

    @Test(
            dataProviderClass = TestNGProviders.class,
            dataProvider = "all"
    )
    public void shouldLoginWithValidCredentials(String hub, Platform platform, String browser) throws MalformedURLException {

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
        }

        finally {
            if(webDriver != null) webDriver.quit();
        }
    }

    @Test(
            dataProviderClass = TestNGProviders.class,
            dataProvider = "all"
    )
    public void shouldNotLoginWithInvalidCredentials(String hub, Platform platform, String browser) throws MalformedURLException {

        RemoteWebDriver webDriver;

        URL hubUrl = new URL(hub);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(platform);
        capabilities.setBrowserName(browser);
        webDriver = new RemoteWebDriver(hubUrl, capabilities);

        LoginPage login = new LoginPage(webDriver);
        login.open();
        login.sendForm(invalidUsername, invalidPassword);

        Assert.assertTrue(login.isOpened());
        Assert.assertTrue(login.hasAlert("Login failed"));

        webDriver.quit();
    }
}
