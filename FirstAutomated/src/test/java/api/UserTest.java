package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.DataProv;
import Utils.MyUtils;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserTest extends MyUtils{
	DataProv dp = new DataProv();
	public static final String baseURL = "https://reqres.in/";
	
	
	@Test (dataProvider = "New Users", dataProviderClass = DataProv.class)
	public static void runTests(String dataProvidedName, String dataProvidedJob) {
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		Response response = httpRequest.body(createUserJson(dataProvidedName, dataProvidedJob)).post("api/users/");
		Assert.assertEquals(response.statusCode(),  201);
		response.prettyPrint();
	}
}
