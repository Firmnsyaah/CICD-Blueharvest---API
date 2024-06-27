package starter.user.farmMonitor;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static java.util.concurrent.TimeUnit.SECONDS;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetAllFarmMonitorByFarmId {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/farmmonitors";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";

    @Step("I set farm monitor API endpoint for get all monitors by FarmId")
    public String setFarmMonitorApiEndpointForFarmId() {
        return BASE_URL + "/farm/";
    }

    @Step("I send GET request to get all farm monitors by valid FarmId")
    public void sendGetRequestToGetAllFarmMonitorsByFarmId() {
        SerenityRest.given()
                .header("Authorization", TOKEN)
                .get(setFarmMonitorApiEndpointForFarmId() + "6e64f138-a094-4780-b34a-b1d0a00430f2")
                .then()
                .time(lessThan(10L), SECONDS)  // Set maximum response time to 10 seconds
                .log().all();
    }

    @Step("I receive status code 200")
    public void receiveStatusCode200() {
        SerenityRest.then().statusCode(200);
    }

    @Step("I receive a list of farm monitors with the given FarmId")
    public void receiveListOfFarmMonitorsWithFarmId() {
        // Example assertions for response body
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Success get all farm monitor data!")));
        restAssuredThat(response -> response.body("data", notNullValue()));
        restAssuredThat(response -> response.body("data.size()", greaterThan(0)));

        // Example JSON schema validation
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_FARM_MONITORS_BY_FARMID);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send GET request to get all farm monitors by invalid FarmId")
    public void sendGetRequestToGetAllFarmMonitorsByInvalidFarmId() {
        SerenityRest.given()
                .header("Authorization", TOKEN)
                .get(setFarmMonitorApiEndpointForFarmId() + "9j54h948-f874-4780-b34a-b1d0a00450h8");
    }

    @Step("I receive status code 400")
    public void receiveStatusCode400() {
        SerenityRest.then().statusCode(400);
    }

    @Step("I send GET request to get all farm monitors with missing FarmId")
    public void sendGetRequestToGetAllFarmMonitorsWithMissingFarmId() {
        SerenityRest.given()
                .header("Authorization", TOKEN)
                .get(BASE_URL + "/farm/");
    }

    @Step("I receive status code 404")
    public void receiveStatusCode404() {
        SerenityRest.then().statusCode(404);
    }
}
