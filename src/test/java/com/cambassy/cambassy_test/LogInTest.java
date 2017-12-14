package com.cambassy.cambassy_test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.AnyScreen;
import pageobjects.HomeScreen;
import pageobjects.LoginScreen;
import pageobjects.SplashScreen;
import pageobjects.TestBase;

public class LogInTest extends TestBase {
	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void openApp() throws MalformedURLException {
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void LogIn_Test() {
		SplashScreen splash = new SplashScreen(driver);
		LoginScreen login = new LoginScreen(driver);
		HomeScreen home = new HomeScreen(driver);
		AnyScreen any = new AnyScreen(driver);
		// click on Login link
		splash.clickLogIn();
		// check if Login screen is opened
		Assert.assertEquals(login.getTitle(), "Log In");
		// enter user name
		login.enterUsername("main_user3");
		// enter password
		login.enterPassword("123456");
		// hide Keyboard
		any.hideKeyboard();
		// click Login button
		login.clickLogIn();
		// wait for login completion
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// check if user is logged in
		Assert.assertTrue(home.checkTitle(), "Can not find title on home page");
	}

}
