package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MessagesScreen {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;
	By messagesTitle = By.xpath("(//android.widget.TextView)[1]");
	By btnAddChat = By.id("com.cambassy:id/toolbar_add_chat_button");
	By chatLastMsg = By.id("com.cambassy:id/user_last_message_view");
	By chatLastTime = By.id("com.cambassy:id/chat_last_message_date_time_view");
	By numberOfUnreadMsg = By.id("com.cambassy:id/chat_unread_messages_count_view");
	By chatDate = By.id("");
	By btnDeleteChat = By.id("com.cambassy:id/toolbar_delete_chat_button");
	By btnRemoveChat = By.id("com.cambassy:id/chat_remove_button");
	By btnConfirmDelete = By.id("com.cambassy:id/chat_remove_confirm_button");
	By btnCloseDelete = By.id("com.cambassy:id/toolbar_delete_chat_confirm_button");

	public MessagesScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public String getMessagesTitle() {

		return driver.findElement(messagesTitle).getText();
	}

	public void clickAddChat() {
		driver.findElement(btnAddChat).click();
	}

	public void clickDeleteChat() {
		driver.findElement(btnDeleteChat).click();
	}

	public void clickRemoveChat(int index) {
		driver.findElements(btnRemoveChat).get(index).click();
	}

	public void clickConfirmDelete(int index) {
		driver.findElements(btnConfirmDelete).get(index).click();
	}

	public String getLastMessage(int index) {
		if (driver.findElements(chatLastMsg).size() > index) {
			return driver.findElements(chatLastMsg).get(index).getText();
		} else {
			return "None message found";
		}
	}

	public String getLastTime(int index) {
		if (driver.findElements(chatLastTime).size() > index) {
			return driver.findElements(chatLastTime).get(index).getText();
		} else {
			return "None time found";
		}
	}

	public String getNumberOfUnreadMsg() {
		if (!driver.findElements(numberOfUnreadMsg).isEmpty()) {
			return driver.findElements(numberOfUnreadMsg).get(0).getText();
		}
		return "0";
	}

	public void clickNumberOfUnreadMsg() {
		driver.findElement(numberOfUnreadMsg).click();
	}

	public void clickCloseDeleteMode() {
		driver.findElement(btnCloseDelete).click();
	}
}
