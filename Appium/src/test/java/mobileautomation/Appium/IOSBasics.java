package mobileautomation.Appium;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest {
	
	@Test
	public void IOSBasicsTest() {
		
		//Xpath,className,IOS,iosclassChain,iosPredicateString,accessiblity id,id
		
		setup();
		
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		
		// class chain 
		driver .findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Text Entry\"`]")).click();
		
		// ios Predicate String
		
		driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTextField\"")).sendKeys("Hi Saibrahma");
		
		// click on Ok 
		
		driver .findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"OK\"`]")).click();
		
		// click on confirm and cancel btn 
		
		driver .findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value = 'Confirm / Cancel'")).click();
		
		
		//Verifying the string through predicatestring
		
		String message = driver.findElement(AppiumBy.iOSNsPredicateString("label == \"A message should be a short, complete sentence.\"")).getText();
		
		String expectedString  = "A message should be a short, complete sentence.";
		
		Assert.assertEquals(message, expectedString);
		
		// Click on Confirm Btn 
		
		driver.findElement(AppiumBy.iOSNsPredicateString("label == \"Confirm\"")).click();
		
		//LongPress,scroll,swipe,slides,dropdowns
		
				
	}

}
