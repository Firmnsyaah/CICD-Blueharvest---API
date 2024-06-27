package starter.stepdefinitions.farm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.farm.GetFarmByFarmID;

public class GetFarmByFarmIDSteps {

    private GetFarmByFarmID getFarmByFarmIDSteps = new GetFarmByFarmID();

    @Given("I set farm API endpoint for get farm by FarmID")
    public void iSetFarmApiEndpointForGetFarmByFarmID() {
        getFarmByFarmIDSteps.setFarmApiEndpointForFarmByID();
    }

    @Given("I set invalid farm API endpoint for get farm by FarmID")
    public void iSetInvalidFarmApiEndpointForGetFarmByFarmID() {
        getFarmByFarmIDSteps.setInvalidFarmApiEndpointForFarmByID();
    }

    @When("I send GET request to get farm by FarmID")
    public void iSendGETRequestToGetFarmByFarmID() {
        getFarmByFarmIDSteps.sendGetRequestToGetFarmByID();
    }

    @When("I send GET request to get farm by missing FarmID")
    public void iSendGETRequestToGetFarmByMissingFarmID() {
        getFarmByFarmIDSteps.sendGetRequestToGetFarmByMissingID();
    }

    @When("I send GET request to get farm by invalid FarmID")
    public void iSendGETRequestToGetFarmByInvalidFarmID() {
        getFarmByFarmIDSteps.sendGetRequestToGetFarmByInvalidID();
    }



    @Then("I receive detail farm with FarmID")
    public void iReceiveDetailFarmWithFarmID() {
        getFarmByFarmIDSteps.receiveDetailFarmWithID();
    }
}
