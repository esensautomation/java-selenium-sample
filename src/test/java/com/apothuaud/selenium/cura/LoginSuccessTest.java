package com.apothuaud.selenium.cura;

import com.apothuaud.selenium.cura.pages.LoginPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginSuccessTest {

    private void testLogic(RemoteWebDriver webDriver){

        LoginPage login = new LoginPage(webDriver);

        login.open();
    }

    @Test
    public void chromeTest() throws MalformedURLException {

        RemoteWebDriver webDriver;

        URL hubUrl = new URL("http://192.168.43.171:4444/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        webDriver = new RemoteWebDriver(hubUrl, capabilities);

        testLogic(webDriver);

        webDriver.quit();
    }

    @Test
    public void firefoxTest() throws MalformedURLException {

        RemoteWebDriver webDriver;

        URL hubUrl = new URL("http://192.168.43.171:4444/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        webDriver = new RemoteWebDriver(hubUrl, capabilities);

        testLogic(webDriver);

        webDriver.quit();
    }
}
