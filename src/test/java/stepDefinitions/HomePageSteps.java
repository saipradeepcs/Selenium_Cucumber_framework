package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.HomePage;
import testDataTypes.Customer;
import testDataTypes.Items;

public class HomePageSteps {

	HomePage homePage;
	TestContext testContext;
	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("^user is on hom page$")
	public void user_is_on_hom_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homePage.navigateTo_HomePage();

	}

	@When("^he searches for \"([^\"]*)\"$")
	public void he_searches_for(String itemname) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Items item = FileReaderManager.getInstance().getJsonReader().getITemByName(itemname);
		homePage.perform_Search(item);
	}
}
