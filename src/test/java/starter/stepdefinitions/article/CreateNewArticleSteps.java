package starter.stepdefinitions.article;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.article.CreateNewArticle;

public class CreateNewArticleSteps {

    private CreateNewArticle createNewArticle = new CreateNewArticle();

    @Given("I set API endpoint for creating a new article")
    public void setApiEndpointForCreatingNewArticle() {
        createNewArticle.setApiEndpoint();
    }

    @When("I send a POST request to create a new article")
    public void sendPostRequestToCreateNewArticle() {
        createNewArticle.sendPostRequestToCreateNewArticle();
    }

    @When("I send a POST request to create a new article without required fields")
    public void sendPostRequestToCreateNewArticleWithoutRequiredFields() {
        createNewArticle.sendPostRequestToCreateNewArticleWithoutRequiredFields();
    }

    @When("I send a POST request to create a new article with invalid endpoint")
    public void sendPostRequestToCreateNewArticleWithInvalidToken() {
        createNewArticle.sendPostRequestToCreateNewArticleWithInvalidToken();
    }

    @Then("the system should confirm the article creation")
    public void systemShouldConfirmArticleCreation() {
        createNewArticle.receiveValidArticleCreationData();
    }

}
