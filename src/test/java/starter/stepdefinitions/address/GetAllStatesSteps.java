package starter.stepdefinitions.address;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.address.GetAllStates;

public class GetAllStatesSteps {

    private GetAllStates getAllStates = new GetAllStates();

    @Given("I want to retrieve all states")
    public void aUserWantsToRetrieveAllStates() {
        getAllStates.setApiEndpoint();
    }

    @Given("I want to retrieve all states with an invalid endpoint")
    public void aUserWantsToRetrieveAllStatesWithAnInvalidEndpoint() {
        getAllStates.setInvalidApiEndpoint();
    }

    @When("I sends a GET request to retrieve all states")
    public void theUserSendsAGetRequestToRetrieveAllStates() {
        getAllStates.sendGetRequestToRetrieveAllStates();
    }

    @When("I sends a GET request to retrieve all states with an invalid endpoint")
    public void theUserSendsAGetRequestToRetrieveAllStatesWithAnInvalidEndpoint() {
        getAllStates.sendGetRequestToRetrieveAllStatesWithInvalidEndpoint();
    }

    @When("I sends a GET request to retrieve all states without proper authorization")
    public void theUserSendsAGetRequestToRetrieveAllStatesWithoutProperAuthorization() {
        getAllStates.sendGetRequestToRetrieveAllStatesWithoutAuthorization();
    }


    @Then("the system should provide all state details")
    public void theSystemShouldProvideAllStateDetails() {
        getAllStates.receiveValidStateData();
    }
    @Then("I receive status code 405")
    public void receiveStatusCode405() {
        getAllStates.receiveStatusCode405(); }

}
