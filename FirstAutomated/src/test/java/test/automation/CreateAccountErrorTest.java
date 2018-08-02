package test.automation;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.Locators;
import pages.automation.CreateAccountPage;
import test.TestBase;

/**
 * 
 * @author andrei.ghircoias The pupose is to test an error when entering a void
 *         value in the sign-up field Is a child of TestBase class
 */
public class CreateAccountErrorTest extends TestBase {
	CreateAccountPage cap = new CreateAccountPage();

	/**
	 * This method is executed after the @BeforeClass initialiseDriver(); method
	 * from the parent class It navigates to the wanted link
	 */
	@BeforeClass
	public void navigateToWantedLink() {
		navigateToWantedPage("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		maximizePAGE();
		System.out.println("CreateAccount @BeforeClass");
	}

	@Test
	public void errorTest() {
		cap.clickOnSubmitButton(Locators.ID, "SubmitCreate");
		WebElement error = /* driver.findElement(By.id("create_account_error")); */ findElementBySomething(Locators.ID,
				"create_account_error", false);
		Assert.assertTrue(error.isDisplayed());
	}

}
