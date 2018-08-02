package test.sv;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.sv.ContactPage;
import pages.sv.HamburgerButtonPage;
import test.TestBase;

public class ContactButtonTest extends TestBase {
	HamburgerButtonPage hbp = new HamburgerButtonPage();
	ContactPage cp = new ContactPage();

	@BeforeClass
	public void navigate() {
		navigateToWantedPage("https://www.softvision.com/");
	}

	@Test
	public void clickingOnContactButton() {
		String url = "https://www.softvision.com/contact/";
		hbp.clickConfirmation();
		hbp.clickHamburgerButton();
		cp.clickOnContactButton();
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}

}
