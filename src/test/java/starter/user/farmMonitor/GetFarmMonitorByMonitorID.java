package starter.user.farmMonitor;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetFarmMonitorByMonitorID {
    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/farmmonitors";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";

    @Step("I set farm monitor API endpoint for get all monitors by FarmId")
    public String setFarmMonitorApiEndpointForFarmId() {
        return BASE_URL + "/";
    }

    @Step("I send GET request to get all farm monitors by valid FarmId")
    public void sendGetRequestToGetAllFarmMonitorsByFarmId() {
        SerenityRest.given()
                .header("Authorization", TOKEN)
                .get(setFarmMonitorApiEndpointForFarmId() + "df0a0283-daa3-4cb3-bf54-d0d246ed63e8");
    }

    @Step("I receive status code 200")
    public void receiveStatusCode200() {
        SerenityRest.then().statusCode(200);
    }

    @Step("I receive a list of farm monitors with the given FarmId")
    public void receiveListOfFarmMonitorsWithFarmId() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_FARM_MONITORS_BY_MONITORID);
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Success get farm monitor data!")));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send GET request to get all farm monitors by invalid FarmId")
    public void sendGetRequestToGetAllFarmMonitorsByInvalidFarmId() {
        SerenityRest.given()
                .header("Authorization", TOKEN)
                .get(setFarmMonitorApiEndpointForFarmId() + "2534e423-24e0-4751-8073-ebcd19061a9b");
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
