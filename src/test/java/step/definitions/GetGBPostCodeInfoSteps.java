package step.definitions;


import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;



public class GetGBPostCodeInfoSteps {

    private final String BASE_URL = "https://api.zippopotam.us";
    private Response response;
    private Scenario scenario;


    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }


    @Given("a get call to {string}")
    public void a_get_call_to(String url) throws URISyntaxException {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecification = RestAssured.given();
        response = requestSpecification.when().get(new URI(url));
        System.out.println("Base Url is - " + BASE_URL);
        System.out.println("Final Endpoint is - " + url);

    }
    @Then("status code is {string}")
    public void status_code_is(String statusCode) {
        int actualResponseCode = response.then().extract().statusCode();
        Assert.assertEquals(statusCode, actualResponseCode + "");
        System.out.println("Status code is - " + actualResponseCode);
    }
    @Then("I retrieve Great Britain post code")
    public void i_retrieve_great_britain_post_code() {
        System.out.println("**** Great Britain places are:****");
        List<Map<String, String>> postCode = response.jsonPath().getList("places" );
        System.out.println(postCode);
        System.out.println("***** Extract of Great Britain Post Codes ******");
        int i = 0;
        while (postCode.size() > i)
        {
            System.out.println(postCode.get(i++).get("post code"));
        }
    }

}
