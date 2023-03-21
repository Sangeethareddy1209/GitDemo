package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
    public WebDriver driver;
	public OffersPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By search=By.xpath("//input[@type='search']");
	By offerPageProductName=By.cssSelector("tr td:nth-child(1)");
	
	
	public void searchName(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	public String getProductName()
	{
		return driver.findElement(offerPageProductName).getText();
		 
	}
}
