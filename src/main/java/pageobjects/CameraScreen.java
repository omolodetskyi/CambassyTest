package pageobjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CameraScreen {
	AndroidDriver<AndroidElement> driver;
	By permissionMsg = By.id("com.android.packageinstaller:id/permission_message");
	By btnAllow = By.id("com.android.packageinstaller:id/permission_allow_button");
	By btnCapture = By.id("com.cambassy:id/camera_capture_button");
	By btnClose = By.id("com.cambassy:id/camera_close_button");
	By btnPost = By.id("com.cambassy:id/preview_share_button");

	// constructor
	public CameraScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public String getPermissionMsg() {
		// Allow Cambassy to access photos, media, and files on your device?
		// Allow Cambassy to record audio?
		// Allow Cambassy to take pictures and record video?
		return driver.findElement(permissionMsg).getText();
	}

	public boolean isPermissionMsg() {
		return !driver.findElements(permissionMsg).isEmpty();
	}

	public boolean isbtnCapture() {
		return !driver.findElements(btnCapture).isEmpty();
	}

	public void clickAllow() {
		driver.findElement(btnAllow).click();
	}

	public void clickClose() {
		driver.findElement(btnClose).click();

	}

	public void takePhoto() {
		driver.findElement(btnCapture).click();
		while (isPermissionMsg()) {
			clickAllow();
		}
	}

	public void makePost() {
		driver.findElement(btnPost).click();
	}
}
