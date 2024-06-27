package starter.user.article;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class CreateNewArticle {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/articles";
    private static final String BASE_InvalidURL = "https://blueharvest.irvansn.com/v1/articles/invalid";
    private static final String VALID_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";

    @Step("I set API endpoint for creating a new article")
    public String setApiEndpoint() {
        return BASE_URL;
    }

    @Step("I send a POST request to create a new article")
    public void sendPostRequestToCreateNewArticle() {
        File sampleFile = new File("src/test/java/starter/user/picture/Ikan.jpeg");

        SerenityRest.given()
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .multiPart("title", "this test title")
                .multiPart("content", "this test content")
                .multiPart("picture_file", sampleFile)
                .post(setApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a POST request to create a new article without required fields")
    public void sendPostRequestToCreateNewArticleWithoutRequiredFields() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .multiPart("title", "this test title")
                .multiPart("content", "this test content")
                .post(setApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a POST request to create a new article with invalid authorization token")
    public void sendPostRequestToCreateNewArticleWithInvalidToken() {
        // Load sample file (adjust path as needed)
       new File("src/test/java/starter/user/picture/Ikan.jpeg");

        SerenityRest.given()
                .header("Authorization", "Bearer " + "invalid_token_here")
                .multiPart("title", "this test title")
                .multiPart("content", "this test content")
                .multiPart("picture_file", new File("src/test/java/starter/user/picture/Ikan.jpeg"))
                .post(BASE_InvalidURL)
                .then()
                .statusCode(403);
    }

    @Step("the system should confirm the article creation")
    public void receiveValidArticleCreationData() {
        restAssuredThat(response -> {
            response.body("status", equalTo(true));
            response.body("message", Matchers.notNullValue());
            response.body("data.id", Matchers.notNullValue());
            response.body("data.title", Matchers.notNullValue());

            JsonSchemaHelper helper = new JsonSchemaHelper();
            String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_ARTICLE);
            restAssuredThat(schemaValidator -> schemaValidator.body(matchesJsonSchema(schema)));
        });
    }

}
