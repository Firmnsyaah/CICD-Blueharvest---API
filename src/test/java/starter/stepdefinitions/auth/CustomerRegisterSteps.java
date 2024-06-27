package starter.stepdefinitions.auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.auth.CustomerRegister;

public class CustomerRegisterSteps {

    CustomerRegister register = new CustomerRegister();

    @Given("I set API endpoint for user registration")
    public void setApiEndpointForUserRegistration() {
        register.setApiEndpoint();
    }
    @Given("I set an invalid API endpoint for user registration")
    public void setWrongApiEndpointForUserRegistration() {
        register.setWrongApiEndpointForUserRegistration();
    }

    @When("I send a POST request to register a new user with valid data")
    public void sendPostRequestToRegisterNewUserWithValidData() {
        register.sendRegisterRequestWithValidData();
    }

    @When("I send a POST request to register a new user with Duplicate data")
    public void sendPostRequestToRegisterNewUserWithDuplicateData() {
        register.sendPostRequestToRegisterNewUserWithDuplicateData();
    }

    @When("I send a POST request to register a new user with invalid data")
    public void sendPostRequestToRegisterNewUserWithInalidData() {
        register.sendRegisterRequestWithInvalidData();
    }

    @Then("I receive status code 201")
    public void receiveStatusCodeRegister200() {register.receiveStatusCodeRegister201();
    }

    @Then("I receive valid registration data")
    public void receiveValidRegistrationData() {
        register.receiveValidRegistrationData();
    }

    @Then("I receive status code 400")
    public void receiveStatusCodeRegister400() {
        register.receiveStatusCodeRegister400(); }

    @Then("I receive status code 404")
    public void receiveStatusCodeRegister404() {
        register.receiveStatusCodeRegister404();
    }
    @Then("I receive an error message about product not found")
    public void receiveErrorMessageAboutNotFound() {
        register.receiveErrorMessageAboutNotFound();
    }
}
