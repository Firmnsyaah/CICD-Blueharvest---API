package starter.stepdefinitions.customer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.customer.AddNewAddress;

public class AddNewAddressSteps {

    private AddNewAddress addNewAddress = new AddNewAddress();

    @Given("I want to add a new address")
    public void givenIWantToAddNewAddress() {
        addNewAddress.setApiEndpoint();
    }

    @Given("I want to add a new address with an invalid endpoint")
    public void givenIWantToAddNewAddressWithInvalidEndpoint() {
        addNewAddress.setInvalidApiEndpoint();
    }

    @When("I send a POST request to add the new address")
    public void whenISendPostRequestToAddNewAddress() {
        addNewAddress.sendPostRequestToAddNewAddress();
    }

    @When("I send a POST request to add the new address with an invalid endpoint")
    public void whenISendPostRequestToAddNewAddressWithInvalidEndpoint() {
        addNewAddress.sendPostRequestToAddNewAddressWithInvalidEndpoint();
    }

    @When("I send a POST request with missing required fields address")
    public void whenISendPostRequestWithMissingRequiredFields() {
        addNewAddress.sendPostRequestWithMissingRequiredFields();
    }

    @Then("I should receive valid address creation response")
    public void thenIShouldReceiveValidAddressCreationResponse() {
        addNewAddress.receiveValidAddressCreationResponse();
    }

    @Then("I should receive status code 404 for invalid endpoint")
    public void thenIShouldReceiveStatusCode404ForInvalidEndpoint() {
        addNewAddress.receiveStatusCode404ForInvalidEndpoint();
    }

    @Then("I should receive status code 400 for missing required fields")
    public void thenIShouldReceiveStatusCode400ForMissingRequiredFields() {
        addNewAddress.receiveStatusCode400ForMissingRequiredFields();
    }
}
