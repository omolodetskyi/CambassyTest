package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MyCambassadorScreen {

	AndroidDriver<AndroidElement> driver;
	By title = By.id("com.cambassy:id/toolbar_title_view");

	public MyCambassadorScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public String getMyCambassadorTitle() {
		return driver.findElement(title).getText();
	}
}
