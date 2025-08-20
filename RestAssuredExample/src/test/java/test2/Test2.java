	package test2;
	
	import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
	import io.restassured.response.Response;
	
	public class Test2 {
	@Test
	public void getresponce() {
		Response res= RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");
		int code=res.getStatusCode();
		String data = res.asString();
		System.out.println(code);
		System.out.println(data);
		System.out.println(res.getTime());
		Assert.assertEquals(code, 200);
	}
	}
