package starter.stepdefinitions.dashboard;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.dashboard.CustomerDashboard;

public class CustomerDashboardSteps {
    private CustomerDashboard customerDashboard = new CustomerDashboard();

    @Given("I set API endpoint for retrieving customer dashboard")
    public void setApiEndpointForRetrievingAllArticles() {
        customerDashboard.setApiEndpoint();
    }

    @Given("I set invalid API endpoint for retrieving customer dashboard")
    public void setInvalidApiEndpointForRetrievingAllArticles() {
        customerDashboard.setInvalidApiEndpoint();
    }

    @When("I send a GET request to retrieve customer dashboard")
    public void sendGetRequestToRetrieveCustomerDashboard() {
        customerDashboard.sendGetRequestToRetrieveCustomerDashboard();
    }

    @When("I send a GET request to retrieve customer dashboard with invalid endpoint")
    public void sendGetRequestToRetrieveCustomerDashboardWithInvalidEndpoint() {
        customerDashboard.sendGetRequestToRetrieveCustomerDashboardWithInvalidEndpoint();
    }

    @When("I send a GET request to retrieve customer dashboard with invalid authorization token")
    public void sendGetRequestToRetrieveCustomerDashboardWithInvalidToken() {
        customerDashboard.sendGetRequestToRetrieveCustomerDashboardWithInvalidToken();
    }

    @Then("I receive valid customer dashboard list data")
    public void receiveValidCustomerDashboardListData() {
        customerDashboard.receiveValidCustomerDashboardListData();
    }


}
