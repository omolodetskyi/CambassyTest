package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SignUpScreen {
	// Driver declaration
	AndroidDriver<AndroidElement> driver;
	// Sign Up title
	By signUptitle = By.xpath("//android.widget.TextView[@text='Sign Up']");
	// Username
	By userName = By.id("com.cambassy:id/signup_user_edit");
	// Email
	By email = By.id("com.cambassy:id/signup_mail_edit");
	// Password
	By password = By.id("com.cambassy:id/signup_password_edit");
	// Nationality dropdown
	By nationality = By.id("com.cambassy:id/nationality_view");
	// Search nationality field
	By searchNationality = By.id("com.cambassy:id/chooser_search_query_edit");
	// Nationality dropdown values
	By searchResultNationality = By.id("com.cambassy:id/text_view");

	// I agree with the Terms of Use
	By chkIagreeTerms = By.id("com.cambassy:id/signup_check_terms");
	// SignUP button
	By btnSignUp = By.id("com.cambassy:id/sign_up_button");
	// Login Link
	By loginLink = By.id("com.cambassy:id/signup_login_link");

	// constructor for SignUpScreen
	public SignUpScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	// enter UserName method
	public void enterUsername(String enteredUserName) {
		driver.findElement(userName).sendKeys(enteredUserName);
	}

	// enter UserName method
	public void enterEmail(String enteredEmail) {
		driver.findElement(email).sendKeys(enteredEmail);
	}

	// enter password method
	public void enterPassword(String enteredPassword) {
		driver.findElement(password).sendKeys(enteredPassword);
	}

	// select Nationality
	public void selectNationality(String enteredNationality) {
		// click on Nationality dropdown
		driver.findElement(nationality).click();
		// enter Nationality in search field
		driver.findElement(searchNationality).sendKeys(enteredNationality);
		// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// select first value in the search result

		driver.findElement(searchResultNationality).click();

	}

	// Check "I agree ..."
	public void checkIagreeTerms() {
		driver.findElement(chkIagreeTerms).click();
	}

	// Click "Sign Up" button
	public void clickSignUp() {
		driver.findElement(btnSignUp).click();
	}

	public String getTitle() {
		return driver.findElement(signUptitle).getText();
	}

	// Click "Log In" link
	public void clickLogIn() {
		driver.findElement(loginLink).click();
	}
}
