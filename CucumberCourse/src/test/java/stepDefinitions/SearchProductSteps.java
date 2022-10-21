package stepDefinitions;

import org.testng.Assert;

import common.TestContextSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;

public class SearchProductSteps {
	
	public TestContextSetUp testContextSetUp;
	public LandingPage landingPageObject;
	
	public SearchProductSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.landingPageObject = testContextSetUp.pageObjectManager.getLandingPage();
	}
	
	@Given("^User is on the greencart website landing page$")
	public void user_is_on_the_greencart_website_landing_page() throws Throwable {
		Assert.assertTrue(landingPageObject.verifyLandingPageTittle().contains("GreenKart"));
	}
    
	/*
    @When("^User searches for the given product with name \"([^\"]*)\"$")
    public void user_searches_for_the_given_product_with_name_something(String productName) throws Throwable {
    	//INSTEAD OF DOING THIS, WE USE DEPENDENCY INJECTION TO MANAGE PAGE OBJECT AND AVOID OBJECT INIZIALIZATION
	    //LandingPage landingPageObjects = new LandingPage(testContextSetUp.driver);
		//landingPageObjects.searchItem(pattern);
    	
    	LandingPage landingPageObject = testContextSetUp.pageObjectManager.getLandingPage();
		landingPageObject.searchItem(productName);
    }
    */
    
    @When("^User searches for the given product with name (.+)$")
    public void user_searches_for_the_given_product_with_name(String productname) throws Throwable {
    	//INSTEAD OF DOING THIS, WE USE DEPENDENCY INJECTION TO MANAGE PAGE OBJECT AND AVOID OBJECT INIZIALIZATION
	    //LandingPage landingPageObjects = new LandingPage(testContextSetUp.driver);
		//landingPageObjects.searchItem(pattern);
		landingPageObject.searchItem(productname);
    }
	
	@Then("^The existing product (.+) is displayed$")
    public void the_existing_product_is_displayed(String productname) throws Throwable {
		Thread.sleep(2000);
		//INSTEAD OF DOING THIS, WE USE DEPENDENCY INJECTION TO MANAGE PAGE OBJECT AND AVOID OBJECT INIZIALIZATION
		//LandingPage landingPageObjects = new LandingPage(testContextSetUp.driver);
		//boolean productIsvisible = landingPageObjects.getProductVisibility();
		Assert.assertTrue(landingPageObject.getProductVisibility(productname));
    }
	
	@Then("^An error for failed search is displayed$")
    public void an_error_for_failed_search_is_displayed() throws Throwable {
		Thread.sleep(2000);
		//INSTEAD OF DOING THIS, WE USE DEPENDENCY INJECTION TO MANAGE PAGE OBJECT AND AVOID OBJECT INIZIALIZATION
		//LandingPage landingPageObjects = new LandingPage(testContextSetUp.driver);
		//boolean errorMessageIsVisible = landingPageObjects.getFailedSearchErrorVisibility();
		boolean errorMessageIsVisible = landingPageObject.getFailedSearchErrorVisibility();
		Assert.assertEquals(errorMessageIsVisible, true); 
    }

}
