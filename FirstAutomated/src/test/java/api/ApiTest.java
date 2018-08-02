package api;


import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.MyUtils;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTest extends MyUtils {
	public static final String baseURL = "https://reqres.in/";

	@Test
	public void reutrnUsers() {
		boolean statusCodeResp;
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		Response response = httpRequest.request(Method.GET, "/api/users/");
		// System.out.println(response.statusCode());
		// System.out.println(response.prettyPrint());
		if (response.statusCode() == 200) {
			statusCodeResp = true;
		} else {
			statusCodeResp = false;
			System.out.println("invalid Status code");
		}
		Assert.assertTrue(statusCodeResp);
	}

	@Test
	public void notFound() {
		boolean statusCodeResp;
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		Response response = httpRequest.request(Method.GET, "/api/users/13");
		if (response.statusCode() == 404) {
			statusCodeResp = true;
		} else {
			statusCodeResp = false;
			System.out.println("invalid Status code");
		}

		Assert.assertTrue(statusCodeResp);
	}

	@Test
	public void check() {
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		Response response = httpRequest.request(Method.GET, "/api/users/2");
		String name = response.asString();
		Assert.assertTrue(name.contains("Janet"));

	}

	@Test
	public void json() {
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		Response response = httpRequest.request(Method.GET, "/api/users/2");

		String jsonString = response.asString();
		String string = getUserDataFromJson(jsonString, "first_name").toString();
		Assert.assertTrue(((String) string).contains("Janet"));
	}

	@Test
	public void getUsersTestNG() {
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		Response response = httpRequest.request(Method.GET, "/api/users");
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test
	public void getUsersRESTAssure() {
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		RestAssured.given().header(contentType).when().get("/api/users").then().statusCode(200);

	}

	@Test
	public void getAllUsers() {
		final String parameters = "api/users/";
		boolean checkTest;
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		Response response = httpRequest.request(Method.GET, parameters);
		String users = response.asString();
		String string = getUserDataFromJson(users, "total").toString();
		int number = Integer.parseUnsignedInt(string);

		for (int i = 1; i < number; i++) {
			Response response2 = httpRequest.request(Method.GET, parameters + i);
			String users2 = response2.asString();
			String stringID = getUserDataFromJson(users2, "id").toString();
			int integerID = Integer.parseInt(stringID);
			if (integerID == i) {
				checkTest = true;
			} else {
				checkTest = false;
			}
			integerID++;
			Assert.assertTrue(checkTest);
		}
	}
	
	
	@Test
	public void create() {
		boolean check =false;
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		String st = createUserJson("Grigore", "QAengineer");

		Response re = httpRequest.body(st).post("api/users/");
		String st2 = re.asString();
		System.out.println(st2);
		if(st2.contains("Grigore") && st2.contains("QAengineer")) {
			check = true;
		}else {
			check=false;
		}
		Assert.assertTrue(check);
	}
	
	@Test
	public void statusCodeWhenAdd() {
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		String st = createUserJson("Grigore", "QAengineer");
		Response r = httpRequest.body(st).post("api/users/");
		Assert.assertEquals(r.getStatusCode(), 201);
		
		
		
	}
	
	
	
	

}
