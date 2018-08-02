package test.automation;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.TestBase;

public class HomePageTesting extends TestBase {

	@BeforeClass
	public void goToPage() {
		navigateToWantedPage("http://automationpractice.com/index.php");
		maximizePAGE();
		System.out.println("HomePage: @BeforeClass");
	}

	@Test
	public void checkIfIsTheRightPage() {
		String url = "http://automationpractice.com/index.php";
		assertEquals(driver.getCurrentUrl(), url);
		System.out.println("HomePage @Test");
	}

}
