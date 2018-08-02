package test.sv;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.Locators;
import pages.sv.HamburgerButtonPage;
import test.TestBase;

public class HamburgerButtonTest extends TestBase{
	HamburgerButtonPage hbp  = new HamburgerButtonPage();
	@BeforeClass
	public void navigate() {
		navigateToWantedPage("https://www.softvision.com/");
	}
	@Test
	public void clickingOnHamburgerButton() {

		hbp.clickConfirmation();
	
		hbp.clickHamburgerButton();
	
		WebElement element = findElementBySomething(Locators.XPATH, ".//*[@id='nav-menu-item-19896']/a/span[1]", true);
		Assert.assertTrue(element.isDisplayed());
	}
}
