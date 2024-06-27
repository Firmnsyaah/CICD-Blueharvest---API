package starter.stepdefinitions.auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.auth.CreateAdminUser;

public class CreateAdminUserSteps {
    private CreateAdminUser adminUserCreation = new CreateAdminUser();

    @Given("I set API endpoint for creating admin user")
    public void iSetAPIEndpointForCreatingAdminUser() {
        adminUserCreation.setApiEndpoint();
    }

    @Given("I set an invalid API endpoint for creating admin user")
    public void setWrongApiEndpointForAdminUserCreation() {
        adminUserCreation.setWrongApiEndpointForAdminUserCreation();
    }

    @When("I send a POST request to create admin user with valid data")
    public void sendCreateAdminUserRequestWithValidData() {
        adminUserCreation.sendCreateAdminUserRequestWithValidData();
    }

    @When("I send a POST request to create admin user with duplicate email")
    public void sendCreateAdminUserRequestWithDuplicateEmail() {
        adminUserCreation.sendCreateAdminUserRequestWithDuplicateEmail();
    }

    @When("I send a POST request to create admin user with valid data on invalid endpoint")
    public void sendCreateAdminUserRequestWithValidDataOnInvalidEndpoint() {
        adminUserCreation.sendCreateAdminUserRequestWithValidDataOnInvalidEndpoint();
    }

    @Then("I receive valid admin creation data")
    public void receiveValidAdminCreationData() {
        adminUserCreation.receiveValidAdminCreationData();
    }

    @Then("I receive an error message about duplicate data")
    public void receiveErrorMessageAboutDuplicateData() {
        adminUserCreation.receiveErrorMessageDuplicateData();
    }

}
