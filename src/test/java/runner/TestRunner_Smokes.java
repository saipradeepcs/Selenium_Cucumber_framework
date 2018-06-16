package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests",
		glue = "stepDefinitions",
		tags = "@SmokeTest",
		monochrome = true,
		plugin =  { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"} )
public class TestRunner_Smokes {

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(FileReaderManager.getInstance().getConfigFileReader().getReportConfigPath());
		Reporter.setSystemInfo("User name", System.getProperty("user.name"));
		Reporter.setSystemInfo("TimeZone", System.getProperty("user.timeZone"));
		Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.3");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}
