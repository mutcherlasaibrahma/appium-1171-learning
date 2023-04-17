package mobileautomation.Appium;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSLongPress  extends IOSBaseTest {
	
	@Test
	public void IOSLongPress() {
		
		setup();
		
		// Click on Steppers
		
		WebElement steppers =   driver.findElement(AppiumBy.accessibilityId("Steppers"));
		steppers.click();
		
		
		WebElement ele =  driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Increment\"`][3]"));
		
		//long press on custom steppers
		longPress(ele);
		
		tearDownServer();
		
	}

}
