package test.automation;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.TestBase;

/**
 * 
 * @author andrei.ghircoias 
 * The purpose is to test the contact and sign in buttons 
 * This class is a child of TestBase class
 */
public class ContactSignInButtonTest extends TestBase {

	/**
	 * This method is executed after the @BeforeClass initialiseDriver(); method
	 * from the parent class
	 * 
	 * @return void
	 */
	@BeforeClass
	public void navigateToWantedLink() {
		driver.navigate().to("http://automationpractice.com/index.php");
		maximizePAGE();
		System.out.println("Contact&signInButton @BeforeClass");
	}

	/**
	 * This tests the functionality of the contact button
	 * 
	 * @return void
	 */
	@Test
	public void navigateToContactLink() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("contact-link")));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#contact-link>a")));
		element.click();
		assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=contact");
	}

	/**
	 * This methods tests the sign in button
	 * 
	 * @return void
	 */

	@Test
	public void navigateToSingInLink() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("login")));
		element.click();
		assertEquals(driver.getCurrentUrl(),
				"http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

}
