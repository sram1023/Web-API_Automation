package com.api.stepdefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonUtil;
import utils.WebServiceUtil;

public class RestWebServices {

    private final TestContext testContext;
    private final WebServiceUtil webServiceUtil;

    public RestWebServices(TestContext testContext) {
        this.testContext = testContext;
        webServiceUtil = new WebServiceUtil();
    }


    @Given("^the rest api for (.+) is ready$")
    public void restApi(String action) {
        webServiceUtil.restApiActions(action);
    }

    @When("^I (.+) the record with some details$")
    public void iPostTheRecordWithSomeDetails(String action) {
        webServiceUtil.restActions(action);
    }

    @Then("^validate the success status (.+)$")
    public void validateTheSuccessStatus(String expected) {
        webServiceUtil.validatePost(expected);
    }

    @Then("^validate the address (.+) from get response$")
    public void validateTheNameFrontlineHousesFromGetResponse(String expected) {
        webServiceUtil.validateGetServiceResponse(expected);
    }

    @Then("^validate the message (.+)$")
    public void validateTheMessageAddressSuccessfullyUpdated(String expected) {
        webServiceUtil.validatePut(expected);
    }

    @Then("^validate the delete success status (.+)$")
    public void validateTheDeleteSuccessStatus(String expected) {
        webServiceUtil.validateDelete(expected);
    }
}
