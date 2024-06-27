package starter.stepdefinitions.product.admin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.product.admin.CreateProduct;

public class CreateProductSteps {

    private CreateProduct createProduct = new CreateProduct();

    @Given("I set API endpoint for creating a new product")
    public void setApiEndpointForCreatingNewProduct() {
        createProduct.setApiEndpoint();
    }

    @When("I send a POST request to create a new product")
    public void sendPostRequestToCreateProduct() {
        createProduct.sendPostRequestToCreateProduct();
    }

    @When("I send a POST request to create a new product without required fields")
    public void sendPostRequestToCreateProductWithoutRequiredFields() {
        createProduct.sendPostRequestToCreateProductWithoutRequiredFields();
    }

    @When("I send a POST request to create a new product with invalid authorization token")
    public void sendPostRequestToCreateProductWithInvalidToken() {
        createProduct.sendPostRequestToCreateProductWithInvalidToken();
    }

    @Then("I receive valid product creation data")
    public void receiveValidProductCreationData() {
        createProduct.receiveValidProductCreationData();
    }

    @Then("I receive status code 403")
    public void receiveStatusCode403() {
        createProduct.receiveStatusCode403();
    }

    @Then("I receive an error message about unauthorized access")
    public void receiveErrorMessageAboutUnauthorizedAccess() {
        createProduct.receiveErrorMessageAboutUnauthorizedAccess();
    }

}
