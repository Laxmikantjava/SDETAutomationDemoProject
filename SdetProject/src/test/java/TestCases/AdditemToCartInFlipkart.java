package TestCases;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.HomePage;
import Resources.TestBase;

public class AdditemToCartInFlipkart extends TestBase {
	HomePage homepage;
	String flipkart ="https://www.flipkart.com/";
	@BeforeTest
	public void setup() throws FileNotFoundException {
		initialization();
		homepage  =new HomePage ();
		launchAut(flipkart);
	}
	
	//getting the title of the page
		@Test(enabled=false)
		public void verifyAmazonTitlePageTest()
		{
			Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		}

	
	// Enter the item 
	@Test(priority=1)
	public void searchItem() {
		HomePage.flipkartCloseWindow.click();
		HomePage.flipkartSearchTextBox.sendKeys("asus Zenfone Max (Black, 32 GB)");
		HomePage.clickOnSearchIcon.click();
	}
	
	//Select The particular item from the item list
	@Test(priority=2)
	public void selectItem() {
		HomePage.clickAsusPhone.click();
		Set<String> handles=driver.getWindowHandles();
		System.out.println(handles);
		Iterator<String> itr=handles.iterator();
		
		String handles2  =itr.next();
		driver.switchTo().window(handles2);
		
	}
	
	
	
	
	//Getting price of the selected item
		@Test(priority=3)
		public void getPrice()
		{
			String AussPrice =	HomePage.getPriceofAsusProd.getText();
			System.out.println(AussPrice);
		}
}
