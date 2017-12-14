package com.cambassy.cambassy_test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.LoginScreen;
import pageobjects.SplashScreen;
import pageobjects.TestBase;

public class HomeScreenTest extends TestBase {

	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void openApp() throws MalformedURLException {
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LoginScreen login = new LoginScreen(driver);
		SplashScreen splash = new SplashScreen(driver);
		login.quickLogin(splash, "main_user", "123456");
	}

	@Test
	public void f() {
		Assert.assertTrue(true);
	}

}
