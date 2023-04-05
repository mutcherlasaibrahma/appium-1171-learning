package mobileautomation.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellanousAppiumAction extends BaseTest {

	@Test
	public void miscellanous() throws MalformedURLException {

		setup();
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		//Device Roation to 90 Degress.
		DeviceRotation landscapeMode = new DeviceRotation(0, 0, 90);
		driver.rotate(landscapeMode);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

		// Getting the text
		String wifiAlertTitleName = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(wifiAlertTitleName, "WiFi settings");

		//Clip Board like(copy and paste in app)
		driver.setClipboardText("Saibrahma123");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		//Pressing andriod in build buttons like(home ,back or enter etc)
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		tearDownServer();
	}

}
