package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.OrderPage;
import pageObjects.ProductListingPage;

public class PageObjectManager {

	private WebDriver driver;
	private CartPage cartPage;
	private HomePage homePage;
	private ProductListingPage productListingPage;
	private CheckOutPage checkOutPage;
	private OrderPage orderPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public HomePage getHomePage() {
		return(homePage==null)? homePage = new HomePage(driver) : homePage;
	}
	public ProductListingPage getProductListingPage() {
		return(productListingPage==null)? productListingPage = new ProductListingPage(driver) : productListingPage;
	}
	public CartPage getCartPage() {
		return(cartPage==null)? cartPage = new CartPage(driver) : cartPage;
	}
	public CheckOutPage getCheckOutPage() {
		return(checkOutPage==null)? checkOutPage = new CheckOutPage(driver): checkOutPage;
	}
	public OrderPage getOrderPage(){
		return (orderPage == null)? orderPage = new OrderPage(driver) : orderPage;
	}
}
