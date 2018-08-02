package test.automation;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.Locators;
import constants.SignInConstants;
import pages.automation.SignInPage;
import test.TestBase;

/**
 * 
 * @author andrei.ghircoias 
 * This class tests the sign in and sign out functionality 
 * Is child of TestBase class
 */
public class SignInTest extends TestBase {
	SignInPage sip = new SignInPage();

	/**
	 * This method is executed after the @BeforeClass initialiseDriver(); method
	 * from the parent class
	 */
	@BeforeClass
	public void navigate() {
		navigateToWantedPage(SignInConstants.url);
		maximizePAGE();
		System.out.println("SignIn: @BeforeClass");
	}
	
	
	/**
	 * this method verifies the sign in functionality
	 */
	@Test
	public void signIn() {
		String currentUrl = "http://automationpractice.com/index.php?controller=my-account";
		sip.typeInUsername(Locators.ID, SignInConstants.ID_USERNAME_CONSTANT, "ghirc.and@gmail.com");
		sip.typeInPassword(Locators.ID, SignInConstants.ID_PASSWORD_CONSTANT, "redhotchilipeppers");
		sip.submit(Locators.ID, SignInConstants.ID_SUBMIT_BUTTON);
		assertEquals(driver.getCurrentUrl(), currentUrl);
		System.out.println("SignIn: signInTest");
	}
	/**
	 * this method verifies the sign out functionality
	 */
	@Test
	public void signOut() {
		String currentUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		sip.signOut(Locators.CLASS_NAME, "logout");
		assertEquals(driver.getCurrentUrl(), currentUrl);
	}
	
}
