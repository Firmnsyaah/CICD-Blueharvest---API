package starter.stepdefinitions.transactions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.transactions.CheckoutSummary;

public class CheckoutSummarySteps {

    CheckoutSummary checkoutSummary = new CheckoutSummary();

    @Given("I set checkout summary API endpoint")
    public void iSetCheckoutSummaryApiEndpoint() {
        checkoutSummary.setApiEndpoint();
    }

    @When("I send POST request to view checkout summary with valid authorization and data")
    public void iSendPostRequestToViewCheckoutSummaryWithValidAuthorizationAndData() {
        checkoutSummary.sendPostRequestToViewCheckoutSummaryWithValidData();
    }

    @When("I send POST request to view checkout summary without providing required fields")
    public void iSendPostRequestToViewCheckoutSummaryWithoutProvidingRequiredFields() {
        checkoutSummary.sendPostRequestToViewCheckoutSummaryWithoutRequiredFields();
    }

    @When("I send POST request to view checkout summary with invalid data")
    public void iSendPostRequestToViewCheckoutSummaryWithInvalidData() {
        checkoutSummary.sendPostRequestToViewCheckoutSummaryWithInvalidData();
    }

    @Then("The system should confirm successful checkout summary response")
    public void theSystemShouldConfirmSuccessfulCheckoutSummaryResponse() {
        checkoutSummary.confirmSuccessfulCheckoutSummaryResponse();
    }
}
