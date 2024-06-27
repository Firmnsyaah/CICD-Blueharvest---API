package starter.stepdefinitions.farmInvest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.farmInvest.GetAllFarmInvestUser;

public class GetAllFarmInvestUserSteps {

    private GetAllFarmInvestUser getAllFarmInvestUser = new GetAllFarmInvestUser();

    @Given("I set farm invest API endpoint for get all farm invests user")
    public void iSetFarmInvestApiEndpointForGetAllFarmInvestsUser() {
        getAllFarmInvestUser.setFarmInvestUserApiEndpoint();
    }

    @When("I send GET request to get all farm invests user")
    public void iSendGetRequestToGetAllFarmInvestsUser() {
        getAllFarmInvestUser.sendGetRequestToGetAllFarmInvestUser();
    }

    @Then("I receive a list of farm invests user")
    public void iReceiveListOfFarmInvestsUser() {
        getAllFarmInvestUser.receiveListOfFarmInvestUser();
    }

    @Given("I set invalid farm invest API endpoint")
    public void iSetInvalidFarmInvestApiEndpoint() {
        getAllFarmInvestUser.setInvalidFarmInvestUserApiEndpoint();
    }

    @Given("I send a GET request to retrieve all farm with invalid authorization token")
    public void sendGetRequestToGetAllFarmInvestUserAuth() {
        getAllFarmInvestUser.sendGetRequestToGetAllFarmInvestUserAuth();
    }
    @Given("I send a GET request to retrieve all farm with invalid endpoint")
    public void sendGetRequestToGetAllFarmInvestUserInvalid() {
        getAllFarmInvestUser.sendGetRequestToGetAllFarmInvestUserInvalid();
    }

}
