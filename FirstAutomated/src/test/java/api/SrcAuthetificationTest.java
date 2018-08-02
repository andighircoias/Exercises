package api;

import org.testng.annotations.Test;

import Utils.DataProv;
import Utils.MyUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SrcAuthetificationTest extends MyUtils {
	DataProv dp = new DataProv();
	public static final String baseURL = "http://restapi.demoqa.com/authentication/CheckForAuthentication";

	@Test
	public void noAuthetificationTest() {
		RestAssured.baseURI = baseURL;
		RequestSpecification httpRequest = RestAssured.given();
		Response r = httpRequest.request(Method.GET);
		r.prettyPrint();
		System.out.println(r.statusCode());
	}

	@Test(dataProvider = "Username&Password", dataProviderClass = DataProv.class)
	public void authentification(String dataProvidedName, String dataProvidedPassword) {

		RestAssured.baseURI = baseURL;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.auth().basic(dataProvidedName, dataProvidedPassword);
		Response r = httpRequest.get();
		System.out.println(r.getStatusCode());
		System.out.println(r.getHeader("Authorization"));
		r.prettyPeek();

	}
}
