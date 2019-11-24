package com.apothuaud.selenium.cura;

public class ExecutionConfig {

    private String hub;
    private String platform;
    private String browser;

    private static ExecutionConfig instance = new ExecutionConfig();

    private ExecutionConfig(){

        String hubEnv = (System.getenv("hub")!=null)?System.getenv("hub"):"http://192.168.43.171:4444/wd/hub";
        String platform = (System.getenv("platform")!=null)?System.getenv("platform"):"LINUX";
        String browser = (System.getenv("browser")!=null)?System.getenv("browser"):"firefox";
    }

    public static ExecutionConfig getInstance(){
        return instance;
    }

    public String getHub() {
        return hub;
    }

    public void setHub(String hub) {
        this.hub = hub;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
}
