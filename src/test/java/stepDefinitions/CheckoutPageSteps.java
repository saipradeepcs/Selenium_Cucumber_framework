package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.CheckOutPage;
import testDataTypes.Customer;

public class CheckoutPageSteps {

	TestContext testContext;
	CheckOutPage checkOutPage;
	
	public CheckoutPageSteps(TestContext context) {
		testContext = context;
		checkOutPage = testContext.getPageObjectManager().getCheckOutPage();
	}
	
//	@When("^enters Billing details on checkout page$")
//	public void enters_Billing_details_on_checkout_page() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		Thread.sleep(5000);
//		checkOutPage.procedurePopulatePersonalDetails();
//	}
	@When("^enters \"([^\"]*)\" Billings details on checkout page$")
	public void enters_Billings_details_on_checkout_page(String customerName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerbyname(customerName);
		checkOutPage.procedurePopulatePersonalDetails(customer);
	}

	@When("^selects same delivery address$")
	public void selects_same_delivery_address() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		checkOutPage.checkshipToDifferentAddressCheckbox();
		Thread.sleep(3000);
	}

	@When("^selects mode of payment as \"([^\"]*)\"$")
	public void selects_mode_of_payment_as(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
//		checkOutPage.checkBillingPaymentOptions("CheckPayment");
	}
	@When("^places the order$")
	public void places_the_order() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		checkOutPage.checkTerms();
		checkOutPage.placeOrder();
	}
}
