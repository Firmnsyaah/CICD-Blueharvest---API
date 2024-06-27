package starter.user.auth;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class AdminLogin {
    private static String correctUrl = "https://blueharvest.irvansn.com/v1/login/admin";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/login/admin/invalid";

    @Step("I set API endpoint for admin login")
    public String setApiEndpoint() {
        return correctUrl;
    }

    @Step("I set the wrong API endpoint for admin login")
    public String setWrongApiEndpointForAdminLogin() {
        return wrongUrl;
    }

    @Step("I send a POST request to log in as admin with valid data")
    public void sendLoginRequestAdminWithValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "irvan-surya-admin-2@blueharvest.com");
        requestBody.put("password", "123hore");

        SerenityRest.given()
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send a POST request to log in as admin with invalid password")
    public void sendLoginRequestWithInvalidPassword() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "irvan-surya-admin-2@blueharvest.com");
        requestBody.put("password", "wrongpassword");

        SerenityRest.given()
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send a POST request to log in as admin with valid data on invalid endpoint")
    public void sendLoginRequestWithValidDataOnInvalidEndpoint() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "irvan-surya-admin-2@blueharvest.com");
        requestBody.put("password", "123hoe");

        SerenityRest.given()
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setWrongApiEndpointForAdminLogin());
    }

    @Step("I receive status code login 200")
    public void receiveStatusCodeLogin200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid login data")
    public void receiveValidLoginData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ADMIN_LOGIN);

        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Berhasil login!")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.full_name", equalTo("Irvan")));
        restAssuredThat(response -> response.body("data.email", equalTo("irvan-suryaa-admin-2@blueharvest.com")));
        restAssuredThat(response -> response.body("data.user_token", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

    @Step("I receive status code login 401")
    public void receiveStatusCodeLogin401() {
        restAssuredThat(response -> response.statusCode(401));
    }

    @Step("I receive an error message about invalid credentials")
    public void receiveErrorMessageInvalidCredentials() {
        restAssuredThat(response -> response.body("status", equalTo(false)));
        restAssuredThat(response -> response.body("message", equalTo("invalid email or password")));
    }

    @Step("I receive status code login 404")
    public void receiveStatusCodeLogin404() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("I receive an error message about the endpoint not being found")
    public void receiveErrorMessageInvalidEndpoint() {
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
    }
}
