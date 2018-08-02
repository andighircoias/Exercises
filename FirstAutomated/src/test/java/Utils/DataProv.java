package Utils;

import org.testng.annotations.DataProvider;

public class DataProv {
	
	@DataProvider(name = "New Users")
	 public static Object[][] users() {
	  return new Object[][] {
	   {"Ion Creanga", "writer"},
	   {"Mihai Eminescu", "poet"},
	   {"Simona Halep", "tennis player"},
	   {"Klaus Iohannis", "president"},
	   {"Joey Tribianni", "actor"},
	   {"Joey Tribianni", "actor"}
	  };
	 }
	
	@DataProvider(name = "Username&Password")
	public static  Object[][] authentification(){
		return new Object[][] {
			{"ToolsQA", "TestPassword"}
		};
	}
	
}
