package seleniumTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class E2E_Test {
	public static WebDriver driver=null;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");

		driver.navigate().to("http://shop.demoqa.com/?s=" + "dress" + "&post_type=product");


		List<WebElement> items = driver.findElements(By.xpath("//div[@class='noo-product-inner noo-product-inner2']"));
		items.get(0).click();

		WebElement addToCart = driver.findElement(By.xpath("//button[text()='Add to cart']"));
		addToCart.click();		


		WebElement cart = driver.findElement(By.xpath("//a[text()='View Cart']"));
		cart.click();

		WebElement continueToCheckout = driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']"));
		continueToCheckout.click();		


		Thread.sleep(5000);
		WebElement firstName = driver.findElement(By.xpath("//input[@id='billing_first_name']"));
		firstName.sendKeys("Nick");

		WebElement lastName = driver.findElement(By.xpath("//input[@id='billing_last_name']"));
		lastName.sendKeys("Dunne");

		WebElement emailAddress = driver.findElement(By.xpath("//input[@id='billing_email']"));
		emailAddress.sendKeys("test@gmail.com");

		WebElement phone = driver.findElement(By.xpath("//input[@id='billing_phone']"));
		phone.sendKeys("5135555555");

		WebElement countryDropDown = driver.findElement(By.xpath("//div[@id='s2id_billing_country']/a/span[2]"));
		countryDropDown.click();
		Thread.sleep(2000);

		List<WebElement> countryList = driver.findElements(By.xpath("//ul[@id='select2-results-1']//li"));
		for(WebElement country : countryList){
			if(country.getText().equals("United States (US)")) {
				country.click();	
				Thread.sleep(3000);
				break;
			}		
		}

		WebElement city = driver.findElement(By.xpath("//input[@id='billing_city']"));
		city.sendKeys("Cincinnati");
		WebElement stateDroprDown = driver.findElement(By.xpath("//div[@id='s2id_billing_state']/a/span[2]"));
		stateDroprDown.click();
		Thread.sleep(2000);

		List<WebElement> stateDroprDownList = driver.findElements(By.xpath("//ul[@id='select2-results-2']//li"));
		for(WebElement state : stateDroprDownList){
			if(state.getText().equals("Ohio")) {
				state.click();	
				Thread.sleep(3000);
				break;
			}		
		}
		WebElement address = driver.findElement(By.xpath("//input[@id='billing_address_1']"));
		address.sendKeys("12127 Bose Terrace Drive");

		WebElement postcode = driver.findElement(By.xpath("//input[@id='billing_postcode']"));
		postcode.sendKeys("45287");		

		WebElement shipToSameAddress = driver.findElement(By.xpath("//input[@id='ship-to-different-address-checkbox']"));
		shipToSameAddress.click();
		Thread.sleep(3000);

		List<WebElement> paymentMethod = driver.findElements(By.xpath("//div[@id='payment']/ul/li"));
		paymentMethod.get(0).click();

		WebElement acceptTC = driver.findElement(By.xpath("//input[@id='terms']"));
		acceptTC.click();

		WebElement placeOrder = driver.findElement(By.xpath("//input[@id='place_order']"));
		placeOrder.submit();
		WebElement orderNumber = driver.findElement(By.xpath("//li[@class='order']"));
		Assert.assertEquals(orderNumber.getText().contains("Order Number"), true);
		driver.quit();

	}
}
