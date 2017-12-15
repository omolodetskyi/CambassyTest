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
import pageobjects.GoCambassyScreen;
import pageobjects.HomeScreen;
import pageobjects.LoginScreen;
import pageobjects.MessagesScreen;
import pageobjects.MyCambassadorScreen;
import pageobjects.NotificationScreen;
import pageobjects.ProfileScreen;
import pageobjects.SettingsScreen;
import pageobjects.SplashScreen;
import pageobjects.TestBase;

/* ***************************************************************************************************
HomeScreenTest makes a smoke test for Home screen and Follow People feature
*****************************************************************************************************/

public class HomeScreenTest extends TestBase {

	AndroidDriver<AndroidElement> driver;
	String username = "main_user2";
	String password = "123456";
	LoginScreen login;
	SplashScreen splash;

	@BeforeTest
	public void openApp() throws MalformedURLException {
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login = new LoginScreen(driver);
		splash = new SplashScreen(driver);
		login.quickLogin(splash, username, password);
	}

	@Test
	public void HomeScreen_Test() throws InterruptedException {
		HomeScreen home = new HomeScreen(driver);
		BottomMenu bottomMenu = new BottomMenu(driver);
		FollowPeople followPeople = new FollowPeople(driver);
		MessagesScreen messages = new MessagesScreen(driver);
		AnyScreen any = new AnyScreen(driver);
		MyCambassadorScreen myCambassador = new MyCambassadorScreen(driver);
		CameraScreen camera = new CameraScreen(driver);
		NotificationScreen notification = new NotificationScreen(driver);
		ProfileScreen profile = new ProfileScreen(driver);
		GoCambassyScreen goCambassy = new GoCambassyScreen(driver);
		SettingsScreen settings = new SettingsScreen(driver);
		String anotheruser = "main_user3";
		String passAnotherUser = "123456";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
		Assert.assertTrue(notification.isNotificationScreen(), "Notification screen is not opened!");
		// return back to Home screen
		bottomMenu.clickHome();
		// click My Profile button
		bottomMenu.clickProfile();
		// check Profile screen title
		Assert.assertEquals(profile.getProfileTitle(), username, "Profile screen is not opened or has wrong title!");
		// return back to Home screen
		bottomMenu.clickHome();
		// swipe right
		home.goToGoCambassy();
		// check Go Cambassy screen
		Assert.assertTrue(goCambassy.isGoCambassyScreen(), "Go Cambassy screen is not opened!");
		// go back to Home screen
		goCambassy.goToHomeScreen();
		// Go to Profile
		bottomMenu.clickProfile();
		// Go to Settings
		profile.clickSettingsBtn();
		// Click log out button
		settings.clickLogout();
		// confirm log out
		settings.ConfirmLogout();
		// Login as another user
		login.quickLogin(splash, anotheruser, passAnotherUser);
		// make post
		bottomMenu.clickCamera();
		camera.takePhoto();
		camera.makePost();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Go to Profile
		profile.clickSettingsBtn();
		// Click log out button
		settings.clickLogout();
		// confirm log out
		settings.ConfirmLogout();
		// Login as initial user
		login.quickLogin(splash, username, password);
		// follow user which added posts
		home.clickFollowPeople();
		followPeople.searchUser(anotheruser);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		followPeople.followUser(anotheruser);
		// check message on the bottom of screeen
		Assert.assertEquals(followPeople.getfollowMsg(), "You are now following " + anotheruser);
		// return back to Home screen
		any.goBack();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// check Posts feed
		Assert.assertEquals(home.isUserPostHere(anotheruser), true,
				"None posts from " + anotheruser + "on home screen!");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Click follow People
		home.clickFollowPeople();
		// find another user
		followPeople.searchUser(anotheruser);
		// Unfollow another user
		followPeople.unfollowUser(anotheruser);
		// check message on the bottom of screeen
		Assert.assertEquals(followPeople.getfollowMsg(), "You unfollowed " + anotheruser);
		// go back to Home screen
		any.goBack();
		// check Posts feed
		Assert.assertEquals(home.isUserPostHere(anotheruser), false,
				"Posts from " + anotheruser + "still on home screen!");
	}

}
