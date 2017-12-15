package pageobjects;

import java.util.List;

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
	By nextScreenButtons = By.xpath("(//*[@NAF='true'])");
	By postFeedUserName = By.id("com.cambassy:id/user_name_view");
	By postImage = By.id("com.cambassy:id/thumb_image");
	// constructor

	public HomeScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	private AndroidElement nextScreenButtonRight() {
		AndroidElement nextScreenButtonRight = driver.findElements(nextScreenButtons).get(2);
		return nextScreenButtonRight;
	}

	private AndroidElement nextScreenButtonLeft() {
		AndroidElement nextScreenButtonLeft = driver.findElements(nextScreenButtons).get(3);
		return nextScreenButtonLeft;
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

	public void goToGoCambassy() {
		nextScreenButtonLeft().click();
	}

	public String checkContentMsg() {
		return driver.findElement(contentMsg).getText();
	}

	public boolean isUserPostHere(String username) {
		List<AndroidElement> userPosts = driver.findElements(postFeedUserName);
		boolean isUserPostHere = false;
		int i = 0;
		if (!userPosts.isEmpty()) {
			for (AndroidElement userPost : userPosts) {
				if (userPost.getText().equals(username)) {
					isUserPostHere = true;
				}
			}
		}
		return isUserPostHere;

	}
}
