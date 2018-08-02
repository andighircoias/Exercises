package test.sv;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.TestBase;

public class HomeScreenTest extends TestBase {

	
	
	@BeforeClass
	public void navigate() {
		navigateToWantedPage("https://www.softvision.com/");
	}
	@Test
	public void openPage() {
		String url = "https://www.softvision.com/";
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}
	
	
}
