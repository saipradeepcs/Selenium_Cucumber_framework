package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.CartPage;

public class CartPageSteps {

	TestContext testContext;
	CartPage cartPage;
	
	public CartPageSteps(TestContext context) {
		testContext = context;
		cartPage = testContext.getPageObjectManager().getCartPage();
	}
	@When("^moves to checkout from cart$")
	public void moves_to_checkout_from_cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();
	}
}
