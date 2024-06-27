package starter.user.promo.admin;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetPromoByPromoID  {

    private static final String VALID_URL = "https://blueharvest.irvansn.com/v1/promos";
    private static final String INVALID_URL = "https://blueharvest.irvansn.com/v1/promos/invalid";
    private static final String VALID_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";

    @Step("I set API endpoint for retrieving a promo by PromoID")
    public String setApiEndpoint() {
        return VALID_URL;
    }

    @Step("I set an invalid API endpoint for retrieving a promo by PromoID")
    public String setInvalidApiEndpoint() {
        return INVALID_URL;
    }

    @Step("I send a GET request to retrieve the promo with a valid PromoID")
    public void sendGetRequestWithValidPromoID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .get(setApiEndpoint() + "/32af411f-e0b4-4270-8fe2-e9ac525fa879");
    }

    @Step("I send a GET request to retrieve the promo with a wrong PromoID")
    public void sendGetRequestWithWrongPromoID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .get(setApiEndpoint() + "/60dc3770-478c-4e49-aa5e-b9c0ff2c001f");
    }

    @Step("I send a GET request to retrieve the promo with a valid PromoID to an invalid endpoint")
    public void sendGetRequestToInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .get(setInvalidApiEndpoint());
    }


    @Step("I receive valid promo data")
    public void receiveValidPromoData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_PROMO_BY_PROMOID);restAssuredThat(response -> response.body("status", equalTo(true)));

        restAssuredThat(response -> response.body("status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("message", equalTo("Success get promo data!")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.name", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.code", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.amount", Matchers.notNullValue()));

         restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I receive an error message about promo not found")
    public void receiveErrorMessagePromoNotFound() {
        restAssuredThat(response -> response.body("message", equalTo("not found")));
    }

}
