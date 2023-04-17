package mobileautomation.Appium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSSwipeTest extends IOSBaseTest {
	
	@Test
	public void IOSSwipeTestDemo() throws InterruptedException {
		
		setup();
		
		//using the buddle id to indentify the app 
		Map<String,Object> params = new HashMap<>();
		params.put("bundleId", "com.apple.mobileslideshow");
		driver.executeScript("mobile: launchApp", params);
		
		List<WebElement> elements  = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
		int size = elements.size();
		//click on first image
		driver.findElement(By.xpath("//XCUIElementTypeCell[1]")).click();
	
		for(int i = 0;i<size;i++) {
			
		Map<String, Object> params1 = new HashMap<>();
		params1.put("direction", "left");
		driver.executeScript("mobile:swipe", params1);
	
		}
		
	}

}
