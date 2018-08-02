package test.automation;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constants.Locators;
import constants.SearchConstants;
import pages.automation.SearchPage;
import test.TestBase;


/**
 * 
 * @author andrei.ghircoias This class tests the search bar functionality
 */
public class SearchTest extends TestBase {

	SearchPage sp = new SearchPage();

	@BeforeMethod
	public void navigate() {
		navigateToWantedPage(SearchConstants.url);
		maximizePAGE();
		System.out.println("SearchTest @BeforeClass");
	}

	@Test
	public void searchProcess() {
		String URL = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		sp.clickAndTypeSearchBar(Locators.ID, SearchConstants.ID_SEARCH_BAR, "dress");
		sp.pressOnSearchButton(Locators.CSS, SearchConstants.CSS_SELECTOR_BUTTON);
		findElementBySomething(Locators.CSS, SearchConstants.CSS_SELECTOR_IMAGE, true);
		Assert.assertEquals(driver.getCurrentUrl(), URL);

	}

	@Test
	public void invalidData() {
		sp.clickAndTypeSearchBar(Locators.ID, SearchConstants.ID_SEARCH_BAR, "numanumaiei");
		sp.pressOnSearchButton(Locators.CSS, SearchConstants.CSS_SELECTOR_BUTTON);
		WebElement e = findElementBySomething(Locators.CSS, ".alert.alert-warning", true);
		Assert.assertTrue(e.isDisplayed());
	}
}
