package test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jdk.jfr.Enabled;

import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class Test1 {
	@Test (enabled = false )
public void Test1_Get()
{
Response response = RestAssured.get("https://reqres.in/api/users?page=2");	

int statuscode = response.getStatusCode();

System.out.println(response.getStatusCode());
System.out.println(response.getTime());
System.out.println(response.getBody().asString());
System.out.println(response.getStatusLine());
System.out.println(response.getHeader("content-type"));

System.out.println("Actual Status Code: " + statuscode);
Assert.assertEquals(200, statuscode, "Status code did not match" );
System.out.println("Assertion Passed");
}

	@Test (enabled = false )
	public void Test2_get()
	{
		baseURI = "https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[0].first_name", equalTo("Michael")).
		log().all();
		;
		}
	
	@Test
	public void Test_Post1() {

	    // Create JSON request body
	    JSONObject request = new JSONObject();
	    request.put("name", "morpheus");
	    request.put("job", "leader");

	    System.out.println("Request JSON: " + request.toJSONString());

	    // Set base URI
	    RestAssured.baseURI = "https://reqres.in/api";

	    // Send POST request and validate
	    given()
	        .contentType(ContentType.JSON)
	        .body(request.toJSONString())
	    .when()
	        .post("/users")
	    .then()
	        .statusCode(201)
	        .log().all(); // Logs response details
	}}