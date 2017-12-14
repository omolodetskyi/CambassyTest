package pageobjects;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	public AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		String serverIP = "127.0.0.1";
		String serverPort = "4723";
		String app = "com.cambassy";
		String deviceId = "520365e0f0c0a3cd";
		String deviceName = "j7xeltexx";
		String activityName = ".module.launch.LaunchActivity";
		AndroidDriver<AndroidElement> driver;
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);

		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, app);
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activityName);

		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");

		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		driver = new AndroidDriver<AndroidElement>(new URL("http://" + serverIP + ":" + serverPort + "/wd/hub"), dc);

		return driver;

	}

}
