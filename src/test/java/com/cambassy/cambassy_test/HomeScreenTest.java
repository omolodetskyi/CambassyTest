package com.cambassy.cambassy_test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
		System.out.println("Startig HomeScreenTest");
		driver = capabilities();
		System.out.println("1. Open Cambassy");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login = new LoginScreen(driver);
		splash = new SplashScreen(driver);
		System.out.println("2. Login as " + username);
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
		System.out.println("3. Check title of Home screen");
		Assert.assertTrue(home.checkTitle(), "Can not find title on home page");
		// check follow people message
		System.out.println("4. Check content message on Home screen");
		Assert.assertEquals(home.checkContentMsg(), "Start following people", "There is wrong content message!");
		System.out.println("5. Tap Follow People button");
		// click Follow People button
		home.clickFollowPeople();
		// check Follow People title
		System.out.println("6. Check title of Follow People screen");
		Assert.assertEquals(followPeople.getFollowPeopleTitle(), "Follow People");
		// return back to Home screen
		System.out.println("7. Press Back key");
		any.goBack();
		// click Chat button
		System.out.println("8. Tap Messages button");
		home.clickChat();
		// check Messages screen title
		System.out.println("9. Check title of Messages screen");
		Assert.assertEquals(messages.getMessagesTitle(), "People you ❤");
		// return back to Home screen
		System.out.println("10. Press Back key");
		any.goBack();
		// click MyCambassador button
		System.out.println("11. Tap My Cambassador button");
		bottomMenu.clickMyCambassador();
		// check MyCambassador screen title
		System.out.println("12. Check title of My Cambassador screen");
		Assert.assertEquals(myCambassador.getMyCambassadorTitle(), "My Cambassador");
		// return back to Home screen
		System.out.println("13. Tap Home button");
		bottomMenu.clickHome();
		// click Camera button
		System.out.println("14. Tap Camera button");
		bottomMenu.clickCamera();
		// check Camera screen
		System.out.println("15. If there is some permissions dialog, press Allow");
		while (camera.isPermissionMsg()) {
			camera.clickAllow();
		}
		// check that there is Capture button, so it's Camera screen
		System.out.println("16. Check there is Capture button, so it's Camera screen");
		Assert.assertTrue(camera.isbtnCapture());
		// return back to Home screen
		System.out.println("17. Click X button on Camera screen");
		camera.clickClose();
		// click Notification button
		System.out.println("18. Tap Notification button");
		bottomMenu.clickNotification();
		// check Notification screen title
		System.out.println("19. Check that it's Notification screen");
		Assert.assertTrue(notification.isNotificationScreen(), "Notification screen is not opened!");
		// return back to Home screen
		System.out.println("20. Tap Home button");
		bottomMenu.clickHome();
		// click My Profile button
		System.out.println("21. Tap Profile button");
		bottomMenu.clickProfile();
		// check Profile screen title
		System.out.println("22.Check title of Profile screen");
		Assert.assertEquals(profile.getProfileTitle(), username, "Profile screen is not opened or has wrong title!");
		// return back to Home screen
		System.out.println("23. Tap Home button");
		bottomMenu.clickHome();
		// swipe right
		System.out.println("24. Swipe right");
		home.goToGoCambassy();
		// check Go Cambassy screen
		System.out.println("25. Check that Go Cambassy screen is opened");
		Assert.assertTrue(goCambassy.isGoCambassyScreen(), "Go Cambassy screen is not opened!");
		// go back to Home screen
		System.out.println("26. Swipe left");
		goCambassy.goToHomeScreen();
		// Go to Profile
		System.out.println("27. Tap Profile button");
		bottomMenu.clickProfile();
		// Go to Settings
		System.out.println("28. Tap Settings button");
		profile.clickSettingsBtn();
		// Click log out button
		System.out.println("29. Tap Log out button");
		settings.clickLogout();
		// confirm log out
		System.out.println("30. Confirm logout");
		settings.ConfirmLogout();
		// Login as another user
		System.out.println("31. Login as " + anotheruser);
		login.quickLogin(splash, anotheruser, passAnotherUser);
		// make post
		System.out.println("32. Tap Camera button");
		bottomMenu.clickCamera();
		System.out.println("33. Tap Capture button");
		camera.takePhoto();
		System.out.println("34. Tap Post button");
		camera.makePost();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Go to Profile
		System.out.println("35. Tap Settings button");
		profile.clickSettingsBtn();
		// Click log out button
		System.out.println("36. Tap Log out button");
		settings.clickLogout();
		// confirm log out
		System.out.println("37. Confirm logout");
		settings.ConfirmLogout();
		// Login as initial user
		System.out.println("38. Login as " + username);
		login.quickLogin(splash, username, password);
		// follow user which added posts
		System.out.println("39. Tap Follow People button");
		home.clickFollowPeople();
		System.out.println("40. Search for " + anotheruser);
		followPeople.searchUser(anotheruser);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("41. Tap Follow  button");
		followPeople.followUser(anotheruser);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// check message on the bottom of screeen
		System.out.println("42. Check message on the bottom of screeen");
		Assert.assertEquals(followPeople.getfollowMsg(), "You are now following " + anotheruser);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// return back to Home screen
		System.out.println("43. Tap Back  button");
		followPeople.clickBack();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// check Posts feed
		System.out.println("44. check Posts feed that there is post from user " + anotheruser);
		Assert.assertEquals(home.isUserPostHere(anotheruser), true,
				"None posts from " + anotheruser + "on home screen!");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Click follow People
		System.out.println("45. Tap Follow People button");
		home.clickFollowPeople();
		// find another user
		System.out.println("46. Search for " + anotheruser);
		followPeople.searchUser(anotheruser);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// Unfollow another user
		System.out.println("47. Tap Following button to unfollow user");
		followPeople.unfollowUser(anotheruser);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// check message on the bottom of screeen
		System.out.println("48. Check message on the bottom of screeen");
		Assert.assertEquals(followPeople.getfollowMsg(), "You unfollowed " + anotheruser);
		// go back to Home screen
		System.out.println("49. Press Back key");
		any.goBack();
		// check Posts feed
		System.out.println("50. check Posts feed that there is NOT  post from user " + anotheruser);
		Assert.assertEquals(home.isUserPostHere(anotheruser), false,
				"Posts from " + anotheruser + "still on home screen!");
	}

	@AfterTest
	public void cleanUp() {
		driver.quit();
	}
}
