package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SplashScreen {

	// Driver declaration
	AndroidDriver<AndroidElement> driver;

	// UI elements on Spalsh Screen

	// Login link
	By loginLink = By.xpath("//android.widget.TextView[@text='Already Cambassador? Log In.']");
	// Sign Up link
	By signUpLink = By.xpath("//android.widget.TextView[@text='Become a Cambassador? Sign Up.']");
	// image on the Splash Screen
	By splashImage = By.id("com.cambassy:id/slide_image");

	// constructor for SpalshScreen
	public SplashScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	// method clicking on LogIn link
	public void clickLogIn() {
		driver.findElement(loginLink).click();
	}

	// method clicking on SignUp link
	public void clickSignUp() {
		driver.findElement(signUpLink).click();
	}

}
