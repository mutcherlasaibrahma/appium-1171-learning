package mobileautomation.Appium;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class AppiumActivityAndPackage extends BaseTest {

	// Defines us to naviage to current page 
	//Mac : adb shell dumpsys window | grep -E 'mCurrentFocus'
	//io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies
	//Any thing before / is activity Package and after it is activity name.

	
	@Test
	public void appiumActievityAndPackag() throws MalformedURLException {
		setup();
		
		//This will directly go the wifi page .
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		
	}


}
