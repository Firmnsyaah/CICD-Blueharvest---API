package starter.stepdefinitions.farmInvest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.farmInvest.GetFarmInvestByFarmInvestID;

public class GetFarmInvestByFarmInvestIDSteps {

    private GetFarmInvestByFarmInvestID getFarmInvestByFarmInvestID = new GetFarmInvestByFarmInvestID();

    @Given("I set farm invest API endpoint for get farm invest by FarmInvestID")
    public void iSetFarmInvestApiEndpointForGetFarmInvestByFarmInvestID() {
        getFarmInvestByFarmInvestID.setFarmInvestApiEndpointForFarmInvestID();
    }

    @When("I send GET request to get farm invest by valid FarmInvestID")
    public void iSendGETRequestToGetFarmInvestByValidFarmInvestID() {
        getFarmInvestByFarmInvestID.sendGetRequestToGetFarmInvestByFarmInvestID();
    }

    @Then("I receive farm invest details with the given FarmInvestID")
    public void iReceiveFarmInvestDetailsWithFarmInvestID() {
        getFarmInvestByFarmInvestID.receiveFarmInvestDetailsWithFarmInvestID();
    }

    @When("I send GET request to get farm invest by invalid FarmInvestID")
    public void iSendGETRequestToGetFarmInvestByInvalidFarmInvestID() {
        getFarmInvestByFarmInvestID.sendGetRequestToGetFarmInvestByInvalidFarmInvestID();
    }

    @When("I send GET request to get farm invest with missing FarmInvestID")
    public void iSendGETRequestToGetFarmInvestWithMissingFarmInvestID() {
        getFarmInvestByFarmInvestID.sendGetRequestToGetFarmInvestWithMissingFarmInvestID();
    }

}
