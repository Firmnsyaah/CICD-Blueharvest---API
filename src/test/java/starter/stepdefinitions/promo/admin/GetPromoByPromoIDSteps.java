package starter.stepdefinitions.promo.admin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.promo.admin.GetPromoByPromoID;

public class GetPromoByPromoIDSteps {

    private GetPromoByPromoID getPromoByPromoID = new GetPromoByPromoID();

    @Given("I set API endpoint for retrieving a promo by PromoID")
    public void iSetApiEndpointForRetrievingAPromoByPromoID() {
        getPromoByPromoID.setApiEndpoint();
    }

    @Given("I set an invalid API endpoint for retrieving a promo by PromoID")
    public void iSetAnInvalidApiEndpointForRetrievingAPromoByPromoID() {
        getPromoByPromoID.setInvalidApiEndpoint();
    }

    @When("I send a GET request to retrieve the promo with a valid PromoID")
    public void iSendAGetRequestToRetrieveThePromoWithAValidPromoID() {
        getPromoByPromoID.sendGetRequestWithValidPromoID();
    }

    @When("I send a GET request to retrieve the promo with a wrong PromoID")
    public void iSendAGetRequestToRetrieveThePromoWithAWrongPromoID() {
        getPromoByPromoID.sendGetRequestWithWrongPromoID();
    }

    @When("I send a GET request to retrieve the promo with a valid PromoID to an invalid endpoint")
    public void iSendAGetRequestToRetrieveThePromoWithAValidPromoIDToAnInvalidEndpoint() {
        getPromoByPromoID.sendGetRequestToInvalidEndpoint();
    }

    @Then("I receive valid promo data")
    public void iReceiveValidPromoData() {
        getPromoByPromoID.receiveValidPromoData();
    }

    @Then("I receive an error message about promo not found")
    public void iReceiveAnErrorMessageAboutPromoNotFound() {
        getPromoByPromoID.receiveErrorMessagePromoNotFound();
    }

}
