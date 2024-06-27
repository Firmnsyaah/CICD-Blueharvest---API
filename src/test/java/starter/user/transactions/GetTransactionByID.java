package starter.user.transactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetTransactionByID {

    private static final String VALID_URL = "https://blueharvest.irvansn.com/v1/transactions";
    private static final String INVALID_URL = "https://blueharvest.irvansn.com/v1/transactions/invalid";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";

    @Step("I set transaction API endpoint for get transaction by TransactionID")
    public String setTransactionApiEndpointForTransactionByID() {
        return VALID_URL;
    }

    @Step("I set invalid transaction API endpoint for get transaction by TransactionID")
    public String setInvalidTransactionApiEndpointForTransactionByID() {
        return INVALID_URL;
    }

    @Step("I send GET request to get transaction by TransactionID")
    public void sendGetRequestToGetTransactionByID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setTransactionApiEndpointForTransactionByID() + "/b7e754fc-9b5c-4bed-9364-fd3ae4af0e25");
    }

    @Step("I send GET request to get transaction by missing TransactionID")
    public void sendGetRequestToGetTransactionByMissingID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setTransactionApiEndpointForTransactionByID() + "/");
    }

    @Step("I send GET request to get transaction by invalid TransactionID")
    public void sendGetRequestToGetTransactionByInvalidID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setTransactionApiEndpointForTransactionByID() + "/00000000-ffe7-0000-9d0f-42b422f00000");
    }

    @Step("I receive detail transaction with TransactionID")
    public void receiveDetailTransactionWithID() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_TRANSACTION_BY_ID);

        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("get transaction succesful")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.transaction_details", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.courier", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
