package cucumber;

import managers.DriverManager;
import managers.PageObjectManager;

public class TestContext {

	private DriverManager drivermanager;
	private PageObjectManager pageObjectManager;
	public ScenarioContext scenarioContext;
	
	public TestContext() {
		drivermanager = new DriverManager();
		pageObjectManager = new PageObjectManager(drivermanager.getDriver());
		scenarioContext = new ScenarioContext();
	}
	public DriverManager getDriverManager() {
		return drivermanager;
	}
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}
}
