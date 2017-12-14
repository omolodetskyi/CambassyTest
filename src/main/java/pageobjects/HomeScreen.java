package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomeScreen {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;
	By posts72hrs = By.xpath("//android.widget.TextView[@text='Posts last 72 Hrs']");
	By contentMsg = By.id("com.cambassy:id/following_content_message_view");
	By btnFollowPeople = By.id("com.cambassy:id/toolbar_search_button");
	By btnChat = By.id("com.cambassy:id/toolbar_chat_button");

	// constructor

	public HomeScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public boolean checkTitle() {
		return !driver.findElements(posts72hrs).isEmpty();
	}

	public void clickFollowPeople() {
		driver.findElement(btnFollowPeople).click();
	}

	public void clickChat() {
		driver.findElement(btnChat).click();
	}

	public void swipeRight() {

	}

	public String checkContentMsg() {
		return driver.findElement(contentMsg).getText();
	}
}
