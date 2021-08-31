package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.TestBase;

public class PageObjectIphone extends TestBase{

	public PageObjectIphone() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="//input[@id='twotabsearchtextbox']")
	public static WebElement clcikSearchBox;
	
	@FindBy(id="//input[@id='nav-search-submit-button']")
	public static WebElement clickSearchResult;
	
	@FindBy(id="//span[contains(text(),'Apple iPhone 11 Pro (64GB) - Silver')]")
	public static WebElement GoToFirstResult;
	
	
}
