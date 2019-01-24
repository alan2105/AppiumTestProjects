import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class setup {
	static AppiumDriver<MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException {
	String appPath = "/Users/alagappan.n/eclipse-workspace/SampleApp/src/ApiDemos-debug.apk";
		File appdir = new File (appPath);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5");
		cap.setCapability(MobileCapabilityType.VERSION, "9.0");
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
		cap.setCapability(MobileCapabilityType.APP, appdir.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("No proxy");
		driver.findElementsByClassName("android.widget.Button").get(1).click();
	}

}
