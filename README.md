# Selenium_Cucumber_framework
A Behavior Driven Development framework which uses Page Object Model and Singleton design pattern
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You need to have following software(s)/tools installed in your machine

* [Eclipse IDE](http://www.eclipse.org/downloads/eclipse-packages/) - IDE used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java
* [Cucumber eclipse plug-in] (http://cucumber.github.com/cucumber-eclipse/update-site) - BDD language used
* [junit](This comes by default when you create a new Maven Project)
* [Selenium 3.11.0](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.12.0)
* [Cucumber JVM: JUnit » 1.2.5](https://mvnrepository.com/artifact/info.cukes/cucumber-junit/1.2.5)
* [Cucumber JVM: Java » 1.2.5](https://mvnrepository.com/artifact/info.cukes/cucumber-java/1.2.5)
* [Cucumber JVM: PicoContainer » 1.2.4](https://mvnrepository.com/artifact/info.cukes/cucumber-picocontainer/1.2.4) - Pico Container to share test context
* [Cucumber Extents Report](https://mvnrepository.com/artifact/com.vimalselvam/cucumber-extentsreport/3.0.2)
## Running the tests

Once you pull the project. Navigate to folder src/test/java->TestRunner_Smokes->Run as Junit Test

### Break down into end to end tests

The above test when run as junit, initiallly it will read the annotation @RunWith(Cucumber.class), then will read the options that re provied in @CucumberOptions annotation.
Options defined @CucumberOptions annotation are very important as these options will define 
* what features to choose
* location of the stepdefintion(s)
* what tags to include
* report generation plug-ins if any 

```
For example: All I'm doing here is asking junit to run the test with below metnioned annotations and options
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests",
		glue = "stepDefinitions",
		tags = "@SmokeTest",
		monochrome = true,
		plugin =  { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"} )
```
* Now JVM will look for a feature file comprsing features located at "src/test/resources/functionalTests"
* Every step in a feature requires a corresponding step defintion file. That's what **_glue_** in the above "CucumberOptions" define. It is telling that all step defintions are located at "stepDefinitions"(which is a package located in src/test/java)

```
Feature File example: 

Feature: Automated End2End Tests
Description: This feature tests E2E scenario of a shopping website

@SmokeTest
Scenario Outline: user places an order by search an item
Given user is on hom page
When he searches for "<item>"
And choose to buy first item from search results
And moves to checkout from cart
And enters "<customer>" Billings details on checkout page
And selects same delivery address
And selects mode of payment as "check"
And places the order
Then I see the order page with order number
Examples:
	|customer|item|
	|Pradeep|dress|
	|nick|shoes|
	
```

```
StepDefinition file example:

package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.HomePage;
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

```


## Authors

* **Sai Pradeep**

## Acknowledgments

* http://toolsqa.com/
* Inspiration - LAKSHAY SHARMA 

