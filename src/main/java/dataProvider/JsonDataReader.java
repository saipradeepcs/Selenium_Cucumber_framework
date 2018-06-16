package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import managers.FileReaderManager;
import testDataTypes.Customer;
import testDataTypes.Items;

public class JsonDataReader {

	private final String customerFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcesPath()+"Customer.json";
	private final String itemsFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcesPath()+"items.json";
	private List<Customer> customerList;
	private List<Items> itemsList;
	Gson gson;
	public JsonDataReader() {
		customerList = getCustomerData();
		itemsList = getItems();
	}

	private List<Items> getItems() {
		gson = new Gson();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(itemsFilePath));
			Items[] items = gson.fromJson(bufferedReader, Items[].class);
			return Arrays.asList(items);
		}
		catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + itemsFilePath);
		}
		finally {
			try {
				if(bufferedReader != null)
					bufferedReader.close();
			}catch(IOException io) {

			}
		}
	}
	public final Items getITemByName(String itemname) {
		for(Items item: itemsList) {
			if(item.itemName.equalsIgnoreCase(itemname)) {
				return item;
			}
		}
		return null;
	}
	private List<Customer> getCustomerData(){

		 gson = new Gson();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(customerFilePath));
			Customer[] customers = gson.fromJson(bufferedReader, Customer[].class);
			return Arrays.asList(customers);
		}
		catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + customerFilePath);
		}
		finally {
			try {
				if(bufferedReader != null)
					bufferedReader.close();
			}catch(IOException io) {

			}
		}
	}
	public final Customer getCustomerbyname(String customerName) {
		for(Customer customer: customerList) {
			if(customer.firstName.equalsIgnoreCase(customerName)) {
				return customer;
			}
		}
		return null;
	}

	
}