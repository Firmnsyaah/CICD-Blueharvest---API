package starter.stepdefinitions.farm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.farm.GetAllFarm;

public class GetAllFarmSteps {

    private GetAllFarm getAllFarmDetails = new GetAllFarm();

    @Given("a user wants to retrieve all farm details")
    public void givenAUserWantsToRetrieveAllFarmDetails() {
    }

    @When("the user sends a GET request to retrieve all farm details")
    public void whenTheUserSendsAGetRequestToRetrieveAllFarmDetails() {
        getAllFarmDetails.sendGetRequestToRetrieveAllFarmDetails();
    }


    @Then("the system should provide all farm details")
    public void thenTheSystemShouldProvideAllFarmDetails() {
        getAllFarmDetails.verifyAllFarmDetails();
    }

    @When("the user sends a GET request to an invalid endpoint")
    public void whenTheUserSendsAGetRequestToAnInvalidEndpoint() {
        getAllFarmDetails.sendGetRequestToInvalidEndpoint();
    }


    @When("the user sends a GET request without proper authorization")
    public void whenTheUserSendsAGetRequestWithoutProperAuthorization() {
        getAllFarmDetails.sendGetRequestWithoutAuthorization();
    }


}
