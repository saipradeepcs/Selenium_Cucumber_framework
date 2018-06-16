package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//a[text()='View Cart']") 
	private WebElement btn_Cart;
	
	@FindBy(how = How.XPATH, using = "//a[@class='checkout-button button alt wc-forward']") 
	private WebElement btn_ContinueToCheckout;
	
	
	public void clickOn_Cart() {
		btn_Cart.click();
	}
	
	public void clickOn_ContinueToCheckout(){
		btn_ContinueToCheckout.click();
		try { Thread.sleep(5000);}
		catch (InterruptedException e) {}
	}
}
