package pageobjects;

import io.appium.java_client.android.AndroidDriver;

public class AnyScreen {
	// Driver declaration
	AndroidDriver driver;

	public AnyScreen(AndroidDriver driver) {
		this.driver = driver;
	}

	public void hideKeyboard() {
		driver.hideKeyboard();
	}
}
