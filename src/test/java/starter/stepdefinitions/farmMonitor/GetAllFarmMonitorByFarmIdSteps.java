package starter.stepdefinitions.farmMonitor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.farmMonitor.GetAllFarmMonitorByFarmId;

public class GetAllFarmMonitorByFarmIdSteps {

    private GetAllFarmMonitorByFarmId getAllFarmMonitorsSteps = new GetAllFarmMonitorByFarmId();

    @Given("I set farm monitor API endpoint for get all monitors by FarmId")
    public void iSetFarmMonitorApiEndpointForGetAllMonitorsByFarmId() {
        getAllFarmMonitorsSteps.setFarmMonitorApiEndpointForFarmId();
    }

    @When("I send GET request to get all farm monitors by valid FarmId")
    public void iSendGETRequestToGetAllFarmMonitorsByFarmId() {
        getAllFarmMonitorsSteps.sendGetRequestToGetAllFarmMonitorsByFarmId();
    }


    @Then("I receive a list of farm monitors with the given FarmId")
    public void iReceiveListOfFarmMonitorsWithFarmId() {
        getAllFarmMonitorsSteps.receiveListOfFarmMonitorsWithFarmId();
    }

    @When("I send GET request to get all farm monitors by invalid FarmId")
    public void iSendGETRequestToGetAllFarmMonitorsByInvalidFarmId() {
        getAllFarmMonitorsSteps.sendGetRequestToGetAllFarmMonitorsByInvalidFarmId();
    }


    @When("I send GET request to get all farm monitors with missing FarmId")
    public void iSendGETRequestToGetAllFarmMonitorsWithMissingFarmId() {
        getAllFarmMonitorsSteps.sendGetRequestToGetAllFarmMonitorsWithMissingFarmId();
    }


}
