package pages.automation;

import constants.Locators;
import pages.TestPage;

public class CreateAccountPage extends TestPage {

	public void clickOnSubmitButton(Locators locator, String nameOfLocator) {
		clickIt(locator, nameOfLocator, true);
	}

}
