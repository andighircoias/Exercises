package test.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.TestBase;

/**
 * 
 * @author andrei.ghircoias
 *
 */
public class ChartTest extends TestBase {

	@BeforeClass
	public void navigateToWantedPege() {
		navigateToWantedPage("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
		maximizePAGE();
		System.out.println("ChartTest @BeforeClass");
	}

	@Test
	public void addToChart() {
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".replace-2x.img-responsive")));
		element.click();
		WebElement element2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='add_to_cart']/button")));
		element2.click();
		WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.className("cross")));
		element3.click();
		WebElement elementToBeHovered = driver.findElement(By.cssSelector(".shopping_cart>a"));
		Actions action = new Actions(driver);
		action.moveToElement(elementToBeHovered).build().perform();
		WebElement element4 = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button_order_cart>span")));
		element4.click();
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.cssSelector(".cart_quantity_input.form-control.grey")));
		WebElement element5 = driver.findElement(By.cssSelector(".cart_quantity_input.form-control.grey"));
		Assert.assertTrue(element5.getAttribute("value").equals("1"));

	}

	@Test
	public void checkAddMoreOfTheSameProductToChart() {
		WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-plus")));
		element5.click();
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.cssSelector(".cart_quantity_input.form-control.grey")));
		WebElement element6 = driver.findElement(By.cssSelector(".cart_quantity_input.form-control.grey"));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(element6.getAttribute("value").equals("2"));

	}
}
