package com.winjit.qtmtest.module;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public static WindowsDriver driver = null;
    private final Properties Configproperties;
    BufferedReader Configreader;
    private final String configPropertyFilePath = "configFile//Configuration.properties";

    //load config file in base constructor
    public base() {
        try {
            Configreader = new BufferedReader(new FileReader(configPropertyFilePath));
            Configproperties = new Properties();
            try {
                Configproperties.load(Configreader);
                Configreader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + configPropertyFilePath);
        }

    }

    //setUP driver
    public void setUpDriver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
           // capabilities.setCapability("app", "C:\\Program Files (x86)\\SA-Taxi (QuanTaMax)\\QuanTaMax.exe");
            capabilities.setCapability("app", getElementFromConfig("ApplicationPath"));
            capabilities.setCapability("ms:waitForAppLaunch", 40);
            capabilities.setCapability("platformName", "Windows");
            capabilities.setCapability("deviceName", "WindowsPC");
            capabilities.setCapability("platformVersion", "10");
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        } catch (Exception e) {
            e.printStackTrace();

        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //CLOSE THE DRIVER
    public void cleanUpDriver() {
        driver.quit();

    }

    //READ THE Element from config file
    public String getElementFromConfig(String element) {
        String elementFromConfig =Configproperties.getProperty(element);

        if ( elementFromConfig != null) return elementFromConfig;
        else throw new RuntimeException( element + ": not specified in the config  file.");
    }

}
