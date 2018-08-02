package pages.sv;

import constants.Locators;
import pages.TestPage;

public class ContactPage extends TestPage{
	
	
	public void clickOnContactButton(){
		clickIt(Locators.XPATH, ".//*[@id='nav-menu-item-19896']/a/span[1]", true);
	}
}
