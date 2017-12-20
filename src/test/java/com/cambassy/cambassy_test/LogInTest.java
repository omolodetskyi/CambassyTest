package com.cambassy.cambassy_test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.AnyScreen;
import pageobjects.BottomMenu;
import pageobjects.HomeScreen;
import pageobjects.LoginScreen;
import pageobjects.ProfileScreen;
import pageobjects.SettingsScreen;
import pageobjects.SplashScreen;
import pageobjects.TestBase;
import utils.ExcelDataProvider;

public class LogInTest extends TestBase {
	AndroidDriver<AndroidElement> driver;
	SplashScreen splash;
	LoginScreen login;
	HomeScreen home;
	AnyScreen any;
	BottomMenu bottomMenu;
	SettingsScreen settings;
	ProfileScreen profile;

	@DataProvider(name = "LoginTest")
	public Object[][] dataProvider() {
		Object[][] testData = ExcelDataProvider.getTestData("LoginTest");
		return testData;

	}

	@BeforeTest
	public void openApp() throws Exception {
		ExcelDataProvider.setExcelFile("/Users/alexander/Downloads/cambassyTestData-2.xlsx", "LoginTest");
		Reporter.log("Startig LoginTest", true);
		driver = capabilities();
		Reporter.log("1. Open Cambassy", true);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "LoginTest")
	public void LogIn_Test(String username, String password) {

		splash = new SplashScreen(driver);
		login = new LoginScreen(driver);
		home = new HomeScreen(driver);
		any = new AnyScreen(driver);

		// click on Login link
		Reporter.log("2. Click on Login link", true);
		splash.clickLogIn();
		// check if Login screen is opened
		Reporter.log("3. Check if Login screen is opened", true);
		Assert.assertEquals(login.getTitle(), "Log In");
		// enter user name
		Reporter.log("4. Enter username " + username, true);
		login.enterUsername(username);
		// enter password
		Reporter.log("5. Enter password " + password, true);
		login.enterPassword(password);
		// hide Keyboard
		Reporter.log("6. Hide Keyboard", true);
		any.hideKeyboard();
		// click Login button
		Reporter.log("7. Click Login button", true);
		login.clickLogIn();
		// wait for login completion
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// check if user is logged in
		Reporter.log("8. Check if user is logged in", true);
		Assert.assertTrue(home.checkTitle(), "Can not find title on home page");
	}

	@AfterTest
	public void cleanUp() {
		bottomMenu = new BottomMenu(driver);
		settings = new SettingsScreen(driver);
		profile = new ProfileScreen(driver);
		// Go to Profile
		Reporter.log("9. Go to Profile", true);
		bottomMenu.clickProfile();
		// Go to Settings
		Reporter.log("10. Go to Settings", true);
		profile.clickSettingsBtn();
		// Click log out button
		Reporter.log("11. Click log out button", true);
		settings.clickLogout();
		// confirm log out
		Reporter.log("12. Confirm logout", true);
		settings.ConfirmLogout();
		driver.quit();
	}
}
