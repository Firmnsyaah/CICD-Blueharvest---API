package starter.stepdefinitions.article;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.article.GetAllArticle;

public class GetAllArticleSteps {

    private GetAllArticle getAllArticles = new GetAllArticle();

    @Given("I set API endpoint for retrieving all articles")
    public void setApiEndpointForRetrievingAllArticles() {
        getAllArticles.setApiEndpoint();
    }

    @Given("I set invalid API endpoint for retrieving all articles")
    public void setInvalidApiEndpointForRetrievingAllArticles() {
        getAllArticles.setInvalidApiEndpoint();
    }

    @When("I send a GET request to retrieve all articles")
    public void sendGetRequestToRetrieveAllArticles() {
        getAllArticles.sendGetRequestToRetrieveAllArticles();
    }

    @When("I send a GET request to retrieve all articles with invalid endpoint")
    public void sendGetRequestToRetrieveAllArticlesWithInvalidEndpoint() {
        getAllArticles.sendGetRequestToRetrieveAllArticlesWithInvalidEndpoint();
    }

    @When("I send a GET request to retrieve all articles with invalid authorization token")
    public void sendGetRequestToRetrieveAllArticlesWithInvalidToken() {
        getAllArticles.sendGetRequestToRetrieveAllArticlesWithInvalidToken();
    }

    @Then("I receive valid article list data")
    public void receiveValidArticleListData() {
        getAllArticles.receiveValidArticleListData();
    }


}
