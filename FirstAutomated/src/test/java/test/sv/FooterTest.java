package test.sv;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.Locators;
import pages.sv.HamburgerButtonPage;
import test.TestBase;

public class FooterTest extends TestBase{
	HamburgerButtonPage gbl = new HamburgerButtonPage();

	@BeforeClass
	public void navigate() {
		navigateToWantedPage("https://www.softvision.com/");
	}
	
	@Test
	public void footerDisplayed() {
		gbl.clickConfirmation();
		WebElement element = findElementBySomething(Locators.XPATH, ".//*[@id='text-10']/div/div[2]/ul", true);
		Assert.assertTrue(element.isDisplayed());
	}
	
}
