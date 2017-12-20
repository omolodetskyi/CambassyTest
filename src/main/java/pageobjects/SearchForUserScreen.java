package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class SearchForUserScreen {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;
	By searchForUsertitle = By.className("android.widget.TextView");
	By searchUser = By.id("com.cambassy:id/search_query_edit");
	By userAvatar = By.id("com.cambassy:id/user_avatar_image");
	By searchUserName = By.id("com.cambassy:id/user_login_view");

	public SearchForUserScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public String getSearchForUserTitle() {
		return driver.findElements(searchForUsertitle).get(0).getText();
	}

	public void searchUser(String username) {
		// String firstPart = userName.substring(0, userName.length() - 1);
		// String lastPart = userName.substring(userName.length());
		driver.findElement(searchUser).sendKeys(username + " ");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public void selectUser(String username) {
		if (driver.findElements(searchUserName).size() > 0) {

			for (int i = 0; i < driver.findElements(searchUserName).size(); i++) {

				if (driver.findElements(searchUserName).get(i).getText().equals(username)) {

					driver.findElements(userAvatar).get(i).click();
				}
			}
		}
	}
}
