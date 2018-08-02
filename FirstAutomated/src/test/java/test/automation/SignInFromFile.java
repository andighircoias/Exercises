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
 *
 *	This class verifies the sign in functionality using data
 *	taken from a file
 *	Is a child of TestBase class
 */
public class SignInFromFile extends TestBase {
	SignInPage sip = new SignInPage();

	@BeforeClass
	public void navigate() {
		navigateToWantedPage(SignInConstants.url);
		maximizePAGE();
		System.out.println("SignInFromPage: @BeforeClass");
	}
	/**
	 * method for taking the data, introducing it to text boxes 
	 * and pressing submit
	 */
	@Test
	public void signInFromFile() {
		String filePath = "C:\\Users\\andrei.ghircoias\\eclipse-workspace\\FirstAutomated\\login.properties";
		String currentUrl = "http://automationpractice.com/index.php?controller=my-account";
		String username = sip.readFromPropertiesFile(filePath, "email");
		String password = sip.readFromPropertiesFile(filePath, "password");
		sip.typeInUsername(Locators.ID, SignInConstants.ID_USERNAME_CONSTANT, username);
		sip.typeInPassword(Locators.ID, SignInConstants.ID_PASSWORD_CONSTANT, password);
		sip.submit(Locators.ID, SignInConstants.ID_SUBMIT_BUTTON);
		assertEquals(driver.getCurrentUrl(), currentUrl);
		System.out.println("SignIn: @Test");
	}

}
