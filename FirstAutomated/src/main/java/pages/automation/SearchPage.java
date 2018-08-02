package pages.automation;

import org.openqa.selenium.WebElement;

import constants.Locators;
import pages.TestPage;

public class SearchPage extends TestPage {
	
	
	public WebElement clickAndTypeSearchBar(Locators locatorType, String locatorValue, String wantedValue) {
		clickIt(locatorType, locatorValue, true);
		sendKeysToElement(locatorType, locatorValue, true, wantedValue);
		WebElement w = findElementBySomething(locatorType, locatorValue, true);
		return w;
		
	}
	
	public void pressOnSearchButton(Locators locatorType, String locatorValue) {
		clickIt(locatorType, locatorValue, true);
	}
	
	
	
	
	

}
