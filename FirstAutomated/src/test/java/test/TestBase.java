package test;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pages.TestPage;

/**
 * 
 * @author andrei.ghircoias This is the parent class for all tests
 */

public class TestBase extends TestPage {

	
	public final static String PLATFORM_CONSTANT = "platform";
	public final static String APP_CONSTANT = "app";
	/**
	 * This method is the first to be executed when a test is run
	 * 
	 * @return void
	 */
	
	@BeforeClass
	public void initialiseDriver() {
		initializeDriver2();
	}

	/**
	 * This method is being executed after each test is ran
	 * 
	 * @return void
	 */
	@AfterClass
	public void closeProcess() {
		closeWholeProcess();
	}
	
	@BeforeSuite
	public void selectPlatform(ITestContext context) {
			HashMap<String,String> parameters = new HashMap<String, String>(context.getCurrentXmlTest().getAllParameters());
			platform = parameters.get(PLATFORM_CONSTANT);
			app = parameters.get(APP_CONSTANT);
			System.out.println(platform + " " + app);
	}
	


}
