package starter.user.chatBotAI;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetAllMessage {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/chat-bot/messages";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImFlM2JlMTY4LWU3Y2UtNDU2MC05YzhjLTNjYjBlMGJlMTI4NiIsIkVtYWlsIjoiYXpyaWVsZHdpbUBnbWFpbC5jb20iLCJGdWxsTmFtZSI6IkF6cmllbCBEd2kgTWFoZW5kcmEiLCJSb2xlIjoiY3VzdG9tZXIiLCJleHAiOjQzNDcxNzg3NTF9.WyJau5Y4QJEL0CrBoOZSdfw9rDUGKN0_OMu8hKNSa00";

    @Step("I set API endpoint for retrieving all messages")
    public String setApiEndpoint() {
        return BASE_URL;
    }

    @Step("I send a GET request to retrieve all messages")
    public void sendGetRequestToRetrieveAllMessages() {
        SerenityRest.given()
                .header("Authorization", TOKEN)
                .get(setApiEndpoint());
    }

    @Step("I send a GET request to retrieve all messages with invalid endpoint")
    public void sendGetRequestToRetrieveAllMessagesWithInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", TOKEN)
                .get(BASE_URL + "/invalid");
    }

    @Step("I send a GET request to retrieve all messages without proper authorization")
    public void sendGetRequestWithoutAuthorization() {
        SerenityRest.given()
                .get(setApiEndpoint());
    }

    @Step("the user should receive valid message data")
    public void verifyValidMessageData() {
        restAssuredThat(response -> {
            response.statusCode(200);
            response.body("status", equalTo(true));
            response.body("message", equalTo("get all message successful"));
            response.body("data.messages", Matchers.notNullValue());
            JsonSchemaHelper helper = new JsonSchemaHelper();
            String schema = helper.getResponseSchema(JsonSchema.GET_ALL_MESSAGE);
            restAssuredThat(schemaValidator -> schemaValidator.body(matchesJsonSchema(schema)));
        });
    }

}
