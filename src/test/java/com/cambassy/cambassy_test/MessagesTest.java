package com.cambassy.cambassy_test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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

public class MessagesTest {
	AndroidDriver<AndroidElement> driver;
	SplashScreen splash;
	LoginScreen login;
	HomeScreen home;
	AnyScreen any;
	BottomMenu bottomMenu;
	SettingsScreen settings;
	ProfileScreen profile;

	@BeforeTest
	public void beforeTest() {
	}

	@Test
	public void Messages_Test() {
	}

	@AfterTest
	public void afterTest() {
	}

}
