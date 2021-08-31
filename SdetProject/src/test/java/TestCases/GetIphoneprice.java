package TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Resources.TestBase;
import junit.framework.Assert;
import net.bytebuddy.jar.asm.Handle;

public class GetIphoneprice {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		double IphonePrice = 0.0;
		String AmazonHomePageURl = "https://www.amazon.in/";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hp\\eclipse-workspace\\SdetProject\\src\\main\\java\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(AmazonHomePageURl);
		String ActualProduct = "iphone XR 64 gb -silver";

		String title = driver.getTitle();

		System.out.println(title);

		// Search iphone XR 64 gb -silver and get the price of first result

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone XR 64 gb -silver");

		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 11 Pro (64GB) - Silver')]")).click();

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> itr = handles.iterator();
		for (String windowhandle : handles) {

			String handle2 = itr.next();

			driver.switchTo().window(handle2);

			//driver.switchTo().defaultContent();// switch to parent window
		}
		/*
		 * Thread.sleep(10); String IphonePriceorg = driver.findElement(By.
		 * xpath("//span[@id='priceblock_ourprice' and @class='a-size-medium a-color-price priceBlockBuyingPriceString']"
		 * )).getText(); System.out.println(IphonePriceorg);
		 */
		Thread.sleep(4);
		Select drpSelect = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));

		drpSelect.selectByVisibleText("Music");

		// Verity the product tile
		String ExpectedProductName = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();

		System.out.println(ExpectedProductName);

		// get the price of the product
		String ProductPrice = driver.findElement(By.xpath("//span[@id='priceblock_ourprice']")).getText();

		System.out.println("Actual price of phone is " + ProductPrice);
		String productPriceOrg = ProductPrice.substring(1, ProductPrice.length());

		System.out.println("Final Price of phone is " + productPriceOrg);
		
		// clcik on hamburger menu and open the amazon prime page 
		driver.findElement(By.xpath("//*[@id='nav-hamburger-menu']/i")).click();
		driver.findElement(By.linkText("Your Account")).click();

	}

}
