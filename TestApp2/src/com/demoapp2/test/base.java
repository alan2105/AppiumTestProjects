package com.demoapp2.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class base {
	
    static AppiumDriver<WebElement> driver;
    public static void main(String[] args) throws MalformedURLException {

        File fp = new File("src");
        File fs = new File(fp,"ApiDemos-debug.apk");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel");
        caps.setCapability(MobileCapabilityType.VERSION, "9.0");
        caps.setCapability(MobileCapabilityType.APP,fs.getAbsoluteFile());
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }
}
