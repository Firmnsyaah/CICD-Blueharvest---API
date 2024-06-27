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

public class CustomerLogin {
    private static String correctUrl = "https://blueharvest.irvansn.com/v1/login/customer";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/login/customer/invalid";

    @Step("I set API endpoint for customer login")
    public String setApiEndpoint() {
        return correctUrl;
    }

    @Step("I set an invalid API endpoint for customer login")
    public String setWrongApiEndpointForCustomerLogin() {
        return wrongUrl;
    }

    @Step("I send a POST request to login with valid data")
    public void sendLoginRequestWithValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "irvan-suriaaa2@blueharvest.com");
        requestBody.put("password", "123hore");

        SerenityRest.given()
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send a POST request to login with invalid password")
    public void sendLoginRequestWithInvalidPassword() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "irvan-surya@blueharvest.com");
        requestBody.put("password", "wrong-password");

        SerenityRest.given()
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send a POST request to login with invalid data")
    public void sendLoginRequestWithInvalidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "irvan-surya@blueharvest.com");
        requestBody.put("password", "123hore");

        SerenityRest.given()
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setWrongApiEndpointForCustomerLogin());
    }

    @Step("I receive status code login 200")
    public void receiveStatusCodeLogin200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid login data")
    public void receiveValidLoginData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CUSTOMER_LOGIN);

        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Berhasil login!")));
        restAssuredThat(response -> response.body("data.user_token", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

    @Step("I receive status code login 401")
    public void receiveStatusCodeLogin401() {
        restAssuredThat(response -> response.statusCode(401));
    }
}
