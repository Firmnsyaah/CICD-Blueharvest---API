package starter.stepdefinitions.auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.auth.AdminLogin;

public class AdminLoginSteps {
    private AdminLogin login = new AdminLogin();

    @Given("I set API endpoint for admin login")
    public void iSetAPIEndpointForAdminLogin() {
        login.setApiEndpoint();
    }

    @Given("I set an invalid API endpoint for admin login")
    public void iSetAnInvalidAPIEndpointForAdminLogin() {
        login.setWrongApiEndpointForAdminLogin();
    }

    @When("I send a POST request to log in as admin with valid data")
    public void iSendAPOSTRequestToLogInAsAdminWithValidData() {
        login.sendLoginRequestAdminWithValidData();
    }

    @When("I send a POST request to log in as admin with invalid password")
    public void iSendAPOSTRequestToLogInAsAdminWithInvalidPassword() {
        login.sendLoginRequestWithInvalidPassword();
    }

    @When("I send a POST request to log in as admin with invalid endpoint")
    public void iSendAPOSTRequestToLogInAsAdminWithValidDataOnInvalidEndpoint() {
        login.sendLoginRequestWithValidDataOnInvalidEndpoint();
    }


    @Then("I receive an error message about invalid credentials")
    public void iReceiveAnErrorMessageAboutInvalidCredentials() {
        login.receiveErrorMessageInvalidCredentials();
    }

    @Then("I receive an error message about the endpoint not being found")
    public void iReceiveAnErrorMessageAboutTheEndpointNotBeingFound() {
        login.receiveErrorMessageInvalidEndpoint();
    }
}
