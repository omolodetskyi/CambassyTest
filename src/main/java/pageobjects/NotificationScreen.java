package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class NotificationScreen {
	AndroidDriver<AndroidElement> driver;
	By notification_Screen = By.id("com.cambassy:id/notifications");

	// constructor
	public NotificationScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public boolean isNotificationScreen() {
		return !driver.findElements(notification_Screen).isEmpty();
	}
}
