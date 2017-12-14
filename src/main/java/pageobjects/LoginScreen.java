package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginScreen {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;

	// Sign Up title
	By logIntitle = By.xpath("//android.widget.TextView[@text='Log In']");

	// Username
	By userName = By.id("com.cambassy:id/login_user_edit");

	// Password
	By password = By.id("com.cambassy:id/login_password_edit");

	// Remember Me radio button
	By rememberMe = By.id("com.cambassy:id/login_remember_check");

	// Forgot Password

	By forgotPassword = By.id("com.cambassy:id/login_forgot_pass");

	// Log In button
	By btnLogIn = By.id("com.cambassy:id/login_button");

	// SignUp Link
	By signUpLink = By.id("com.cambassy:id/login_link_sign_up");

	// LoginBack

	By loginBack = By.id("com.cambassy:id/login_back");

	// constructor

	public LoginScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public String getTitle() {

		return driver.findElement(logIntitle).getText();
	}

	public void enterUsername(String enteredUserName) {
		driver.findElement(userName).sendKeys(enteredUserName);
	}

	public void enterPassword(String enteredPassword) {
		driver.findElement(password).sendKeys(enteredPassword);
	}

	public void clickLogIn() {
		driver.findElement(btnLogIn).click();

	}

	public void quickLogin(SplashScreen splash, String enteredUserName, String enteredPassword) {

		// click on Login link
		splash.clickLogIn();

		enterUsername(enteredUserName);
		// enter password
		enterPassword(enteredPassword);
		// hide Keyboard
		driver.hideKeyboard();
		// click Login button
		clickLogIn();

	}

}
