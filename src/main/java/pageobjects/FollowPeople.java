package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FollowPeople {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;
	By followPeopleTitle = By.xpath("(//android.widget.TextView)[1]");
	By searchPeople = By.id("com.cambassy:id/search_query_edit");
	By followUser = By.id("com.cambassy:id/user_follow_button");

	public FollowPeople(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public String getFollowPeopleTitle() {
		return driver.findElement(followPeopleTitle).getText();
	}

	public void searchUser(String username) {
		driver.findElement(searchPeople).sendKeys(username);
	}

	public void followUser() {
		driver.findElements(followUser).get(0).click();
	}
}
