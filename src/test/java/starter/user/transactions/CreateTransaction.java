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

public class CreateTransaction {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/transactions";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6IjZiYTZkZGM2LTBkMWUtNGU3Mi1iODQ1LThiNjgwY2I2MjI0ZCIsIkVtYWlsIjoiaXJ2YW4tc3VyeWFAYmx1ZWhhcnZlc3QuY29tIiwiRnVsbE5hbWUiOiJJcnZhbiBTdXJ5YSIsIlJvbGUiOiJjdXN0b21lciIsImV4cCI6NDM0NzE2NjI0Nn0.rLFp-oULwjXw70Sx4Uon3-EA3G6CU9_TKmhgxnGeOQY";

    @Step("I set transaction API endpoint for creating a transaction")
    public String setApiEndpoint() {
        return BASE_URL;
    }

    @Step("I send POST request to create a transaction with valid authorization and data")
    public void sendPostRequestToCreateTransactionWithValidData() {
        JSONObject requestBody = new JSONObject();

        JSONArray transactionDetails = new JSONArray();
        JSONObject product1 = new JSONObject();
        product1.put("product_id", "017ad4e5-37c5-4c99-b943-91d84766b3a9");
        product1.put("quantity", 2);
        transactionDetails.put(product1);

        JSONObject product2 = new JSONObject();
        product2.put("product_id", "e49ff677-fcfa-4e57-8a41-ecd49ba5cf87");
        product2.put("quantity", 1);
        transactionDetails.put(product2);

        requestBody.put("transaction_details", transactionDetails);
        requestBody.put("promo_id", "");

        JSONObject courier = new JSONObject();
        courier.put("destination_address_id", "158a1bfa-8d56-4af1-9d68-e8821f0bfe62");
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
                .statusCode(201)
                .log().all(); // Log all details of the request and response
    }

    @Step("I send POST request to create a transaction without providing required fields")
    public void sendPostRequestToCreateTransactionWithoutRequiredFields() {
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

    @Step("I send POST request to create a transaction with invalid data")
    public void sendPostRequestToCreateTransactionWithInvalidData() {
        JSONObject requestBody = new JSONObject();

        JSONArray transactionDetails = new JSONArray();
        JSONObject product1 = new JSONObject();
        product1.put("product_id", "f4c6b40c-c268-4486-86d3-ae3a43e271b0");
        product1.put("quantity", 2);
        transactionDetails.put(product1);

        JSONObject product2 = new JSONObject();
        product2.put("product_id", "e49ff677-fcfa-4e57-8a41-ecd49ba5cf87");
        product2.put("quantity", 1);
        transactionDetails.put(product2);

        requestBody.put("transaction_details", transactionDetails);
        requestBody.put("promo_id", "");

        JSONObject courier = new JSONObject();
        courier.put("destination_address_id", "987a1bfa-8d56-4af1-9d68-e8821f0bfe62");
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

    @Step("The system should confirm successful transaction creation")
    public void confirmSuccessfulTransactionCreation() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_TRANSACTIONS);
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("transaction created")));
        restAssuredThat(resp -> resp.body(matchesJsonSchema(schema)));
    }
}
