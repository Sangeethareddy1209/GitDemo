package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	By search=By.xpath("//input[@type='search']");//page objects
	By productName=By.cssSelector("h4.product-name");//variables
	By topDeals=By.linkText("Top Deals");
	By increment=By.cssSelector("a[class='increment']");
	By addToCart=By.cssSelector("div.product-action button");
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
		 
	}
	public void toTopDealsPage()
	{
		driver.findElement(topDeals).click();
	}
	public String getTitle()
	{
		return driver.getTitle();
	}
	public void increment(int quantity)
	{
		int i=quantity-1;//quantity is 3 we have to click 2 times as one is already present
		while(i>0)
		{
			driver.findElement(increment).click();;
			i--;
		}
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}
}
