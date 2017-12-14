package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FollowPeople {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;
	By followPeopleTitle = By.xpath("(//android.widget.TextView)[1]");

	public FollowPeople(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public String getFollowPeopleTitle() {
		return driver.findElement(followPeopleTitle).getText();
	}
}
