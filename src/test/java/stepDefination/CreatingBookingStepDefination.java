package stepDefination;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import utilities.Utilitiy;

public class CreatingBookingStepDefination extends Utilitiy
{
	static RequestSpecification reqspec;
	ResponseSpecification resspec;
	TestDataBuild testdata = new TestDataBuild();
	Response response;

	@Given("User creates a booking with {string},{string},{string},{string},{string},{string},{string}")
	public void user_creates_a_booking_with
	(String firstname, String lastname, String totalprice, String depositpaid, String checkin, 
			String checkout, String additionalneeds) throws IOException 
	{
		reqspec = given().spec(requestSpecifcation()).body(testdata.CreateBooking_Payload(firstname,lastname,totalprice,
				depositpaid,checkin,checkout,additionalneeds));
	}
	
	@When("User has access to {string} API with {string} request")
	public void user_has_access_to_api_with_request(String resource, String method) 
	{
		resspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST"))
		{
			response = reqspec.when().post(resource);
		}
	}
	
	@Then("API call got success with the status code {int}")
	public void api_call_got_success_with_the_status_code(int statusCode) 
	{
		response.then().assertThat().assertThat().statusCode(statusCode);
		//Assert.assertEquals(response.getStatusCode(), statusCode);
	}
	
	@And("User validates the response")
	public void user_validates_the_response() {
	  
		System.out.println("PCompleted");
	}



}
