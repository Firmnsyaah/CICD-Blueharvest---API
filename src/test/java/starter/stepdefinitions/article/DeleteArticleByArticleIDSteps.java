package starter.stepdefinitions.article;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.article.DeleteArticleByArticleID;

public class DeleteArticleByArticleIDSteps {
    private DeleteArticleByArticleID deleteArticleByArticleID = new DeleteArticleByArticleID();

    @Given("I set promo API endpoint for deleting Article by ArticleID")
    public void setApiEndpoint() {
        deleteArticleByArticleID.setApiEndpoint();
    }

    @Given("I set invalid Article API endpoint for deleting Article")
    public void setWrongApiEndpoint() {
        deleteArticleByArticleID.setWrongApiEndpoint();
    }

    @When("I send DELETE request to delete Article by ArticleID")
    public void sendDeleteArticleRequest() {
        deleteArticleByArticleID.sendDeleteArticleRequest();
    }

    @When("I send DELETE request to delete Article by invalid Endpoint")
    public void sendDeleteArticleRequestWithInvalidEndpoint() {
        deleteArticleByArticleID.sendDeleteArticleRequestWithInvalidEndpoint();
    }

    @When("I send DELETE request without providing ArticleID")
    public void sendDeleteArticleRequestWithMissingArticleID() {
        deleteArticleByArticleID.sendDeleteArticleRequestWithMissingArticleID();
    }

    @Then("the system should confirm successful Article deletion")
    public void receiveConfirmationOfSuccessfulArticleDeletion() {
        deleteArticleByArticleID.receiveConfirmationOfSuccessfulArticleDeletion();
    }
}
