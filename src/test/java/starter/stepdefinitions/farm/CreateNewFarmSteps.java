package starter.stepdefinitions.farm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.farm.CreateNewFarm;

public class CreateNewFarmSteps {

    private CreateNewFarm createNewFarm = new CreateNewFarm();

    @Given("I set API endpoint for creating a new farm")
    public void iSetApiEndpointForCreatingANewFarm() {
        createNewFarm.setApiEndpoint();
    }

    @Given("I set an invalid API endpoint for creating a new farm")
    public void iSetAnInvalidApiEndpointForCreatingANewFarm() {
        createNewFarm.setWrongApiEndpoint();
    }

    @When("I send a POST request with valid data")
    public void iSendAPostRequestWithValidData() {
        createNewFarm.sendCreateFarmRequestWithValidData();
    }

    @When("I send a POST request with missing required fields")
    public void iSendAPostRequestWithMissingRequiredFields() {
        createNewFarm.sendCreateFarmRequestWithMissingRequiredFields();
    }

    @When("I send a POST request with valid data to invalid endpoint")
    public void iSendAPostRequestWithValidDataToInvalidEndpoint() {
        createNewFarm.sendCreateFarmRequestWithValidDataOnInvalidEndpoint();
    }

    @Then("I receive valid farm creation data")
    public void iReceiveValidFarmCreationData() {
        createNewFarm.receiveValidFarmCreationData();
    }

    @Then("I receive an error message about missing fields")
    public void iReceiveErrorMessageAboutMissingFields() {
        createNewFarm.receiveErrorMessageAboutMissingFields();
    }

    @Then("I receive an error message about invalid endpoint")
    public void iReceiveErrorMessageAboutInvalidEndpoint() {
        createNewFarm.receiveErrorMessageAboutInvalidEndpoint();
    }
}
