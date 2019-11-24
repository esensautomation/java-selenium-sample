package com.apothuaud.selenium.cura.data;

import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;

public class TestNGProviders {

    @DataProvider(name = "all")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                { "http://192.168.43.171:4444/wd/hub", Platform.LINUX, "chrome" },
                { "http://192.168.43.171:4444/wd/hub", Platform.LINUX, "firefox" },
                { "http://192.168.43.171:4444/wd/hub", Platform.VISTA, "chrome" },
                { "http://192.168.43.171:4444/wd/hub", Platform.VISTA, "firefox" }
        };
    }
}
