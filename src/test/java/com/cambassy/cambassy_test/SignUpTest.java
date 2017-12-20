package com.cambassy.cambassy_test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.SignUpScreen;
import pageobjects.SplashScreen;
import pageobjects.TestBase;

public class SignUpTest extends TestBase {
	AndroidDriver<AndroidElement> driver;
	String username = "test_ms_user2";
	String email = "test_ms_user2@test.com";
	String password = "123456";
	String nationality = "Ukraine";

	@BeforeTest
	public void openApp() throws MalformedURLException {
		Reporter.log("Startig SignUpTest", true);
		driver = capabilities();
		Reporter.log("1. Open Cambassy", true);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void SingUp_Test() {
		SplashScreen splash = new SplashScreen(driver);
		SignUpScreen signUp = new SignUpScreen(driver);
		// click on Sing Up link
		Reporter.log("2. Click on Sing Up link", true);
		splash.clickSignUp();
		Reporter.log("3. Check if Sign Up screen is opened", true);
		// check if Sign Up screen is opened
		Assert.assertEquals(signUp.getTitle(), "Sign Up");
		// enter user name
		Reporter.log("3. Enter user name " + username, true);
		signUp.enterUsername(username);
		// enter email
		Reporter.log("4. Enter email " + email, true);
		signUp.enterEmail(email);
		// enter password
		Reporter.log("5. Enter password " + password, true);
		signUp.enterPassword(password);
		// select Nationality
		Reporter.log("6. Enter nationality " + nationality, true);
		signUp.selectNationality(nationality);
		// agree with Terms of Use
		Reporter.log("6. Agree with Terms of Use", true);
		signUp.checkIagreeTerms();
		// tap Sign up button
		Reporter.log("7. Tap Sign up button", true);
		signUp.clickSignUp();
		// Check the message that email is sent to user
		Reporter.log("8. Check the message that email is sent to  user", true);

	}

	@AfterTest
	public void cleanUp() {
		driver.quit();
	}
}
