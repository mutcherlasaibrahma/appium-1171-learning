package mobileautomation.Appium;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class IOSBaseTest {

	public static AppiumDriverLocalService service;
	public static IOSDriver driver;

	@BeforeClass
	public void setup() {

		setUpServer();
		driver = new IOSDriver(service.getUrl(), setCapabilities());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	public void setUpServer() {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1").usingPort(4723)
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.usingDriverExecutable(new File("/usr/local/bin/node"))
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE).withArgument(GeneralServerFlag.LOG_LEVEL, "debug");

		service = AppiumDriverLocalService.buildService(builder);
		service.start();
	}

	private DesiredCapabilities setCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.4");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		capabilities.setCapability(MobileCapabilityType.APP,
				"//Users//saibrahma.mutcherla//Downloads//resources//TestApp 3.app");
		capabilities.setCapability("noReset", false);
		
		return capabilities;
	}

	
	public static double getFormatedAmount(String amount) {
		
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public static void longPress(WebElement ele) {
		Map<String,Object> params = new HashMap<>();
		
		params.put("elementId", ((RemoteWebElement)ele).getId());
		params.put("duration", 5);
		
		driver.executeScript("mobile: touchAndHold", params);
		
//		((JavascriptExecutor) driver).executeScript("mobile: touchAndHold",
//				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}
	
	public static void scrollElement(WebElement ele) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "down");
		params.put("elementId", ((RemoteWebElement)ele).getId());
	
		driver.executeScript("mobile: scroll", params);
	}

	@AfterClass
	public void tearDownServer() {

		driver.quit();
		service.stop();
	}

}