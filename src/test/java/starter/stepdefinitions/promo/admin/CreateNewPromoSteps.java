package starter.stepdefinitions.promo.admin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.promo.admin.CreateNewPromo;

public class CreateNewPromoSteps {

    private CreateNewPromo createNewPromo = new CreateNewPromo();

    @Given("I set API endpoint for creating a new promo")
    public void iSetApiEndpointForCreatingANewPromo() {
        createNewPromo.setApiEndpoint();
    }

    @Given("I set an invalid API endpoint for creating a new promo")
    public void iSetAnInvalidApiEndpointForCreatingANewPromo() {
        createNewPromo.setInvalidApiEndpointForCreatePromo();
    }

    @When("I send a POST request promo with valid data")
    public void iSendAPostRequestPromoWithValidData() {
        createNewPromo.sendCreatePromoRequestWithValidData();
    }

    @When("I send a POST request promo with missing required fields")
    public void sendCreatePromoRequestWithMissingRequiredFields() {
        createNewPromo.sendCreatePromoRequestWithMissingRequiredFields();
    }

    @When("I send a POST request promo with valid data to invalid endpoint")
    public void iSendAPostRequestPromoWithValidDataToInvalidEndpoint() {
        createNewPromo.sendCreatePromoRequestToInvalidEndpoint();
    }

    @Then("I receive valid promo creation data")
    public void iReceiveValidPromoCreationData() {
        createNewPromo.receiveValidPromoCreationData();
    }

    @Then("I receive status code 401 for unauthorized access")
    public void iReceiveStatusCode401ForUnauthorizedAccess() {
        createNewPromo.receiveStatusCode401ForUnauthorizedAccess();
    }

    @Then("I receive an error promo message about unauthorized access")
    public void iReceiveAnErrorPromoMessageAboutUnauthorizedAccess() {
        createNewPromo.receiveErrorPromoMessageUnauthorizedAccess();
    }

    @Then("I receive status code 404 for invalid endpoint")
    public void iReceiveStatusCode404ForInvalidEndpoint() {
        createNewPromo.receiveStatusCode404ForInvalidEndpoint();
    }

    @Then("I receive an error promo message about invalid endpoint")
    public void iReceiveAnErrorPromoMessageAboutInvalidEndpoint() {
        createNewPromo.receiveErrorPromoMessageInvalidEndpoint();
    }
}
