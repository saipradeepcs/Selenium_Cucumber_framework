package managers;

import dataProvider.ConfigFileReader;
import dataProvider.JsonDataReader;

public class FileReaderManager {

	private static FileReaderManager filereaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonDataReader jsonDataReader;
	
	private FileReaderManager() {
	}
	public static FileReaderManager getInstance() {
		return filereaderManager;
	}
	
	public ConfigFileReader getConfigFileReader() {
		return(configFileReader == null) ?  new ConfigFileReader() : configFileReader;
	}
	
	public JsonDataReader getJsonReader(){
		 return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
	}
}
