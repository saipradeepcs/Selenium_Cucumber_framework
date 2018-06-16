package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage {

	public ProductListingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//button[text()='Add to cart']") 
	private WebElement btn_AddToCart;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='noo-product-inner noo-product-inner2']"))
	private List<WebElement> prd_List;	
	
	public void clickOn_AddToCart() {
		btn_AddToCart.click();
	}
	
	public void select_Product(int productNumber) {
		prd_List.get(productNumber).click();
	}
	public String getProductName(int productNumber) {
		return prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText();
	}
}
