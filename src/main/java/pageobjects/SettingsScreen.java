package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SettingsScreen {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;
	By btnLogout = By.id("com.cambassy:id/log_out_button");
	By confirmLogout = By.id("com.cambassy:id/dialog_yes_button");

	// constructor
	public SettingsScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void clickLogout() {

		driver.findElement(btnLogout).click();

	}

	public void ConfirmLogout() {
		driver.findElement(confirmLogout).click();
	}
}
