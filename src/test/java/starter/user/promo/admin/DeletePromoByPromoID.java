package starter.user.promo.admin;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class DeletePromoByPromoID {
    private static String apiUrl = "https://blueharvest.irvansn.com/v1/promos/ae09ca82-71c9-4076-8cde-a257f9dff7dc";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/ebf588aa-6e35-472f-a982-ddcdb014fc1g";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";

    @Step("I set promo API endpoint for deleting promo by PromoID")
    public String setApiEndpoint() {
        return apiUrl;
    }

    @Step("I set an invalid promo API endpoint for deleting promo by PromoID")
    public String setWrongApiEndpoint() {
        return wrongUrl;
    }

    @Step("I send DELETE request to delete promo by PromoID")
    public void sendDeletePromoRequest() {

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .delete(setApiEndpoint());
    }

    @Step("I send DELETE request to delete promo by invalid endpoint")
    public void sendDeletePromoRequestWithInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .delete(setWrongApiEndpoint());
    }

    @Step("I send DELETE request to delete promo without providing PromoID")
    public void sendDeletePromoRequestWithMissingPromoID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .delete("https://blueharvest.irvansn.com/v1/promos/")
                .then()
                .statusCode(404);  // Ensure we expect a 404 status code for missing PromoID
    }

    @Step("I receive confirmation of successful promo deletion")
    public void receiveConfirmationOfSuccessfulPromoDeletion() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.DELETE_PROMO_BY_PROMOID);
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Success delete promo data!")));

        restAssuredThat(schemaValidator -> schemaValidator.body(matchesJsonSchema(schema)));
    }
}
