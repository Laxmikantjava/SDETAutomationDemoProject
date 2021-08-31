package TestCases;



import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.PageObjectIphone;
import Resources.TestBase;



public class GetPriceIphone12Pro extends TestBase {
	
	// Open amazon homepage => Verify the title => Enter keyword  iphone XR 64 gb -silver in search box => get the price of the first result 
     PageObjectIphone pageobjectiphone;
     
	String AmazonHomePageURl  ="https://www.amazon.in/";
	
	
	@BeforeTest
	public void setup() throws FileNotFoundException {
		 pageobjectiphone = new PageObjectIphone();
		 
		 initialization();
			launchAut(AmazonHomePageURl);
		
	}
	
	//Verify the title of the amazon page
	@Test(priority=1)
	public void verifyAmazonTitlePage() {
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		System.out.println(title);
		
		}
		
	// Search iphone XR 64 gb -silver
			@Test(priority=2)
			public void searchBox() {
				pageobjectiphone.clcikSearchBox.click();

			}
			
			@Test(priority=3)
			public void giveinputInSearchBox() {
				pageobjectiphone.clcikSearchBox.sendKeys("iphone XR 64 gb -silver");

			}
			
			@Test(priority=4)
			public void goIphoneResults() {
				pageobjectiphone.clickSearchResult.click();
			}
			
			
			
			@Test(priority=5)
			public void goTOFirstResult() {
				pageobjectiphone.GoToFirstResult.click();
			}
	
	

	@AfterTest
	public void closeSetUp()
	{
		driver.quit();
	}
}
