package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GoCambassyScreen {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;
	By goCambassy_Screen = By.id("com.cambassy:id/slide_image");
	By nextScreenButtons = By.xpath("(//*[@NAF='true'])");

	// constructor
	public GoCambassyScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public AndroidElement goCambassy_Screen_Element() {

		AndroidElement goCambassy_Screen_Element;
		goCambassy_Screen_Element = driver.findElement(goCambassy_Screen);
		return goCambassy_Screen_Element;

	}

	private AndroidElement nextScreenButtonLeft() {
		AndroidElement nextScreenButtonLeft = driver.findElements(nextScreenButtons).get(0);
		return nextScreenButtonLeft;
	}

	public void goToHomeScreen() {
		nextScreenButtonLeft().click();
	}

	public boolean isGoCambassyScreen() {

		return !driver.findElements(goCambassy_Screen).isEmpty();
	}

	public void swipeLeft() {
		Dimension size = driver.manage().window().getSize();
		int startx = (int) (size.width * 0.70);
		int starty = (int) (size.height / 2);
		int endx = (int) (size.width * 0.30);
		driver.swipe(startx, starty, endx, starty, 3000);

	}
}
