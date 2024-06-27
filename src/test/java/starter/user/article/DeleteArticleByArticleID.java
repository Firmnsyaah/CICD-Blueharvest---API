package starter.user.article;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteArticleByArticleID {
    private static String apiUrl = "https://blueharvest.irvansn.com/v1/articles/a06d6110-0149-4bf3-bd35-94b469394e68";
    private static String wrongUrl = "https://blueharvest.irvansn.com/v1/ebf588aa-6e35-472f-a982-ddcdb014fc1g";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";

    @Step("I set promo API endpoint for deleting article by PromoID")
    public String setApiEndpoint() {
        return apiUrl;
    }

    @Step("I set an invalid article API endpoint for deleting article by ArticleID")
    public String setWrongApiEndpoint() {
        return wrongUrl;
    }

    @Step("I send DELETE request to delete article by PromoID")
    public void sendDeleteArticleRequest() {

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .delete(setApiEndpoint());
    }

    @Step("I send DELETE request to delete article by invalid endpoint")
    public void sendDeleteArticleRequestWithInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .delete(setWrongApiEndpoint());
    }

    @Step("I send DELETE request to delete article without providing ArticleID")
    public void sendDeleteArticleRequestWithMissingArticleID() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .delete("https://blueharvest.irvansn.com/v1/promos/")
                .then()
                .statusCode(404);  // Ensure we expect a 404 status code for missing PromoID
    }

    @Step("I receive confirmation of successful promo deletion")
    public void receiveConfirmationOfSuccessfulArticleDeletion() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.DELETE_ARTICLE_BY_ARTICLEID);
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Success delete article data!")));
        restAssuredThat(schemaValidator -> schemaValidator.body(matchesJsonSchema(schema)));
    }
}
