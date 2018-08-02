package pages.automation;

import java.io.File;


import constants.Locators;
import pages.TestPage;

public class SignInPage extends TestPage {


	public void typeInUsername(Locators typeOfLocatorForUsername, String locatorName, String textWanted) {
		clickIt(typeOfLocatorForUsername, locatorName, true);
		sendKeysToElement(typeOfLocatorForUsername, locatorName, true, textWanted);
	}

	public void typeInPassword(Locators typeOfLocatorForPassword, String locatorName, String textWanted) {
		clickIt(typeOfLocatorForPassword, locatorName, true);
		sendKeysToElement(typeOfLocatorForPassword, locatorName, true, textWanted);
	}

	public void submit(Locators typeOfLocatorForButton, String locatorName) {
		clickIt(typeOfLocatorForButton, locatorName, true);

	}
	
	public File createPropertyFile(String path) {
		File file = createFile(path);
		return file;
	}
	
	public void writeInPropertiyFile(String path, String key, String value) {
		writeInFile(path, key, value);
	}

	public String readFromPropertiesFile(String path, String key) {
		String st = readFromFile(path, key);
		return st;
	}
	
	public void writeInPropertyFile(String path, String key, String value) {
		writeInFile(path, key, value);		
	}
	
	public void signOut(Locators locator, String nameLocator) {
		clickIt(locator, nameLocator, true);
	}

}
