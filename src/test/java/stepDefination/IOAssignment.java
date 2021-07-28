package stepDefination;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utility.AppiumServer;

public class IOAssignment extends AppiumServer {

	// private static AndroidDriver driver;

@Given("^IO shopping app is install$")
public void io_shopping_app_is_install() throws Exception  {
	//start();

	  DesiredCapabilities capabilities = new DesiredCapabilities();
  	  capabilities.setCapability("UDID", "6283dcf7");		  
	  capabilities.setCapability("autoGrantPermissions", "true"); 
	  capabilities.setCapability("deviceName", "Redmi");
	  capabilities.setCapability("automationName", "UiAutomator2");
	  capabilities.setCapability("platformVersion", "9.0.0");
	  capabilities.setCapability("platformName", "Android");
	  capabilities.setCapability("appPackage", "org.openintents.shopping");
	  capabilities.setCapability("appActivity", "org.openintents.shopping.ShoppingActivity");
	  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  System.out.println("Welcome to our shoppoing application");
	  Thread.sleep(5000);
	  
   
}

@When("^select type of application UI$")
public void select_type_of_application_UI() throws Throwable {
	 MobileElement el1 = (MobileElement) driver.findElementById("org.openintents.shopping:id/layout_choice_bottom");
	  el1.click();
	  Thread.sleep(5000);
}

@When("^click on menu item$")
public void click_on_menu_item() throws Throwable {
	  MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Open navigation drawer");
	  el2.click();

}

@When("^click on new list$")
public void click_on_new_list() throws Throwable {
	MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.ListView/android.widget.RelativeLayout[3]/android.widget.TextView");
	  el3.click();
}

@When("^create new list as \"([^\"]*)\"$")
public void create_new_list_as(String listName) throws Throwable {
	 MobileElement el9 = (MobileElement) driver.findElementById("org.openintents.shopping:id/edittext");
	  el9.clear(); 
	MobileElement el4 = (MobileElement) driver.findElementById("org.openintents.shopping:id/edittext");
	  el4.sendKeys(listName);
	  MobileElement el5 = (MobileElement) driver.findElementById("android:id/button1");
	  el5.click();
}

@When("^add new item as \"([^\"]*)\"$")
public void add_new_item_as(String newItem) throws Throwable {
	MobileElement el12 = (MobileElement) driver.findElementById("org.openintents.shopping:id/autocomplete_add_item");
	  el12.sendKeys(newItem);
	  MobileElement el13 = (MobileElement) driver.findElementById("org.openintents.shopping:id/button_add_item");
	  el13.click();
	  Thread.sleep(5000);
}

@Then("^delete the recently created item from list$")
public void delete_the_recently_created_item_from_list() throws Throwable {
	 MobileElement el14 = (MobileElement) driver.findElementById("org.openintents.shopping:id/check");
	  el14.click();
	  MobileElement el = (MobileElement) driver.findElementByAccessibilityId("Clean up list");
	  el.click();
}


}
