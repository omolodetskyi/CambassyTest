package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MessagesScreen {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;
	By messagesTitle = By.xpath("(//android.widget.TextView)[1]");

	public MessagesScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public String getMessagesTitle() {

		return driver.findElement(messagesTitle).getText();
	}
}
