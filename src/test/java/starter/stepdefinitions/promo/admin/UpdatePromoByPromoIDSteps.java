package starter.stepdefinitions.promo.admin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.promo.admin.UpdatePromoByPromoID;

public class UpdatePromoByPromoIDSteps {

    private UpdatePromoByPromoID updatePromoByPromoID = new UpdatePromoByPromoID();

    @Given("I set API endpoint for editing a promo by PromoID")
    public void givenISetAPIEndpointForEditingPromoByPromoID() {
        updatePromoByPromoID.setApiEndpoint();
    }

    @Given("I set an invalid API endpoint for editing a promo by PromoID")
    public void givenISetInvalidAPIEndpointForEditingPromoByPromoID() {
        updatePromoByPromoID.setInvalidApiEndpoint();
    }

    @When("I send a PUT request to edit the promo with valid data")
    public void whenISendPUTRequestToEditPromoWithValidData() {
        updatePromoByPromoID.sendPutRequestWithValidData();
    }

    @When("I send a PUT request to edit the promo with missing promo id")
    public void whenISendPUTRequestToEditPromoWithMissingPromoID() {
        updatePromoByPromoID.sendPutRequestWithMissingPromoID();
    }

    @When("I send a PUT request to edit the promo with valid data but invalid PromoID")
    public void whenISendPUTRequestToEditPromoWithValidDataButInvalidPromoID() {
        updatePromoByPromoID.sendPutRequestWithInvalidPromoID();
    }

    @Then("the promo is successfully updated")
    public void thenThePromoIsSuccessfullyUpdated() {
        updatePromoByPromoID.receivePromoIsSuccessfullyUpdated();
    }

}
