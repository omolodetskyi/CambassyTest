package com.cambassy.cambassy_test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.LoginScreen;
import pageobjects.SplashScreen;
import pageobjects.TestBase;

public class LogInTest extends TestBase {
	AndroidDriver<AndroidElement> driver;

	public void openApp() throws MalformedURLException {
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void LogInTest() {
		SplashScreen splash = new SplashScreen(driver);
		LoginScreen login = new LoginScreen(driver);
		// click on Sing Up link
		splash.clickLogIn();
		// check if Sign Up screen is opened
		Assert.assertEquals(login.getTitle(), "Sign Up");
		// enter user name
		login.enterUsername("main_user4");
		// enter password
		login.enterPassword("123456");
		// click Login button
		login.clickLogIn();

	}

}
