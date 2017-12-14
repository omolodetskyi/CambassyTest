package com.cambassy.cambassy_test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.AnyScreen;
import pageobjects.BottomMenu;
import pageobjects.CameraScreen;
import pageobjects.FollowPeople;
import pageobjects.HomeScreen;
import pageobjects.LoginScreen;
import pageobjects.MessagesScreen;
import pageobjects.MyCambassadorScreen;
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
		login.quickLogin(splash, "main_user2", "123456");
	}

	@Test
	public void HomeScreen_Test() {
		HomeScreen home = new HomeScreen(driver);
		BottomMenu bottomMenu = new BottomMenu(driver);
		FollowPeople followPeople = new FollowPeople(driver);
		MessagesScreen messages = new MessagesScreen(driver);
		AnyScreen any = new AnyScreen(driver);
		MyCambassadorScreen myCambassador = new MyCambassadorScreen(driver);
		CameraScreen camera = new CameraScreen(driver);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// check if home screen has correct title
		Assert.assertTrue(home.checkTitle(), "Can not find title on home page");
		// check follow people message
		Assert.assertEquals(home.checkContentMsg(), "Start following people", "There is wrong content message!");
		// click Follow People button
		home.clickFollowPeople();
		// check Follow People title
		Assert.assertEquals(followPeople.getFollowPeopleTitle(), "Follow People");
		// return back to Home screen
		any.goBack();
		// click Chat button
		home.clickChat();
		// check Messages screen title
		Assert.assertEquals(messages.getMessagesTitle(), "People you ❤");
		// return back to Home screen
		any.goBack();
		// click MyCambassador button
		bottomMenu.clickMyCambassador();
		// check MyCambassador screen title
		Assert.assertEquals(myCambassador.getMyCambassadorTitle(), "My Cambassador");
		// return back to Home screen
		bottomMenu.clickHome();
		// click Camera button
		bottomMenu.clickCamera();
		// check Camera screen
		while (camera.isPermissionMsg()) {
			camera.clickAllow();
		}
		Assert.assertTrue(camera.isbtnCapture());
		// return back to Home screen
		camera.clickClose();
		// click Notification button
		bottomMenu.clickNotification();
		// check Notification screen title

		// return back to Home screen
		// click My Profile button
		// check Profile screen title
		// return back to Home screen
		// swipe right
		// check Go Cambassy screen
		// return back to Home screen
		// Logout
		// Login as another user
		// make several posts
		// Logout
		// Login as initial user
		// follow user which added posts
		// return back to Home screen
		// check Posts feed

	}

}
