package starter.user.farm;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetAllFarm {

    private static final String VALID_URL = "https://blueharvest.irvansn.com/v1/farms";
    private static final String INVALID_URL = "https://blueharvest.irvansn.com/v1/farms/invalid";
    private static final String UNAUTHORIZED_URL = "https://blueharvest.irvansn.com/v1/farms/unauthorized";
    private static final String VALID_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";

    @Step("I set farm API endpoint to retrieve all farm details")
    public String setFarmApiEndpointToRetrieveAllFarmDetails() {
        return VALID_URL;
    }

    @Step("I set invalid farm API endpoint to retrieve all farm details")
    public String setInvalidFarmApiEndpointToRetrieveAllFarmDetails() {
        return INVALID_URL;
    }

    @Step("I send GET request to retrieve all farm details")
    public void sendGetRequestToRetrieveAllFarmDetails() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .get(setFarmApiEndpointToRetrieveAllFarmDetails());
    }

    @Step("I send GET request to an invalid endpoint")
    public void sendGetRequestToInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .get(setInvalidFarmApiEndpointToRetrieveAllFarmDetails());
    }

    @Step("I receive all farm details")
    public void receiveAllFarmDetails() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_FARM);

        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Success get all farm data!")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.title", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.description", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.picture", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }


    @Step("the system should provide all farm details")
    public void verifyAllFarmDetails() {
    }



    @Step("the system should provide an error message about unauthorized access")
    public void verifyErrorMessageAboutUnauthorizedAccess() {
        restAssuredThat(response -> response.body("error", equalTo("Unauthorized")));
    }

    @Step("I send GET request without proper authorization")
    public void sendGetRequestWithoutAuthorization() {
        SerenityRest.given()
                .get(UNAUTHORIZED_URL);
    }

}
