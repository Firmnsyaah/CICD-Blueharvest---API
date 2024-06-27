package starter.stepdefinitions.transactions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import starter.user.transactions.GetAllTransactions;

public class GetAllTransactionsSteps {

    GetAllTransactions getAllTransactions = new GetAllTransactions();

    @Given("I set API endpoint to get all transactions")
    public void iSetApiEndpointToGetAllTransactions() {
        getAllTransactions.setApiEndpoint();
    }

    @When("I send GET request to retrieve all transactions")
    public void iSendGetRequestToRetrieveAllTransactions() {
        getAllTransactions.getTransactionsWithValidAuthorization();
    }

    @When("I send a GET request to the transactions API endpoint with valid authorization and filter parameters")
    public void getTransactionsWithFilterParameters() {
        getAllTransactions.getTransactionsWithFilterParameters();
    }
    @When("I send a GET request to the transactions API endpoint with invalid filter parameters")
    public void getTransactionsWithInvalidFilterParameters() {
        getAllTransactions.getTransactionsWithInvalidFilterParameters();
    }

    @Then("The system should return all transactions")
    public void verifyListOfTransactions() {
        getAllTransactions.verifyListOfTransactions();
    }
}
