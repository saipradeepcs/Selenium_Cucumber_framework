package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import junit.framework.Assert;
import pageObjects.OrderPage;

@SuppressWarnings("deprecation")
public class OrderPageSteps {

	TestContext testContext;
	OrderPage orderPage;
	
	public OrderPageSteps(TestContext context) {
		testContext = context;
		orderPage = testContext.getPageObjectManager().getOrderPage();
	}
	
	@Then("^I see the order page with order number$")
	public void i_see_the_order_page_with_order_number() throws Throwable {
		Assert.assertEquals(orderPage.orderNumber(), true);
		String productName = (String)testContext.scenarioContext.getContext(Context.PRODUCT_NAME);
		Assert.assertTrue(productName + " : is not found on " + orderPage.getProductNames().toString(), orderPage.getProductNames().stream().filter(x -> x.contains(productName)).findFirst().get().length()>0);
	}
}
