package starter.user.transactions;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetAllTransactions {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/transactions";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";

    @Step("I have a valid API endpoint for transactions")
    public String setApiEndpoint() {
        return BASE_URL;
    }

    @Step("I have a invalid valid API endpoint for transactions")
    public String setInApiEndpoint() {
        return BASE_URL + "/invalid";
    }

    @Step("I send a GET request to the transactions API endpoint with valid authorization")
    public void getTransactionsWithValidAuthorization() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .get(setApiEndpoint())
                .then()
                .statusCode(200)
                .log().all(); // Log all details of the request and response
    }

    @Step("I send a GET request to the transactions API endpoint with valid authorization and filter parameters")
    public void getTransactionsWithFilterParameters() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .queryParam("status", "completed")
                .queryParam("date", "2024-06-23")
                .contentType(ContentType.JSON)
                .get(setApiEndpoint())
                .then()
                .statusCode(200)
                .log().all(); // Log all details of the request and response
    }

    @Step("I send a GET request to the transactions API endpoint with invalid filter parameters")
    public void getTransactionsWithInvalidFilterParameters() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setInApiEndpoint())
                .then()
                .statusCode(500)
                .log().all(); // Log all details of the request and response
    }

    @Step("The response should contain a list of transactions")
    public void verifyListOfTransactions() {
        restAssuredThat(response -> response.body("data", not(empty())));
    }

}
