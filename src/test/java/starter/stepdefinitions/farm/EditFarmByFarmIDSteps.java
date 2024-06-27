package starter.stepdefinitions.farm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.farm.EditFarmByFarmID;

public class EditFarmByFarmIDSteps {

    private EditFarmByFarmID editFarmByFarmID = new EditFarmByFarmID();

    @Given("I set farm API endpoint for editing farm by FarmID")
    public void givenISetFarmAPIEndpointForEditingFarmByFarmID() {
        editFarmByFarmID.setApiEndpoint();
    }

    @Given("I set an invalid farm API endpoint for editing farm by FarmID")
    public void givenISetAnInvalidFarmAPIEndpointForEditingFarmByFarmID() {
        editFarmByFarmID.setWrongApiEndpoint();
    }

    @When("I send PUT request to edit farm by FarmID with valid authorization and data")
    public void whenISendPUTRequestToEditFarmByFarmIDWithValidAuthorizationAndData() {
        editFarmByFarmID.sendEditFarmRequestWithValidData();
    }

    @When("I send PUT request to edit farm without providing FarmID")
    public void whenISendPUTRequestToEditFarmWithoutProvidingFarmID() {
        editFarmByFarmID.sendEditFarmRequestWithMissingFarmID();
    }

    @When("I send PUT request to edit farm with valid authorization and data")
    public void whenISendPUTRequestToEditFarmWithValidAuthorizationAndDataToInvalidEndpoint() {
        editFarmByFarmID.sendEditFarmRequestWithValidDataOnInvalidEndpoint();
    }

    @Then("the system should confirm successful farm edit")
    public void thenTheSystemShouldConfirmSuccessfulFarmEdit() {
        editFarmByFarmID.confirmSuccessfulFarmEdit();
    }
}
