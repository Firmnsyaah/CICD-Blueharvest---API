package starter.stepdefinitions.product.admin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.product.admin.DeleteProductByID;

public class DeleteProductByIDSteps {

    private DeleteProductByID deleteProduct = new DeleteProductByID();

    @Given("I set API endpoint for deleting a product")
    public void setApiEndpointForDeletingProduct() {
        deleteProduct.setApiEndpoint("7ac6ea27-8e79-4634-9505-dec87ddc2900");
    }


    @Given("I set an invalid product ID")
    public void setInvalidProductID() {
    }

    @When("I send a DELETE request to delete the product")
    public void sendDeleteRequestToDeleteProduct() {
        deleteProduct.sendDeleteRequestToDeleteProduct();
    }

    @When("I send a DELETE request to delete the product with invalid product ID")
    public void sendDeleteRequestToDeleteProductWithInvalidID() {
        deleteProduct.sendDeleteRequestToDeleteProductWithInvalidID();
    }

    @When("I send a DELETE request to delete the product with invalid authorization token")
    public void sendDeleteRequestToDeleteProductWithInvalidToken() {
        deleteProduct.sendDeleteRequestToDeleteProductWithInvalidToken();
    }

    @Then("I receive valid product deletion data")
    public void receiveValidProductDeletionData() {
        deleteProduct.receiveValidProductDeletionData();
    }
}
