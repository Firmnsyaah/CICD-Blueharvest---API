package starter.user.article;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetAllArticle {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/articles";
    private static final String BASE_INVALID_URL = "https://blueharvest.irvansn.com/v1/articles/invalid";
    private static final String UNAUTHORIZED_URL = "https://blueharvest.irvansn.com/v1/articles/unauthorized";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";


    @Step("I set API endpoint for retrieving all articles")
    public String setApiEndpoint() {
        return BASE_URL;
    }


    @Step("I set invalid API endpoint for retrieving all articles")
    public String setInvalidApiEndpoint() {
        return BASE_INVALID_URL;
    }
    @Step("I set invalid API endpoint for retrieving all articles")
    public String UNAUTHORIZED_URL() {
        return UNAUTHORIZED_URL;
    }

    @Step("I send a GET request to retrieve all articles")
    public void sendGetRequestToRetrieveAllArticles() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a GET request to retrieve all articles with invalid endpoint")
    public void sendGetRequestToRetrieveAllArticlesWithInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setInvalidApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a GET request to retrieve all articles with invalid authorization token")
    public void sendGetRequestToRetrieveAllArticlesWithInvalidToken() {
        SerenityRest.given()
                .get(UNAUTHORIZED_URL())
                .then()
                .log().all();
    }

    @Step("I receive valid farm creation data")
    public void receiveValidArticleListData() {
        Response response = SerenityRest.lastResponse();

        // Log the entire response for debugging
        response.prettyPrint();

        // Basic response validations
        restAssuredThat(resp -> resp.statusCode(200));
        restAssuredThat(resp -> resp.body("status", equalTo(true)));
        restAssuredThat(resp -> resp.body("message", equalTo("Success get all article data!")));

        // Validate the articles array and its items
        restAssuredThat(resp -> resp.body("data.articles", notNullValue()));
        restAssuredThat(resp -> resp.body("data.articles.size()", greaterThan(0)));
        restAssuredThat(resp -> resp.body("data.articles[0].id", notNullValue()));
        restAssuredThat(resp -> resp.body("data.articles[0].admin_id", notNullValue()));
        restAssuredThat(resp -> resp.body("data.articles[0].author", notNullValue()));
        restAssuredThat(resp -> resp.body("data.articles[0].title", notNullValue()));
        restAssuredThat(resp -> resp.body("data.articles[0].content", notNullValue()));
        restAssuredThat(resp -> resp.body("data.articles[0].picture", notNullValue()));
        restAssuredThat(resp -> resp.body("data.articles[0].created_at", notNullValue()));
        restAssuredThat(resp -> resp.body("data.articles[0].updated_at", notNullValue()));


        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_ARTICLE);
        restAssuredThat(resp -> resp.body(matchesJsonSchema(schema)));
    }

    @Step("I receive an error message about unauthorized access")
    public void receiveUnauthorizedAccessErrorMessage() {
        restAssuredThat(response -> response.statusCode(403));
        restAssuredThat(response -> response.body("error", equalTo("Unauthorized access")));
    }

    @Step("I receive an error message about invalid endpoint")
    public void receiveInvalidEndpointErrorMessage() {
        restAssuredThat(response -> response.statusCode(404));
        restAssuredThat(response -> response.body("error", equalTo("Invalid endpoint")));
    }
}
