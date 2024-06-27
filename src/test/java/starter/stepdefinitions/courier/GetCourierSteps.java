package starter.stepdefinitions.courier;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.courier.GetCourier;

public class GetCourierSteps {

    private GetCourier getCourier = new GetCourier();

    @Given("I want to get courier information")
    public void givenIWantToGetCourierInformation() {
        getCourier.setApiEndpoint();
    }

    @Given("I want to get courier information with an invalid endpoint")
    public void givenIWantToGetCourierInformationWithInvalidEndpoint() {
        getCourier.setInvalidApiEndpoint();
    }

    @When("I send a POST request to get courier information")
    public void whenISendPostRequestToGetCourierInformation() {
        getCourier.sendPostRequestToRetrieveCourierInformation();
    }

    @When("I send a POST request to get courier information with an invalid endpoint")
    public void whenISendPostRequestToGetCourierInformationWithInvalidEndpoint() {
        getCourier.sendPostRequestToRetrieveCourierInformationWithInvalidEndpoint();
    }

    @When("I send a POST request to retrieve courier information with missing required fields")
    public void sendPostRequestToRetrieveCourierInformationWithMissingRequiredFields() {
        getCourier.sendPostRequestToRetrieveCourierInformationWithMissingRequiredFields();
    }

    @Then("I should receive valid courier information")
    public void thenIShouldReceiveValidCourierInformation() {
        getCourier.receiveValidCourierInformation();
    }

}
