package starter.stepdefinitions.product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.product.GetAllProduct;

public class GetAllProductSteps {

    private GetAllProduct getAllProducts = new GetAllProduct();

    @Given("I set API endpoint for retrieving all products")
    public void setApiEndpointForRetrievingAllProducts() {
        getAllProducts.setApiEndpoint();
    }
    @Given("I set invalid API endpoint for retrieving all products")
    public void setInvalidApiEndpointForRetrievingAllProducts() {
        getAllProducts.setInvalidApiEndpoint();
    }

    @When("I send a GET request to retrieve all products")
    public void sendGetRequestToRetrieveAllProducts() {
        getAllProducts.sendGetRequestToRetrieveAllProducts();
    }
    @When("I send a GET request to retrieve all products with invalid endpoint")
    public void sendGetRequestToRetrieveAllProductsWithInvalidEndpoint() {
        getAllProducts.sendGetRequestToRetrieveAllProductsWithInvalidEndpoint();
    }

    @When("I send a GET request to retrieve all products with invalid authorization token")
    public void sendGetRequestToRetrieveAllProductsWithInvalidToken() {
        getAllProducts.sendGetRequestToRetrieveAllProductsWithInvalidToken();
    }


    @Then("I receive valid product list data")
    public void receiveValidProductListData() {
        getAllProducts.receiveValidProductListData();
    }

    @Then("I receive an empty product list")
    public void receiveEmptyProductList() {
        getAllProducts.receiveEmptyProductList();
    }
}
