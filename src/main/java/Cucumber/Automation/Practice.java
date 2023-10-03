package Cucumber.Automation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import static io.restassured.RestAssured.*;

public class Practice {

		public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI ="https://reqres.in/";
		Response postresponse = given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").when().post("api/users").then().log().all().assertThat().statusCode(201).extract().response();
		JsonPath js1 = new JsonPath(postresponse.asString());
		int id = js1.getInt("id");
		System.out.println(js1.get("id"));
		
		RestAssured.baseURI ="https://reqres.in/";
		
	//	given().pathParam("id",id).when().get("api/users/${id}").then().
		
		Response getresponse = given().queryParam("page","{2}").when().get("api/users/${page}").then().
		log().all().assertThat().statusCode(200).extract().response();
		
		JsonPath js2 = new JsonPath(getresponse.asString());
		System.out.println(js2.get("data.id"));
		Assert.assertEquals(id, js2.get("data.id"));
	}
}
