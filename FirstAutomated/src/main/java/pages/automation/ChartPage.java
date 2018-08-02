package pages.automation;

import constants.Locators;
import pages.TestPage;

public class ChartPage extends TestPage{
	public void clickOnSomething(Locators locator, String name, boolean mandatory){
		findElementBySomething(locator, name, mandatory);
	}
	
	
}
