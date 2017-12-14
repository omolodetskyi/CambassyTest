package pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AnyScreen {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;

	public AnyScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void hideKeyboard() {
		driver.hideKeyboard();
	}

	public void goBack() {
		driver.navigate().back();
	}
}
