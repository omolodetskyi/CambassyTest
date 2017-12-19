package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ChatScreen {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;
	By message = By.id("com.cambassy:id/edittext_group_chat_message");
	By btnSend = By.id("com.cambassy:id/button_group_chat_send");
	By chatMsg = By.id("com.cambassy:id/text_group_chat_message");
	By btnBack = By.id("com.cambassy:id/toolbar_back_button");
	By chatTime = By.id("com.cambassy:id/text_group_chat_time");

	public ChatScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void enterMessage(String enteredMessage) {
		driver.findElement(message).sendKeys(enteredMessage);
	}

	public void clickSend() {
		driver.findElement(btnSend).click();
	}

	public String getChatMsg(int index) {
		if (driver.findElements(chatMsg).size() > index) {
			return driver.findElements(chatMsg).get(index).getText();
		} else {
			return "None message found";
		}
	}

	public String getChatTime(int index) {
		if (driver.findElements(chatTime).size() > index) {
			return driver.findElements(chatTime).get(index).getText();
		} else {
			return "None time found";
		}
	}

}
