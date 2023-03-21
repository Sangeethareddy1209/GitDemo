package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	//this pageobjectmanager creating object and assign driver
	//this class passes the objects and driver to other page object classes
	public LandingPage landingPage;
	public WebDriver driver;
	public OffersPage offersPage;
	public CheckOutPage checkOutPage;
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	public LandingPage LandingPage()
	{
		landingPage=new LandingPage(driver);
		return landingPage;
	}
	public OffersPage OffersPage()
	{
		 offersPage=new OffersPage(driver);
		 return offersPage;
	}
	public CheckOutPage CheckOutPage()
	{
		 checkOutPage=new CheckOutPage(driver);
		 return checkOutPage;
		
	}

}
