package starter.user.chatBotAI;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class SendMessage {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/chat-bot/messages/send";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImFlM2JlMTY4LWU3Y2UtNDU2MC05YzhjLTNjYjBlMGJlMTI4NiIsIkVtYWlsIjoiYXpyaWVsZHdpbUBnbWFpbC5jb20iLCJGdWxsTmFtZSI6IkF6cmllbCBEd2kgTWFoZW5kcmEiLCJSb2xlIjoiY3VzdG9tZXIiLCJleHAiOjQzNDcxNzg3NTF9.WyJau5Y4QJEL0CrBoOZSdfw9rDUGKN0_OMu8hKNSa00";

    public void setApiEndpoint() {
        SerenityRest.given()
                .header("Authorization", TOKEN);
    }

    public void sendPostRequestToSendMessageWithValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("message", "fitur fitur apa saja yang menjadi unggulan di blueharvest?");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post(BASE_URL)
                .then()
                .statusCode(201)
                .log().all();
    }

    public void sendPostRequestToSendMessageWithoutRequiredFields() {
        JSONObject requestBody = new JSONObject();

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post(BASE_URL)
                .then()
                .statusCode(400)
                .log().all();
    }

    public void sendPostRequestToSendMessageWithInvalidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("message", 12345); // Invalid data, expecting string

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post(BASE_URL)
                .then()
                .statusCode(500)
                .log().all();
    }

    public void receiveSuccessfulMessageSentConfirmation() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SEND_MESSAGE);
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("send message successful")));
        restAssuredThat(schemaValidator -> schemaValidator.body(matchesJsonSchema(schema)));
    }
}
