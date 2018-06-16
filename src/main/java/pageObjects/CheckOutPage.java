package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import selenium.Wait;
import testDataTypes.Customer;

public class CheckOutPage {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Page objects
	@FindBy(how = How.XPATH, using = "//input[@id='billing_first_name']")
	private WebElement billing_firstname;
	@FindBy(how = How.XPATH, using = "//input[@id='billing_last_name']")
	private WebElement billing_lastname;
	@FindBy(how = How.XPATH, using = "//input[@id='billing_email']")
	private WebElement billing_email;
	@FindBy(how = How.XPATH, using = "//input[@id='billing_phone']")
	private WebElement billing_phone;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_billing_country']/a/span[2]")
	private WebElement billing_country_dropdown;
	@FindBy(how = How.XPATH, using = "//ul[@id='select2-results-1']//li")
	private List<WebElement> billing_country_results;
	@FindBy(how = How.XPATH, using = "//input[@id='billing_city']")
	private WebElement billing_city;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_billing_state']/a/span[2]")
	private WebElement billing_state_dropdown;
	@FindBy(how = How.XPATH, using = "//ul[@id='select2-results-2']//li")
	private List<WebElement> billing_state_results;
	@FindBy(how = How.XPATH, using = "//input[@id='billing_address_1']")
	private WebElement billing_address1;
	@FindBy(how = How.XPATH, using = "//input[@id='billing_postcode']")
	private WebElement billing_zipCode;
	@FindBy(how = How.XPATH, using = "//input[@id='ship-to-different-address-checkbox']")
	private WebElement billing_shipToDifferentAddressCheckbox;
	@FindBy(how = How.XPATH, using = "//div[@id='payment']/ul/li")
	private List<WebElement> billing_paymentOptions;
	@FindBy(how = How.XPATH, using = "//p[@class='form-row terms wc-terms-and-conditions']//input[@id='terms']")
	private WebElement billing_termsCheckBox;
	@FindBy(how = How.XPATH, using = "//input[@id='place_order']")
	private WebElement billing_placeOrder;
	
	
	//Action methods
	public void enterFirstName(String firstname) {
		billing_firstname.sendKeys(firstname);
	}
	public void enterLastName(String lastname) {
		billing_lastname.sendKeys(lastname);
	}
	public void enterEmail(String email) {
		billing_email.sendKeys(email);
	}
	public void enterPhone(String phone) {
		billing_phone.sendKeys(phone);
	}
	public void selectCountry(String country) {
		billing_country_dropdown.click();
		Wait.untilJqueryIsDone(driver);
		List<WebElement> results = billing_country_results;
		for(WebElement result: results) {
			if(result.getText().equalsIgnoreCase(country)) {
				result.click();
				Wait.untilJqueryIsDone(driver);
				break;
			}
		}
	}
	public void enterCity(String city) {
		billing_city.sendKeys(city);
	}
	public void selectState(String state) {
		billing_state_dropdown.click();
		Wait.untilJqueryIsDone(driver);
		List<WebElement> results = billing_state_results;
		for(WebElement result: results) {
			if(result.getText().equalsIgnoreCase(state)) {
				result.click();
				Wait.untilJqueryIsDone(driver);
				break;
			}
		}
	}
	public void enterAddress(String address) {
		billing_address1.sendKeys(address);
	}
	public void enterZipCode(String zip) {
		billing_zipCode.sendKeys(zip);
	}
	public void checkshipToDifferentAddressCheckbox() {
		billing_shipToDifferentAddressCheckbox.click();
	}
	public void checkBillingPaymentOptions(String paymentMethod) {
		List<WebElement> results = billing_paymentOptions;
		if(paymentMethod.equals("CheckPayment")) {
			results.get(0).click();
		}else if(paymentMethod.equals("Cash")) {
			results.get(1).click();
		}else {
			new Exception("Payment Method not recognised : " + paymentMethod);
		}
		Wait.untilJqueryIsDone(driver);
	}
	public void checkTerms() {
		billing_termsCheckBox.click();
	}
	public void placeOrder() {
		billing_placeOrder.click();
		Wait.untilJqueryIsDone(driver);
		Wait.untilPageLoadComplete(driver);
	}
	//Procedures
	public void procedurePopulatePersonalDetails(Customer customer) {
		enterFirstName(customer.firstName);
		enterLastName(customer.lastName);
		enterPhone(customer.phoneNumber.mob);
		enterEmail(customer.emailAddress);
		selectCountry(customer.address.country);
		enterCity(customer.address.city);
		enterAddress(customer.address.streetAddress);
		enterZipCode(customer.address.postCode);
		selectState(customer.address.state);
	}
}
