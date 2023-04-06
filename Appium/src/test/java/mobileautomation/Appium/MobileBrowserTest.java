package mobileautomation.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MobileBrowserTest extends BrowserBaseTest {

	@Test
	public void browserTest() throws MalformedURLException, InterruptedException {
		
		setup();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
		String text = driver.findElement(By.cssSelector("a[href*='/angularAppdemo/products/3']")).getText();
		Thread.sleep(2000);
		Assert.assertEquals(text, "Devops");
		tearDownServer();
		
	}
}
