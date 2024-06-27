package starter.stepdefinitions.product.admin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.product.admin.UpdateProductByProductID;

public class UpdateProductByProductIDSteps {

    private UpdateProductByProductID updateProduct = new UpdateProductByProductID();

    @Given("I set API endpoint for updating a product")
    public void setApiEndpointForUpdatingProduct() {
        updateProduct.setApiEndpoint();
    }

    @Given("I set the valid product ID")
    public void setValidProductID() {
    }

    @When("I send a PUT request to update the product")
    public void sendPutRequestToUpdateProduct() {
        updateProduct.sendPutRequestToUpdateProduct();
    }

    @When("I send a PUT request to update the product without productID")
    public void sendPutRequestToUpdateProductWithoutRequiredFields() {
        updateProduct.sendPutRequestToUpdateProductWithoutRequiredFields();
    }

    @When("I send a PUT request to update the product with invalid authorization token")
    public void sendPutRequestToUpdateProductWithInvalidToken() {
        updateProduct.sendPutRequestToUpdateProductWithInvalidToken();
    }

    @Then("I receive valid product update data")
    public void receiveValidProductUpdateData() {
        updateProduct.receiveValidProductUpdateData();
    }


}
