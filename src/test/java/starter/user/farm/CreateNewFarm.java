package starter.user.farm;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateNewFarm {
    private static String correctUrl = "https://blueharvest.irvansn.com/v1/farms";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/invalid-farms";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";

    @Step("I set API endpoint for creating a new farm")
    public String setApiEndpoint() {
        return correctUrl;
    }

    @Step("I set an invalid API endpoint for creating a new farm")
    public String setWrongApiEndpoint() {
        return wrongUrl;
    }

    @Step("I send a POST request with valid data")
    public void sendCreateFarmRequestWithValidData() {
        File sampleFile = new File("src/test/java/starter/user/picture/Ikan.jpeg");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .multiPart("title", "this test title")
                .multiPart("description", "this test description")
                .multiPart("minimum_investment_amount", 5000000)
                .multiPart("picture_file", sampleFile)
                .post(setApiEndpoint());
    }

    @Step("I send a POST request with missing required fields")
    public void sendCreateFarmRequestWithMissingRequiredFields() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .multiPart("title", "")
                .multiPart("description", "")
                .post(setApiEndpoint())
                .then()
                .statusCode(400);  // Ensure we expect a 400 status code
    }

    @Step("I send a POST request with valid data to invalid endpoint")
    public void sendCreateFarmRequestWithValidDataOnInvalidEndpoint() {
        File sampleFile = new File("src/test/java/starter/user/picture/Ikan.jpeg");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .multiPart("title", "this test title")
                .multiPart("description", "this test description")
                .multiPart("picture_file", sampleFile)
                .post(setWrongApiEndpoint())
                .then()
                .statusCode(404);  // Ensure we expect a 404 status code for invalid endpoint
    }

    @Step("I receive valid farm creation data")
    public void receiveValidFarmCreationData() {
        restAssuredThat(response -> {
            response.body("status", equalTo(true));
            response.body("message", equalTo("Farm created!"));
            response.body("data.id", Matchers.notNullValue());

            JsonSchemaHelper helper = new JsonSchemaHelper();
            String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_FARM);

            restAssuredThat(schemaValidator -> schemaValidator.body(matchesJsonSchema(schema)));
        });
    }

    @Step("I receive an error message about missing fields")
    public void receiveErrorMessageAboutMissingFields() {
        restAssuredThat(response -> response.body("status", equalTo(false)));
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
    }

    @Step("I receive an error message about invalid endpoint")
    public void receiveErrorMessageAboutInvalidEndpoint() {
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
    }
}
