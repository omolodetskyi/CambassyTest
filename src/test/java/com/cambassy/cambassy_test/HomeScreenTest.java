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
import utils.ExcelDataProvider;

/* ***************************************************************************************************
HomeScreenTest makes a smoke test for Home screen and Follow People feature
*****************************************************************************************************/

public class HomeScreenTest extends TestBase {

	AndroidDriver<AndroidElement> driver;

	LoginScreen login;
	SplashScreen splash;
	MessagesScreen messages;
	FollowPeople followPeople;
	BottomMenu bottomMenu;
	HomeScreen home;
	AnyScreen any;
	MyCambassadorScreen myCambassador;
	CameraScreen camera;
	NotificationScreen notification;
	ProfileScreen profile;
	GoCambassyScreen goCambassy;
	SettingsScreen settings;

	@DataProvider(name = "HomeScreenTest")
	public Object[][] dataProvider() {
		Object[][] testData = ExcelDataProvider.getTestData("HomeScreenTest");
		return testData;

	}

	@BeforeTest
	public void openApp() throws Exception {
		ExcelDataProvider.setExcelFile("/Users/alexander/Downloads/cambassyTestData.xlsx", "HomeScreenTest");
		Reporter.log("Startig HomeScreenTest", true);
		driver = capabilities();
		Reporter.log("1. Open Cambassy", true);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "HomeScreenTest")
	public void HomeScreen_Test(String userName, String password, String anotherUserName,
			String passwordAnotherUserName) throws InterruptedException {
		home = new HomeScreen(driver);
		bottomMenu = new BottomMenu(driver);
		followPeople = new FollowPeople(driver);
		messages = new MessagesScreen(driver);
		any = new AnyScreen(driver);
		myCambassador = new MyCambassadorScreen(driver);
		camera = new CameraScreen(driver);
		notification = new NotificationScreen(driver);
		profile = new ProfileScreen(driver);
		goCambassy = new GoCambassyScreen(driver);
		settings = new SettingsScreen(driver);
		login = new LoginScreen(driver);
		splash = new SplashScreen(driver);
		Reporter.log("2. Login as " + userName, true);
		login.quickLogin(splash, userName, password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// check if home screen has correct title
		Reporter.log("3. Check title of Home screen", true);
		Assert.assertTrue(home.checkTitle(), "Can not find title on home page");
		// check follow people message
		Reporter.log("4. Check content message on Home screen", true);
		Assert.assertEquals(home.checkContentMsg(), "Start following people", "There is wrong content message!");
		Reporter.log("5. Tap Follow People button", true);
		// click Follow People button
		home.clickFollowPeople();
		// check Follow People title
		Reporter.log("6. Check title of Follow People screen", true);
		Assert.assertEquals(followPeople.getFollowPeopleTitle(), "Follow People");
		// return back to Home screen
		Reporter.log("7. Press Back key", true);
		any.goBack();
		// click Chat button
		Reporter.log("8. Tap Messages button", true);
		home.clickChat();
		// check Messages screen title
		Reporter.log("9. Check title of Messages screen", true);
		Assert.assertEquals(messages.getMessagesTitle(), "People you ❤");
		// return back to Home screen
		Reporter.log("10. Press Back key", true);
		any.goBack();
		// click MyCambassador button
		Reporter.log("11. Tap My Cambassador button", true);
		bottomMenu.clickMyCambassador();
		// check MyCambassador screen title
		Reporter.log("12. Check title of My Cambassador screen", true);
		Assert.assertEquals(myCambassador.getMyCambassadorTitle(), "My Cambassador");
		// return back to Home screen
		Reporter.log("13. Tap Home button", true);
		bottomMenu.clickHome();
		// click Camera button
		Reporter.log("14. Tap Camera button", true);
		bottomMenu.clickCamera();
		// check Camera screen
		Reporter.log("15. If there is some permissions dialog, press Allow", true);
		while (camera.isPermissionMsg()) {
			camera.clickAllow();
		}
		// check that there is Capture button, so it's Camera screen
		Reporter.log("16. Check there is Capture button, so it's Camera screen", true);
		Assert.assertTrue(camera.isbtnCapture());
		// return back to Home screen
		Reporter.log("17. Click X button on Camera screen", true);
		camera.clickClose();
		// click Notification button
		Reporter.log("18. Tap Notification button", true);
		bottomMenu.clickNotification();
		// check Notification screen title
		Reporter.log("19. Check that it's Notification screen", true);
		Assert.assertTrue(notification.isNotificationScreen(), "Notification screen is not opened!");
		// return back to Home screen
		Reporter.log("20. Tap Home button", true);
		bottomMenu.clickHome();
		// click My Profile button
		Reporter.log("21. Tap Profile button", true);
		bottomMenu.clickProfile();
		// check Profile screen title
		Reporter.log("22.Check title of Profile screen", true);
		Assert.assertEquals(profile.getProfileTitle(), userName, "Profile screen is not opened or has wrong title!");
		// return back to Home screen
		Reporter.log("23. Tap Home button", true);
		bottomMenu.clickHome();
		// swipe right
		Reporter.log("24. Swipe right", true);
		home.goToGoCambassy();
		// check Go Cambassy screen
		Reporter.log("25. Check that Go Cambassy screen is opened", true);
		Assert.assertTrue(goCambassy.isGoCambassyScreen(), "Go Cambassy screen is not opened!");
		// go back to Home screen
		Reporter.log("26. Swipe left", true);
		goCambassy.goToHomeScreen();
		// Go to Profile
		Reporter.log("27. Tap Profile button", true);
		bottomMenu.clickProfile();
		// Go to Settings
		Reporter.log("28. Tap Settings button", true);
		profile.clickSettingsBtn();
		// Click log out button
		Reporter.log("29. Tap Log out button", true);
		settings.clickLogout();
		// confirm log out
		Reporter.log("30. Confirm logout", true);
		settings.ConfirmLogout();
		// Login as another user
		Reporter.log("31. Login as " + anotherUserName, true);
		login.quickLogin(splash, anotherUserName, passwordAnotherUserName);
		// make post
		Reporter.log("32. Tap Camera button", true);
		bottomMenu.clickCamera();
		Reporter.log("33. Tap Capture button", true);
		camera.takePhoto();
		Reporter.log("34. Tap Post button", true);
		camera.makePost();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Go to Settings
		Reporter.log("35. Tap Settings button", true);
		profile.clickSettingsBtn();
		// Click log out button
		Reporter.log("36. Tap Log out button", true);
		settings.clickLogout();
		// confirm log out
		Reporter.log("37. Confirm logout", true);
		settings.ConfirmLogout();
		// Login as initial user
		Reporter.log("38. Login as " + userName, true);
		login.quickLogin(splash, userName, password);
		// follow user which added posts
		Reporter.log("39. Tap Follow People button", true);
		home.clickFollowPeople();
		Reporter.log("40. Search for " + anotherUserName, true);
		followPeople.searchUser(anotherUserName);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Reporter.log("41. Tap Follow  button", true);
		followPeople.followUser(anotherUserName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// check message on the bottom of screeen
		Reporter.log("42. Check message on the bottom of screeen", true);
		Assert.assertEquals(followPeople.getfollowMsg(), "You are now following " + anotherUserName);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// return back to Home screen
		Reporter.log("43. Tap Back  button", true);
		any.clickBack();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// check Posts feed
		Reporter.log("44. check Posts feed that there is post from user " + anotherUserName, true);
		Assert.assertEquals(home.isUserPostHere(anotherUserName), true,
				"None posts from " + anotherUserName + "on home screen!");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Click follow People
		Reporter.log("45. Tap Follow People button", true);
		home.clickFollowPeople();
		// find another user
		Reporter.log("46. Search for " + anotherUserName);
		followPeople.searchUser(anotherUserName);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// Unfollow another user
		Reporter.log("47. Tap Following button to unfollow user", true);
		followPeople.unfollowUser(anotherUserName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// check message on the bottom of screeen
		Reporter.log("48. Check message on the bottom of screeen", true);
		Assert.assertEquals(followPeople.getfollowMsg(), "You unfollowed " + anotherUserName);
		// go back to Home screen
		Reporter.log("49. Press Back key", true);
		any.goBack();
		// check Posts feed
		Reporter.log("50. check Posts feed that there is NOT  post from user " + anotherUserName, true);
		Assert.assertEquals(home.isUserPostHere(anotherUserName), false,
				"Posts from " + anotherUserName + "still on home screen!");
		// Go to Profile
		Reporter.log("51. Tap Profile button", true);
		bottomMenu.clickProfile();
		// Go to Settings
		Reporter.log("52. Tap Settings button", true);
		profile.clickSettingsBtn();
		// Click log out button
		Reporter.log("53. Tap Log out button", true);
		settings.clickLogout();
		// confirm log out
		Reporter.log("54. Confirm logout", true);
		settings.ConfirmLogout();
	}

	@AfterTest
	public void cleanUp() {
		driver.quit();
	}
}
