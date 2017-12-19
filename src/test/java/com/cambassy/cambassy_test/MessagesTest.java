package com.cambassy.cambassy_test;

import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.AnyScreen;
import pageobjects.BottomMenu;
import pageobjects.ChatScreen;
import pageobjects.HomeScreen;
import pageobjects.LoginScreen;
import pageobjects.MessagesScreen;
import pageobjects.ProfileScreen;
import pageobjects.SearchForUserScreen;
import pageobjects.SettingsScreen;
import pageobjects.SignUpScreen;
import pageobjects.SplashScreen;
import pageobjects.TestBase;

public class MessagesTest extends TestBase {
	AndroidDriver<AndroidElement> driver;
	SignUpScreen signUp;
	SplashScreen splash;
	LoginScreen login;
	HomeScreen home;
	AnyScreen any;
	BottomMenu bottomMenu;
	SettingsScreen settings;
	ProfileScreen profile;
	MessagesScreen messages;
	SearchForUserScreen searchUser;
	ChatScreen chat;

	String username = "test_ms_user2";
	String password = "123456";
	String email = username + "@test.ua";
	String nationality = "Ukraine";
	String anotheruser = "veraivanovna";
	String emailAnotherUser = anotheruser + "@test.ua";
	String passAnotherUser = "123456";
	String enteredMessage = "Hello!";
	String answerMsg = "Hey, how are you?";

	@BeforeTest
	public void beforeTest() throws MalformedURLException {

		Reporter.log("Startig MessagesScreenTest");
		Reporter.log("1. Open Cambassy");
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login = new LoginScreen(driver);
		splash = new SplashScreen(driver);
		Reporter.log("2. Login as " + username);
		login.quickLogin(splash, username, password);
	}

	@Test
	public void Messages_Test() {

		home = new HomeScreen(driver);
		messages = new MessagesScreen(driver);
		searchUser = new SearchForUserScreen(driver);
		bottomMenu = new BottomMenu(driver);
		profile = new ProfileScreen(driver);
		settings = new SettingsScreen(driver);
		chat = new ChatScreen(driver);
		any = new AnyScreen(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Tap Messages button
		Reporter.log("3. Tap Messages button");
		home.clickChat();
		// check Messages screen title
		Reporter.log("4. Check title of Messages screen");
		Assert.assertEquals(messages.getMessagesTitle(), "People you ❤");
		// Tap add chat button
		Reporter.log("5. Tap Add chat button");
		messages.clickAddChat();
		// check Search for User title
		Reporter.log("6. Check Search for User title");
		Assert.assertEquals(searchUser.getSearchForUserTitle(), "Search for User");
		// Search for another user
		Reporter.log("7. Search for user " + anotheruser);
		searchUser.searchUser(anotheruser);
		// Tap on user avatar
		Reporter.log("8. Tap on " + anotheruser + " avatar");
		searchUser.selectUser(anotheruser);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		// enter message
		Reporter.log("9. Enter message " + enteredMessage);
		chat.enterMessage(enteredMessage);
		// send message
		Reporter.log("10. Click Send button");
		chat.clickSend();
		// check that message appears in the chat screen
		Reporter.log("11. Check if message appears in chat screen");
		Assert.assertEquals(chat.getChatMsg(0), enteredMessage, "Message is not found!");
		// check time of the message
		Reporter.log("13. Check time of the message in chat screen");
		String messageTime = getCurrentTime();
		Assert.assertEquals(chat.getChatTime(0), messageTime);
		// go back to Messages screen
		Reporter.log("14. Go back to Messages screen");
		any.clickBack();
		// check last message on Messages screen
		Reporter.log("15. Check last message on Messages screen");
		Assert.assertEquals(messages.getLastMessage(0), enteredMessage, "Message is not found!");
		// check last message time on Messages screen
		Reporter.log("16. Check last message time on Messages screen");
		Assert.assertEquals(messages.getLastTime(0), messageTime);
		// go back to Home screen
		Reporter.log("17. Tap Back button");
		any.clickBack();
		// Go to Profile
		Reporter.log("18. Tap Profile button");
		bottomMenu.clickProfile();
		// Go to Settings
		Reporter.log("19. Tap Settings button");
		profile.clickSettingsBtn();
		// Click log out button
		Reporter.log("20. Tap Log out button");
		settings.clickLogout();
		// confirm log out
		Reporter.log("21. Confirm logout");
		settings.ConfirmLogout();
		// Login as another user
		Reporter.log("22. Login as " + anotheruser);
		login.quickLogin(splash, anotheruser, passAnotherUser);
		// Check number of unread messages on Home screen
		Reporter.log("23. Check number of unread messages on Home screen");
		Assert.assertEquals(home.getNumberOfUnreadMsg(), "1");
		// Tap on Chat button
		Reporter.log("24. Tap on Chat button");
		home.clickChat();
		// check number of unread messages on messages screen
		Reporter.log("25. Check number of unread messages on Messages screen");
		Assert.assertEquals(messages.getNumberOfUnreadMsg(), "1");
		// tap on number unread messages to see message from test user
		Reporter.log("26. Tap on number unread messages to see message from " + username);
		messages.clickNumberOfUnreadMsg();
		// check message from test user in Chat screen
		Reporter.log("27. Check message from test user in Chat screen");
		Assert.assertEquals(chat.getChatMsg(0), enteredMessage, "Message is not found!");
		// check time of the message
		Reporter.log("28. Check time of the message in chat screen");
		Assert.assertEquals(chat.getChatTime(0), messageTime);
		// write answer to test user
		Reporter.log("29. Enter answer to " + username);
		chat.enterMessage(answerMsg);
		// send message
		Reporter.log("30. Click Send button");
		chat.clickSend();
		// check message to test user in Chat screen
		String answerMessageTime = getCurrentTime();
		Reporter.log("31. Check message to test user in Chat screen");
		Assert.assertEquals(chat.getChatMsg(1), answerMsg, "Message is not found!");
		// check time of message to test user in Chat screen
		Assert.assertEquals(chat.getChatTime(1), answerMessageTime);
		// go back to Messages screen
		Reporter.log("32. Tap Back button");
		any.clickBack();
		// Tap on Delete Chat button
		Reporter.log("33. Tap Delete Chat button");
		messages.clickDeleteChat();
		// Tap on Remove Chat Button
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Reporter.log("34. Tap Remove Chat button");
		messages.clickRemoveChat(0);
		// Confirm removing chat
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Reporter.log("35. Tap DELETE button");
		messages.clickConfirmDelete(0);
		// Close deletion mode
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Reporter.log("36. Tap Close deletion mode");
		messages.clickCloseDeleteMode();
		// Check that chat was deleted
		Reporter.log("37. Check that chat was deleted");
		Assert.assertEquals(messages.getLastMessage(0), "None message found", "Message is not deleted!");

	}

	private String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("h:mm a", new Locale("en"));
		Date d = new Date();
		d.getTime();
		return dateFormat.format(d);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
