package stepDefination;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageLocator.applicationLocator;
import utility.AppiumServer;

public class IOAssignment extends applicationLocator {



@Given("^IO shopping app is install$")
public void io_shopping_app_is_install() throws Exception  {
	//start();
	setupApplication();
	  System.out.println("Welcome to our shoppoing application");
	  Thread.sleep(5000);
	  
   
}

@When("^select type of application UI$")
public void select_type_of_application_UI() {
	
	select_type_of_application_UI();
	 
}

@When("^click on menu item$")
public void click_on_menu_item() {
	click_on_menu_item();

}

@When("^click on new list$")
public void click_on_new_list() {
	click_on_new_list();
}

@When("^create new list as \"([^\"]*)\"$")
public void create_new_list_as(String listName) {
	create_new_list_as(listName);
}

@When("^add new item as \"([^\"]*)\"$")
public void add_new_item_as(String newItem)  {
	add_new_item_as(newItem);
	
}

@Then("^delete the recently created item from list$")
public void delete_the_recently_created_item_from_list(){
	delete_the_recently_created_item_from_list();
}


}
