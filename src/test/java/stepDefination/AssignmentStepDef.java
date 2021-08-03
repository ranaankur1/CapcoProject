package stepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageLocator.applicationLocator;

public class AssignmentStepDef extends applicationLocator {
	
	public static AndroidDriver driver;

@Given("^IO shopping app is installed successffully$")
public void io_shopping_app_is_installed_successffully() throws Throwable {
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
public void select_type_of_application_UI(){

select_type_of_application();
click_on_menu();
}
@When("^create new list as \"([^\"]*)\"$")
public void create_new_list_as(String listName) {
	create_new_listas(listName);
}
String actualcount;
private int itemcount;
@When("^add new ten items$")
public void add_new_ten_items() throws Throwable {

	File file =new File("C:\\Users\\ankrana\\Downloads\\capcoAssignment\\CapcoAssignment\\src\\test\\resources\\TestData.xlsx");
    FileInputStream inputStream = new FileInputStream(file);
    XSSFWorkbook wb=new XSSFWorkbook(inputStream);
    XSSFSheet sheet=wb.getSheetAt(0);
    int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
            
    for(int i=0;i<=rowCount;i++){
        int cellcount=sheet.getRow(i).getLastCellNum();
        
            String testdatavalue=sheet.getRow(i).getCell(0).getStringCellValue();
            MobileElement el12 = (MobileElement) driver.findElementById("org.openintents.shopping:id/autocomplete_add_item");
    		el12.clear();
    		MobileElement el13 = (MobileElement) driver.findElementById("org.openintents.shopping:id/autocomplete_add_item");
    		el13.sendKeys(testdatavalue);
    		MobileElement el30 = (MobileElement) driver.findElementById("org.openintents.shopping:id/button_add_item");
    		el30.click();
    		Thread.sleep(1500);
    //		String actualvalue=driver.findElementByXPath("//*[contains(@resource-id,'org.openintents.shopping:id/name')]").getText();
    		
    	//	Assert.assertEquals(actualvalue, testdatavalue);
    		
         }
    
    
	List<MobileElement> itemlist=(List<MobileElement>)driver.findElementsByXPath("//*[contains(@resource-id,'org.openintents.shopping:id/name')]");
	itemcount=itemlist.size();
	for(int i1=0;i1<itemlist.size();i1++)
	{
		System.out.println("Item name is: "+itemlist.get(i1).getText());
		
	}
	
}

@Then("^delete four items$")
public void delete_four_items() throws Throwable {
	List<MobileElement> el31 = (List<MobileElement>) driver.findElementsByXPath("//*[contains(@resource-id,'org.openintents.shopping:id/check_surround')]");
	for(int i2=0;i2<4;i2++)
	{
		el31.get(i2).click();
	}
	
	MobileElement el35 = (MobileElement) driver.findElementByAccessibilityId("Clean up list");
	el35.click();

	System.out.println("item get deleted successfuly");
	
}

@Then("^check count$")
public void check_count() throws Throwable {
	List<MobileElement> itemlistUpdated=(List<MobileElement>)driver.findElementsByXPath("//*[contains(@resource-id,'org.openintents.shopping:id/description')]");

	System.out.println("updated Item name is: "+itemlistUpdated.size());
	Assert.assertEquals(itemlistUpdated.size(), itemcount-4);
}

}
