package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomeScreen {
	// Driver declaration
	AndroidDriver driver;
	By posts72hrs = By.xpath("//android.widget.TextView[@text='Posts last 72 Hrs']");

	// constructor

	public HomeScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public boolean checkTitle() {
		return !driver.findElements(posts72hrs).isEmpty();
	}
}
