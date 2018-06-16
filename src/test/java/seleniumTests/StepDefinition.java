package seleniumTests;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import managers.DriverManager;
import managers.PageObjectManager;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.OrderPage;
import pageObjects.ProductListingPage;

@SuppressWarnings("deprecation")
public class StepDefinition {
//	WebDriver driver;
//	PageObjectManager pageObjectManager;
//	HomePage homePage;
//	CartPage cartPage;
//	CheckOutPage checkOutPage;
//	ProductListingPage productListingPage;
//	OrderPage orderPage;
//	DriverManager driverManager;
//	@Given("^user is on hom page$")
//	public void user_is_on_hom_page() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		driverManager = new DriverManager();
//		driver = driverManager.getDriver();
//		pageObjectManager = new PageObjectManager(driver);
//		homePage = pageObjectManager.getHomePage();
//		homePage.navigateTo_HomePage();
//
//	}
//
//	@When("^he searches for \"([^\"]*)\"$")
//	public void he_searches_for(String product) throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		homePage.perform_Search(product);
//	}
//
//	@When("^choose to buy first item from search results$")
//	public void choose_to_buy_first_item_from_search_results() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		productListingPage = pageObjectManager.getProductListingPage();
//		productListingPage.select_Product(0);
//		productListingPage.clickOn_AddToCart();
//	}
//
//	@When("^moves to checkout from cart$")
//	public void moves_to_checkout_from_cart() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		cartPage = pageObjectManager.getCartPage();
//		cartPage.clickOn_Cart();
//		cartPage.clickOn_ContinueToCheckout();
//	}
//
//	@When("^enters Billing details on checkout page$")
//	public void enters_Billing_details_on_checkout_page() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		Thread.sleep(5000);
//		checkOutPage = pageObjectManager.getCheckOutPage();
//		checkOutPage.procedurePopulatePersonalDetails();
//	}
//
//	@When("^selects same delivery address$")
//	public void selects_same_delivery_address() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		checkOutPage.checkshipToDifferentAddressCheckbox();
//		Thread.sleep(3000);
//	}
//
//	@When("^selects mode of payment as \"([^\"]*)\"$")
//	public void selects_mode_of_payment_as(String arg1) throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
////		checkOutPage.checkBillingPaymentOptions("CheckPayment");
//	}
//
//	@When("^places the order$")
//	public void places_the_order() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		checkOutPage.checkTerms();
//		checkOutPage.placeOrder();
//	}
//	@Then("^I see the order page with order number$")
//	public void i_see_the_order_page_with_order_number() throws Throwable {
//		Thread.sleep(3000);
//		orderPage = pageObjectManager.getOrderPage();
//		Assert.assertEquals(orderPage.orderNumber(), true);
//		driverManager.closeDriver();
//	}
}
