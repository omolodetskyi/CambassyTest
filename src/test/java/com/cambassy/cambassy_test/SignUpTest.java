package com.cambassy.cambassy_test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.SignUpScreen;
import pageobjects.SplashScreen;
import pageobjects.TestBase;

public class SignUpTest extends TestBase {
	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void openApp() throws MalformedURLException {
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void SingUp_Test() {
		SplashScreen splash = new SplashScreen(driver);
		SignUpScreen signUp = new SignUpScreen(driver);
		// click on Sing Up link
		splash.clickSignUp();
		// check if Sign Up screen is opened
		Assert.assertEquals(signUp.getTitle(), "Sign Up");
		// enter user name
		signUp.enterUsername("main_user3");
		// enter email
		signUp.enterEmail("test3@test.com");
		// enter password
		signUp.enterPassword("123456");
		// select Nationality
		signUp.selectNationality("Ukraine");
		// agree with Terms of Use
		signUp.checkIagreeTerms();
		// tap Sign up button
		signUp.clickSignUp();

	}
}
