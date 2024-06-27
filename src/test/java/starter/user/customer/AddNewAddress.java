package starter.user.customer;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class AddNewAddress {

    private static final String VALID_URL = "https://blueharvest.irvansn.com/v1/customers/addresses";
    private static final String INVALID_URL = "https://blueharvest.irvansn.com/v1/customers/addresses/invalid";

    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6IjI4MDY3MTUwLTNjN2UtNDNiYi05YzQ5LWExNGM0OGU4NDFmOCIsIkVtYWlsIjoiaXJ2YW4tc3VyaWFhYTJAYmx1ZWhhcnZlc3QuY29tIiwiRnVsbE5hbWUiOiJKb2huIERvZSIsIlJvbGUiOiJjdXN0b21lciIsImV4cCI6NDM0NzA4MTE1NH0.uN_0PYvQCeI-dTRVCxZD5pF6KBAyCEzoVF1v84rOK3o";


    @Step("I set API endpoint for adding a new address")
    public String setApiEndpoint() {
        return VALID_URL;
    }

    @Step("I set an invalid API endpoint for adding a new address")
    public String setInvalidApiEndpoint() {
        return INVALID_URL;
    }

    @Step("I send a POST request to add a new address")
    public void sendPostRequestToAddNewAddress() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("address", "Jl. Merdeka No.10, Kel. Menteng, Kec. Menteng");
        requestBody.put("city_id", "67");
        requestBody.put("city", "Jakarta Pusat");
        requestBody.put("state_id", "1");
        requestBody.put("state", "DKI Jakarta");
        requestBody.put("zip_code", "10310");
        requestBody.put("country", "Indonesia");
        requestBody.put("longitude", "106.8272");
        requestBody.put("latitude", "-6.1902");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I send a POST request to add a new address with an invalid endpoint")
    public void sendPostRequestToAddNewAddressWithInvalidEndpoint() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("address", "Jl. Merdeka No.10, Kel. Menteng, Kec. Menteng");
        requestBody.put("city_id", "67");
        requestBody.put("city", "Jakarta Pusat");
        requestBody.put("state_id", "1");
        requestBody.put("state", "DKI Jakarta");
        requestBody.put("zip_code", "10310");
        requestBody.put("country", "Indonesia");
        requestBody.put("longitude", "106.8272");
        requestBody.put("latitude", "-6.1902");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setInvalidApiEndpoint());
    }

    @Step("I send a POST request to add a new address with missing required fields")
    public void sendPostRequestWithMissingRequiredFields() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("address", "");
        requestBody.put("city_id", "");
        requestBody.put("city", "");
        requestBody.put("state_id", "");
        requestBody.put("state", "");
        requestBody.put("zip_code", "");
        requestBody.put("country", "");
        requestBody.put("longitude", "");
        requestBody.put("latitude", "");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive valid address creation response")
    public void receiveValidAddressCreationResponse() {
        restAssuredThat(response -> {
            response.statusCode(201);
            response.body("status", equalTo(true));
            response.body("message", equalTo("Berhasil menambahkan Alamat baru!"));
            response.body("data.id", Matchers.notNullValue());
        });
    }

    @Step("I receive status code 404 for invalid endpoint")
    public void receiveStatusCode404ForInvalidEndpoint() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("I receive status code 400 for missing required fields")
    public void receiveStatusCode400ForMissingRequiredFields() {
        restAssuredThat(response -> response.statusCode(400));
        restAssuredThat(response -> response.body("message", equalTo("input cannot be empty")));
    }
}
