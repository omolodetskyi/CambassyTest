package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class FollowPeople {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;
	By followPeopleTitle = By.xpath("(//android.widget.TextView)[1]");
	By searchPeople = By.id("com.cambassy:id/search_query_edit");
	By followUser = By.id("com.cambassy:id/user_follow_button");
	By followMsg = By.id("com.cambassy:id/snackbar_text");
	By followUserName = By.id("com.cambassy:id/user_login_view");

	public FollowPeople(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public String getFollowPeopleTitle() {
		return driver.findElement(followPeopleTitle).getText();
	}

	public void searchUser(String username) {
		driver.findElement(searchPeople).sendKeys(username);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void followUser(String username) {
		if (driver.findElements(followUserName).size() > 0) {

			for (int i = 0; i < driver.findElements(followUserName).size(); i++) {

				if (driver.findElements(followUserName).get(i).getText().equals(username)) {

					driver.findElements(followUser).get(i).click();
				}
			}
		}
	}

	public void unfollowUser(String username) {
		if (driver.findElements(followUserName).size() > 0) {

			for (int i = 0; i < driver.findElements(followUserName).size(); i++) {
				if (driver.findElements(followUserName).get(i).getText().equals(username)) {
					driver.findElements(followUser).get(i).click();
				}
			}
		}

	}

	public String getfollowMsg() {
		return driver.findElement(followMsg).getText();
	}
}
