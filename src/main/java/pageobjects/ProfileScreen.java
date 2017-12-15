package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProfileScreen {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;
	By title = By.id("com.cambassy:id/toolbar_title_view");
	By btnSettings = By.id("com.cambassy:id/toolbar_right_image_button");

	// constructor
	public ProfileScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public String getProfileTitle() {
		return driver.findElement(title).getText();
	}

	public void clickSettingsBtn() {
		driver.findElement(btnSettings).click();
	}
}
