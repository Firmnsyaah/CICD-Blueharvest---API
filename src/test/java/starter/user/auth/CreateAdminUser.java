package starter.user.auth;

import com.github.javafaker.Faker;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateAdminUser {
    private static String correctUrl = "https://blueharvest.irvansn.com/v1/create/admin";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/create/admin/invalid";

    @Step("I set API endpoint for creating admin user")
    public String setApiEndpoint() {
        return correctUrl;
    }

    @Step("I set the wrong API endpoint for creating admin user")
    public String setWrongApiEndpointForAdminUserCreation() {
        return wrongUrl;
    }

    @Step("I send a POST request to create admin user with valid data")
    public void sendCreateAdminUserRequestWithValidData() {
        // Create Faker object
        Faker faker = new Faker();

        // Generate fake data
        String fullName = faker.name().fullName();
        String email = faker.internet().safeEmailAddress();
        String password = faker.internet().password();

        // Create request body with fake data
        JSONObject requestBody = new JSONObject();
        requestBody.put("full_name", fullName);
        requestBody.put("email", email);
        requestBody.put("password", password);

        // Send POST request with fake data
        SerenityRest.given()
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send a POST request to create admin user with duplicate email")
    public void sendCreateAdminUserRequestWithDuplicateEmail() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("full_name", "Irvan");
        requestBody.put("email", "irvan-surya-admin-2@blueharvest.com");
        requestBody.put("password", "123hore");

        SerenityRest.given()
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send a POST request to create admin user with valid data on invalid endpoint")
    public void sendCreateAdminUserRequestWithValidDataOnInvalidEndpoint() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("full_name", "John Doe");
        requestBody.put("email", "irvan-surya@blueharvest.com");
        requestBody.put("password", "123hore");

        SerenityRest.given()
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setWrongApiEndpointForAdminUserCreation());
    }

    @Step("I receive valid admin creation data")
    public void receiveValidAdminCreationData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_ADMIN_USER);

        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Berhasil membuat user Admin!")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.full_name", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.auth.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.auth.email", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.created_at", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.updated_at", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.deleted_at", equalTo(null)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }



    @Step("I receive an error message about duplicate data")
    public void receiveErrorMessageDuplicateData() {
        restAssuredThat(response -> response.body("status", equalTo(false)));
        restAssuredThat(response -> response.body("message", equalTo("duplicated data")));
    }
}
