package starter.user.farmInvest;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetAllFarmInvestUser {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/farminvests";
    private static final String INVALID_URL = "https://blueharvest.irvansn.com/v1/invalid-farminvests";
    private static final String UNAUTHORIZED_URL = "https://blueharvest.irvansn.com/v1/farminvests/unauthorized";

    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";
    private static final String INVALID_TOKEN = "gyasdGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";

    @Step("I set farm invest API endpoint for get all farm invests user")
    public String setFarmInvestUserApiEndpoint() {
        return BASE_URL;
    }

    @Step("I set invalid farm invest API endpoint")
    public String setInvalidFarmInvestUserApiEndpoint() {
        return INVALID_URL;
    }

    @Step("I set invalid API endpoint for retrieving all articles")
    public String UNAUTHORIZED_URL() {
        return UNAUTHORIZED_URL;
    }

    @Step("I send GET request to get all farm invests user")
    public void sendGetRequestToGetAllFarmInvestUser() {
        SerenityRest.given()
                .header("Authorization", TOKEN)
                .get(setFarmInvestUserApiEndpoint());
    }
    @Step("I send GET request to get all farm invests user")
    public void sendGetRequestToGetAllFarmInvestUserAuth() {
        SerenityRest.given()
                .header("Authorization", INVALID_TOKEN)

                .get(setFarmInvestUserApiEndpoint());
    }
    @Step("I send GET request to get all farm invests user")
    public void sendGetRequestToGetAllFarmInvestUserInvalid() {
        SerenityRest.given()
                .header("Authorization", TOKEN)

                .get(setInvalidFarmInvestUserApiEndpoint());
    }

    @Step("I receive status code 200")
    public void receiveStatusCode200() {
        SerenityRest.then().statusCode(200);
    }

    @Step("I receive a list of farm invests user")
    public void receiveListOfFarmInvestUser() {
        // Example assertions for response body
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Success get all farm invest user data!")));

        // Example JSON schema validation
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_FARM_INVEST_USER);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I receive status code 404")
    public void receiveStatusCode404() {
        SerenityRest.then().statusCode(404);
    }
}
