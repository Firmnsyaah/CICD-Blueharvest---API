package starter.stepdefinitions.promo.admin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.promo.admin.DeletePromoByPromoID;

public class DeletePromoByPromoIDSteps {

    private DeletePromoByPromoID deletePromoByPromoID = new DeletePromoByPromoID();

    @Given("I set promo API endpoint for deleting promo by PromoID")
    public void givenISetPromoAPIEndpointForDeletingPromoByPromoID() {
        deletePromoByPromoID.setApiEndpoint();
    }

    @Given("I set invalid promo API endpoint for deleting promo")
    public void givenISetAnInvalidPromoAPIEndpointForDeletingPromoByPromoID() {
        deletePromoByPromoID.setWrongApiEndpoint();
    }

    @When("I send DELETE request to delete promo by PromoID")
    public void whenISendDELETERequestToDeletePromoByPromoID() {
        deletePromoByPromoID.sendDeletePromoRequest();
    }

    @When("I send DELETE request to delete promo by invalid Endpoint")
    public void whenISendDELETERequestToDeletePromoByInvalidEndpoint() {
        deletePromoByPromoID.sendDeletePromoRequestWithInvalidEndpoint();
    }

    @When("I send DELETE request without providing PromoID")
    public void whenISendDELETERequestToDeletePromoWithoutProvidingPromoID() {
        deletePromoByPromoID.sendDeletePromoRequestWithMissingPromoID();
    }

    @Then("the system should confirm successful promo deletion")
    public void thenTheSystemShouldConfirmSuccessfulPromoDeletion() {
        deletePromoByPromoID.receiveConfirmationOfSuccessfulPromoDeletion();
    }
}
