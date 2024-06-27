package starter.stepdefinitions.auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.auth.CustomerLogin;

public class CustomerLoginSteps {
    private CustomerLogin login = new CustomerLogin();

    @Given("I set API endpoint for customer login")
    public void iSetAPIEndpointForCustomerLogin() {
        login.setApiEndpoint();
    }

    @Given("I set an invalid API endpoint for customer login")
    public void iSetAnInvalidAPIEndpointForCustomerLogin() {
        login.setWrongApiEndpointForCustomerLogin();
    }

    @When("I send a POST request to login with valid data")
    public void iSendAPOSTRequestToLoginWithValidData() {
        login.sendLoginRequestWithValidData();
    }

    @When("I send a POST request to login with incorrect password")
    public void iSendAPOSTRequestToLoginWithInvalidPassword() {
        login.sendLoginRequestWithInvalidPassword();
    }

    @When("I send a POST request to login with invalid data")
    public void iSendAPOSTRequestToLoginWithInvalidData() {
        login.sendLoginRequestWithInvalidData();
    }

    @Then("I receive status code 200")
    public void iReceiveStatusCodeLogin200() {
        login.receiveStatusCodeLogin200();
    }

    @Then("I receive valid login data")
    public void iReceiveValidLoginData() {
        login.receiveValidLoginData();
    }

    @Then("I receive status code 401")
    public void iReceiveStatusCodeLogin401() {
        login.receiveStatusCodeLogin401();
    }

}
