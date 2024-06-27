package starter.user.promo.admin;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateNewPromo {
    private static String correctUrl = "https://blueharvest.irvansn.com/v1/promos";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/promos/invalid";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";

    @Step("I set API endpoint for creating a new promo")
    public String setApiEndpoint() {
        return correctUrl;
    }

    @Step("I set an invalid API endpoint for creating a new promo")
    public String setInvalidApiEndpointForCreatePromo() {
        return wrongUrl;
    }

    @Step("I send a POST request promo with valid data")
    public void sendCreatePromoRequestWithValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "this test name");
        requestBody.put("code", "this test code");
        requestBody.put("status", "available");
        requestBody.put("amount", 35000);

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send a POST request promo with missing required fields")
    public void sendCreatePromoRequestWithMissingRequiredFields() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "");
        requestBody.put("code", "this test code");
        requestBody.put("status", "available");
        requestBody.put("amount", 35000);

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send a POST request promo with valid data to invalid endpoint")
    public void sendCreatePromoRequestToInvalidEndpoint() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "this test name");
        requestBody.put("code", "this test code");
        requestBody.put("status", "available");
        requestBody.put("amount", 35000);

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)

                .contentType("application/json")
                .body(requestBody.toString())
                .post(setInvalidApiEndpointForCreatePromo());
    }

    @Step("I receive valid promo creation data")
    public void receiveValidPromoCreationData() {
        restAssuredThat(response -> response.body("status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("message", equalTo("Promo created!")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.name", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.code", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.amount", Matchers.notNullValue()));

        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_PROMO);
        restAssuredThat(schemaValidator -> schemaValidator.body(matchesJsonSchema(schema)));
    }

    @Step("I receive status code 400 for unauthorized access")
    public void receiveStatusCode401ForUnauthorizedAccess() {
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I receive an error promo message about unauthorized access")
    public void receiveErrorPromoMessageUnauthorizedAccess() {
        restAssuredThat(response -> response.body("message", equalTo("input cannot be empty")));
    }

    @Step("I receive status code 404 for invalid endpoint")
    public void receiveStatusCode404ForInvalidEndpoint() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("I receive an error promo message about invalid endpoint")
    public void receiveErrorPromoMessageInvalidEndpoint() {
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
    }
}
