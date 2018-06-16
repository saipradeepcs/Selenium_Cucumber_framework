package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import enums.Context;
import pageObjects.ProductListingPage;

public class ProductPageSteps {

	TestContext testContext;
	ProductListingPage productListingPage;
	
	public ProductPageSteps(TestContext context) {
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
	}
	
	@When("^choose to buy first item from search results$")
	public void choose_to_buy_first_item_from_search_results() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String productName = productListingPage.getProductName(0);
		testContext.getScenarioContext().setContext(Context.PRODUCT_NAME, productName);
		productListingPage.select_Product(0);
		productListingPage.clickOn_AddToCart();
	}
}
