package com.cambassy.cambassy_test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.BottomMenu;
import pageobjects.ProfileScreen;
import pageobjects.SettingsScreen;
import pageobjects.SignUpScreen;
import pageobjects.SplashScreen;
import pageobjects.TestBase;
import utils.ExcelDataProvider;

public class SignUpTest extends TestBase {
	AndroidDriver<AndroidElement> driver;
	BottomMenu bottomMenu;
	SettingsScreen settings;
	ProfileScreen profile;

	@BeforeTest
	public void openApp() throws Exception {
		ExcelDataProvider.setExcelFile("/Users/alexander/Downloads/cambassyTestData.xlsx", "SignUpTest");
		Reporter.log("Startig SignUpTest", true);
		driver = capabilities();
		Reporter.log("1. Open Cambassy", true);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@DataProvider(name = "SignUpTest")
	public Object[][] dataProvider() {
		Object[][] testData = ExcelDataProvider.getTestData("SignUpTest");
		return testData;

	}

	@AfterMethod
	public void Logout() {
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
	}

	@Test(dataProvider = "SignUpTest")
	public void SingUp_Test(String username, String email, String password, String nationality) {
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
		// TODO there is a defect that user is automatically logged, as soon as
		// it is fixed there should be added step to check the message and
		// logout steps can be deleted, now they are added to @AfterMethod to
		// make the whole suite working

	}

	@AfterTest
	public void cleanUp() {
		// driver.quit();
	}
}
