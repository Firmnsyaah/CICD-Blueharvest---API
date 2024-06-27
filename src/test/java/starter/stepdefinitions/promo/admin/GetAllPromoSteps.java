package starter.stepdefinitions.promo.admin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import starter.user.promo.admin.GetAllPromo;

public class GetAllPromoSteps {


    private GetAllPromo getAllPromos = new GetAllPromo();

    @Given("I set API endpoint for retrieving all promos")
    public void iSetApiEndpointForRetrievingAllPromos() {
        getAllPromos.setApiEndpoint();
    }

    @When("I send a GET request to retrieve all promos with valid data")
    public void iSendAGetRequestToRetrieveAllPromosWithValidData() {
        getAllPromos.sendGetRequestToRetrieveAllPromosWithValidData();
    }


    @Then("I receive a list of all promos")
    public void iReceiveAListOfAllPromos() {
        getAllPromos.receiveListOfAllPromos();
    }

    @Given("I set an invalid API endpoint for retrieving all promos")
    public void iSetAnInvalidApiEndpointForRetrievingAllPromos() {
        getAllPromos.setInvalidApiEndpoint();
    }

    @When("I send a GET request to the invalid endpoint")
    public void iSendAGetRequestToTheInvalidEndpoint() {
        getAllPromos.sendGetRequestToInvalidEndpoint();
    }


    @When("I send a GET request to retrieve all promos during a server error")
    public void iSendAGetRequestToRetrieveAllPromosDuringAServerError() {
        getAllPromos.sendGetRequestDuringServerError();
    }

    @Then("I receive status code 500")
    public void iReceiveStatusCode500() {
        getAllPromos.receiveStatusCode500();
    }

    @Then("I receive an error message about a server issue")
    public void iReceiveAnErrorMessageAboutAServerIssue() {
        getAllPromos.receiveErrorMessageServerIssue();
    }
}
