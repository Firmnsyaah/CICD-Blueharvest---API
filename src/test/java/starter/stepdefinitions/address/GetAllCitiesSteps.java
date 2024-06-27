package starter.stepdefinitions.address;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.address.GetAllCities;

public class GetAllCitiesSteps {

    private GetAllCities getAllCities = new GetAllCities();

    @Given("I wants to retrieve all cities for a specific state")
    public void givenAUserWantsToRetrieveAllCitiesForSpecificState() {
        getAllCities.setApiEndpoint();
    }

    @Given("I wants to retrieve all cities for an invalid state ID")
    public void givenAUserWantsToRetrieveAllCitiesForInvalidStateID() {
        getAllCities.setInvalidApiEndpoint();
    }

    @When("I sends a GET request to retrieve all cities")
    public void whenTheUserSendsGETRequestToRetrieveAllCities() {
        getAllCities.sendGetRequestToRetrieveAllCities();
    }

    @When("I sends a GET request to retrieve all cities with an invalid state ID")
    public void whenTheUserSendsGETRequestToRetrieveAllCitiesWithInvalidStateID() {
        getAllCities.sendGetRequestToRetrieveAllCitiesWithInvalidStateID();
    }

    @When("I sends a GET request to retrieve all cities without proper authorization")
    public void whenTheUserSendsGETRequestToRetrieveAllCitiesWithoutProperAuthorization() {
        getAllCities.sendGetRequestToRetrieveAllCitiesWithoutAuthorization();
    }

    @Then("the user should receive valid city data for the specific state")
    public void thenTheUserShouldReceiveValidCityDataForSpecificState() {
        getAllCities.receiveValidCityData();
    }

    @Then("the user should receive status code for invalid state ID")
    public void thenTheUserShouldReceiveStatusCodeForInvalidStateID() {
        getAllCities.receiveStatusCode404ForInvalidStateID();
    }

    @Then("the user should receive status code for unauthorized access")
    public void thenTheUserShouldReceiveStatusCodeForUnauthorizedAccess() {
        getAllCities.receiveStatusCode401ForUnauthorizedAccess();
    }
}
