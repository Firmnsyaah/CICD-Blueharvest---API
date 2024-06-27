package starter.user.article;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UpdateArticleByID {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/articles/";
    private static final String INV_URL = "https://blueharvest.irvansn.com/v1/articles/";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";
    private static final String ARTICLE_ID = "e6ef8f55-8571-42bf-898a-ea2e8e5b0b1b";
    private static final String INVALID_ID = "00000c5c-860d-4542-8b10-d669beeb0000";

    @Step("I set API endpoint for updating an article by ID")
    public String setApiEndpoint() {
        return BASE_URL + ARTICLE_ID;
    }

    @Step("I set API endpoint for updating an article with invalid ID")
    public String setInvalidApiEndpoint() {
        return INV_URL + INVALID_ID;
    }


    @Step("I send a PUT request to update the article with ID")
    public void sendPutRequestToUpdateArticle() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.MULTIPART)
                .multiPart("title", "this is update test title")
                .multiPart("content", "this is update test description")
                .multiPart("picture_file", new File("src/test/java/starter/user/picture/Ikan.jpeg"))
                .when()
                .put(setApiEndpoint())
                .then()
                .statusCode(200)
                .log().all();
    }

    @Step("I send a PUT request to update the article with invalid endpoint")
    public void sendPutRequestToUpdateArticleWithoutRequiredFields() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.MULTIPART)
                .multiPart("title", "")
                .multiPart("content", "")
                .when()
                .put(setInvalidApiEndpoint())
                .then()
                .statusCode(400)
                .log().all();
    }

    @Step("I send a PUT request to update an article with invalid ID")
    public void sendPutRequestToUpdateArticleWithInvalidID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.MULTIPART)
                .multiPart("title", "this is update test title")
                .multiPart("content", "this is update test description")
                .multiPart("picture_file", new File("src/test/java/starter/user/picture/Ikan.jpeg"))
                .when()
                .put(setInvalidApiEndpoint())
                .then()
                .statusCode(404)
                .log().all();
    }

    @Step("The system should confirm the article update")
    public void systemShouldConfirmArticleUpdate() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_ARTICLE_BY_ARTICLEID);
        restAssuredThat(response -> response.body("message", Matchers.equalTo("article updated!")));
        restAssuredThat(schemaValidator -> schemaValidator.body(matchesJsonSchema(schema)));
    }

    @Step("I receive an error message about missing fields")
    public void receiveErrorMessageAboutMissingFields() {
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Missing required fields")));
    }

    @Step("I receive an error message about invalid endpoint")
    public void receiveErrorMessageAboutInvalidEndpoint() {
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Invalid endpoint")));
    }
}
