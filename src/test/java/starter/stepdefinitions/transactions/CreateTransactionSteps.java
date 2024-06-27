package starter.stepdefinitions.transactions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.transactions.CreateTransaction;

public class CreateTransactionSteps {

    CreateTransaction createTransaction = new CreateTransaction();

    @Given("I set transaction API endpoint for creating a transaction")
    public void iSetTransactionApiEndpointForCreatingTransaction() {
        createTransaction.setApiEndpoint();
    }

    @When("I send POST request to create a transaction with valid authorization and data")
    public void iSendPostRequestToCreateTransactionWithValidAuthorizationAndData() {
        createTransaction.sendPostRequestToCreateTransactionWithValidData();
    }

    @When("I send POST request to create a transaction without providing required fields")
    public void iSendPostRequestToCreateTransactionWithoutProvidingRequiredFields() {
        createTransaction.sendPostRequestToCreateTransactionWithoutRequiredFields();
    }

    @When("I send POST request to create a transaction with invalid data")
    public void iSendPostRequestToCreateTransactionWithInvalidData() {
        createTransaction.sendPostRequestToCreateTransactionWithInvalidData();
    }


    @Then("The system should confirm successful transaction creation")
    public void theSystemShouldConfirmSuccessfulTransactionCreation() {
        createTransaction.confirmSuccessfulTransactionCreation();
    }

}
