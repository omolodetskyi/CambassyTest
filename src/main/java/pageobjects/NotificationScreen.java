package pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class NotificationScreen {
	AndroidDriver<AndroidElement> driver;

	// constructor
	public NotificationScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

}
