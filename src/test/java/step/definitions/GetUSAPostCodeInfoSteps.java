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
import java.util.List;
import java.util.Map;


public class GetUSAPostCodeInfoSteps {

    private final String BASE_URL = "https://api.zippopotam.us";
    private Response response;
    private Scenario scenario;


    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;

    }
    @Given("I made a get call to {string}")
    public void i_made_a_get_call_to(String url2) throws URISyntaxException {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecification = RestAssured.given();
        response = requestSpecification.when().get(new URI(url2));
        System.out.println("Base Url is - " +BASE_URL);
        System.out.println("Final Endpoint is - " + url2);
    }
    @Then("status code should be {string}")
    public void status_code_should_be(String statusCode) {
        int actualResponseCode = response.then().extract().statusCode();
        Assert.assertEquals(statusCode, actualResponseCode + "");
        System.out.println("Status code is - " + actualResponseCode);
    }
    @Then("I retrieve United states post code")
    public void i_retrieve_united_states_post_code() {
        System.out.println("**** USA places are: ****");
        List<Map<String, String>> postCode = response.jsonPath().getList("places" );
        System.out.println(postCode);
        System.out.println("***** Extract of USA Post Codes ******");
        int i = 0;
        while (postCode.size() > i)
        {
            System.out.println(postCode.get(i++).get("post code"));
        }
    }
}
