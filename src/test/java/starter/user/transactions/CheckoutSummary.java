package starter.user.transactions;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSummary {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/transactions/checkout/summaries";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6IjZiYTZkZGM2LTBkMWUtNGU3Mi1iODQ1LThiNjgwY2I2MjI0ZCIsIkVtYWlsIjoiaXJ2YW4tc3VyeWFAYmx1ZWhhcnZlc3QuY29tIiwiRnVsbE5hbWUiOiJJcnZhbiBTdXJ5YSIsIlJvbGUiOiJjdXN0b21lciIsImV4cCI6NDM0NzE2NjI0Nn0.rLFp-oULwjXw70Sx4Uon3-EA3G6CU9_TKmhgxnGeOQY";

    @Step("I set checkout summary API endpoint")
    public String setApiEndpoint() {
        return BASE_URL;
    }

    @Step("I send POST request to view checkout summary with valid authorization and data")
    public void sendPostRequestToViewCheckoutSummaryWithValidData() {
        JSONObject requestBody = new JSONObject();

        JSONArray transactionDetails = new JSONArray();
        JSONObject product1 = new JSONObject();
        product1.put("product_id", "f676debc-00b7-46bd-bfc6-5e61a75f82dc");
        product1.put("quantity", 2);
        transactionDetails.put(product1);

        JSONObject product2 = new JSONObject();
        product2.put("product_id", "c734cb07-6caa-488f-b242-1d106723df4d");
        product2.put("quantity", 1);
        transactionDetails.put(product2);

        requestBody.put("transaction_details", transactionDetails);
        requestBody.put("promo_id", "");

        JSONObject courier = new JSONObject();
        courier.put("destination_address_id", "40d97e13-4fc2-48b5-b755-16f6b10956a8");
        courier.put("name", "POS Indonesia (POS)");
        courier.put("type", "Pos Nextday");
        courier.put("fee", 32000);

        requestBody.put("courier", courier);

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post(setApiEndpoint())
                .then()
                .statusCode(200)
                .log().all(); // Log all details of the request and response
    }

    @Step("I send POST request to view checkout summary without providing required fields")
    public void sendPostRequestToViewCheckoutSummaryWithoutRequiredFields() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("transaction_details", new JSONArray()); // Missing required transaction details
        requestBody.put("promo_id", "");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post(setApiEndpoint())
                .then()
                .statusCode(400)
                .log().all(); // Log all details of the request and response
    }

    @Step("I send POST request to view checkout summary with invalid data")
    public void sendPostRequestToViewCheckoutSummaryWithInvalidData() {
        JSONObject requestBody = new JSONObject();

        JSONArray transactionDetails = new JSONArray();
        JSONObject product1 = new JSONObject();
        product1.put("product_id", "ca1c89bf-130b-4713-bcde-eef77507e20f");
        product1.put("quantity", 2);
        transactionDetails.put(product1);

        JSONObject product2 = new JSONObject();
        product2.put("product_id", "ce83b067-a64b-47ca-b454-9c0f970d0ea0");
        product2.put("quantity", 1);
        transactionDetails.put(product2);

        requestBody.put("transaction_details", transactionDetails);
        requestBody.put("promo_id", "3456b77b-90bf-4c2e-8cdb-afb03cce57fd");

        JSONObject courier = new JSONObject();
        courier.put("destination_address_id", "765a1bfa-8d56-4af1-9d68-e8821f0bfe62");
        courier.put("name", "POS Indonesia (POS)");
        courier.put("type", "Pos Nextday");
        courier.put("fee", 32000);

        requestBody.put("courier", courier);

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post(setApiEndpoint())
                .then()
                .statusCode(404)
                .log().all(); // Log all details of the request and response
    }

    @Step("The system should confirm successful checkout summary response")
    public void confirmSuccessfulCheckoutSummaryResponse() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CHECKOUT_SUMMARY);
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("get checkout summary successfully")));
        restAssuredThat(resp -> resp.body(matchesJsonSchema(schema)));
    }

    @Step("The system should return an unauthorized error message")
    public void confirmUnauthorizedErrorMessage() {
        restAssuredThat(response -> response.body("status", equalTo(false)));
        restAssuredThat(response -> response.body("message", equalTo("Unauthorized access")));
    }

    @Step("The system should return a forbidden error message")
    public void confirmForbiddenErrorMessage() {
        restAssuredThat(response -> response.body("status", equalTo(false)));
        restAssuredThat(response -> response.body("message", equalTo("Forbidden access")));
    }
}
