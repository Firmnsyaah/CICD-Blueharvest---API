package starter.stepdefinitions.farmMonitor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.farmMonitor.UpdateFarmMonitorByFarmMonitorID;

public class UpdateFarmMonitorByFarmMonitorIDSteps {

    private UpdateFarmMonitorByFarmMonitorID updateFarmMonitorSteps = new UpdateFarmMonitorByFarmMonitorID();

    @Given("I set farm monitor API endpoint for editing farm monitor by FarmMonitorID")
    public void iSetFarmMonitorApiEndpointForEditingFarmMonitorByFarmMonitorID() {
        updateFarmMonitorSteps.setApiEndpoint();
    }

    @Given("I set an invalid farm monitor API endpoint for editing farm monitor by FarmMonitorID")
    public void iSetInvalidFarmMonitorApiEndpointForEditingFarmMonitorByFarmMonitorID() {
        updateFarmMonitorSteps.setInvalidApiEndpoint();
    }

    @When("I send PUT request to edit farm monitor by FarmMonitorID with valid authorization and data")
    public void iSendPutRequestToEditFarmMonitorByFarmMonitorIDWithValidAuthorizationAndData() {
        updateFarmMonitorSteps.sendPutRequestToEditFarmMonitorWithValidData();
    }

    @When("I send PUT request to edit farm monitor without providing FarmMonitorID")
    public void iSendPutRequestToEditFarmMonitorWithoutProvidingFarmMonitorID() {
        updateFarmMonitorSteps.sendPutRequestToEditFarmMonitorWithoutID();
    }

    @When("I send PUT request to edit farm monitor with valid authorization and data")
    public void iSendPutRequestToEditFarmMonitorWithValidAuthorizationAndData() {
        updateFarmMonitorSteps.sendPutRequestToEditFarmMonitorWithInvalidEndpoint();
    }

    @Then("The system should confirm successful farm monitor edit")
    public void theSystemShouldConfirmSuccessfulFarmMonitorEdit() {
        updateFarmMonitorSteps.confirmSuccessfulFarmMonitorEdit();
    }

}
