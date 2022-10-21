package stepDefinitions;

import org.testng.Assert;

import common.TestContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.PlaceOrderPage;

public class CheckPurchaseSteps {
	
public TestContextSetUp testContextSetUp;
public PlaceOrderPage orderPageObjects;
	
	public CheckPurchaseSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.orderPageObjects = testContextSetUp.pageObjectManager.getPlaceOrderObject();
	}
	
	@And("^Add \"([^\"]*)\" products to the cart$")
    public void add_something_products_to_the_cart(String numberOfProducts) throws Throwable {
		orderPageObjects.selectNumberOfProducts(Integer.parseInt(numberOfProducts)-1);
    }
	
	@And("^User add that product to the cart$")
    public void user_add_that_product_to_the_cart() throws Throwable {
		Thread.sleep(2000);
		//INSTEAD OF DOING THIS, WE USE DEPENDENCY INJECTION TO MANAGE PAGE OBJECT AND AVOID OBJECT INIZIALIZATION
		//PlaceOrderPage orderPageObjects = new PlaceOrderPage(testContextSetUp.driver);
		//orderPageObjects.addProductCart();
		orderPageObjects.addProductCart();
    }
	
	@And("^Proceed with the checkout of that product$")
    public void proceed_with_the_checkout_of_that_product() throws Throwable {
		//INSTEAD OF DOING THIS, WE USE DEPENDENCY INJECTION TO MANAGE PAGE OBJECT AND AVOID OBJECT INIZIALIZATION
		//PlaceOrderPage orderPageObjects = new PlaceOrderPage(testContextSetUp.driver);
		//orderPageObjects.proceedCheckout();
		
		orderPageObjects.proceedCheckout();
    }
	
	@And("^Validates that product in the checkout is (.+)$")
    public void validates_that_product_in_the_checkout_is(String productname) throws Throwable {
        Assert.assertEquals(orderPageObjects.verifyProductNameInCheckoutPage(productname), true);
    }

    @And("^Place the order in the system$")
    public void place_the_order_in_the_system() throws Throwable {
    	Thread.sleep(2000);
    	//INSTEAD OF DOING THIS, WE USE DEPENDENCY INJECTION TO MANAGE PAGE OBJECT AND AVOID OBJECT INIZIALIZATION
    	//PlaceOrderPage orderPageObjects = new PlaceOrderPage(testContextSetUp.driver);
    	//orderPageObjects.placeTheOrder();
    	
    	orderPageObjects.placeTheOrder();
    }

    @And("^Select country \"([^\"]*)\" and agre with terms$")
    public void select_country_something_and_agre_with_terms(String countryName) throws Throwable {
    	Thread.sleep(2000);
    	//INSTEAD OF DOING THIS, WE USE DEPENDENCY INJECTION TO MANAGE PAGE OBJECT AND AVOID OBJECT INIZIALIZATION
    	//PlaceOrderPage orderPageObjects = new PlaceOrderPage(testContextSetUp.driver);
    	//orderPageObjects.filltermsAndFinishOrder(countryName);
    	
    	orderPageObjects.filltermsAndFinishOrder(countryName);
    }

	@Then("^The landing page is displayed$")
    public void the_landing_page_is_displayed() throws Throwable {
		Thread.sleep(5000);
		//INSTEAD OF DOING THIS, WE USE DEPENDENCY INJECTION TO MANAGE PAGE OBJECT AND AVOID OBJECT INIZIALIZATION
		//PlaceOrderPage orderPageObjects = new PlaceOrderPage(testContextSetUp.driver);
		//boolean homePageIsVisible = orderPageObjects.verifyHomePageVisibility();
		
		boolean homePageIsVisible = orderPageObjects.verifyHomePageVisibility();
		Assert.assertEquals(homePageIsVisible, true); 
    }
}
