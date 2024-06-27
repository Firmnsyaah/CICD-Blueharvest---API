package starter.user.customer;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllAdress {
    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/customers/addresses";
    private static final String BASE_INVALID_URL = "https://blueharvest.irvansn.com/v1/addresses/invalid";
    private static final String UNAUTHORIZED_URL = "https://blueharvest.irvansn.com/v1/customers/addresses";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6IjI4MDY3MTUwLTNjN2UtNDNiYi05YzQ5LWExNGM0OGU4NDFmOCIsIkVtYWlsIjoiaXJ2YW4tc3VyaWFhYTJAYmx1ZWhhcnZlc3QuY29tIiwiRnVsbE5hbWUiOiJKb2huIERvZSIsIlJvbGUiOiJjdXN0b21lciIsImV4cCI6NDM0NzA4MTE1NH0.uN_0PYvQCeI-dTRVCxZD5pF6KBAyCEzoVF1v84rOK3o";


    @Step("I set API endpoint for retrieving all address")
    public String setApiEndpoint() {
        return BASE_URL;
    }


    @Step("I set invalid API endpoint for retrieving all address")
    public String setInvalidApiEndpoint() {
        return BASE_INVALID_URL;
    }
    @Step("I set invalid API endpoint for retrieving all address")
    public String UNAUTHORIZED_URL() {
        return UNAUTHORIZED_URL;
    }

    @Step("I send a GET request to retrieve all address")
    public void sendGetRequestToRetrieveAllAddress() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a GET request to retrieve all address with invalid endpoint")
    public void sendGetRequestToRetrieveAllAddressWithInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setInvalidApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a GET request to retrieve all address with invalid authorization token")
    public void sendGetRequestToRetrieveAllAddressWithInvalidToken() {
        SerenityRest.given()
                .get(UNAUTHORIZED_URL())
                .then()
                .log().all();
    }

    @Step("I receive valid address list data")
    public void receiveValidAddressListData() {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("data", notNullValue()));
    }

}
