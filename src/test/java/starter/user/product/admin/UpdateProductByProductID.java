package starter.user.product.admin;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateProductByProductID {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/products/";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";
    private static final String PRODUCT_ID = "aa8af147-40e9-4ed2-b92d-054180b77016";

    @Step("I set API endpoint for updating a product")
    public String setApiEndpoint() {
        return BASE_URL + PRODUCT_ID;
    }
    @Step("I set API endpoint for updating a product without ProductID")
    public String setApiEndpointWithoutProductID() {
        return BASE_URL ;
    }


    @Step("I send a PUT request to update the product")
    public void sendPutRequestToUpdateProduct() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .multiPart("name", "Udang Vaname Besar")
                .multiPart("description", "PREMIUM LOKAL PRODUCT Harap !!! OPEN 05:00 WIB S/D 15.00 WIB [SILAHKAN PILIH UKURAN IKAN SESUAI VARIANT, JIKA INGIN UKURAN TERTENTU SILAHKAN CHAT SELLER TERLEBIH DAHULU UNTUK KETERSEDIAANNYA ] *IKAN LANGSUNG DARI KOLAM")
                .multiPart("price", 13000)
                .multiPart("status", "available")
                .put(setApiEndpoint())
                .then()
                .statusCode(200)
                .log().all();
    }

    @Step("I send a PUT request to update the product without productID")
    public void sendPutRequestToUpdateProductWithoutRequiredFields() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .multiPart("name", "")
                .multiPart("description", "")
                .multiPart("price", "")
                .multiPart("status", "")
                .put(setApiEndpointWithoutProductID())
                .then()
                .statusCode(404)
                .log().all();
    }

    @Step("I send a PUT request to update the product with invalid authorization token")
    public void sendPutRequestToUpdateProductWithInvalidToken() {
        SerenityRest.given()
                .header("Authorization", "Bearer invalid_token_here")
                .multiPart("name", "Udang Vaname Besar")
                .multiPart("description", "PREMIUM LOKAL PRODUCT Harap !!! OPEN 05:00 WIB S/D 15.00 WIB [SILAHKAN PILIH UKURAN IKAN SESUAI VARIANT, JIKA INGIN UKURAN TERTENTU SILAHKAN CHAT SELLER TERLEBIH DAHULU UNTUK KETERSEDIAANNYA ] *IKAN LANGSUNG DARI KOLAM")
                .multiPart("price", 13000)
                .multiPart("status", "available")
                .put(setApiEndpoint())
                .then()
                .statusCode(403)
                .log().all();
    }

    @Step("I receive valid product update data")
    public void receiveValidProductUpdateData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_PRODUCT_BY_PRODUCTID);restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(schemaValidator -> schemaValidator.body(matchesJsonSchema(schema)));
    }


    @Step("I receive an error message about unauthorized access")
    public void receiveErrorMessageAboutUnauthorizedAccess() {
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
    }

    @Step("I receive an error message about missing fields")
    public void receiveErrorMessageAboutMissingFields() {
        restAssuredThat(response -> response.body("status", equalTo(false)));
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
    }
}
