package starter.stepdefinitions.article;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.article.UpdateArticleByID;

public class UpdateArticleByIDSteps {

    private UpdateArticleByID updateArticleByID = new UpdateArticleByID();

    @Given("I set API endpoint for updating an article by ID")
    public void setApiEndpointForUpdatingArticleByID() {
        updateArticleByID.setApiEndpoint();
    }

    @When("I send a PUT request to update the article with ID")
    public void sendPutRequestToUpdateArticle() {
        updateArticleByID.sendPutRequestToUpdateArticle();
    }

    @When("I send a PUT request to update the article due to missing required fields")
    public void sendPutRequestToUpdateArticleByIDWithoutRequiredFields() {
        updateArticleByID.sendPutRequestToUpdateArticleWithoutRequiredFields();
    }

    @When("I send a PUT request to update an article with invalid ID")
    public void sendPutRequestToUpdateArticleWithInvalidID() {
        updateArticleByID.sendPutRequestToUpdateArticleWithInvalidID();
    }

    @Then("the system should confirm the article update")
    public void receiveConfirmationArticleUpdate() {
        updateArticleByID.systemShouldConfirmArticleUpdate();
    }

}
