package stepDefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import pageObjects.CheckOutPage;
import utils.TestContextSetup;

public class CheckOutStepDefinition {
	TestContextSetup testContextSetup;
	public CheckOutPage checkOutPage;
	public String productName;
	public CheckOutStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.checkOutPage=testContextSetup.pageObjectManager.CheckOutPage();//we are creating object for checkoutpage in the constructor so that all methods can access
		
	}

	 @Then("^user proceeds to CheckOut and validate the (.+) items in checkout page$")
	    public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws Throwable {
		 
	      checkOutPage.checkOutItems();
	      productName=checkOutPage.getText().split("-")[0].trim();
	      Assert.assertEquals(testContextSetup.homePageProductName, productName);
	    }


	    @Then("^verify user has ability to enter promo code and place the order$")
	    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() throws Throwable {
	    	
	    	Assert.assertTrue(checkOutPage.verifyPromoButton());
	    	Assert.assertTrue(checkOutPage.verifyPlaceOrder());
	    	
	    	
        }
}
