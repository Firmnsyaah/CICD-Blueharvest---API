package starter.stepdefinitions.article;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.article.GetArticleByArticleID;

public class GetArticleByArticleIDSteps {
    private GetArticleByArticleID getArticle = new GetArticleByArticleID();
    private String validProductId = "503c5bdd-2ee6-4749-ab83-47ab27b745fc";
    private String invalidProductId = "10fdc0a4-10be-4907-b376-9b826703ae49";

    @Given("I set API endpoint for retrieving a valid article")
    public void setApiEndpointForRetrievingValidArticle() {
        getArticle.setApiEndpoint(validProductId);
    }

    @Given("I set API endpoint for retrieving an invalid article")
    public void setApiEndpointForRetrievingInvalidArticle() {
        getArticle.setApiEndpoint(invalidProductId);
    }

    @When("I send a GET request to retrieve the valid article")
    public void sendGetRequestToRetrieveArticle() {
        getArticle.sendGetRequestToRetrieveArticle();
    }

    @When("I send a GET request to retrieve the invalid article")
    public void sendGetRequestToRetrieveArticleWithInvalidID() {
        getArticle.sendGetRequestToRetrieveArticleWithInvalidID();
    }

    @When("I send a GET request to retrieve the article with an invalid authorization token")
    public void sendGetRequestToRetrieveArticleWithInvalidToken() {
        getArticle.sendGetRequestToRetrieveArticleWithInvalidToken();
    }

    @Then("I receive valid article retrieval data")
    public void receiveValidArticleRetrievalData() {
        getArticle.receiveValidArticleRetrievalData();
    }
}
