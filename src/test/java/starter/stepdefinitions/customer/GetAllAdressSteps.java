package starter.stepdefinitions.customer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.customer.GetAllAdress;

public class GetAllAdressSteps {
    private GetAllAdress getAllAdress = new GetAllAdress();

    @Given("I set API endpoint for retrieving all address")
    public void setApiEndpointForRetrievingAllArticles() {
        getAllAdress.setApiEndpoint();
    }

    @Given("I set invalid API endpoint for retrieving all address")
    public void setInvalidApiEndpointForRetrievingAllArticles() {
        getAllAdress.setInvalidApiEndpoint();
    }

    @When("I send a GET request to retrieve all address")
    public void sendGetRequestToRetrieveAllArticles() {
        getAllAdress.sendGetRequestToRetrieveAllAddress();
    }

    @When("I send a GET request to retrieve all address with invalid endpoint")
    public void sendGetRequestToRetrieveAllArticlesWithInvalidEndpoint() {
        getAllAdress.sendGetRequestToRetrieveAllAddressWithInvalidEndpoint();
    }

    @When("I send a GET request to retrieve all address with invalid authorization token")
    public void sendGetRequestToRetrieveAllArticlesWithInvalidToken() {
        getAllAdress.sendGetRequestToRetrieveAllAddressWithInvalidToken();
    }

    @Then("I receive valid address list data")
    public void receiveValidArticleListData() {
        getAllAdress.receiveValidAddressListData();
    }


}
