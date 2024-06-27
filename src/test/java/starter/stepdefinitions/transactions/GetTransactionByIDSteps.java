package starter.stepdefinitions.transactions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.transactions.GetTransactionByID;

public class GetTransactionByIDSteps {

    private GetTransactionByID getTransactionByID = new GetTransactionByID();

    @Given("I set transaction API endpoint for get transaction by TransactionID")
    public void iSetTransactionApiEndpointForGetTransactionByID() {
        getTransactionByID.setTransactionApiEndpointForTransactionByID();
    }

    @Given("I set invalid transaction API endpoint for get transaction by TransactionID")
    public void iSetInvalidTransactionApiEndpointForGetTransactionByID() {
        getTransactionByID.setInvalidTransactionApiEndpointForTransactionByID();
    }

    @When("I send GET request to get transaction by TransactionID")
    public void iSendGetRequestToGetTransactionByID() {
        getTransactionByID.sendGetRequestToGetTransactionByID();
    }

    @When("I send GET request to get transaction by missing TransactionID")
    public void iSendGetRequestToGetTransactionByMissingID() {
        getTransactionByID.sendGetRequestToGetTransactionByMissingID();
    }

    @When("I send GET request to get transaction by invalid TransactionID")
    public void iSendGetRequestToGetTransactionByInvalidID() {
        getTransactionByID.sendGetRequestToGetTransactionByInvalidID();
    }

    @Then("I receive detail transaction with TransactionID")
    public void iReceiveDetailTransactionWithTransactionID() {
        getTransactionByID.receiveDetailTransactionWithID();
    }
}
