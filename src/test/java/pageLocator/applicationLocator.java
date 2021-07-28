package pageLocator;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utility.AppiumServer;

public class applicationLocator extends AppiumServer {
	
	MobileElement el1 = (MobileElement) driver.findElementById("org.openintents.shopping:id/layout_choice_bottom");
	MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Open navigation drawer");
	MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.ListView/android.widget.RelativeLayout[3]/android.widget.TextView");
	MobileElement el9 = (MobileElement) driver.findElementById("org.openintents.shopping:id/edittext");
	MobileElement el4 = (MobileElement) driver.findElementById("org.openintents.shopping:id/edittext");
	MobileElement el5 = (MobileElement) driver.findElementById("android:id/button1");
	
	MobileElement el12 = (MobileElement) driver.findElementById("org.openintents.shopping:id/autocomplete_add_item");
	MobileElement el13 = (MobileElement) driver.findElementById("org.openintents.shopping:id/button_add_item");
	
	 MobileElement el14 = (MobileElement) driver.findElementById("org.openintents.shopping:id/check");
	 MobileElement el = (MobileElement) driver.findElementByAccessibilityId("Clean up list");
	  
	  
	
	public void select_type_of_application_UI()
	{
		  el1.click();
	}
	
	public void click_on_menu_item()
	{
		  el2.click();
	}
	
	public void click_on_new_list()
	{
		  el3.click();
	}
	
	public void create_new_list_as(String listName)
	{
		el9.clear(); 
		el4.sendKeys(listName);
		 el5.click(); 
	}
	
	public void add_new_item_as(String newItem)
	{
		el12.sendKeys(newItem);
		  el13.click();
		
	}
	
	public void delete_the_recently_created_item_from_list()
	{
	  el14.click();
	  el.click();
	}
	
	public void setupApplication() throws MalformedURLException
	{ DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("UDID", "6283dcf7");		  
	  capabilities.setCapability("autoGrantPermissions", "true"); 
	  capabilities.setCapability("deviceName", "Redmi");
	  capabilities.setCapability("automationName", "UiAutomator2");
	  capabilities.setCapability("platformVersion", "9.0.0");
	  capabilities.setCapability("platformName", "Android");
	  capabilities.setCapability("appPackage", "org.openintents.shopping");
	  capabilities.setCapability("appActivity", "org.openintents.shopping.ShoppingActivity");
	  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	 }

}
