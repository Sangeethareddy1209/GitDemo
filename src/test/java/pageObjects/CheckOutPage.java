package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    public WebDriver driver;
	public CheckOutPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	By cart=By.cssSelector("img[alt='Cart']");//page objects
	By proceedButton=By.cssSelector("button[type='button']");//variables
	By apply=By.xpath("//button[@class='promoBtn']");
	By placeOrder=By.xpath("//div[@class='products']/div/button");
	By text=By.xpath("//p[@class='product-name']");
	
	public void checkOutItems()
	{
		driver.findElement(cart).click();
		driver.findElement(proceedButton).click();
	}
	public boolean verifyPromoButton()
	{
		return driver.findElement(apply).isDisplayed();
		
	}
	public boolean verifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	public String getText()
	{
		return driver.findElement(text).getText();
	}
}

