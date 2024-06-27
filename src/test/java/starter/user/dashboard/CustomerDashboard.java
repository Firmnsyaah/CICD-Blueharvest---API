package starter.user.dashboard;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CustomerDashboard {
    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/dashboards/customer";
    private static final String BASE_INVALID_URL = "https://blueharvest.irvansn.com/v1/dashboards/customer/invalid";
    private static final String UNAUTHORIZED_URL = "https://blueharvest.irvansn.com/v1/dashboards/customer/unauthorized";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6IjI4MDY3MTUwLTNjN2UtNDNiYi05YzQ5LWExNGM0OGU4NDFmOCIsIkVtYWlsIjoiaXJ2YW4tc3VyaWFhYTJAYmx1ZWhhcnZlc3QuY29tIiwiRnVsbE5hbWUiOiJKb2huIERvZSIsIlJvbGUiOiJjdXN0b21lciIsImV4cCI6NDM0NzA4MTE1NH0.uN_0PYvQCeI-dTRVCxZD5pF6KBAyCEzoVF1v84rOK3o";


    @Step("I set API endpoint for retrieving customer dashboard")
    public String setApiEndpoint() {
        return BASE_URL;
    }


    @Step("I set invalid API endpoint for retrieving customer dashboard")
    public String setInvalidApiEndpoint() {
        return BASE_INVALID_URL;
    }
    @Step("I set invalid API endpoint for retrieving admin dashboard")
    public String UNAUTHORIZED_URL() {
        return UNAUTHORIZED_URL;
    }

    @Step("I send a GET request to retrieve customer dashboard")
    public void sendGetRequestToRetrieveCustomerDashboard() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a GET request to retrieve customer dashboard with invalid endpoint")
    public void sendGetRequestToRetrieveCustomerDashboardWithInvalidEndpoint() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .get(setInvalidApiEndpoint())
                .then()
                .log().all();
    }

    @Step("I send a GET request to retrieve customer dashboard with invalid authorization token")
    public void sendGetRequestToRetrieveCustomerDashboardWithInvalidToken() {
        SerenityRest.given()
                .get(UNAUTHORIZED_URL())
                .then()
                .log().all();
    }

    @Step("I receive valid customer dashboard list data")
    public void receiveValidCustomerDashboardListData() {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body("status", equalTo(true)));
    }
}
