package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class CommonUtilss {

	public static int IMPLICIT_WAIT_TIME;
	public static int EXPLICIT_WAIT_TIME;
	public static String BASE_PKG;
	public static String APP_ACTIVITY;
	public static String APP_WAIT_ACTIVITY;
	public static String BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static String APPIUM_PORT;
	public static String APP_PATH;
	public static String EXTENT_REPORT_CONFIG_PATH;
	public static URL serverURL;

	public static Properties prop = new Properties();
	private static DesiredCapabilities capabilties = new DesiredCapabilities();

	// Abstract class
	private AppiumDriver<MobileElement> driver;

	// loadAndroidConfProp
	public void loadAndroidConfProp(String propertyFileName) throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/properties/" + propertyFileName);
		prop.load(fis);

		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		APP_PATH = prop.getProperty("application.path");
		APPIUM_PORT = prop.getProperty("appium.server.port");
		DEVICE_NAME = prop.getProperty("device.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		PLATFORM_NAME = prop.getProperty("platform.name");
		BROWSER_NAME = prop.getProperty("browser.name");
		APP_ACTIVITY = prop.getProperty("application.activity");
		APP_WAIT_ACTIVITY = prop.getProperty("application.WaitActivity");
		BASE_PKG = prop.getProperty("base.pkg");

	}

	// SetAndroidCapabilties
	public void setAndroidCapabilities() {
		capabilties.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		capabilties.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilties.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilties.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER_NAME);
		capabilties.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + APP_PATH);
		capabilties.setCapability("unicodeKeyboard", true);
		capabilties.setCapability("resetKeyboard", true);
		capabilties.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PKG);
		capabilties.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
		capabilties.setCapability("autoGrantPermissions", true);

	}

	public AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException {
		serverURL = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
		return driver = new AndroidDriver<MobileElement>(serverURL, capabilties);
	}

}
