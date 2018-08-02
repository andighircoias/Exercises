package pages.sv;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import constants.Locators;
import pages.TestPage;

public class SearchPageSV extends TestPage{
	
	public void pressOnSearchButton() {
		clickIt(Locators.CSS, ".search-trigger", true);
	}
	public void pressOnSearchBar() {
		clickIt(Locators.ID, "search", true);
	}
	
	public void sendKeysToSearch(String message) {
		sendKeysToElement(Locators.ID, "search", true, message);
	}
	public int results() {
		List<WebElement> list = new ArrayList<WebElement>(driver.findElements(By.className("result")));
		int results = list.size();
		return results;
	}
}
