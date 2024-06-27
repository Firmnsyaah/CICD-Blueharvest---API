package starter.stepdefinitions.farm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.farm.DeleteFarmByFarmID;

public class DeleteFarmByFarmIDSteps {

    private DeleteFarmByFarmID deleteFarmByFarmID = new DeleteFarmByFarmID();

    @Given("I set farm API endpoint for deleting farm by FarmID")
    public void givenISetFarmAPIEndpointForDeletingFarmByFarmID() {
        deleteFarmByFarmID.setApiEndpoint();
    }

    @Given("I set invalid farm API endpoint for deleting farm")
    public void setWrongApiEndpoint() {
        deleteFarmByFarmID.setWrongApiEndpoint();
    }

    @When("I send DELETE request to delete farm by FarmID")
    public void whenISendDELETERequestToDeleteFarmByFarmID() {
        deleteFarmByFarmID.sendDeleteFarmRequest();
    }

    @When("I send DELETE request without providing FarmID")
    public void whenISendDELETERequestToDeleteFarmWithoutProvidingFarmID() {
        deleteFarmByFarmID.sendDeleteFarmRequestWithMissingFarmID();
    }

    @When("I send DELETE request to delete farm by invalid Endpoint")
    public void sendDeleteFarmRequestWithInvalidEndpoint() {
        deleteFarmByFarmID.sendDeleteFarmRequestWithInvalidEndpoint();
    }

    @Then("the system should confirm successful farm deletion")
    public void thenIReceiveConfirmationOfSuccessfulFarmDeletion() {
        deleteFarmByFarmID.receiveConfirmationOfSuccessfulFarmDeletion();
    }
}
