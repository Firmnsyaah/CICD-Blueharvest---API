package starter.user.farmInvest;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CreateNewFarmInvest {
    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/farms";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";
    private static final String INVALID_TOKEN = "jdfhgGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Hoi";

    @Step("I set API endpoint for creating a new farm investment")
    public String setApiEndpoint() {
        return BASE_URL;
    }

    @Step("I send a POST request to create a new farm investment")
    public void sendCreateFarmInvestRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("farm_id", "fdd92bdd-f23b-491a-9b62-930ea2e23216");
        requestBody.put("investment_amount", "6500000");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send a POST request to create a new farm investment without required fields")
    public void sendCreateFarmInvestRequestWithoutRequiredFields() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send a POST request to create a new farm investment with invalid authorization token")
    public void sendCreateFarmInvestRequestWithInvalidToken() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("farm_id", "fdd92bdd-f23b-491a-9b62-930ea2e23216");
        requestBody.put("investment_amount", 6500000);

        SerenityRest.given()
                .header("Authorization", "Bearer " + INVALID_TOKEN)
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive valid farm investment creation data")
    public void iReceiveValidFarmInvestmentCreationData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_FARM_INVEST);
        SerenityRest.then().body("status", equalTo(true));
        SerenityRest.then().body("message", equalTo("Farm invest created!"));
        SerenityRest.then().body("data.id", notNullValue());
        restAssuredThat(resp -> resp.body(matchesJsonSchema(schema)));
    }

}
