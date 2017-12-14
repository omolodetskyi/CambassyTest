package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BottomMenu {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;
	By buttons = By.id("com.cambassy:id/icon");

	// constructor
	public BottomMenu(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	private AndroidElement btnHome() {
		AndroidElement btnHome = driver.findElements(buttons).get(0);
		return btnHome;

	}

	private AndroidElement btnMyCambassador() {
		AndroidElement btnHome = driver.findElements(buttons).get(1);
		return btnHome;

	}

	private AndroidElement btnCamera() {
		AndroidElement btnHome = driver.findElements(buttons).get(2);
		return btnHome;

	}

	private AndroidElement btnNotification() {
		AndroidElement btnHome = driver.findElements(buttons).get(3);
		return btnHome;

	}

	private AndroidElement btnProfile() {
		AndroidElement btnHome = driver.findElements(buttons).get(4);
		return btnHome;

	}

	public void clickHome() {
		btnHome().click();
	}

	public void clickMyCambassador() {
		btnMyCambassador().click();
	}

	public void clickCamera() {
		btnCamera().click();
	}

	public void clickNotification() {
		btnNotification().click();
	}

	public void clickProfile() {
		btnProfile().click();
	}
}
