package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Locators;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestPage {
	public static final Locators UNDIFINED = null;
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	public static String platform;
	public static String app;
	public static final String DESKTOP_TYPE = "desktop";
	public static final String MOBILE_TYPE = "mobile";
	public static final String MOBILE_TYPE_C = "mobileEmulator";

	public void initializeDriver2() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Resources\\chromedriver.exe");

		if (platform.equals(DESKTOP_TYPE)) {

			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 10);
		}

		if (platform.equals(MOBILE_TYPE)) {

			Map<String, String> mobileEmulation = new HashMap<String, String>();
			ChromeOptions chromeOptions = new ChromeOptions();
			mobileEmulation.put("deviceName", "Nexus 5");
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			driver = new ChromeDriver(chromeOptions);
			wait = new WebDriverWait(driver, 10);
		}

		else if (platform.equals(MOBILE_TYPE_C)) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			URL url = null;
			try {
				url = new URL("http://127.0.0.1:4723/wd/hub");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			AppiumDriver<WebElement> driver = new AndroidDriver<WebElement>(url, capabilities);
			driver.navigate().to("https://www.softvision.com/");

		}
	}

	public void navigateToWantedPage(String url) {
		driver.navigate().to(url);
	}

	public void maximizePAGE() {
		driver.manage().window().maximize();
	}

	public void findIfVisiblie(String locator, String name) {

	}

	public WebElement findElementBySomething(Locators locator, String nameOfLocator, boolean selectIfMendatory) {
		WebElement element = null;

		try {
			switch (locator) {

			case CSS:
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(nameOfLocator)));
				element = driver.findElement(By.cssSelector(nameOfLocator));
				break;
			case XPATH:
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(nameOfLocator)));
				element = driver.findElement(By.xpath(nameOfLocator));
				break;
			case ID:
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(nameOfLocator)));
				element = driver.findElement(By.id(nameOfLocator));
				break;
			case NAME:
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(nameOfLocator)));
				element = driver.findElement(By.className(nameOfLocator));
				break;
			case LINK_TEXT:
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(nameOfLocator)));
				element = driver.findElement(By.linkText(nameOfLocator));
				break;
			case TAG_NAME:
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName(nameOfLocator)));
				element = driver.findElement(By.tagName(nameOfLocator));
				break;
			case CLASS_NAME:
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(nameOfLocator)));
				element = driver.findElement(By.className(nameOfLocator));
				break;
			default:
				locator = UNDIFINED;
				break;
			}
		} catch (NoSuchElementException e) {
			if (selectIfMendatory == true) {
				e.printStackTrace();
				System.exit(1);
			} else {
				e.getMessage();
			}
		}
		return element;

	}

	public void clickIt(Locators locator, String nameOfLocator, boolean mendatory) {
		findElementBySomething(locator, nameOfLocator, mendatory).click();
	}

	public void sendKeysToElement(Locators locators, String nameOfLocators, boolean mendatories, String messageWanted) {
		findElementBySomething(locators, nameOfLocators, mendatories).sendKeys(messageWanted);

	}

	public void hoverOverSomething(Locators locator, String nameOfLocator, boolean mendatory) {
		WebElement hoverable = findElementBySomething(locator, nameOfLocator, mendatory);
		Actions action = new Actions(driver);
		action.moveToElement(hoverable).build().perform();
	}

	public File createFile(String path) {
		File file = new File(path);
		return file;

	}

	public void writeInFile(String path, String key, String value) {
		FileOutputStream fos = null;
		Properties prop = new Properties();

		try {
			File file = new File(path);
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		try {
			prop.setProperty(key, value);
		} catch (Exception w) {
			w.getLocalizedMessage();
		}
		try {
			prop.store(fos, "data");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public String readFromFile(String path, String key) {
		File file = new File(path);
		String line = null;
		FileInputStream fir = null;

		try {

			fir = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		Properties properties = new Properties();
		try {
			properties.load(fir);

		} catch (Exception e) {
			e.getMessage();
		} finally {
			try {
				fir.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Enumeration<?> enumeration = properties.keys();
		while (enumeration.hasMoreElements()) {
			enumeration.nextElement();
			line = properties.getProperty(key);

		}

		return line;

	}

	public void closeWholeProcess() {
		driver.close();
		if (driver != null) {
			driver.quit();
		}
	}

}
