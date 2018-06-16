package dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}
	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if(driverPath !=null) {
			return driverPath;
		}
		else{
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
		}
	}
	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			return Long.parseLong(implicitlyWait);
		}else {
			throw new RuntimeException("wait is not specified in the Configuration.properties file.");
		}
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) {
			return url;
		}else {
			throw new RuntimeException("url not specified in the Configuration.properties file.");
		}
			
	}
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browserName");
		if(browserName == null || browserName.equalsIgnoreCase("chrome")) {
			return DriverType.CHROME;
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			return DriverType.FIREFOX;
		}else if(browserName.equalsIgnoreCase("internetexplorer")) {
			return DriverType.INTERNETEXPLORER;
		}
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
	
	public EnvironmentType getEnvironment() {
		String environment = properties.getProperty("environment");
		if(environment==null || environment.equalsIgnoreCase("local")) {
			return EnvironmentType.LOCAL;
		}else if(environment.equalsIgnoreCase("remote")) {
			return EnvironmentType.REMOTE;
		}else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + environment);
	}
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
	public String getTestDataResourcesPath() {
		String testDataResourcesPath = properties.getProperty("testDataResourcePath");
		if(testDataResourcesPath != null)
			return testDataResourcesPath;
		else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
	}
	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath != null) {
			return reportConfigPath;
		}else {
		 throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
		}
		
	}
}

