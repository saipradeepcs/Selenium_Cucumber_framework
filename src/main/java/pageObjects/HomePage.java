package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import managers.FileReaderManager;
import testDataTypes.Items;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void perform_Search(Items item) {
		driver.navigate().to(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl() + "/?s=" + item.itemName + "&post_type=product");
	}
	
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl());
	}
}
