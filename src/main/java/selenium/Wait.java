package selenium;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;



import managers.FileReaderManager;

public class Wait {

	public static void untilJqueryIsDone(WebDriver driver) {
		untilJqueryIsDone(driver, FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait());
	}
	
	public static void untilJqueryIsDone(WebDriver driver, Long timeoutinseconds) {
		until(driver, (d) ->
		{
			Boolean isJqueryCallDone  = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active ==0");
			if(!isJqueryCallDone) {
				System.out.println("JQuery call is in progress");
			}
			return isJqueryCallDone;
		},	timeoutinseconds);
		
	}
	public static void untilPageLoadComplete(WebDriver driver) {
		untilPageLoadComplete(driver, FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait());
	}
 
	public static void untilPageLoadComplete(WebDriver driver, long timeoutInSeconds){
		until(driver, (d) ->
			{
				Boolean isPageLoaded = (Boolean)((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				if (!isPageLoaded) System.out.println("Document is loading");
				return isPageLoaded;
			}, timeoutInSeconds);
	}
	public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition) {
		until(driver, waitCondition, FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait());
		
	}
	@SuppressWarnings("deprecation")
	public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, long timeoutinseconds) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutinseconds);
		webDriverWait.withTimeout(timeoutinseconds, TimeUnit.SECONDS);
		try {
			webDriverWait.until(waitCondition);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@SuppressWarnings("deprecation")
	public static void untilElementPresence(WebDriver driver, Function<WebDriver, WebElement> waitCondition, long timeoutinseconds) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutinseconds);
		webDriverWait.pollingEvery(250, TimeUnit.MILLISECONDS);
		webDriverWait.withTimeout(timeoutinseconds, TimeUnit.SECONDS);
		webDriverWait.ignoring(NoSuchElementException.class);
		try {
			webDriverWait.until(waitCondition);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
