package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String homePageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup)//we created instance of the class which we are going to use 
	{
		this.testContextSetup=testContextSetup;// testContextSetup is local variable so we created one global variable and allocating the value of local to global using this
		this.landingPage= testContextSetup.pageObjectManager.LandingPage();
	}
	
	@Given("User is on Greenkart Landing page")
	public void user_is_on_greenkart_landing_page() {
		
		//driver is local to this method if we give here
		Assert.assertTrue(landingPage.getTitle().contains("GreenKart"));
		
	}
	

	@When("^user searched with shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws Throwable {
		LandingPage landingPage= testContextSetup.pageObjectManager.LandingPage();
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		landingPage.getProductName();
		testContextSetup.homePageProductName=landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.homePageProductName +"is extracted from home page");
	}

	 @When("^Added \"([^\"]*)\" items of the selected product to cart$")
	    public void added_something_items_of_the_selected_product_to_cart(String quantity) throws Throwable {
	        
		     //we have to convert string quantity to int as we are giving number to increment method in landing page
		     landingPage.increment(Integer.parseInt(quantity));
		     landingPage.addToCart();
		 
	    }


}
