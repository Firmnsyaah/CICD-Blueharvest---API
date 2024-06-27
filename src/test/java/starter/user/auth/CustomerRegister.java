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
import static org.hamcrest.Matchers.notNullValue;

public class CustomerRegister {
    private static String correctUrl = "https://blueharvest.irvansn.com/v1/register/customer";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/register/customer/invalid";

    @Step("I set API endpoint for user registration")
    public String setApiEndpoint() {
        return correctUrl;
    }

    @Step("I set the wrong API endpoint for user registration")
    public String setWrongApiEndpointForUserRegistration() {
        return wrongUrl;
    }

    @Step("I send a POST request to register a new user with valid data")
    public void sendRegisterRequestWithValidData() {
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
    @Step("I send a POST request to register a new user with Duplicate data")
    public void sendPostRequestToRegisterNewUserWithDuplicateData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("full_name", "John Doe");
        requestBody.put("email", "irvan-suriaaa2@blueharvest.com");
        requestBody.put("password", "123hore");

        SerenityRest.given()
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }
    @Step("I send a POST request to register a new user with invalid data")
    public void sendRegisterRequestWithInvalidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("full_name", "John Doe");
        requestBody.put("email", "irvan-suriaaa2@blueharvest.com");
        requestBody.put("password", "123hore");

        SerenityRest.given()
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setWrongApiEndpointForUserRegistration());
    }

    @Step("I receive status code register 201")
    public void receiveStatusCodeRegister201() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I receive valid registration data")
    public void receiveValidRegistrationData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CUSTOMER_REGISTER);

        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", notNullValue()));
        restAssuredThat(response -> response.body("data.id", notNullValue()));
        restAssuredThat(response -> response.body("data.full_name", notNullValue()));
        restAssuredThat(response -> response.body("data.email", notNullValue()));
        restAssuredThat(response -> response.body("data.user_token", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

    @Step("I receive status code register 400")
    public void receiveStatusCodeRegister400() {
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I receive status code register 404")
    public void receiveStatusCodeRegister404() {
        restAssuredThat(response -> response.statusCode(404));
    }
    @Step("I receive an error message about product not found")
    public void receiveErrorMessageAboutNotFound() {
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
    }

}
