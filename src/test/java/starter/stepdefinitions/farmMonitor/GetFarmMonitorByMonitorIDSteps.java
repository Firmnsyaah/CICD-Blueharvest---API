package starter.stepdefinitions.farmMonitor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.farmMonitor.GetFarmMonitorByMonitorID;
public class GetFarmMonitorByMonitorIDSteps {

    private GetFarmMonitorByMonitorID getAllFarmMonitorsSteps = new GetFarmMonitorByMonitorID();

    @Given("I set farm monitor API endpoint for get all monitors by MonitorId")
    public void iSetFarmMonitorApiEndpointForGetAllMonitorsByFarmId() {
        getAllFarmMonitorsSteps.setFarmMonitorApiEndpointForFarmId();
    }

    @When("I send GET request to get all monitor monitors by valid MonitorId")
    public void iSendGETRequestToGetAllFarmMonitorsByFarmId() {
        getAllFarmMonitorsSteps.sendGetRequestToGetAllFarmMonitorsByFarmId();
    }


    @Then("I receive a list of farm monitors with the given MonitorId")
    public void iReceiveListOfFarmMonitorsWithFarmId() {
        getAllFarmMonitorsSteps.receiveListOfFarmMonitorsWithFarmId();
    }

    @When("I send GET request to get all monitor monitors by invalid MonitorId")
    public void iSendGETRequestToGetAllFarmMonitorsByInvalidFarmId() {
        getAllFarmMonitorsSteps.sendGetRequestToGetAllFarmMonitorsByInvalidFarmId();
    }


    @When("I send GET request to get all monitor monitors with missing MonitorId")
    public void iSendGETRequestToGetAllFarmMonitorsWithMissingFarmId() {
        getAllFarmMonitorsSteps.sendGetRequestToGetAllFarmMonitorsWithMissingFarmId();
    }
}
