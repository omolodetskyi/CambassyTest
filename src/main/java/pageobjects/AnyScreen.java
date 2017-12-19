package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AnyScreen {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;
	By btnBack = By.id("com.cambassy:id/toolbar_back_button");

	public AnyScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void hideKeyboard() {
		driver.hideKeyboard();
	}

	public void goBack() {
		driver.navigate().back();
	}

	public void clickBack() {
		driver.findElement(btnBack).click();
	}
}
