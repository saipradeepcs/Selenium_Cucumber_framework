package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.DriverType;
import enums.EnvironmentType;

public class DriverManager {

	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private final static String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public DriverManager() {
		driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if(driver == null) {
			driver = createDriver();
		}
		return driver;
	}

	private WebDriver createDriver() {
		switch(environmentType) {
		case LOCAL: createLocalDriver();
		break;
		case REMOTE: createRemoteDriver();
		break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver() {
		switch(driverType) {
		case CHROME : System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
		driver = new ChromeDriver();
		break;
		case FIREFOX : driver = new FirefoxDriver();
		break;
		case INTERNETEXPLORER: driver = new InternetExplorerDriver();
		break;
		}
		if(FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize()) driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}
	
	public void closeDriver() {
		driver.close();
		driver.quit();
	}
}
