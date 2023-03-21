package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;
import pageObjects.LandingPage;


public class OfferPageStepDefinition {

	public String offerPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup; //we can access present class variable using this 
	}
	
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
	    
		switchToOffersPage();
		OffersPage offersPage=testContextSetup.pageObjectManager.OffersPage();
		offersPage.searchName(shortName);
		Thread.sleep(2000);
		offerPageProductName=offersPage.getProductName();
		
			
	}
	public void switchToOffersPage()
	{
		
		LandingPage landingPage=testContextSetup.pageObjectManager.LandingPage();
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		
		
		landingPage.toTopDealsPage();
		
		testContextSetup.genericUtils.switchWindow();
	}
	
       @Then("validate product name in offers page matches with Landing page")
	    public void validate_product_name_in_offers_page_matches_with_landing_page() throws Throwable {
	       Assert.assertEquals(offerPageProductName, testContextSetup.homePageProductName);
    	   
	    }

}
