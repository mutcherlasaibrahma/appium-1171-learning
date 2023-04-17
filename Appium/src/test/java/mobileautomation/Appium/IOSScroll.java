package mobileautomation.Appium;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSScroll extends IOSBaseTest {
	
	@Test
	public void IOSScrollTestDemo() throws InterruptedException {
		
		setup();
		
		
		WebElement element =  driver.findElement(AppiumBy.accessibilityId("Web View"));
		scrollElement(element);
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Web View\"`]")).click();
		
		driver.findElement(AppiumBy.iOSNsPredicateString("label == \"Picker View\"")).click();
		
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypePickerWheel[`label == 'Red color component value'`]")).sendKeys("23");
		
		Thread.sleep(1000);
		
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Green color component value'")).sendKeys("220");
		
		Thread.sleep(1000);
		
		driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("120");
		
		Thread.sleep(1000);
		
		String actualValue = driver.findElement(AppiumBy.accessibilityId("Blue color component value")).getText();
		
		Assert.assertEquals(actualValue, "120");
		
		tearDownServer();
		
	}
}
