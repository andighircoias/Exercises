package test.sv;

import java.util.concurrent.TimeUnit;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.sv.HamburgerButtonPage;
import pages.sv.SearchPageSV;
import test.TestBase;

public class SearchTest extends TestBase{
	HamburgerButtonPage hbp  = new HamburgerButtonPage();
	SearchPageSV sp = new SearchPageSV();
	@BeforeClass
	public void navigate() {
		navigateToWantedPage("https://www.softvision.com/");
	}
	@Test
	public void searchDisplay() {
		boolean check;
		int minimumResults=1;
		hbp.clickConfirmation();
		sp.pressOnSearchButton();
		sp.sendKeysToSearch("Digital");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(sp.results()>=minimumResults) {
			check=true;
		}else {
			check=false;
		}
		Assert.assertTrue(check);
	}
}
