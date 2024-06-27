package starter.user.article;

import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetArticleByArticleID {
    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/articles/";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";
    private static final String VALID_PRODUCT_ID = "e6ef8f55-8571-42bf-898a-ea2e8e5b0b1b";
    private static final String INVALID_PRODUCT_ID = "000c0bdd-2ee6-0000-ab83-00ab00b745fc";

    @Step("I set API endpoint for retrieving an article by ID")
    public String setApiEndpoint(String productId) {
        return BASE_URL + productId;
    }

    @Step("I send a GET request to retrieve the article with valid article ID")
    public void sendGetRequestToRetrieveArticle() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setApiEndpoint(VALID_PRODUCT_ID))
                .then()
                .statusCode(200)
                .log().all();
    }

    @Step("I send a GET request to retrieve the article with invalid article ID")
    public void sendGetRequestToRetrieveArticleWithInvalidID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setApiEndpoint(INVALID_PRODUCT_ID))
                .then()
                .statusCode(404)
                .log().all();
    }

    @Step("I send a GET request to retrieve the article with invalid authorization token")
    public void sendGetRequestToRetrieveArticleWithInvalidToken() {
        SerenityRest.given()
                .header("Authorization", "Bearer invalid_token_here")
                .get(setApiEndpoint(VALID_PRODUCT_ID))
                .then()
                .statusCode(403)
                .log().all();
    }

    @Step("I receive valid article retrieval data")
    public void receiveValidArticleRetrievalData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ARTICLE_BY_ARTICLEID);
        Response response = SerenityRest.lastResponse();

        // Log the entire response for debugging
        response.prettyPrint();

        restAssuredThat(resp -> resp.statusCode(200));
        restAssuredThat(resp -> resp.body("status", equalTo(true)));
        restAssuredThat(resp -> resp.body("message", equalTo("Success get article data!")));
        restAssuredThat(resp -> resp.body("data.id", notNullValue()));
        restAssuredThat(resp -> resp.body("data.admin_id", notNullValue()));
        restAssuredThat(resp -> resp.body("data.author", notNullValue()));
        restAssuredThat(resp -> resp.body("data.title", notNullValue()));
        restAssuredThat(resp -> resp.body("data.content", notNullValue()));
        restAssuredThat(resp -> resp.body("data.picture", notNullValue()));
        restAssuredThat(resp -> resp.body("data.created_at", notNullValue()));
        restAssuredThat(resp -> resp.body("data.updated_at", notNullValue()));

        restAssuredThat(schemaValidator -> schemaValidator.body(matchesJsonSchema(schema)));
    }
}
