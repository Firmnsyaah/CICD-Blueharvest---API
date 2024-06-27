package starter.user.farmMonitor;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateFarmMonitorByFarmMonitorID {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/farmmonitors/";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MTYxMzI0fQ.quEfLvd1SUv5rYntRVIG5hcNLSYuj3mkpvvI3P3jcd8";

    @Step("I set farm monitor API endpoint for editing farm monitor by FarmMonitorID")
    public String setApiEndpoint() {
        return BASE_URL + "df0a0283-daa3-4cb3-bf54-d0d246ed63e8";
    }

    @Step("I set invalid farm monitor API endpoint for editing farm monitor by FarmMonitorID")
    public String setInvalidApiEndpoint() {
        return BASE_URL + "/invalid-id";
    }

    @Step("I send PUT request to edit farm monitor by FarmMonitorID with valid authorization and data")
    public void sendPutRequestToEditFarmMonitorWithValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("farm_id", "25346423-2460-4751-8873-ebcd19961a9b");
        requestBody.put("temperature", 25.617313845122542);
        requestBody.put("ph", 7.365703746556487);
        requestBody.put("dissolved_oxygen", 8.744452365506064);

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .put(setApiEndpoint())
                .then()
                .statusCode(200)
                .log().all(); // Log all details of the request and response
    }

    @Step("I send PUT request to edit farm monitor without providing FarmMonitorID")
    public void sendPutRequestToEditFarmMonitorWithoutID() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Updated Farm Monitor Title");
        requestBody.put("description", "Updated description for farm monitor.");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .put(BASE_URL + "/") // No FarmMonitorID provided
                .then()
                .statusCode(404)
                .log().all(); // Log all details of the request and response
    }

    @Step("I send PUT request to edit farm monitor with valid authorization and data")
    public void sendPutRequestToEditFarmMonitorWithInvalidEndpoint() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "Updated Farm Monitor Title");
        requestBody.put("description", "Updated description for farm monitor.");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .put(setInvalidApiEndpoint())
                .then()
                .statusCode(404)
                .log().all(); // Log all details of the request and response
    }

    @Step("The system should confirm successful farm monitor edit")
    public void confirmSuccessfulFarmMonitorEdit() {
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Farm monitor updated!")));
    }
}
