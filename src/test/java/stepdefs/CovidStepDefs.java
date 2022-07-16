package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CovidStepDefs {
    Response response;//make one universal response for the class

    @When("user sends GET request to COVID api")
    public void userSendsGETRequestToCOVIDApi() {
        response =RestAssured.given().accept("application/json")
                .when().get("https://corona.lmao.ninja/v2/states");
    }
    @Then("User gets information about all States")
    public void userGetsInformationAboutAllStates() {
        List<Map<String,Object>> parsedResp=
                response.as(new TypeRef<List<Map<String,Object>>>(){

                });
        Assert.assertTrue(parsedResp.size()==50);
    }
    @Then("status is {int}")
    public void statusIs(int expStatusCode) {
        int actStatusCode= response.statusCode();
        Assert.assertEquals(expStatusCode,actStatusCode);
    }
}
