package starter.user.farmInvest;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetFarmInvestByFarmInvestID {

    private static final String BASE_URL = "https://blueharvest.irvansn.com/v1/farminvests";
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6ImIwMWI0ZjkwLWEyNGYtNDc4YS1hYTQ1LTM4MTM1YWMyNDIwYiIsIkVtYWlsIjoiaXJ2YW4tc3VyeWEtYWRtaW4tMkBibHVlaGFydmVzdC5jb20iLCJGdWxsTmFtZSI6IklydmFuIiwiUm9sZSI6ImFkbWluIiwiZXhwIjo0MzQ3MDgwOTM2fQ.Msmd5l0mMjnXFk4B07Ue6KLqSHnmtp5429PlkW21Yao";


    @Step("I set farm invest API endpoint for get farm invest by FarmInvestID")
    public String setFarmInvestApiEndpointForFarmInvestID() {
        return BASE_URL + "/" + "aa7cfcd1-95d9-478b-aab8-3b63113f4c82";
    }

    @Step("I send GET request to get farm invest by valid FarmInvestID")
    public void sendGetRequestToGetFarmInvestByFarmInvestID() {
        SerenityRest.given()
                .header("Authorization", TOKEN)
                .get(setFarmInvestApiEndpointForFarmInvestID());
    }


    @Step("I receive farm invest details with the given FarmInvestID")
    public void receiveFarmInvestDetailsWithFarmInvestID() {
        restAssuredThat(response -> response.body("status", equalTo(true)));
        restAssuredThat(response -> response.body("message", equalTo("Success get farm invest data!")));

        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_FARM_INVEST_BY_ID);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send GET request to get farm invest by invalid FarmInvestID")
    public void sendGetRequestToGetFarmInvestByInvalidFarmInvestID() {
        SerenityRest.given()
                .header("Authorization", TOKEN)
                .get(BASE_URL + "/ac7cfcd1-95d9-345l-sdf8-3b63113f4c99");
    }

    @Step("I send GET request to get farm invest with missing FarmInvestID")
    public void sendGetRequestToGetFarmInvestWithMissingFarmInvestID() {
        SerenityRest.given()
                .header("Authorization", TOKEN)
                .get(BASE_URL + "/");
    }

    @Step("I receive status code 404")
    public void receiveStatusCode404() {
        SerenityRest.then().statusCode(404);
    }
}
