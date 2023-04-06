package mobileautomation.Appium;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;

import java.io.File;
import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BrowserBaseTest {

	public static AppiumDriverLocalService service;
	public static AndroidDriver driver;

	@BeforeClass
	public void setup() {

		setUpServer();
		driver = new AndroidDriver(service.getUrl(), setCapabilities());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	public void setUpServer() {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1").usingPort(4723)
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.usingDriverExecutable(new File("/usr/local/bin/node")).withArgument(BASEPATH, "/wd/hub")
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE).withArgument(GeneralServerFlag.LOG_LEVEL, "debug");

		service = AppiumDriverLocalService.buildService(builder);
		service.start();
	}

	private DesiredCapabilities setCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
		capabilities.setCapability("browserName","Chrome");
		capabilities.setCapability("noReset", false);
		capabilities.setCapability("chromedriverExecutable","//Users//saibrahma.mutcherla//Documents//Chrome_Driver_69//chromedriver");

		return capabilities;
	}

	public static double getFormatedAmount(String amount) {
		
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	@AfterClass
	public void tearDownServer() {

		driver.quit();
		service.stop();
	}

}
