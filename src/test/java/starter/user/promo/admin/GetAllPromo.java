package starter.user.promo.admin;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllPromo {
    private static final String VALID_URL = "https://blueharvest.irvansn.com/v1/promos";
    private static final String INVALID_URL = "https://blueharvest.irvansn.com/v1/invalid_promos";
    private static final String UNAUTHORIZED_URL = "https://blueharvest.irvansn.com/v1/unauthorized";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";

    @Step("I set API endpoint for retrieving all promos")
    public String setApiEndpoint() {
        return VALID_URL;
    }

    @Step("I set an invalid API endpoint for retrieving all promos")
    public String setInvalidApiEndpoint() {
        return INVALID_URL;
    }

    @Step("I send a GET request to retrieve all promos with valid data")
    public void sendGetRequestToRetrieveAllPromosWithValidData() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)

                .get(setApiEndpoint());
    }

    @Step("I send a GET request to retrieve all promos to an invalid endpoint")
    public void sendGetRequestToInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)

                .get(setInvalidApiEndpoint());
    }

    @Step("I send a GET request to retrieve all promos during a server error")
    public void sendGetRequestDuringServerError() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(UNAUTHORIZED_URL);

    }

    @Step("I receive a list of all promos")
    public void receiveListOfAllPromos() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_PROMO);restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("data", notNullValue()));
        restAssuredThat(schemaValidator -> schemaValidator.body(matchesJsonSchema(schema)));
    }


    @Step("I receive an error message about the endpoint not being found")
    public void receiveErrorMessageEndpointNotFound() {
        restAssuredThat(response -> response.body("message", equalTo("Not Found")));
    }

    @Step("I receive status code 500")
    public void receiveStatusCode500() {
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("I receive an error message about a server issue")
    public void receiveErrorMessageServerIssue() {
        restAssuredThat(response -> response.body("message", equalTo("Internal Server Error")));
    }
}
