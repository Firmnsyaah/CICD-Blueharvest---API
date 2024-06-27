package starter.stepdefinitions.dashboard;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.dashboard.AdminDashboard;

public class AdminDashboardSteps {
    private AdminDashboard adminDashboard = new AdminDashboard();

    @Given("I set API endpoint for retrieving admin dashboard")
    public void setApiEndpointForRetrievingAllArticles() {
        adminDashboard.setApiEndpoint();
    }

    @Given("I set invalid API endpoint for retrieving admin dashboard")
    public void setInvalidApiEndpointForRetrievingAllArticles() {
        adminDashboard.setInvalidApiEndpoint();
    }

    @When("I send a GET request to retrieve admin dashboard")
    public void sendGetRequestToRetrieveAllArticles() {
        adminDashboard.sendGetRequestToRetrieveAdminDashboard();
    }

    @When("I send a GET request to retrieve admin dashboard with invalid endpoint")
    public void sendGetRequestToRetrieveAllArticlesWithInvalidEndpoint() {
        adminDashboard.sendGetRequestToRetrieveAdminDashboardWithInvalidEndpoint();
    }

    @When("I send a GET request to retrieve admin dashboard with invalid authorization token")
    public void sendGetRequestToRetrieveAllArticlesWithInvalidToken() {
        adminDashboard.sendGetRequestToRetrieveAdminDashboardWithInvalidToken();
    }

    @Then("I receive valid admin dashboard list data")
    public void receiveValidArticleListData() {
        adminDashboard.receiveValidAdminDashboardListData();
    }


}
