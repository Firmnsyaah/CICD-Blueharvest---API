package starter.stepdefinitions.chatBotAI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.chatBotAI.GetAllMessage;

public class GetAllMessagesSteps {

    private final GetAllMessage getAllMessages = new GetAllMessage();

    @Given("I set API endpoint for retrieving all messages")
    public void iSetApiEndpointForRetrievingAllMessages() {
        getAllMessages.setApiEndpoint();
    }

    @When("I send a GET request to retrieve all messages")
    public void iSendAGetRequestToRetrieveAllMessages() {
        getAllMessages.sendGetRequestToRetrieveAllMessages();
    }

    @When("I send a GET request to retrieve all messages with invalid endpoint")
    public void iSendAGetRequestToRetrieveAllMessagesWithInvalidEndpoint() {
        getAllMessages.sendGetRequestToRetrieveAllMessagesWithInvalidEndpoint();
    }

    @When("I send a GET request to retrieve all messages without proper authorization")
    public void iSendAGetRequestToRetrieveAllMessagesWithoutProperAuthorization() {
        getAllMessages.sendGetRequestWithoutAuthorization();
    }

    @Then("the user should receive valid message data")
    public void theUserShouldReceiveValidMessageData() {
        getAllMessages.verifyValidMessageData();
    }

}
