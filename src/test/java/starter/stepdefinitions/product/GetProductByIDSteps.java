package starter.stepdefinitions.product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.product.GetProductByID;

public class GetProductByIDSteps {

    private GetProductByID getProduct = new GetProductByID();

    @Given("I set API endpoint for retrieving a product")
    public void setApiEndpointForRetrievingProduct() {
        getProduct.setApiEndpoint("7ac6ea27-8e79-4634-9505-dec87ddc2900");
    }

    @When("I send a GET request to retrieve the product")
    public void sendGetRequestToRetrieveProduct() {
        getProduct.sendGetRequestToRetrieveProduct();
    }

    @When("I send a GET request to retrieve the product with invalid product ID")
    public void sendGetRequestToRetrieveProductWithInvalidID() {
        getProduct.sendGetRequestToRetrieveProductWithInvalidID();
    }

    @When("I send a GET request to retrieve the product with invalid authorization token")
    public void sendGetRequestToRetrieveProductWithInvalidToken() {
        getProduct.sendGetRequestToRetrieveProductWithInvalidToken();
    }

    @Then("I receive valid product retrieval data")
    public void receiveValidProductRetrievalData() {
        getProduct.receiveValidProductRetrievalData();
    }

}
