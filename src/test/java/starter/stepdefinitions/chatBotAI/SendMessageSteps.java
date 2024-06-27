package starter.stepdefinitions.chatBotAI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.chatBotAI.SendMessage;

public class SendMessageSteps {

    private SendMessage sendMessage = new SendMessage();

    @Given("I set message API endpoint for sending a message")
    public void iSetMessageApiEndpointForSendingMessage() {
        sendMessage.setApiEndpoint();
    }

    @When("I send POST request to send a message with valid data")
    public void iSendPostRequestToSendMessageWithValidData() {
        sendMessage.sendPostRequestToSendMessageWithValidData();
    }

    @When("I send POST request to send a message without providing required fields")
    public void iSendPostRequestToSendMessageWithoutProvidingRequiredFields() {
        sendMessage.sendPostRequestToSendMessageWithoutRequiredFields();
    }

    @When("I send POST request to send a message with invalid data")
    public void iSendPostRequestToSendMessageWithInvalidData() {
        sendMessage.sendPostRequestToSendMessageWithInvalidData();
    }

    @Then("The system should confirm successful message sent")
    public void theSystemShouldConfirmSuccessfulMessageSent() {
        sendMessage.receiveSuccessfulMessageSentConfirmation();
    }
}
