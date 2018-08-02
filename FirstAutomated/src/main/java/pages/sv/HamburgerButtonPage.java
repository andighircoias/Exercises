package pages.sv;

import constants.Locators;
import pages.TestPage;

public class HamburgerButtonPage extends TestPage{
	
	public void clickHamburgerButton() {
		clickIt(Locators.CSS, ".open-icon", true);
	}
	
	public void clickConfirmation() {
		clickIt(Locators.CSS, "#hs-eu-confirmation-button", true);
	}

}
