package starter.stepdefinitions.farmInvest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import starter.user.farmInvest.CreateNewFarmInvest;

public class CreateNewFarmInvestSteps {

    private CreateNewFarmInvest createNewFarmInvest = new CreateNewFarmInvest();

    @Given("I set API endpoint for creating a new farm investment")
    public void iSetApiEndpointForCreatingNewFarmInvestment() {
        createNewFarmInvest.setApiEndpoint();
    }

    @When("I send a POST request to create a new farm investment")
    public void iSendPostRequestToCreateNewFarmInvestment() {
        createNewFarmInvest.sendCreateFarmInvestRequest();
    }

    @When("I send a POST request to create a new farm investment without required fields")
    public void iSendPostRequestToCreateNewFarmInvestmentWithoutRequiredFields() {
        createNewFarmInvest.sendCreateFarmInvestRequestWithoutRequiredFields();
    }

    @When("I send a POST request to create a new farm investment with invalid authorization token")
    public void iSendPostRequestToCreateNewFarmInvestmentWithInvalidAuthorizationToken() {
        createNewFarmInvest.sendCreateFarmInvestRequestWithInvalidToken();
    }
    @Then("I receive valid farm investment creation data")
    public void iReceiveValidFarmInvestmentCreationData() {
        createNewFarmInvest.iReceiveValidFarmInvestmentCreationData();
    }



}
