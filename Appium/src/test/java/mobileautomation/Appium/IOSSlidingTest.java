package mobileautomation.Appium;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSSlidingTest  extends IOSBaseTest {
	
	@Test
	public void IOSSlidingTestDemo() throws InterruptedException {
		
		setup();
		
		//click on sliders button
		WebElement sliderElement =  driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`label == \"AppElem\"`]"));
		sliderElement.sendKeys("0%");
		Assert.assertEquals("0%", sliderElement.getAttribute("value"));
		
		Thread.sleep(5000);
		sliderElement.sendKeys("1%");
		Assert.assertEquals("100%", sliderElement.getAttribute("value"));
		Thread.sleep(5000);
		
	}
}
