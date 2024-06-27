package starter.user.profil.customer;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetProfil {
    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/customers/profile";
    private static final String BASE_INVALID_URL = "https://blueharvest.irvansn.com/v1/customers/profile/invalid";
    private static final String UNAUTHORIZED_URL = "https://blueharvest.irvansn.com/v1/customers/profile/unauthorized";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6IjI4MDY3MTUwLTNjN2UtNDNiYi05YzQ5LWExNGM0OGU4NDFmOCIsIkVtYWlsIjoiaXJ2YW4tc3VyaWFhYTJAYmx1ZWhhcnZlc3QuY29tIiwiRnVsbE5hbWUiOiJKb2huIERvZSIsIlJvbGUiOiJjdXN0b21lciIsImV4cCI6NDM0NzA4MTE1NH0.uN_0PYvQCeI-dTRVCxZD5pF6KBAyCEzoVF1v84rOK3o";


    @Step("I set API endpoint for retrieving profile")
    public String setApiEndpoint() {
        return BASE_URL;
    }


    @Step("I set invalid API endpoint for retrieving profile")
    public String setInvalidApiEndpoint() {
        return BASE_INVALID_URL;
    }
    @Step("I set invalid API endpoint for retrieving profile")
    public String UNAUTHORIZED_URL() {
        return UNAUTHORIZED_URL;
    }

    @Step("I send a GET request to retrieve profile")
    public void sendGetRequestToRetrieveProfile() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a GET request to retrieve profile with invalid endpoint")
    public void sendGetRequestToRetrieveProfileWithInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setInvalidApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a GET request to retrieve profile with invalid authorization token")
    public void sendGetRequestToRetrieveProfileWithInvalidToken() {
        SerenityRest.given()
                .get(UNAUTHORIZED_URL())
                .then()
                .log().all();
    }

    @Step("I receive valid profile list data")
    public void receiveValidProfileListData() {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body("status", equalTo(true)));
    }
}
