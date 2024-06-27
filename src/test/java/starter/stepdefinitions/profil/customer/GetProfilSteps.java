package starter.stepdefinitions.profil.customer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.profil.customer.GetProfil;

public class GetProfilSteps {
    private GetProfil getProfil = new GetProfil();

    @Given("I set API endpoint for retrieving profil")
    public void setApiEndpointForRetrievingAllArticles() {
        getProfil.setApiEndpoint();
    }

    @Given("I set invalid API endpoint for retrieving profil")
    public void setInvalidApiEndpointForRetrievingAllArticles() {
        getProfil.setInvalidApiEndpoint();
    }

    @When("I send a GET request to retrieve profil")
    public void sendGetRequestToRetrieveProfile() {
        getProfil.sendGetRequestToRetrieveProfile();
    }

    @When("I send a GET request to retrieve profil with invalid endpoint")
    public void sendGetRequestToRetrieveProfileWithInvalidEndpoint() {
        getProfil.sendGetRequestToRetrieveProfileWithInvalidEndpoint();
    }

    @When("I send a GET request to retrieve profil with invalid authorization token")
    public void sendGetRequestToRetrieveProfileWithInvalidToken() {
        getProfil.sendGetRequestToRetrieveProfileWithInvalidToken();
    }

    @Then("I receive valid profil list data")
    public void receiveValidProfileListData() {
        getProfil.receiveValidProfileListData();
    }

}
